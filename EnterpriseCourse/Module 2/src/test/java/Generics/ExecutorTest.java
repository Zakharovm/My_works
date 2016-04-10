package generics;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;



public class ExecutorTest {
    private static Executor<Long> numberExecutor;

    @BeforeClass
    public static void setUpClass() {
        numberExecutor = new ExecutorImpl();
        numberExecutor.addTask(new TaskImpl(15L, 15L, '+'), new ResultValidator());
        numberExecutor.addTask(new TaskImpl(-15L, 15L, '+'), new ResultValidator());
        numberExecutor.addTask(new TaskImpl(-10L, -15L, '+'), new ResultValidator());
        numberExecutor.addTask(new TaskImpl(-10L, -15L, '+'));
        numberExecutor.execute();

    }

    @Test
    public void getValidResults() throws Exception {
        System.out.println("Valid results:");
        List<Long> validResults = numberExecutor.getValidResults();
        for (int i = 0; i < validResults.size(); i++) {
            Long number = (Long) validResults.get(i);
            System.out.println(number);
        }
    }

    @Test
    public void getInvalidResults () throws Exception {
        System.out.println("Invalid results:");
        List<Long> invalidResults = numberExecutor.getInvalidResults();
        for (int i = 0; i < invalidResults.size(); i++) {
            Long number = (Long) invalidResults.get(i);
            System.out.println(number);
        }

    }

}