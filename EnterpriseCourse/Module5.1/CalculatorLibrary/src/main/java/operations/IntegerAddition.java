package operations;

public class IntegerAddition implements Operator<Integer> {

    @Override
    public Integer execute(Integer operand1, Integer operand2) {
        return operand1 + operand2;
    }
}
