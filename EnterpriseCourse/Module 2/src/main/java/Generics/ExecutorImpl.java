package Generics;

import java.util.*;

public class ExecutorImpl implements Executor<Long> {

    private List<Long> validResults = new ArrayList<>();
    private List<Long> invalidResults = new ArrayList<>();
    private List<Task<? extends Long>> addedTasks = new ArrayList<>();
    private Map<Task<? extends Long>, Validator<? super Long>> addedTasksValidator = new HashMap<>();
    private boolean tasksExecuted = false;


    @Override
    public void addTask(Task<? extends Long> task) throws RuntimeException {
        addedTasks.add(task);
        if (tasksExecuted) {
            throw new executedTasks();
        }

    }

    @Override
    public void addTask(Task<? extends Long> task, Validator<? super Long> validator) throws RuntimeException {
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

        Iterator<Map.Entry<Task<? extends Long>, Validator<? super Long>>> itr1 = addedTasksValidator.entrySet().iterator();

        while (itr1.hasNext()) {
            Map.Entry<Task<? extends Long>, Validator<? super Long>> pair = itr1.next();

            Task<? extends Long> task = pair.getKey();
            Validator<? super Long> validator = pair.getValue();
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
