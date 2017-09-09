package test.doma.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity
public class MemberDept {

    public Integer memberId;

    public String familyName;

    public String lastName;

    public Integer deptId;

    public String deptName;
}
