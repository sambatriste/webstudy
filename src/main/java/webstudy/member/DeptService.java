package webstudy.member;

import org.seasar.doma.jdbc.tx.TransactionManager;
import webstudy.db.AppConfig;
import webstudy.entity.Dept;

/**
 * Created by tie304275 on 2018/03/02.
 */
public class DeptService {

    private final DeptDao dao;

    DeptService(){
        this(new DeptDaoImpl());
    }

    private DeptService(DeptDao dao){
        this.dao = dao;
    }

    Dept findById(Integer deptId){
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        return  tm.required(() ->{
            return dao.selectById(deptId);
                }
        );
    }
}
