package jp.co.tis.adc.webstudy.validation;

import javax.validation.ConstraintViolation;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * バリデーションの結果を表すクラス。
 * {@link TreeMap}のサブクラスであり、
 * <ul>
 * <li>キー:エラーとなったプロパティ名</li>
 * <li>値:エラーメッセージ</li>
 * </ul>
 * を保持している。
 *
 * @param <T> バリデーション対象となったBeanの型
 */
public class ValidationResult<T> extends TreeMap<String, Set<String>> {

    private final Set<ConstraintViolation<T>> violations;

    ValidationResult(Set<ConstraintViolation<T>> violations) {
        this.violations = violations;
        for (ConstraintViolation<T> e : violations) {
            String path = e.getPropertyPath().toString();
            String msg = e.getMessage();
            put(path, msg);
        }
    }

    public boolean isError(String propertyName) {
        return violations.stream().anyMatch(
                violation -> violation.getPropertyPath().toString().equals(propertyName)
        );
    }

    public Set<ConstraintViolation<T>> getViolations() {
        return violations;
    }

    public boolean isError() {
        return !isValid();
    }

    public boolean isValid() {
        return violations.isEmpty();
    }

    private Set<String> put(String path, String msg) {
        Set<String> messages = computeIfAbsent(path, key -> new LinkedHashSet<>());
        messages.add(msg);
        return messages;
    }
    public void forward(String forwardUri) {
        throw new ForwardingValidationException(this, forwardUri);
    }

    public void forwardIfInvalid(String forwardUri) {
        if (!isValid()) {
            forward(forwardUri);
        }
    }

    public void sendErrorIfInvalid() {
        if (!isValid()) {
            sendError();
        }
    }

    private void sendError() {
        throw new ValidationException(this);
    }
}
