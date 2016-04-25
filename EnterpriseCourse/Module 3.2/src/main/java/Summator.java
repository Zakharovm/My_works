import java.util.concurrent.Phaser;

public class Summator implements Runnable {

    private int[] elements;
    private Phaser phaser;
    private long sum = 0;

    public Summator(int[] elements, Phaser phaser) {
        this.elements = new int[elements.length];
        this.elements = elements;
        this.phaser = phaser;
        phaser.register();
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " выполняет фазу сумирования квадратов элементов (фаза № " + phaser.getPhase() + ")");
        for (int element : elements) {
            sum += (long) Math.pow(element, 2);
        }
        phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " выполняет фазу добавления суммы элементов к общей сумме (фаза № " + phaser.getPhase() + "). Добавляемая сумма: " + sum);
        Sum.addValue(sum);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты

    }

}
