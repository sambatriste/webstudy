package test.doma.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;
import org.seasar.doma.Version;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequence = "MEMBER_SEQ")
    public Integer memberId;

    public String familyName;

    public String lastName;

    public Integer deptId;
    @Version
    public Integer version;

}
