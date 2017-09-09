package jp.co.tis.adc.webstudy.validation;


public class ValidationException extends RuntimeException {

    private final ValidationResult result;



    ValidationException(ValidationResult result) {
        this.result = result;
    }

    public ValidationResult getResult() {
        return result;
    }


}
