package Generics;

import java.util.List;

public class Test {

    @org.junit.Test
    public void testGenerics(List<Task<Long>> intTasks) throws RuntimeException {
        Executor<Long> numberExecutor = new ExecutorImpl();

        for (Task<Long> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }
        numberExecutor.addTask(new TaskImpl(10L, 15L, '+'), new ResultValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        List<Long> validResults = numberExecutor.getValidResults();
        for (int i = 0; i < validResults.size(); i++) {
            Long number = (Long) validResults.get(i);
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        List<Long> invalidResults = numberExecutor.getInvalidResults();
        for (int i = 0; i < invalidResults.size(); i++) {
            Long number = (Long) invalidResults.get(i);
            System.out.println(number);
        }

    }
}

