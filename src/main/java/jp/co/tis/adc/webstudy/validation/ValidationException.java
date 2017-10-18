package jp.co.tis.adc.webstudy.validation;


/**
 * バリデーション失敗を通知するための例外クラス.
 *
 * @see ValidationFilter
 */
public class ValidationException extends ClientErrorException {

    /** バリデーション結果 */
    private final ValidationResult result;

    /** フォワード先 */
    private final String forwardUri;

    /**
     * コンストラクタ.
     * @param result バリデーション結果
     */
    public ValidationException(ValidationResult result) {
        this(result, null);
    }

    /**
     * コンストラクタ.
     * @param result バリデーション結果
     * @param forwardUri フォワード先
     */
    public ValidationException(ValidationResult result, String forwardUri) {
        this(result, 400, forwardUri);
    }

    /**
     * コンストラクタ.
     * @param result バリデーション結果
     * @param statusCode ステータスコード
     * @param forwardUri フォワード先
     */
    public ValidationException(ValidationResult result, int statusCode, String forwardUri) {
        super(statusCode);
        this.result = result;
        this.forwardUri = forwardUri;
    }


    /**
     * バリデーション結果を取得する.
     * @return バリデーション結果
     */
    public ValidationResult getResult() {
        return result;
    }

    /**
     * フォワード先を取得する.
     * @return フォワード先
     */
    public String getForwardUri() {
        return forwardUri;
    }
}
