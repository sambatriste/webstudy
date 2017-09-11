package jp.co.tis.adc.webstudy.validation;

/**
 * フォワード先を指定できる{@link ValidationException}サブクラス.
 *
 * @see ValidationFilter
 */
public class ForwardingValidationException extends ValidationException {

    private final String forwardUri;

    /**
     * コンストラクタ.
     * @param result バリデーション結果
     * @param forwardUri フォワード先URI
     */
    ForwardingValidationException(ValidationResult result, String forwardUri) {
        super(result);
        this.forwardUri = forwardUri;
    }

    /**
     * フォワード先URIを取得する。
     * @return フォワード先URI
     */
    public String getForwardUri() {
        return forwardUri;
    }
}


