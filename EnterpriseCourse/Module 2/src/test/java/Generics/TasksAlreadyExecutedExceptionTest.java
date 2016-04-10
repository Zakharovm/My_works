package generics;

import org.junit.BeforeClass;
import org.junit.Test;

public class TasksAlreadyExecutedExceptionTest {
    private static Executor<Long> numberExecutor;

    @BeforeClass
    public static void setUpClass() {
        numberExecutor = new ExecutorImpl();
        numberExecutor.execute();

    }

    @Test(expected = TasksAlreadyExecutedException.class)
    public void addTask () throws RuntimeException {
        numberExecutor.addTask(new TaskImpl(20L, 80L, '+'));

    }
}
