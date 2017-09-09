package jp.co.tis.adc.webstudy.db;


import org.h2.jdbcx.JdbcConnectionPool;

import javax.sql.DataSource;


public class DataSourceFactory {

    public static DataSource create() {
        return JdbcConnectionPool.create(
                "jdbc:h2:./h2/test;AUTO_SERVER=true", "sa", "sa");
    }
}
