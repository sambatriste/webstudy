package jp.co.tis.adc.webstudy.member;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class MemberFindForm {

    private String id;

    @NotNull
    @Digits(integer = 9, fraction = 0)
    public String getId() {
        return id;
    }

    public Integer getParsedId() {
        return Integer.parseInt(id);
    }

    public void setId(String id) {
        this.id = id;
    }
}
