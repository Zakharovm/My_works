package operations;

public class FloatAddition implements Operator<Float> {
    private float result = 0;

    @Override
    public void execute(Float operand1, Float operand2) {
        result = operand1 + operand2;
    }

    public float getResult() {
        return result;
    }
}

