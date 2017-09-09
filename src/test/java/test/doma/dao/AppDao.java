package test.doma.dao;


import org.seasar.doma.Dao;
import org.seasar.doma.Script;
import test.doma.AppConfig;

@Dao(config = AppConfig.class)
public interface AppDao {

    @Script
    void create();

    @Script
    void drop();

}
