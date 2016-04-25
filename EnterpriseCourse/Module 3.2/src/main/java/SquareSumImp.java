import java.util.concurrent.ExecutionException;
import java.util.concurrent.Phaser;

public class SquareSumImp implements SquareSum {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int[] array = {1, 2, 1, 3, 1, 4, 1, 5};

        System.out.println("General sum: " + new SquareSumImp().getSquareSum(array, 3));

    }

    public long getSquareSum(int[] values, int numberOfThreads) throws InterruptedException, ExecutionException {

        Phaser phaser = new Phaser(1);
        int quantityOfElements = values.length;
        int elementsPerThread;
        long result;
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

                // заполнение подмассива элементами для первого потока, который работает с отличным от других потоков количеством элементов
                for (int j = 0; j < reminder; j++) {
                    arrayPart[j] = values[elementCounter];
                    elementCounter++;
                }

                new Thread(new Summator(arrayPart, phaser)).start();
            }

        }

        arrayPart = new int[elementsPerThread];

        // создание нужного количества остальных потоков
        for (int i = 0; i < numberOfThreads; i++) {

            // заполнение подмассива элементами для определенного потока
            for (int j = 0; j < elementsPerThread; j++) {
                arrayPart[j] = values[elementCounter];
                elementCounter++;
            }

            new Thread(new Summator(arrayPart, phaser)).start();
        }

        // ждем завершения фазы 0
        int phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");
        // ждем завершения фазы 1
        phase = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("Фаза " + phase + " завершена");
        result = Sum.getValue();
        phaser.arriveAndDeregister();

        return result;
    }


}

