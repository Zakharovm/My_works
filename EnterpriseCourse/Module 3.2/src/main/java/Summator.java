import java.util.concurrent.Phaser;

public class Summator implements Runnable {

    private int[] elements;
    private Phaser phaser;
    private long sum;

    public Summator(int[] elements, Phaser phaser) {
        this.elements = new int[elements.length];
        this.elements = elements;
        this.phaser = phaser;
        this.sum = 0;
    }

    public long getSum() {
        return sum;
    }

    @Override
    public void run() {

        for (int element : elements) {
            sum += (long) Math.pow(element, 2);
        }
        System.out.println(Thread.currentThread().getName() + " performs the adding of elements of some part. Added sum: " + sum);
        phaser.arrive(); // сообщаем, что первая фаза достигнута
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        phaser.arriveAndDeregister(); // сообщаем о завершении фаз и удаляем с регистрации объекты


    }

}
