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

    MemberService(MemberDao dao) {
        this.dao = dao;
    }

    List<Member> getAllMembers() {
        return dao.selectAll();
    }

    void register(Member member) {
        dao.insert(member);
    }

    Member findById(Integer memberId) {
        return dao.selectById(memberId);
    }

    MemberDept getUserInfo(Integer memberId) {
        return dao.selectMemberDeptById(memberId);
    }

    void update(Member member) {
        dao.update(member);
    }

    void delete(Member member) {
        dao.delete(member);
    }
}