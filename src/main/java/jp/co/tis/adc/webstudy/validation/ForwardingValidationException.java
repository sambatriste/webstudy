package jp.co.tis.adc.webstudy.validation;

public class ForwardingValidationException extends ValidationException {

    private final String forwardUri;

    ForwardingValidationException(ValidationResult result, String forwardUri) {
        super(result);
        this.forwardUri = forwardUri;
    }

    public String getForwardUri() {
        return forwardUri;
    }
}


