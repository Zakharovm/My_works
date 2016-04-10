package Generics;

public class TaskImpl implements Task<Long> {
    private Long operand1;
    private Long operand2;
    private char operation;
    private Long result;

    public TaskImpl(Long operand1, Long operand2, char operation) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operation = operation;
    }

    public TaskImpl(char operation) {
        this.operation = operation;
    }

    @Override
    public void execute() {
        switch (operation) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            default:
                System.out.println("No such operation");
        }
    }

    @Override
    public Long getResult() {
        return result;
    }
}
