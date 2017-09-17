package jp.co.tis.adc.webstudy.member;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * メンバー検索用フォーム。
 */
public class MemberFindForm {

    @NotEmpty
    @Digits(integer = 9, fraction = 0)
    private String memberId;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * {@link Integer}変換したメンバーIDを取得する。
     * @return メンバーID
     */
    Integer getParsedMemberId() {
        return Integer.parseInt(memberId);
    }
}
