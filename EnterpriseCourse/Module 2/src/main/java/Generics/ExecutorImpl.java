package generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExecutorImpl implements Executor<Long> {

    private List<Long> validResults = new ArrayList<>();
    private List<Long> invalidResults = new ArrayList<>();

    private Map<Task<? extends Long>, Validator<? super Long>> tasks = new HashMap<>();
    private boolean tasksExecuted = false;


    @Override
    public void addTask(Task<? extends Long> task) throws RuntimeException {


        tasks.put(task, null);
        if (tasksExecuted) {
            throw new TasksAlreadyExecutedException();
        }

    }

    @Override
    public void addTask(Task<? extends Long> task, Validator<? super Long> validator) throws RuntimeException {
        tasks.put(task, validator);
        if (tasksExecuted) {
            throw new TasksAlreadyExecutedException();
        }

    }

    @Override
    public void execute() {
        tasksExecuted = true;
        
        tasks.forEach( (task, validator) -> task.execute());

        tasks.forEach( (task, validator) -> {
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

        
    }

    @Override
    public List<Long> getValidResults () throws RuntimeException {
        if (!tasksExecuted) {
            throw new TasksNotExecutedException();
        }

        return validResults;
    }

    @Override
    public List<Long> getInvalidResults () throws RuntimeException {
        if (!tasksExecuted) {
            throw new TasksNotExecutedException();
        }

        return invalidResults;
    }

}
