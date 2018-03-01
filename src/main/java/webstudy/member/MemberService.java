package webstudy.member;

import org.seasar.doma.jdbc.tx.TransactionManager;
import webstudy.db.AppConfig;
import webstudy.entity.Member;
import webstudy.entity.MemberDept;

import java.util.List;

class MemberService {

    private final MemberDao dao;

    MemberService() {
        this(new MemberDaoImpl());
    }

    private MemberService(MemberDao dao) {
        this.dao = dao;
    }

    List<MemberDept> getAllMembers() {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        return tm.required(() -> {
            return dao.selectMemberDeptAll();
        });
    }

    void register(Member member) {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        tm.required(() -> {
            dao.insert(member);
        });
    }

    Member findById(Integer memberId) {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        return tm.required(() -> {
            return dao.selectById(memberId);
        });
    }

    void update(Member member) {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        tm.required(() -> {
            dao.update(member);
        });
    }

    void delete(Member member) {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        tm.required(() -> {
            dao.delete(member);
        });
    }
}
