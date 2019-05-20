package webstudy.member.dao;

import org.junit.Ignore;
import org.junit.Test;
import webstudy.db.TestAppConfig;
import webstudy.db.TestTransaction;
import webstudy.entity.Member;
import webstudy.entity.MemberDept;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class MemberDaoTest {

    private TestTransaction tran = new TestTransaction(TestAppConfig.singleton());

    private MemberDao dao = new MemberDaoImpl(TestAppConfig.singleton());

    @Test
    public void testSelectById() {
        Member member = tran.execute(() -> {
            return dao.selectById(1);
        });
        assertThat(member, is(notNullValue()));
        assertThat(member.getFamilyName(), is("山田"));
        assertThat(member.getLastName(), is("太郎"));
        assertThat(member.getVersion(), is(0));

    }

    @Test
    public void testSelectAll() {
        List<Member> memberList = tran.execute(() -> {
            return dao.selectAll();
        });
        assertThat(memberList.size(), is(2));
    }

    @Ignore
    @Test
    public void testJoin() {
        List<MemberDept> memberDeptList = tran.execute(() -> {
            return dao.selectMemberDeptAll();
        });

        assertThat(memberDeptList, is(notNullValue()));
        assertThat(memberDeptList.size(), is(2));

        {
            MemberDept memberDept = memberDeptList.get(0);
            assertThat(memberDept.getMemberId(), is(1));
            assertThat(memberDept.getFamilyName(), is("山田"));
            assertThat(memberDept.getLastName(), is("太郎"));
            assertThat(memberDept.getDeptId(), is(1));
            assertThat(memberDept.getDeptName(), is("人事部"));
        }
        {
            MemberDept memberDept = memberDeptList.get(1);
            assertThat(memberDept.getMemberId(), is(2));
            assertThat(memberDept.getFamilyName(), is("田中"));
            assertThat(memberDept.getLastName(), is("次郎"));
            assertThat(memberDept.getDeptId(), is(1));
            assertThat(memberDept.getDeptName(), is("人事部"));
        }
    }

    @Test
    public void testUpdate() {
        tran.execute(() -> {
            Member member = dao.selectById(1);
            assertThat(member.getFamilyName(), is("山田"));

            member.setFamilyName("田中");
            dao.update(member);

            Member updated = dao.selectById(1);
            assertThat(updated.getFamilyName(), is("田中"));
        });
    }

    @Test
    public void testInsert() {
        Member newMember = new Member();
        newMember.setFamilyName("鈴木");
        newMember.setLastName("三郎");

        tran.execute(() -> dao.insert(newMember));
        assertThat(newMember.getMemberId(), is(notNullValue()));
    }

    @Test
    public void testDelete() {
        tran.execute(() -> {
            Member member = dao.selectById(1);
            dao.delete(member);
            assertThat(dao.selectAll().size(), is(1));
        });
    }
}