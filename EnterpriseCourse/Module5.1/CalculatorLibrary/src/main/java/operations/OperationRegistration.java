package operations;

import java.util.HashMap;
import java.util.Map;

public class OperationRegistration {

    public Map<String, Operator> operations = new HashMap<>();

    public OperationRegistration() {
        operations.put("+D", new DoubleAddition());
        operations.put("+F", new FloatAddition());
        operations.put("+L", new LongAddition());
        operations.put("+I", new IntegerAddition());
        operations.put("-D", new DoubleSubtraction());
        operations.put("-F", new FloatSubtraction());
        operations.put("-L", new LongSubtraction());
        operations.put("-I", new IntegerSubtraction());
    }

    public void register (String operationName, Operator operator) {
        operations.put(operationName, operator);
    }
}
