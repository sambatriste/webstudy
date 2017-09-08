package jp.co.tis.adc.vote.validation;


public class ValidationException extends RuntimeException {

    private final ValidationResult result;

    private final String forwardUri;

    ValidationException(ValidationResult result, String forwardUri) {
        this.result = result;
        this.forwardUri = forwardUri;
    }

    public ValidationResult getResult() {
        return result;
    }

    public String getForwardUri() {
        return forwardUri;
    }
}
