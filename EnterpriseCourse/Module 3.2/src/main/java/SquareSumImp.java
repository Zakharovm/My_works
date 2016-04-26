import java.util.Arrays;
import java.util.concurrent.*;

public class SquareSumImp implements SquareSum {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = {1, 2, 1, 3, 1, 4, 1, 5};

        System.out.println("Имеем массив:");
        System.out.println(Arrays.toString(array));

        System.out.println("\nОбщий результат: " + new SquareSumImp().getSquareSum(array, 4));

    }

    public long getSquareSum(int[] values, int numberOfThreads) throws InterruptedException, ExecutionException {

        Phaser phaser = new Phaser(1);
        ExecutorService executorService = Executors.newCachedThreadPool();
        int quantityOfElements = values.length;
        int elementsPerThread;
        long result = 0;
        int reminder = 0;
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
                executorService.execute(new Summator(arrayPart, phaser));

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

            executorService.execute(new Summator(arrayPart, phaser));

        }



        // ждем завершения фазы 0 (сумирование элементов)
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза суммирования элементов отдельными потоками завершена(Фаза " + phase + ").");

        // ждем завершения фазы 1 (получения результатов)
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();

        elementCounter = 0;
        if (reminder != 0) {
            arrayPart = new int[reminder];

            // заполнение подмассива элементами для первого потока, который работает с остатками данных
            for (int j = 0; j < reminder; j++) {
                arrayPart[j] = values[elementCounter];
                elementCounter++;
            }

            result += new Summator(arrayPart, phaser).getSum();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            arrayPart = new int[elementsPerThread];
            // заполнение подмассива элементами для определенного потока
            for (int j = 0; j < elementsPerThread; j++) {
                arrayPart[j] = values[elementCounter];
                elementCounter++;
            }
            System.out.println("Сумма " + i + "-го потока получена и добавлена в общий результат");

            result += new Summator(arrayPart, phaser).getSum();

        }


        System.out.println("Фаза получения общей суммы со всех потоков завершена(Фаза " + phase + ").");

        phaser.arriveAndDeregister();

        executorService.shutdown();
        return result;
    }


}

