package jp.co.tis.adc.webstudy.validation;


/**
 * バリデーション失敗を通知するための例外クラス.
 *
 * @see ValidationFilter
 */
public class ValidationException extends RuntimeException {

    /** バリデーション結果 */
    private final ValidationResult result;

    /**
     * コンストラクタ.
     * @param result バリデーション結果
     */
    ValidationException(ValidationResult result) {
        this.result = result;
    }

    /**
     * バリデーション結果を取得する.
     * @return バリデーション結果
     */
    public ValidationResult getResult() {
        return result;
    }


}
