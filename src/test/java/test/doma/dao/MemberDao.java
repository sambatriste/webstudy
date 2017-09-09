package test.doma.dao;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import test.doma.AppConfig;
import test.doma.entity.Member;
import test.doma.entity.MemberDept;

import java.util.List;

@Dao(config = AppConfig.class)
public interface MemberDao {

    @Select
    List<Member> selectAll();

    @Select
    Member selectById(Integer id);

    @Select
    List<MemberDept> selectMemberDeptAll();

    @Insert
    int insert(Member member);

    @Update
    int update(Member member);

    @Delete
    int delete(Member member);

}
