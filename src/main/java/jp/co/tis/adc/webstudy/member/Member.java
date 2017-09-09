package jp.co.tis.adc.webstudy.member;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



public class Member {

    private Integer id;

    private String familyName;

    private String lastName;

    public Member() {
    }

    public Member(String familyName, String lastName) {
        this(null, familyName, lastName);
    }

    public Member(Integer id, String familyName, String lastName) {
        this.id = id;
        this.familyName = familyName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @NotEmpty(message = "姓は必須項目です。")
    @Size(max = 64, message = "姓は1〜64文字で入力してください。")
    public String getFamilyName() {
        return familyName;
    }


    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @NotEmpty(message = "名は必須項目です。")
    @Size(max = 64, message = "名は1〜64文字で入力してください。")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", familyName='" + familyName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
