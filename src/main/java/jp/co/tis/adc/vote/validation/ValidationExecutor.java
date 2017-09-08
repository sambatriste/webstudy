package jp.co.tis.adc.vote.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kawasaki
 * Date: 13/11/04
 * Time: 1:59
 */
public class ValidationExecutor<T> {

    private final T beanToValidate;

    public ValidationExecutor(T beanToValidate) {
        this.beanToValidate = beanToValidate;
    }

    public static <T> ValidationExecutor<T> create(T bean) {
        return new ValidationExecutor<>(bean);
    }

    public static <T> ValidationResult<T> validate(T bean) {
        return create(bean).validate();
    }

    public ValidationResult<T> validate() {
        Set<ConstraintViolation<T>> violations = doValidate(beanToValidate);
        return new ValidationResult<>(violations);
    }

    private Set<ConstraintViolation<T>> doValidate(T bean) {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            Validator validator = factory.getValidator();
            return validator.validate(bean);
        }
    }


}
