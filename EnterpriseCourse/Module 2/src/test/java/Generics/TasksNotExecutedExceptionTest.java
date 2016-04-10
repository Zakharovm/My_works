package generics;

import org.junit.BeforeClass;
import org.junit.Test;

public class TasksNotExecutedExceptionTest {
    private static Executor<Long> numberExecutor;

    @BeforeClass
    public static void setUpClass() {
        numberExecutor = new ExecutorImpl();
    }

    @Test(expected = TasksNotExecutedException.class)
    public void getValidResults() throws RuntimeException {
        numberExecutor.getValidResults();

    }

    @Test(expected = TasksNotExecutedException.class)
    public void getInvalidResults() throws RuntimeException {
        numberExecutor.getInvalidResults();

    }
}
