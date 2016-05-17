package parser;

import org.junit.Assert;
import org.junit.Test;

public class UtilParseTest {
    @Test
    public void performOperation() throws Exception {
        UtilParse parse = new UtilParse();

        Assert.assertEquals(parse.performOperation("+", 5, 10), 15);
        Assert.assertEquals(parse.performOperation("+", -100, 10), -90);
        Assert.assertEquals(parse.performOperation("+", 5.32f, 10f), 15.32f);
        Assert.assertEquals(parse.performOperation("+", 5.32d, 10.1d), 15.42d);
        Assert.assertEquals(parse.performOperation("-", -999, 1), -1000);
        Assert.assertEquals(parse.performOperation("-", 5.3333f, -3.3333f), 8.6666f);
        Assert.assertEquals(parse.performOperation("-", 2f, 1.5f), 0.5f);
        Assert.assertEquals(parse.performOperation("-", 5L, 10L), -5L);
        Assert.assertEquals(parse.performOperation("+", 5L, 12L), 17L);
        Assert.assertEquals(parse.performOperation("-", 134L, 34L), 100L);


    }

}