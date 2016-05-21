package parser;

import operations.*;

public class UtilParse {

    public Object performOperation(String operation, Object operand1, Object operand2) {

        OperationRegistration operatorRegister = new OperationRegistration();
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
            Operator operationClass = operatorRegister.operations.get(operation);
            result = operationClass.execute(operand1, operand2);
        } catch (NullPointerException e) {
            System.out.println("This operation is invalid or unregistered.");
        }


        return result;
    }

}
