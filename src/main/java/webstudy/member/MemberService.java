package webstudy.member;

import org.seasar.doma.jdbc.tx.TransactionManager;
import webstudy.db.AppConfig;
import webstudy.entity.Dept;
import webstudy.entity.Member;
import webstudy.entity.MemberDept;
import java.util.List;

class MemberService {

    private final MemberDao dao;
    TransactionManager tm = AppConfig.singleton().getTransactionManager();

    MemberService() {
        this(new MemberDaoImpl());
    }

    MemberService(MemberDao dao) {
        this.dao = dao;
    }

    List<Member> getAllMembers() {
        return tm.required(() -> {
            return dao.selectAll();
        });
    }

    List<MemberDept> getAllMembersWithDept() {
        return tm.required(() -> {
            return dao.selectMemberDeptAll();
        });
    }

    List<Dept> getAllDepts() {
        return tm.required(() -> {
            return dao.selectDeptAll();
        });
    }

    void register(Member member) {
        tm.required(() -> {
            dao.insert(member);
        });
    }

    MemberDept findById(Integer memberId) {
        return tm.required(() -> {
            return dao.selectById(memberId);
        });
    }

    Dept findByDeptId(Integer deptId) {
        return tm.required(() -> {
            return dao.selectByDeptId(deptId);
        });
    }

    void update(Member member) {
        tm.required(() -> {
            dao.update(member);
         });
    }

    void delete(MemberDept member) {
        tm.required(() -> {
            dao.delete(member);
        });
    }
}
