package jp.co.tis.adc.webstudy.validation;

import javax.validation.ConstraintViolation;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;

/**
* Created with IntelliJ IDEA.
* User: kawasaki
* Date: 13/11/04
* Time: 2:06
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
        //return containsKey(propertyName);
    }

    public Set<ConstraintViolation<T>> getViolations() {
        return violations;
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
