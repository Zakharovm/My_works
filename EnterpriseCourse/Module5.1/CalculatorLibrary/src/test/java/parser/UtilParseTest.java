package parser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UtilParseTest {
    @Test
    public void performOperation() throws Exception {
        UtilParse parse = new UtilParse();

        List<Object> operations = new ArrayList<>();

        operations.add(parse.performOperation("+", 5, 10));
        operations.add(parse.performOperation("+", -100, 10));
        operations.add(parse.performOperation("+", 5.32, 10));
        operations.add(parse.performOperation("+", 5.32, 10.1));
        operations.add(parse.performOperation("-", -999, -1));
        operations.add(parse.performOperation("-", 5.3333, -3.3333));
        operations.add(parse.performOperation("-", 2, 1.5));
        operations.add(parse.performOperation("-", 5L, 10));
        operations.add(parse.performOperation("+", 5L, 12L));
        operations.add(parse.performOperation("-", 134L, 34L));

        operations.forEach(System.out::println);


    }

}