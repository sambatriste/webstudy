package webstudy.member;

import org.seasar.doma.jdbc.tx.TransactionManager;
import webstudy.db.AppConfig;
import webstudy.entity.Member;
import java.util.List;

class MemberService {

    private final MemberDao dao;
    TransactionManager tm = AppConfig.singleton().getTransactionManager();

    MemberService() {
        this( new MemberDaoImpl());
    }

    MemberService(MemberDao dao) {
        this.dao = dao;
    }

    List<Member> getAllMembers() {
        return tm.required(() -> {
            return dao.selectAll();
        });
    }

    void register(Member member) {
        tm.required(() -> {
            dao.insert(member);
        });
    }

    Member findById(Integer memberId) {
        return tm.required(() -> {
            return dao.selectById(memberId);
        });
    }

    void update(Member member) {
        tm.required(() -> {
            dao.update(member);
         });
    }

    void delete(Member member) {
        tm.required(() -> {
            dao.delete(member);
        });
    }
}
