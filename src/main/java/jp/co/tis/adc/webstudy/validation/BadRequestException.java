package jp.co.tis.adc.webstudy.validation;

public class BadRequestException extends RuntimeException {

    private final ValidationResult result;

    public BadRequestException(ValidationResult result) {
        this.result = result;
    }


}
