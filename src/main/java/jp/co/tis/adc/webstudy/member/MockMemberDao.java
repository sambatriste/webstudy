package jp.co.tis.adc.webstudy.member;


import jp.co.tis.adc.webstudy.entity.Member;
import jp.co.tis.adc.webstudy.entity.MemberDept;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MockMemberDao implements MemberDao {


    private static final Map<Integer, Member> members = new ConcurrentHashMap<>();

    private static final AtomicInteger idGenerator = new AtomicInteger(1);

    static {
        Member yamada = new Member();
        yamada.setFamilyName("山田");
        yamada.setLastName("太郎");
        add(yamada);
        Member tanaka = new Member();
        tanaka.setFamilyName("田中");
        tanaka.setLastName("次郎");
        add(tanaka);
    }

    @Override
    public List<Member> selectAll() {
        return new ArrayList<>(members.values());
    }

    @Override
    public Member selectById(Integer id) {
        return members.get(id);
    }

    @Override
    public List<MemberDept> selectMemberDeptAll() {
        throw new UnsupportedOperationException("not implemented.");
    }

    @Override
    public int insert(Member member) {
        add(member);
        return 1;
    }

    @Override
    public int update(Member member) {
        members.put(member.getMemberId(), member);
        return 1;
    }

    @Override
    public int delete(Member member) {
        members.remove(member.getMemberId());
        return 1;
    }

    private static void add(Member member) {
        int newId = idGenerator.getAndIncrement();
        member.setMemberId(newId);
        members.put(newId, member);
    }
}
