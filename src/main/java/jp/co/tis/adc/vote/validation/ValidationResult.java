package jp.co.tis.adc.vote.validation;

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

    private Set<ConstraintViolation<T>> violations;

    ValidationResult(
            Set<ConstraintViolation<T>> violations) {
        this.violations = violations;
        for (ConstraintViolation<T> e : violations) {
            String path = e.getPropertyPath().toString();
            String msg = e.getMessage();
            put(path, msg);
        }
    }

    public boolean isError(String propertyName) {
        return containsKey(propertyName);
    }

    public Set<ConstraintViolation<T>> getViolations() {
        return violations;
    }

    public boolean isValid() {
        return violations.isEmpty();
    }

    private Set<String> put(String path, String msg) {
        Set<String> msgs = get(path);
        if (msgs == null) {
            msgs = new LinkedHashSet<>();
            put(path, msgs);
        }
        msgs.add(msg);
        return msgs;
    }
    public void forward(String forwardUri) {
        throw new ValidationException(this, forwardUri);
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
        throw new BadRequestException(this);
    }
}
