package test.doma.entity;

import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.SequenceGenerator;
import org.seasar.doma.Version;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(sequence = "EMPLOYEE_SEQ")
    public Integer deptId;

    public String deptName;

    @Version
    public Integer version;

}
