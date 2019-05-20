package webstudy.member.serivce;

import webstudy.entity.Member;
import webstudy.member.dao.MemberDao;
import webstudy.member.dao.MemberDaoImpl;

import java.util.List;

public class MemberService {

    private final MemberDao dao;

    public MemberService() {
        this(new MemberDaoImpl());
    }

    public MemberService(MemberDao dao) {
        this.dao = dao;
    }

    public List<Member> getAllMembers() {
        return dao.selectAll();
    }

    public void register(Member member) {
        dao.insert(member);
    }

    public Member findById(Integer memberId) {
        return dao.selectById(memberId);
    }

    public void update(Member member) {
        dao.update(member);
    }

    public void delete(Member member) {
        dao.delete(member);
    }
}
