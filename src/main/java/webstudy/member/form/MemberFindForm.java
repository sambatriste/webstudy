package webstudy.member.form;

import webstudy.util.MapUtil;
import webstudy.validation.ValidationResult;

import java.util.Map;

/**
 * メンバー検索用フォーム。
 */
public class MemberFindForm {

    public MemberFindForm() {
    }

    public MemberFindForm(Map<String, String[]> params) {
        memberId = MapUtil.getFirst(params, "memberId");
    }

    private String memberId;

    /**
     * {@link Integer}変換したメンバーIDを取得する。
     * @return メンバーID
     */
    public Integer getMemberId() {
        return Integer.parseInt(memberId);
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public ValidationResult validate() {
        ValidationResult result = new ValidationResult();
        if (memberId == null) {
            result.put("memberId", "メンバーIDを入力してください。");
        } else if (memberId.length() > 9 || !isInteger(memberId) ) {
            result.put("memberId", "メンバーIDは1から9桁の数字で入力してください。");
        }
        return result;
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
