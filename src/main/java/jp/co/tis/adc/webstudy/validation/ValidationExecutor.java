package jp.co.tis.adc.webstudy.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 * BeanValidationを利用したバリデーションを実行するクラス.
 *
 * @param <T> バリデーション対象となるBeanの型
 * @see Validator
 */
public class ValidationExecutor<T> {

    /** バリデーション対象となるBeanのインスタンス */
    private final T beanToValidate;

    /**
     * コンストラクタ.
     * @param beanToValidate バリデーション対象となるBean
     */
    public ValidationExecutor(T beanToValidate) {
        this.beanToValidate = beanToValidate;
    }

    /**
     * インスタンスを生成する.
     * @param bean バリデーション対象となるBean
     * @param <T> バリデーション対象となるBeanの型
     * @return インスタンス
     */
    public static <T> ValidationExecutor<T> create(T bean) {
        return new ValidationExecutor<>(bean);
    }

    /**
     * バリデーションを実行する.
     * @param bean バリデーション対象となるBean
     * @param <T> バリデーション対象となるBeanの型
     * @return バリデーションの結果
     */
    public static <T> ValidationResult<T> validate(T bean) {
        return create(bean).validate();
    }

    /**
     * バリデーションを実行する.
     * @return バリデーションの結果
     */
    public ValidationResult<T> validate() {
        Validator validator = ValidatorFactoryBuilder.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(beanToValidate);
        return new ValidationResult<>(violations);
    }
}
