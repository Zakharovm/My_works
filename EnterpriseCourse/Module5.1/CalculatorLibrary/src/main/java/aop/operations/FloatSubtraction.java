package aop.operations;

public class FloatSubtraction implements Operator<Float> {

    @Override
    public Float execute(Float operand1, Float operand2) {
        return operand1 - operand2;
    }
}