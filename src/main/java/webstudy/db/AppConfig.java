package webstudy.db;

import org.seasar.doma.SingletonConfig;

/**
 * {@link AppConfigBase}を継承した{@link org.seasar.doma.jdbc.Config}実装クラス。
 */
@SingletonConfig
public class AppConfig extends AppConfigBase {

    /** URL */
    public static final String URL = "jdbc:h2:file:./h2/webstudy-main";
    /** ユーザ */
    public static final String USER = "sa";
    /** パスワード */
    public static final String PASSWORD = "sa";

    public static final String DRIVER_CLASS_NAME = "org.h2.Driver";

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
