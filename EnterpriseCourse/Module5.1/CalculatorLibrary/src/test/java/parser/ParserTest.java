package parser;

public class ParserTest {
    @org.junit.Test
    public void determine() throws Exception {

        Parser parser = new Parser();
        String input = "- 2 3";

        parser.determine(input);
        System.out.println(parser.getOperand1() + " " + parser.getOperator() + " " + parser.getOperand2());

    }

}