package test.doma.dao;


import org.junit.Rule;
import org.junit.Test;
import org.seasar.doma.jdbc.tx.TransactionManager;
import test.doma.AppConfig;
import test.doma.DbResource;
import test.doma.entity.Member;
import test.doma.entity.MemberDept;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class MemberDaoTest {
    @Rule
    public final DbResource dbResource = new DbResource();

    private final MemberDao dao = new MemberDaoImpl();
    private TransactionManager tm = AppConfig.singleton().getTransactionManager();

    @Test
    public void testSelectById() {

        tm.required(() -> {
            Member member = dao.selectById(1);
            assertThat(member, is(notNullValue()));
            assertThat(member.familyName, is("山田"));
            assertThat(member.lastName, is("太郎"));
            assertThat(member.version, is(0));
        });
    }

    @Test
    public void testSelectAll() {
        List<Member> memberList = tm.required(dao::selectAll);

        assertThat(memberList.size(), is(2));
    }

    @Test
    public void testJoin() {
        List<MemberDept> memberDeptList = tm.required(dao::selectMemberDeptAll);

        assertThat(memberDeptList, is(notNullValue()));
        assertThat(memberDeptList.size(), is(2));

        {
            MemberDept memberDept = memberDeptList.get(0);
            assertThat(memberDept.memberId, is(1));
            assertThat(memberDept.familyName, is("山田"));
            assertThat(memberDept.lastName, is("太郎"));
            assertThat(memberDept.deptId, is(1));
            assertThat(memberDept.deptName, is("人事部"));
        }
        {
            MemberDept memberDept = memberDeptList.get(1);
            assertThat(memberDept.memberId, is(2));
            assertThat(memberDept.familyName, is("田中"));
            assertThat(memberDept.lastName, is("次郎"));
            assertThat(memberDept.deptId, is(1));
            assertThat(memberDept.deptName, is("人事部"));
        }


    }

    @Test
    public void testUpdate() {
        tm.required(() -> {
            Member member = dao.selectById(1);
            assertThat(member.familyName, is("山田"));

            member.familyName = "田中";
            dao.update(member);
        });

        tm.required(() -> {
            Member updated = dao.selectById(1);
            assertThat(updated.familyName, is("田中"));
        });
    }

    @Test
    public void testInsert() {
        Member newMember = new Member();
        newMember.familyName = "鈴木";
        newMember.lastName = "三郎";
        newMember.deptId = 1;

        tm.required(() -> dao.insert(newMember));
        assertThat(newMember.memberId, is(notNullValue()));
    }

    @Test
    public void testDelete() {
        tm.required(() -> {
            Member member = dao.selectById(1);
            dao.delete(member);
        });

        tm.required(() -> {
            assertThat(dao.selectMemberDeptAll().size(), is(1));
        });

    }
}