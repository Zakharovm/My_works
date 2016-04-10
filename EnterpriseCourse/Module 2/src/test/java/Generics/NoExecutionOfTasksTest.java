package generics;

import org.junit.BeforeClass;
import org.junit.Test;

public class NoExecutionOfTasksTest {
    private static Executor<Long> numberExecutor;

    @BeforeClass
    public static void setUpClass() {
        numberExecutor = new ExecutorImpl();
    }

    @Test(expected = NoExecutionOfTasks.class)
    public void getValidResults() throws RuntimeException {
        numberExecutor.getValidResults();

    }

    @Test(expected = NoExecutionOfTasks.class)
    public void getInvalidResults() throws RuntimeException {
        numberExecutor.getInvalidResults();

    }
}
