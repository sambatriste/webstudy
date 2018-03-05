package webstudy.member;

import org.junit.Test;
import webstudy.validation.ValidationResult;

import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MemberUpdateFormTest {
    private MemberUpdateForm form = new MemberUpdateForm();

    @Test
    public void testValid() {
        form.setMemberId("1");
        form.setFamilyName("山田");
        form.setLastName("太郎");
        form.setDeptId("1");
        ValidationResult<MemberUpdateForm> result = form.validate();
        assertThat(result.isValid(), is(true));
    }

    @Test
    public void testEmpty() {
        ValidationResult<MemberUpdateForm> result = form.validate();
        assertThat(result.isError(), is(true));
        {
            Set<String> memberIdResult = result.get("memberId");
            assertThat(memberIdResult, hasItem("メンバーIDを入力してください。"));
            assertThat(memberIdResult.size(), is(1));
        }
        {
            Set<String> familyNameResult = result.get("familyName");
            assertThat(familyNameResult, hasItem("姓を入力してください。"));
            assertThat(familyNameResult.size(), is(1));
        }
        {
            Set<String> lastNameResult = result.get("lastName");
            assertThat(lastNameResult, hasItem("名を入力してください。"));
            assertThat(lastNameResult.size(), is(1));
        }
        {
            Set<String> deptIdResult = result.get("deptId");
            assertThat(deptIdResult, hasItem("部署を選択してください。"));
            assertThat(deptIdResult.size(), is(1));
        }
        assertThat(result.size(), is(4));
    }

    @Test
    public void testOverSize() {
        form.setMemberId("1");  // valid
        form.setFamilyName("1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890"
                                   + "1234567890" + "12345"
        );
        form.setLastName("1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890"
                                 + "1234567890" + "12345"
        );
        form.setDeptId("1");

        ValidationResult<MemberUpdateForm> result = form.validate();

        assertThat(result.isError(), is(true));
        {
            Set<String> familyNameResult = result.get("familyName");
            assertThat(familyNameResult, hasItem("姓は1〜64文字で入力してください。"));
            assertThat(familyNameResult.size(), is(1));
        }
        {
            Set<String> lastNameResult = result.get("lastName");
            assertThat(lastNameResult, hasItem("名は1〜64文字で入力してください。"));
            assertThat(lastNameResult.size(), is(1));
        }
        assertThat(result.size(), is(2));
    }

}