package webstudy.member.servlet;


import org.junit.Test;
import webstudy.member.form.MemberFindForm;
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
        ValidationResult result = form.validate();
        assertThat(result.isValid(), is(true));
    }

    @Test
    public void testInvalid() {
        form.setMemberId("a");
        ValidationResult result = form.validate();
        assertThat(result.isError(), is(true));
        assertThat(result.isError("memberId"), is(true));
        assertThat(result.get("memberId"), is("メンバーIDは1から9桁の数字で入力してください。"));

    }

    @Test
    public void testNull() {
        form.setMemberId(null);
        ValidationResult result = form.validate();
        assertThat(result.isError(), is(true));
        assertThat(result.isError("memberId"), is(true));
        assertThat(result.get("memberId"), is("メンバーIDを入力してください。"));
    }
}