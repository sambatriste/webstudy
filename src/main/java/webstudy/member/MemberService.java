package webstudy.member;

import org.seasar.doma.jdbc.tx.TransactionManager;
import webstudy.db.AppConfig;
import webstudy.entity.Member;

import java.util.List;

class MemberService {

    private final MemberDaoImpl dao;
    //AppConfig AppConfig = new AppConfig();
    TransactionManager tm = AppConfig.singleton().getTransactionManager();


    MemberService() {
        this(new MemberDaoImpl());
    }

    MemberService(MemberDaoImpl dao) {
        this.dao = dao;
    }

    List<Member> getAllMembers() {
        return tm.required(() -> {
            dao.selectAll();
            tm.run;
        });
    }

    void register(Member member) {
        tm.required(() -> {
            dao.insert(member);
            tm.run;
        });
    }


    Member findById(Integer memberId) {
        return dao.selectById(memberId);
    }

    void update(Member member) {
        dao.update(member);
    }

    void delete(Member member) {
        dao.delete(member);
    }
}
