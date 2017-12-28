package webstudy.member;

import org.junit.Test;
import webstudy.validation.ValidationResult;

import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MemberInputFormTest {
    private MemberInputForm form = new MemberInputForm();

    @Test
    public void testValid() {
        form.setFamilyName("山田");
        form.setLastName("太郎");
        ValidationResult<MemberInputForm> result = form.validate();
        assertThat(result.isValid(), is(true));
    }

    @Test
    public void testEmpty() {
        ValidationResult<MemberInputForm> result = form.validate();
        assertThat(result.isError(), is(true));
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
        assertThat(result.size(), is(2));
    }

    @Test
    public void testOverSize() {

        form.setFamilyName("1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890"
                                     + "1234567890" + "12345"
        );
        form.setLastName("1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890"
                                   + "1234567890" + "12345"
        );

        ValidationResult<MemberInputForm> result = form.validate();

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