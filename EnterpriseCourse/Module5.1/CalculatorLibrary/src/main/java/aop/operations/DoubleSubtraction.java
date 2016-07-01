package aop.operations;

public class DoubleSubtraction implements Operator<Double> {

    @Override
    public Double execute(Double operand1, Double operand2) {
        return operand1 + operand2;
    }
}
