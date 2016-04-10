package Generics;

import java.util.*;

public class ExecutorImpl implements Executor<Long> {

    private List<Long> validResults = new ArrayList<>();
    private List<Long> invalidResults = new ArrayList<>();
    private List<Task<Long>> addedTasks = new ArrayList<>();
    private Map<Task<Long>, Validator<Long>> addedTasksValidator = new HashMap<>();
    private boolean tasksExecuted = false;


    @Override
    public void addTask(Task<Long> task) throws RuntimeException {
        addedTasks.add(task);
        if (tasksExecuted) {
            throw new executedTasks();
        }

    }

    @Override
    public void addTask(Task<Long> task, Validator<Long> validator) throws RuntimeException {
        addedTasksValidator.put(task, validator);
        if (tasksExecuted) {
            throw new executedTasks();
        }

    }

    @Override
    public void execute() {
        addedTasks
                .stream()
                .forEach(element -> element.execute());

        Iterator<Map.Entry<Task<Long>, Validator<Long>>> itr1 = addedTasksValidator.entrySet().iterator();

        while (itr1.hasNext()) {
            Map.Entry<Task<Long>, Validator<Long>> pair = itr1.next();

            Task<Long> task = pair.getKey();
            Validator<Long> validator = pair.getValue();
            pair.getKey().execute();

            if (validator.isValid(task.getResult())) {
                validResults.add(task.getResult());
            } else {
                invalidResults.add(task.getResult());
            }

        }
        tasksExecuted = true;
    }

    @Override
    public List<Long> getValidResults () throws RuntimeException {
        if (!tasksExecuted) {
            throw new noExecutionOfTasks();
        }

        return validResults;
    }

    @Override
    public List<Long> getInvalidResults () throws RuntimeException {
        if (!tasksExecuted) {
            throw new noExecutionOfTasks();
        }

        return invalidResults;
    }

}
