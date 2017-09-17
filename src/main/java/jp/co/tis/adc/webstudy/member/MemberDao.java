package jp.co.tis.adc.webstudy.member;

import jp.co.tis.adc.webstudy.db.AppConfig;
import jp.co.tis.adc.webstudy.entity.Member;
import jp.co.tis.adc.webstudy.entity.MemberDept;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

import java.util.List;

/**
 * {@link Member}のDAO。
 */
@Dao(config = AppConfig.class)
public interface MemberDao {

    /**
     * 全件取得する
     * @return {@link} メンバー全件
     */
    @Select
    List<Member> selectAll();

    /**
     * IDを指定して{@link Member}を取得する。
     * @param id メンバーID
     * @return {@link Member}
     */
    @Select
    Member selectById(Integer id);

    /**
     * メンバーと部署を結合して取得する。
     * @return {@link MemberDept}
     */
    @Select
    List<MemberDept> selectMemberDeptAll();

    /**
     * 登録する。
     * @param member メンバー
     * @return 件数
     */
    @Insert
    int insert(Member member);

    /**
     * 更新する。
     * @param member メンバー
     * @return 件数
     */
    @Update
    int update(Member member);

    /**
     * 削除する。
     * @param member メンバー
     * @return 件数
     */
    @Delete
    int delete(Member member);

}
