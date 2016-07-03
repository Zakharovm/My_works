package app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import parser.Parser;
import parser.UtilOperation;

import java.util.Scanner;

@Component
public class Runner {

    private static Logger LOGGER = LoggerFactory.getLogger(app.Runner.class);

    private static Parser parser;
    private static UtilOperation utilOperation;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("This application supports only such types of data: Integer, Long, Float, Double. But both operands should be of the same type.");

        LOGGER.info("User inputs the expression.");
        System.out.println("Input the expression(divide by spaces) {example: 2 + 3  or  2.4 - 2.1}:");

        String input = scanner.nextLine();
        LOGGER.info("The input string is divided into operands.");

        parser.determine(input);
        Object operand1 = parser.getOperand1();
        Object operand2 = parser.getOperand2();
        String operator = parser.getOperator();
        LOGGER.info("Start performing the operation.");
        Object result = utilOperation.performOperation(operator, operand1, operand2);
        LOGGER.info("Finish performing the operation.");
        System.out.println("Result: \n" + operand1 + " " + parser.getOperator() + " " + operand2 + " = " + result);

    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public void setUtilOperation(UtilOperation utilOperation) {
        this.utilOperation = utilOperation;
    }
}
