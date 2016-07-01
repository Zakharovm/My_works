package aop.parser;

import aop.operations.*;

import java.util.HashMap;
import java.util.Map;

public class UtilOperation {

    public Map<String, Operator> operations = new HashMap<>();

    public UtilOperation() {
        operations.put("+D", new DoubleAddition());
        operations.put("+F", new FloatAddition());
        operations.put("+L", new LongAddition());
        operations.put("+I", new IntegerAddition());
        operations.put("-D", new DoubleSubtraction());
        operations.put("-F", new FloatSubtraction());
        operations.put("-L", new LongSubtraction());
        operations.put("-I", new IntegerSubtraction());
    }

    public void register (String operationName, Operator operator) {
        operations.put(operationName, operator);
    }

    public Object performOperation(String operation, Object operand1, Object operand2) {


        Object result = null;

        switch (operation) {
            case "+": {
                if (operand1 instanceof Double && operand2 instanceof Double) {
                    operation = "+D";

                } else if (operand1 instanceof Float && operand2 instanceof Float) {
                    operation = "+F";

                } else if (operand1 instanceof Long && operand2 instanceof Long) {
                    operation = "+L";

                } else if (operand1 instanceof Integer && operand2 instanceof Integer) {
                    operation = "+I";

                }
                break;

            }

            case "-": {
                if (operand1 instanceof Double && operand2 instanceof Double) {
                    operation = "-D";

                } else if (operand1 instanceof Float && operand2 instanceof Float) {
                    operation = "-F";

                } else if (operand1 instanceof Long && operand2 instanceof Long) {
                    operation = "-L";

                } else if (operand1 instanceof Integer && operand2 instanceof Integer) {
                    operation = "-I";

                }
                break;

            }

        }

        try {
            Operator operationClass = operations.get(operation);
            result = operationClass.execute(operand1, operand2);
        } catch (NullPointerException e) {
            System.out.println("This operation is invalid or unregistered.");
        }


        return result;
    }

}
