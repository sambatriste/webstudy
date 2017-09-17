package jp.co.tis.adc.webstudy.db;

import org.seasar.doma.SingletonConfig;
import org.seasar.doma.jdbc.Naming;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.TransactionManager;

import javax.sql.DataSource;

/**
 * {@link AppConfigBase}を継承した{@link org.seasar.doma.jdbc.Config}実装クラス。
 */
@SingletonConfig
public class AppConfig extends AppConfigBase {

    /** URL */
    public static final String URL = "jdbc:h2:file:./h2/webstudy-main;AUTO_SERVER=true";
    /** ユーザ */
    public static final String USER = "sa";
    /** パスワード */
    public static final String PASSWORD = "sa";

    /** シングルトンインスタンス */
    private static final AppConfig CONFIG = new AppConfig();

    /**
     * シングルトンインスタンスを取得する。
     * @return インスタンス
     */
    public static AppConfig singleton() {
        return CONFIG;
    }


    private AppConfig() {
        super(URL, USER, PASSWORD);
    }
}
