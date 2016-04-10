package generics;

public class ResultValidator implements Validator<Long> {

    @Override
    public boolean isValid(Long result) {
        return result >= 0;
    }
}
