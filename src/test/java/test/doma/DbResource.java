package test.doma;

import jp.co.tis.adc.webstudy.util.SimpleBeanUtil;
import org.junit.rules.ExternalResource;
import org.seasar.doma.Dao;
import org.seasar.doma.jdbc.tx.TransactionManager;
import test.doma.dao.AppDao;
import test.doma.dao.MemberDao;

import static org.junit.Assume.assumeNoException;


public class DbResource extends ExternalResource {

    private AppDao dao;

    @Override
    protected void before() throws Throwable {
        try {
            dao = SimpleBeanUtil.newInstance(AppDao.class.getName() + "Impl");
        } catch (RuntimeException e) {
            assumeNoException(e);
        }

        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        tm.required(() -> {
            dao.create();
        });
    }

    @Override
    protected void after() {
        TransactionManager tm = AppConfig.singleton().getTransactionManager();
        tm.required(() -> {
            dao.drop();
        });
    }

}
