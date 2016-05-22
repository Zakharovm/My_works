import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import parser.Parser;
import parser.UtilOperation;

import java.util.Scanner;

public class Runner {

    private static Parser parser;
    private static UtilOperation utilOperation;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);


        System.out.println("Input the expression(divide by spaces) {example: 2 + 3  or  2.4 - 2.1}:");
        String input = scanner.nextLine();
        parser.determine(input);
        Object operand1 = parser.getOperand1();
        Object operand2 = parser.getOperand2();
        Object result = utilOperation.performOperation(parser.getOperator(), operand1, operand2);
        System.out.println("Result: \n" + operand1 + " " + parser.getOperator() + " " + operand2 + " = " + result);

    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public void setUtilOperation(UtilOperation utilOperation) {
        this.utilOperation = utilOperation;
    }
}
