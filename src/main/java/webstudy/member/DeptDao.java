package webstudy.member;

import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import webstudy.db.AppConfig;
import webstudy.entity.Dept;

/**
 * Created by tie304275 on 2018/03/02.
 */
@Dao(config = AppConfig.class)
public interface DeptDao {
    /**
     * IDを指定して{@link Dept}を取得する
     * @param id 部署ID
     * @return {@link Dept}
     */
    @Select
    Dept selectById(Integer id);
}
