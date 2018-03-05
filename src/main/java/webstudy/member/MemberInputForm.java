package webstudy.member;

import org.seasar.doma.In;
import webstudy.entity.Member;
import webstudy.validation.ValidationResult;

import java.util.Map;

import static webstudy.util.MapUtil.getFirst;

/**
 * メンバー。
 */
public class MemberInputForm {

    private String familyName;

    private String lastName;

    private String deptId;

    MemberInputForm() {
    }

    MemberInputForm(Map<String, String[]> params) {
        familyName = getFirst(params, "familyName");
        lastName = getFirst(params, "lastName");
        deptId = getFirst(params,"deptId");
    }

    ValidationResult<MemberInputForm> validate() {
        ValidationResult<MemberInputForm> result = new ValidationResult<>();
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
        if (deptId == null || deptId.isEmpty()) {
            result.put("deptId", "部署を選択してください。");
        }
        return result;
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

    public String getDeptId(){
        return deptId;
    }

    public void setDeptId(String deptId){
        this.deptId=deptId;
    }

    Member toEntity() {
        Member member = new Member();
        member.setFamilyName(familyName);
        member.setLastName(lastName);
        member.setDeptId(Integer.parseInt(deptId));
        member.setVersion(0);
        return member;
    }
}
