package jp.co.tis.adc.webstudy.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

class MemberService {

    private static final Map<Integer, Member> members = new ConcurrentHashMap<>();

    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    static {
        add(new Member("山田", "太郎"));
        add(new Member("田中", "次郎"));
    }

    List<Member> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    void register(Member member) {
        members.put(member.getId(), member);
    }

    Member findById(Integer id) {
        return members.get(id);
    }

    void update(Member member) {
        members.put(member.getId(), member);
    }

    private static void add(Member member) {
        int newId = idGenerator.getAndIncrement();
        member.setId(newId);
        members.put(newId, member);
    }


}
