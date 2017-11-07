package webstudy.db;

import org.seasar.doma.jdbc.tx.TransactionManager;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Doma2のトランザクション制御を行うサーブレットフィルタ。
 *
 * @see TransactionManager
 */
@WebFilter(urlPatterns = "*")
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        tm.required(() -> {
            doFilterInTransaction(request, response, chain);
        });
    }

    private void doFilterInTransaction(ServletRequest request,
                                       ServletResponse response,
                                       FilterChain chain) {
        try {
            chain.doFilter(request, response);
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // NOP
    }

    @Override
    public void destroy() {
        // NOP
    }
}
