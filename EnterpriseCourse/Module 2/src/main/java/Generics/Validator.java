package generics;

public interface Validator<T> {

    // Валидирует переданое значение
    boolean isValid(T result);

}