package webstudy.member;


import org.junit.Test;
import webstudy.validation.ValidationResult;

import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MemberFindFormTest {

    private final MemberFindForm form = new MemberFindForm();

    @Test
    public void testValid() {
        form.setMemberId("1");
        ValidationResult<MemberFindForm> result = form.validate();
        assertThat(result.isValid(), is(true));
    }

    @Test
    public void testInvalid() {
        form.setMemberId("a");
        ValidationResult<MemberFindForm> result = form.validate();
        assertThat(result.isError(), is(true));
        assertThat(result.isError("memberId"), is(true));
        Set<String> memberIdResult = result.get("memberId");
        assertThat(memberIdResult, hasItem("メンバーIDは1から9桁の数字で入力してください。"));
        assertThat(memberIdResult.size(), is(1));
    }

    @Test
    public void testNull() {
        form.setMemberId(null);
        ValidationResult<MemberFindForm> result = form.validate();
        assertThat(result.isError(), is(true));
        assertThat(result.isError("memberId"), is(true));
        Set<String> memberIdResult = result.get("memberId");
        assertThat(memberIdResult, hasItem("メンバーIDを入力してください。"));
        assertThat(memberIdResult.size(), is(1));
    }
}