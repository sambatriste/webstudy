package webstudy.member;

import webstudy.util.MapUtil;
import webstudy.validation.ValidationResult;

import java.util.Map;

/**
 * メンバー検索用フォーム。
 */
class MemberFindForm {

    MemberFindForm() {
    }

    MemberFindForm(Map<String, String[]> params) {
        memberId = MapUtil.getFirst(params, "memberId");
    }

    private String memberId;

    /**
     * {@link Integer}変換したメンバーIDを取得する。
     * @return メンバーID
     */
    Integer getMemberId() {
        return Integer.parseInt(memberId);
    }

    void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    ValidationResult<MemberFindForm> validate() {
        ValidationResult<MemberFindForm> result = new ValidationResult<>();
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
