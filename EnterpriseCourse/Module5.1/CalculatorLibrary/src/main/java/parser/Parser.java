package parser;

import java.util.LinkedList;

public class Parser {
    private Object operand1;
    private Object operand2;
    private String operator;

    // The string is divided by the " " (space). Example: + 2 3
    public void determine(String expression) {
        LinkedList<Integer> numbers = new LinkedList<>();
        StringBuilder number = new StringBuilder();
        StringBuilder operation = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if (symbol - '0' < 9 && symbol - '0' > 0) { //number checking
                number.append(symbol);

            } else if (symbol == ' ') {
                if (number.length() > 0) {
                    numbers.push(Integer.parseInt(number.toString())); // adding the number to the stack
                    number = new StringBuilder();

                }
                if (operation.length() > 0) {
                    operator = operation.toString();
                }

            } else { // if it's operation symbol
                operation.append(symbol);       // create the operator name

            }

        }
        numbers.push(Integer.parseInt(number.toString()));

        operand2 = numbers.pop(); // достаем второе число
        operand1 = numbers.pop(); // достаем первое число

    }

    public Object getOperand1() {
        return operand1;
    }

    public Object getOperand2() {
        return operand2;
    }

    public String getOperator() {
        return operator;
    }
}
