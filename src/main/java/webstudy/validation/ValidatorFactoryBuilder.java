package webstudy.validation;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * {@link ValidatorFactory}の生成を行うリスナー。
 *
 * コンテキスト初期化時に、{@link ValidatorFactory}のインスタンスを取得する。
 * 終了時に、その{@link ValidatorFactory}をクローズする。
 */
@WebListener
public class ValidatorFactoryBuilder implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Initializer.class.getName();  // クラスのstatic initializerを起動させる.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        Initializer.validatorFactory.close();
    }

    static ValidatorFactory getValidatorFactory() {
        return Initializer.validatorFactory;
    }

    /**
     * {@link Validator}のインスタンスを取得する。
     *
     * @return インスタンス
     * @see ValidatorFactory#getValidator()
     */
    static Validator getValidator() {
        return Initializer.validatorFactory.getValidator();
    }

    private static class Initializer {

        private static final ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

        private Initializer() {
        }
    }
}