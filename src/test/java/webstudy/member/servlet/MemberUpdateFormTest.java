package webstudy.member.servlet;

import org.junit.Test;
import webstudy.member.form.MemberUpdateForm;
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
        ValidationResult result = form.validate();
        assertThat(result.isValid(), is(true));
    }

    @Test
    public void testEmpty() {
        ValidationResult result = form.validate();
        assertThat(result.isError(), is(true));
        assertThat(result.get("memberId"), is("メンバーIDを入力してください。"));
        String familyNameResult = result.get("familyName");
        assertThat(familyNameResult, is("姓を入力してください。"));
        String lastNameResult = result.get("lastName");
        assertThat(lastNameResult, is("名を入力してください。"));
        assertThat(result.size(), is(3));
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

        ValidationResult result = form.validate();
        assertThat(result.isError(), is(true));
        assertThat(result.get("familyName"), is("姓は1〜64文字で入力してください。"));
        String lastNameResult = result.get("lastName");
        assertThat(lastNameResult, is("名は1〜64文字で入力してください。"));
        assertThat(result.size(), is(2));
    }

}