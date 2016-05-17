package parser;

import operations.*;

public class UtilParse {
    private Object result = 0;

    public Object performOperation(String operation, Object operand1, Object operand2) {

        switch (operation) {
            case "+": {
                if (operand1 instanceof Double || operand2 instanceof Double) {
                    result = new DoubleAddition().execute((Double) operand1, (Double) operand2);

                } else if (operand1 instanceof Float || operand2 instanceof Float) {
                    result = new FloatAddition().execute((Float) operand1, (Float) operand2);

                } else if (operand1 instanceof Long || operand2 instanceof Long) {
                    result = new LongAddition().execute((Long) operand1, (Long) operand2);

                } else if (operand1 instanceof Integer || operand2 instanceof Integer) {
                    result = new IntegerAddition().execute((Integer) operand1, (Integer) operand2);

                }
                break;

            }

            case "-": {
                if (operand1 instanceof Double || operand2 instanceof Double) {
                    result = new DoubleSubtraction().execute((Double) operand1, (Double) operand2);

                } else if (operand1 instanceof Float || operand2 instanceof Float) {
                    result = new FloatSubtraction().execute((Float) operand1, (Float) operand2);

                } else if (operand1 instanceof Long || operand2 instanceof Long) {
                    result = new LongSubtraction().execute((Long) operand1, (Long) operand2);

                } else if (operand1 instanceof Integer || operand2 instanceof Integer) {
                    result = new IntegerSubtraction().execute((Integer) operand1, (Integer) operand2);

                }
                break;

            }

            default:
                System.out.println("Error. No such operation.");


        }

        return result;
    }

}
