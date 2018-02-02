package webstudy.member;

import webstudy.entity.Member;
import webstudy.validation.ValidationResult;

import java.util.Map;

import static webstudy.util.MapUtil.getFirst;

/**
 * メンバー。
 */
public class MemberUpdateForm {

    private String memberId;
    private String familyName;
    private String lastName;
    private String version;

    MemberUpdateForm() {
    }

    MemberUpdateForm(Map<String, String[]> params) {
        memberId = getFirst(params, "memberId");
        familyName = getFirst(params, "familyName");
        lastName = getFirst(params, "lastName");
        version = getFirst(params, "version");
    }

    ValidationResult<MemberUpdateForm> validate() {
        ValidationResult<MemberUpdateForm> result = new ValidationResult<>();

        if (memberId == null) {
            result.put("memberId", "メンバーIDを入力してください。");
        } else if (memberId.length() > 9 || !isInteger(memberId) ) {
            result.put("memberId", "メンバーIDは1から9桁の数字で入力してください。");
        }
        if (familyName == null || familyName.isEmpty()) {
            result.put("familyName", "姓を入力してください。");
        } else if (familyName.length() > 64) {
            result.put("familyName", "姓は1〜64文字で入力してください。");
        }
        if (lastName == null || lastName.isEmpty()) {
            result.put("lastName", "名を入力してください。");
        } else if (lastName.length() > 64) {
            result.put("lastName", "名は1〜64文字で入力してください。");
        }
        return result;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    Member toEntity() {
        Member member = new Member();
        member.setMemberId(Integer.parseInt(memberId));
        member.setFamilyName(familyName);
        member.setLastName(lastName);
        member.setVersion(Integer.parseInt(version));
        return member;
    }
}
