package parser;

import java.util.LinkedList;

// Import log4j classes


public class Parser {
    private Object operand1;
    private Object operand2;
    private String operator;

    // The string is divided by the " " (space). Example: + 2 3
    public void determine(String expression) {
        LinkedList<Integer> numbers = new LinkedList<>();
        LinkedList<Double> numbersDouble = new LinkedList<>();
        StringBuilder number = new StringBuilder();
        StringBuilder operation = new StringBuilder();
        boolean floatNumber = false;

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if (symbol - '0' <= 9 && symbol - '0' >= 0) { //number checking
                number.append(symbol);

            } else if (symbol == '.') {
                if (number.length() > 0) {
                    number.append(symbol);
                    floatNumber = true;
                } else {

                    System.out.println("Input error.");
                    operand1 = 0;
                    operand2 = 0;
                    operator = "null";
                    break;
                }

            } else if (symbol == ' ') {
                if (number.length() > 0) {
                    if (floatNumber) {
                        numbersDouble.push(Double.parseDouble(number.toString())); // adding the number to the stack
                    } else {
                        numbers.push(Integer.parseInt(number.toString())); // adding the number to the stack
                    }

                    number = new StringBuilder();

                }
                if (operation.length() > 0) {
                    operator = operation.toString();
                }

            } else { // if it's operation symbol
                operation.append(symbol);       // create the operator name

            }

        }
        if (floatNumber) {
            numbersDouble.push(Double.parseDouble(number.toString()));
        } else {
            numbers.push(Integer.parseInt(number.toString()));
        }


        if (floatNumber) {
            operand2 = numbersDouble.pop(); // достаем второе число
            operand1 = numbersDouble.pop(); // достаем первое число
        } else {
            operand2 = numbers.pop(); // достаем второе число
            operand1 = numbers.pop(); // достаем первое число
        }


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
