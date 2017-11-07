package webstudy.member;

import webstudy.member.MemberFindForm;
import webstudy.validation.ValidationExecutor;
import webstudy.validation.ValidationResult;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MemberFindFormTest {

    private final MemberFindForm form = new MemberFindForm();

    @Test
    public void testValid() {
        form.setMemberId("1");
        ValidationResult<MemberFindForm> result = ValidationExecutor.validate(form);
        assertThat(result.isValid(), is(true));
    }

    @Test
    public void testInvalid() {
        form.setMemberId("a");
        ValidationResult<MemberFindForm> result = ValidationExecutor.validate(form);
        assertThat(result.isError(), is(true));
        assertThat(result.isError("memberId"), is(true));

    }

}