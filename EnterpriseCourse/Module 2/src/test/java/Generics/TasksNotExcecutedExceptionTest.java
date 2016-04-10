package generics;

import org.junit.BeforeClass;
import org.junit.Test;

public class TasksNotExcecutedExceptionTest {
    private static Executor<Long> numberExecutor;

    @BeforeClass
    public static void setUpClass() {
        numberExecutor = new ExecutorImpl();
    }

    @Test(expected = TasksNotExcecutedException.class)
    public void getValidResults() throws RuntimeException {
        numberExecutor.getValidResults();

    }

    @Test(expected = TasksNotExcecutedException.class)
    public void getInvalidResults() throws RuntimeException {
        numberExecutor.getInvalidResults();

    }
}
