package jp.co.tis.adc.webstudy.validation;

/**
 * フォワード先を指定できる{@link ValidationException}サブクラス.
 *
 * @see ValidationFilter
 */
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


