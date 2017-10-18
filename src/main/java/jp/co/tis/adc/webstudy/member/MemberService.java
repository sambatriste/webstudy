package jp.co.tis.adc.webstudy.member;

import jp.co.tis.adc.webstudy.entity.Member;
import org.seasar.doma.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class MemberService {

    private final MemberDao dao;

    MemberService() {
        this(new MockMemberDao());
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

    void update(Member member) {
        dao.update(member);
    }

    void delete(Member member) {
        dao.delete(member);
    }
}
