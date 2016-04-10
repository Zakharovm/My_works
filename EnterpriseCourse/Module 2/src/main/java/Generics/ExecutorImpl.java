package Generics;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl implements Executor<Long> {

    private List<Long> validResults = new ArrayList<>();
    private List<Long> invalidResults = new ArrayList<>();
    private boolean tasksExecuted = false;

    @Override
    public void addTask(Task<Long> task) {
        try {
            task.execute();
            validResults.add(task.getResult());
            if (tasksExecuted) {
                throw new executedTasks();
            }
        } catch (Exception executedTasks) {
            System.out.println("Tasks were executed before. So you can't add tasks anymore");
        }

    }

    @Override
    public void addTask(Task<Long> task, Validator<Long> validator) {
        task.execute();
        try {
            if (validator.isValid(task.getResult())) {
                validResults.add(task.getResult());
                if (tasksExecuted) {
                    throw new executedTasks();
                }
            } else {
                invalidResults.add(task.getResult());
            }
        } catch (Exception executedTasks) {
            System.out.println("Tasks were executed before. So you can't add tasks anymore");
        }

    }

    @Override
    public void execute() {
        tasksExecuted = true;
    }

    @Override
    public List<Long> getValidResults() {
        try {
            if (!tasksExecuted) {
                throw new notExecutedTasks();
            }
        } catch (Exception notExecutedTasks) {
            System.out.println("Tasks were not executed before.");
        }
        return validResults;
    }

    @Override
    public List<Long> getInvalidResults() {
        return invalidResults;
    }
}
