package generics;

import java.util.*;

public class ExecutorImpl implements Executor<Long> {

    private List<Long> validResults = new ArrayList<>();
    private List<Long> invalidResults = new ArrayList<>();

    private Map<Task<? extends Long>, Validator<? super Long>> addedTasks = new HashMap<>();
    private boolean tasksExecuted = false;


    @Override
    public void addTask(Task<? extends Long> task) throws RuntimeException {


        addedTasks.put(task, null);
        if (tasksExecuted) {
            throw new ExecutedTasks();
        }

    }

    @Override
    public void addTask(Task<? extends Long> task, Validator<? super Long> validator) throws RuntimeException {
        addedTasks.put(task, validator);
        if (tasksExecuted) {
            throw new ExecutedTasks();
        }

    }

    @Override
    public void execute() {
        addedTasks.forEach( (task, validator) -> task.execute());

        addedTasks.forEach( (task, validator) -> {
            if (validator == null) {
                validResults.add(task.getResult());

            } else {
                if (validator.isValid(task.getResult())) {
                    validResults.add(task.getResult());
                } else {
                    invalidResults.add(task.getResult());
                }
            }
        });

        tasksExecuted = true;
    }

    @Override
    public List<Long> getValidResults () throws RuntimeException {
        if (!tasksExecuted) {
            throw new NoExecutionOfTasks();
        }

        return validResults;
    }

    @Override
    public List<Long> getInvalidResults () throws RuntimeException {
        if (!tasksExecuted) {
            throw new NoExecutionOfTasks();
        }

        return invalidResults;
    }

}
