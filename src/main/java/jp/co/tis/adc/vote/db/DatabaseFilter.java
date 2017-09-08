package jp.co.tis.adc.vote.db;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: kawasaki
 * Date: 13/10/26
 * Time: 23:35
 */
@WebFilter(servletNames = "*")
public class DatabaseFilter implements Filter {

    private DataSource ds;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            ds = DataSourceFactory.create();
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {
        Connection conn = null;
        try {
            conn = getConnection();
            manageTransaction(conn, servletRequest, servletResponse, filterChain);
        } finally {
            close(conn);
            DbConnection.remove();
        }
    }

    private void manageTransaction(Connection conn,
                                   ServletRequest servletRequest,
                                   ServletResponse servletResponse,
                                   FilterChain filterChain) throws IOException, ServletException {
        try {
            DbConnection.set(conn);
            filterChain.doFilter(servletRequest, servletResponse);
            conn.commit();
        } catch (SQLException e) {
            rollback(conn);
            throw new IllegalStateException(e);
        } catch (ServletException | IOException | RuntimeException e) {
            rollback(conn);
            throw e;
        }
    }

    private static void rollback(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                // NOP
            }
        }
    }

    private static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // NOP
            }
        }
    }

    private Connection getConnection() {
        try {
            Connection conn = ds.getConnection();
            conn.setAutoCommit(false);
            return conn;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void destroy() {
        ds = null;
    }
}
