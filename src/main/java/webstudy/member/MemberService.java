package webstudy.member;

import webstudy.entity.Member;

import java.util.List;

class MemberService {

    private final MemberDaoImpl dao;

    MemberService() {
        this(new MemberDaoImpl());
    }

    MemberService(MemberDaoImpl dao) {
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

    void update(Member member) {
        dao.update(member);
    }

    void delete(Member member) {
        dao.delete(member);
    }
}
