package parser;

public class ParserTest {
    @org.junit.Test
    public void determine() throws Exception {

        Parser parser = new Parser();
        String input = "4 + 4";

        parser.determine(input);
        System.out.println(parser.getOperand1() + " " + parser.getOperator() + " " + parser.getOperand2());

    }

}