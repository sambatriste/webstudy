package jp.co.tis.adc.webstudy.db;

import java.sql.Connection;


public class DbConnection {
    private static ThreadLocal<Connection> connectionPerThread = new ThreadLocal<Connection>();

    static void set(Connection conn) {
        connectionPerThread.set(conn);
    }

    public static Connection get() {
        Connection conn = connectionPerThread.get();
        if (conn == null) {
            throw new IllegalStateException("Connection not set.");
        }
        return conn;
    }
    static void remove() {
        connectionPerThread.remove();
    }

}
