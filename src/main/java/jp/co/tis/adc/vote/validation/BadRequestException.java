package jp.co.tis.adc.vote.validation;

public class BadRequestException extends RuntimeException {

    private final ValidationResult result;

    public BadRequestException(ValidationResult result) {
        this.result = result;
    }


}
