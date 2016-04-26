import java.util.concurrent.Callable;

public class Summator implements Callable<Long> {

    private int[] elements;
    private long sum;

    public Summator(int[] elements) {
        this.elements = new int[elements.length];
        this.elements = elements;
        this.sum = 0;
    }

    @Override
    public Long call() throws Exception {

        for (int element : elements) {
            sum += (long) Math.pow(element, 2);
        }
        System.out.println(Thread.currentThread().getName() + " выполняет суммирование квадратов элементов. Добавляемая сумма: " + sum);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sum;
    }

}
