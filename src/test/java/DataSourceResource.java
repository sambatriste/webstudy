import jp.co.tis.adc.webstudy.db.DataSourceFactory;
import org.junit.rules.ExternalResource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceResource extends ExternalResource {

    private DataSource dataSource;
    private Connection connection;

    @Override
    protected void before() throws Throwable {
        dataSource = DataSourceFactory.create();
        connection = dataSource.getConnection();
    }

    @Override
    protected void after() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            // NOP
        }
        try {
            connection.close();
        } catch (SQLException e) {
            // NOP
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public DataSource getDataSource() {
        return dataSource;
    }
}
