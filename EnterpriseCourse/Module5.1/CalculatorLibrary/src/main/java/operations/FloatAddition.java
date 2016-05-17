package operations;

public class FloatAddition implements Operator<Float> {
    private float result = 0;

    @Override
    public Float execute(Float operand1, Float operand2) {
        return operand1 + operand2;
    }

    public float getResult() {
        return result;
    }
}

