import newOperations.IntegerDivider;
import newOperations.IntegerMultiplier;
import operations.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import parser.Parser;
import parser.UtilOperation;

@Configuration
public class AppConfig {

    @Bean
    public Runner runner(Parser parser, UtilOperation utilOperation) {
        Runner runner = new Runner();
        runner.setParser(parser);
        runner.setUtilOperation(utilOperation);

        return runner;
    }

    @Bean
    public Parser parser() {
        return new Parser();
    }

    @Bean
    public UtilOperation utilOperation() {
        UtilOperation utilOperation = new UtilOperation();
        utilOperation.register("*", integerMultiplier());
        utilOperation.register("/", integerDivider());
        return utilOperation;
    }


    // NEW OPERATIONS
    @Bean
    public Operator<Integer> integerMultiplier() {
        return new IntegerMultiplier();
    }

    @Bean
    public Operator<Integer> integerDivider() {
        return new IntegerDivider();
    }

    // OLD OPERATIONS
    @Bean
    public Operator<Double> doubleAddition() {
        return new DoubleAddition();
    }

    @Bean
    public Operator<Float> floatAddition() {
        return new FloatAddition();
    }

    @Bean
    public Operator<Long> longAddition() {
        return new LongAddition();
    }

    @Bean
    public Operator<Integer> integerAddition() {
        return new IntegerAddition();
    }

    @Bean
    public Operator<Double> doubleSubtraction() {
        return new DoubleSubtraction();
    }

    @Bean
    public Operator<Float> floatSubtraction() {
        return new FloatSubtraction();
    }

    @Bean
    public Operator<Long> longSubtraction() {
        return new LongSubtraction();
    }

    @Bean
    public Operator<Integer> integerSubtraction() {
        return new IntegerSubtraction();
    }

}
