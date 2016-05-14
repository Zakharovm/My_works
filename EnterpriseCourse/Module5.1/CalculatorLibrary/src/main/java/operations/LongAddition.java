package operations;

public class LongAddition implements Operator<Long> {

    @Override
    public Long execute(Long operand1, Long operand2) {
        return operand1 + operand2;
    }
}
