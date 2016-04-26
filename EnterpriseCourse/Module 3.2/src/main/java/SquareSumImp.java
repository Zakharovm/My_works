import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SquareSumImp implements SquareSum {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = {1, 2, 1, 3, 1, 4, 1, 5};

        System.out.println("\nОбщий результат: " + new SquareSumImp().getSquareSum(array, 3));

    }

    public long getSquareSum(int[] values, int numberOfThreads) throws InterruptedException, ExecutionException {

        List<Callable<Long>> callables = new ArrayList<>();

        Phaser phaser = new Phaser(1);
        ExecutorService executorService = Executors.newCachedThreadPool();
        int quantityOfElements = values.length;
        int elementsPerThread;
        long result = 0;
        int reminder;
        int[] arrayPart;
        int elementCounter = 0;

        if (quantityOfElements < numberOfThreads) {
            elementsPerThread = 1;
            numberOfThreads = quantityOfElements;
        } else {
            reminder = quantityOfElements % numberOfThreads; //4
            elementsPerThread = quantityOfElements / numberOfThreads; //7

            if (reminder != 0) {
                elementsPerThread += 1; //8
                numberOfThreads -= 1; //4
                reminder = quantityOfElements - numberOfThreads * elementsPerThread; //7
                arrayPart = new int[reminder];

                // заполнение подмассива элементами для первого потока, который работает с остатками данных
                for (int j = 0; j < reminder; j++) {
                    arrayPart[j] = values[elementCounter];
                    elementCounter++;
                }


                // создание потока для остатка данных
                callables.add(new Summator(arrayPart));
            }

        }


        // создание нужного количества остальных потоков
        for (int i = 0; i < numberOfThreads; i++) {
            arrayPart = new int[elementsPerThread];
            // заполнение подмассива элементами для определенного потока
            for (int j = 0; j < elementsPerThread; j++) {
                arrayPart[j] = values[elementCounter];
                elementCounter++;
            }

            callables.add(new Summator(arrayPart));

        }

        List<Future<Long>> futures = executorService.invokeAll(callables);

        // ждем завершения фазы 0 (сумирование элементов)
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза сумирования элементов отдельными потоками завершена(Фаза " + phase + ").");

        // ждем завершения фазы 1 (получения результатов)
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();

        for (int i = 0; i < futures.size(); i++) {
            Future<Long> future = futures.get(i);
            result += future.get();
            System.out.println("Сумма " + i + "-го потока получена и добавлена в общий результат");
        }
        System.out.println("Фаза получения общей суммы со всех потоков завершена(Фаза " + phase + ").");

        phaser.arriveAndDeregister();

        executorService.shutdown();
        return result;
    }


}

