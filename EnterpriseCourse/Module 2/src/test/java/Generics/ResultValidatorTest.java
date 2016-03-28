package Generics;

import org.testng.annotations.Test;


public class ResultValidatorTest {

    @Test
    public void testIsValid() throws Exception {
        ResultValidator validator = new ResultValidator();
        long result = 10;
        if (validator.isValid(result)) {
            System.out.println("Result is valid");
        } else {
            System.out.println("Result is invalid (<0)");
        }
    }
}