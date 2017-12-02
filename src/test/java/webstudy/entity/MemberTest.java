package webstudy.entity;

import org.junit.Test;
import webstudy.validation.ValidationExecutor;
import webstudy.validation.ValidationResult;

import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MemberTest {

    private Member member = new Member();

    @Test
    public void testEmpty() {
        ValidationResult<Member> result = ValidationExecutor.validate(member);
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

        member.setFamilyName("1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890"
                                     + "1234567890" + "12345"
        );
        member.setLastName("1234567890" + "1234567890" + "1234567890" + "1234567890" + "1234567890"
                                     + "1234567890" + "12345"
        );

        ValidationResult<Member> result = ValidationExecutor.validate(member);

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