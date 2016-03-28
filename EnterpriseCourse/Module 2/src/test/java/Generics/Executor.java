package Generics;

import java.util.List;

public interface Executor<T> {

    // Добавить таск на выполнение. Результат таска будет доступен через метод getValidResults().
    // Бросает Эксепшн если уже был вызван метод execute()
    void addTask(Task<T> task);

    // Добавить таск на выполнение и валидатор результата. Результат таска будет записан в ValidResults если validator.isValid вернет true для этого результата
    // Результат таска будет записан в InvalidResults если validator.isValid вернет false для этого результата
    // Бросает Эксепшн если уже был вызван метод execute()
    void addTask(Task<T> task, Validator<T> validator);

    // Выполнить все добавленые таски
    void execute();

    // Получить валидные результаты. Бросает Эксепшн если не был вызван метод execute()
    <T> List<T> getValidResults();

    // Получить невалидные результаты. Бросает Эксепшн если не был вызван метод execute()
    <T> List<T> getInvalidResults();

}
