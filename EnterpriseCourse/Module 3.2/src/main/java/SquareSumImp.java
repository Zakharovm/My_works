import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class SquareSumImp implements SquareSum {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = {1, 2, 1, 3, 1, 4, 1, 5};

        System.out.println("Given array:");
        System.out.println(Arrays.toString(array));

        System.out.println("\nThe result is: " + new SquareSumImp().getSquareSum(array, 8));

    }

    public long getSquareSum(int[] values, int numberOfThreads) throws InterruptedException, ExecutionException {

        Phaser phaser = new Phaser(numberOfThreads + 1);
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Summator> summators = new ArrayList<>();

        int quantityOfElements = values.length;
        int elementsPerThread;
        final long[] result = {0};
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
                summators.add(new Summator(arrayPart, phaser));
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

            summators.add(new Summator(arrayPart, phaser));

        }

        // запуск потоков
        summators.forEach(executorService::execute);

        // ждем завершения фазы 0 (сумирование элементов)
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Elements summation phase by separate streams is completed(Phase " + phase + ").");

        // ждем завершения фазы 1 (получения результатов)
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();

        summators.forEach(element -> {
            result[0] += element.getSum();
            System.out.println("Sum " + summators.indexOf(element) + " stream is received and added to the result.");
        });

        System.out.println("Sum receiving from all streams phase is completed(Phase " + phase + ").");

        phaser.arriveAndDeregister();

        executorService.shutdown();
        return result[0];
    }


}

