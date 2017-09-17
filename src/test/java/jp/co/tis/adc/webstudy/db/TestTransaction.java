package jp.co.tis.adc.webstudy.db;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.tx.TransactionManager;

import java.util.function.Supplier;

public class TestTransaction {

    private final TransactionManager tm;

    public TestTransaction() {
        this(TestAppConfig.singleton());
    }

    public TestTransaction(Config testAppConfig) {
        this(testAppConfig.getTransactionManager());
    }

    public TestTransaction(TransactionManager transactionManager) {
        this.tm = transactionManager;
    }

    public <RESULT> RESULT execute(Supplier<RESULT> supplier) {
        return tm.required(() -> executeInTransaction(supplier));
    }


    public void execute(Runnable runnable) {
        execute((Supplier<Void>) () -> {
            runnable.run();
            return null;
        });
    }

    private <RESULT> RESULT executeInTransaction(Supplier<RESULT> supplier) {
        try {
            return supplier.get();
        } finally {
            tm.setRollbackOnly();
        }
    }

}
