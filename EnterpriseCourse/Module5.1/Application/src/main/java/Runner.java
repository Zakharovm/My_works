import aop.parser.LogAspect;
import aop.parser.Parser;
import aop.parser.UtilOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;


public class Runner {

    // Define a static logger variable so that it references the
    // Logger instance named "Runner".
    private static Logger LOGGER = LoggerFactory.getLogger(Runner.class);

    private static Parser parser;
    private static UtilOperation utilOperation;
    private static LogAspect logAspect;


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        applicationContext = new ClassPathXmlApplicationContext("aop-context.xml");

        System.out.println("This application supports only such types of data: Integer, Long, Float, Double. But both operands should be of the same type.");

        LOGGER.info("User inputs the expression.");
        System.out.println("Input the expression(divide by spaces) {example: 2 + 3  or  2.4 - 2.1}:");

        String input = scanner.nextLine();
        LOGGER.info("The input string is divided into operands.");
        parser.determine(input);
        Object operand1 = parser.getOperand1();
        Object operand2 = parser.getOperand2();
        LOGGER.info("Start performing the operation.");
        Object result = utilOperation.performOperation(parser.getOperator(), operand1, operand2);
        LOGGER.info("Finish performing the operation.");
        System.out.println("Result: \n" + operand1 + " " + parser.getOperator() + " " + operand2 + " = " + result);

    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public void setLogAspect(LogAspect logAspect) {
        this.logAspect = logAspect;
    }

    public void setUtilOperation(UtilOperation utilOperation) {
        this.utilOperation = utilOperation;
    }
}
