package jp.co.tis.adc.webstudy.db;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.Naming;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.H2Dialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;

import javax.sql.DataSource;

/**
 * {@link Config}実装の基底クラス。
 */
public abstract class AppConfigBase implements Config {

    /** 方言 */
    private final Dialect dialect = new H2Dialect();

    /** データソース */
    private final LocalTransactionDataSource dataSource;

    /** トランザクションマネージャ */
    private final TransactionManager transactionManager;

    /**
     * コンストラクタ。
     * @param url URL
     * @param user ユーザ
     * @param password パスワード
     */
    protected AppConfigBase(String url, String user, String password) {
        this.dataSource = new LocalTransactionDataSource(url, user, password);
        this.transactionManager = new LocalTransactionManager(
                dataSource.getLocalTransaction(getJdbcLogger()));
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }


    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    @Override
    public Naming getNaming() {
        return Naming.SNAKE_LOWER_CASE;
    }
}
