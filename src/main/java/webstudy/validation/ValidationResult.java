package webstudy.validation;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * バリデーションの結果を表すクラス。
 * {@link TreeMap}のサブクラスであり、
 * <ul>
 * <li>キー:エラーとなったプロパティ名</li>
 * <li>値:エラーメッセージ</li>
 * </ul>
 * を保持している。
 *
 * @param <T> バリデーション対象となったBeanの型
 */
public class ValidationResult<T> extends TreeMap<String, Set<String>> {

    public ValidationResult() {
    }

    /**
     * 指定されたプロパティでバリデーションエラーが発生したかどうか判定する。
     *
     * @param propertyName プロパティ名
     * @return エラーである場合、真
     */
    public boolean isError(String propertyName) {
        return containsKey(propertyName);
    }

    /**
     * バリデーションエラーが発生したかどうか判定する。
     *
     * @return エラーの場合、真
     */
    public boolean isError() {
        return !isValid();
    }

    /**
     * バリデーション結果が妥当であるか（エラーがなかったか）判定する。
     *
     * @return 妥当である場合、真
     */
    public boolean isValid() {
        return isEmpty();
    }

    public void put(String path, String message) {
        Set<String> messages = computeIfAbsent(path, key -> new LinkedHashSet<>());
        messages.add(message);
    }
}
