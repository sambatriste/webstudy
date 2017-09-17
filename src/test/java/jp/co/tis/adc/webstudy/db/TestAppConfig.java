package jp.co.tis.adc.webstudy.db;


public class TestAppConfig extends AppConfigBase {
    private static final TestAppConfig INSTANCE = new TestAppConfig();

    public static final String URL = "jdbc:h2:file:./h2/webstudy-test";
    public static final String USER = "sa";
    public static final String PASSWORD = "sa";

    private TestAppConfig() {
        super(URL, USER, PASSWORD);
    }

    public static TestAppConfig singleton() {
        return INSTANCE;
    }
}
