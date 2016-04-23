import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class SquareSumImp implements SquareSum {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the quantity of threads: ");
        final int quantityOfThreads = scanner.nextInt();
        System.out.println("Input the quantity of elements (%4 = 0 ): ");
        final int quantityOfElements = scanner.nextInt();
        int[] array = new int[quantityOfElements];


        // заполнение массива
        System.out.println("Given array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
            System.out.print(array[i] + ", ");
        }

        new SquareSumImp().getSquareSum(array, quantityOfThreads);

    }

    public long getSquareSum(int[] values, int numberOfThreads) throws InterruptedException, ExecutionException {

        List<Callable<Long>> callables = new ArrayList<>();
        int elementsPerThread = values.length / numberOfThreads;
        final long[] parts = new long[numberOfThreads];

        long result = 0;

        Phaser phaser = new Phaser(numberOfThreads);
        int startPosition = 0;
        int endPosition = elementsPerThread;

        for (int i = 0; i < numberOfThreads; i++) {
            // начинаем вычисление
            long sum = 0;
            int phase = phaser.getPhase();
            System.out.println(" \nФаза " + phase + " началась");

            // Вычисление суммы одним потоком
            for (int j = startPosition; j < endPosition; j++) {
                sum += Math.pow(values[j], 2);
            }
            parts[i] = sum;
            int finalI = i;

            callables.add(() -> parts[finalI]);

            startPosition += elementsPerThread;
            endPosition = startPosition + elementsPerThread;
            System.out.println("Фаза " + phase + " сейчас закончится");

            phaser.arriveAndAwaitAdvance();
            System.out.println("Фаза " + phase + " завершена");
        }

        phaser.arriveAndDeregister();

        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<Long>> futures = executor.invokeAll(callables);

        for (Future<Long> future : futures) {
            result += future.get();
        }
        System.out.println("The sum is:" + result);
        return result;
    }


}

