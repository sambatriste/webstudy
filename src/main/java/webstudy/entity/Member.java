package webstudy.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;
import org.seasar.doma.Version;

/**
 * メンバー。
 */
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequence = "MEMBER_SEQ")
    private Integer memberId;

    private String familyName;

    private String lastName;

    private Integer deptId;

    @Version
    private Integer version;


    public Integer getMemberId() {
        return memberId;
    }

    public String getFamilyName() {
        return familyName;
    }


    public String getLastName() {
        return lastName;
    }

    public Integer getDeptId() {
        return deptId;
    }


    public Integer getVersion() {
        return version;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDeptId(Integer deptId) {this.deptId = deptId; }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
