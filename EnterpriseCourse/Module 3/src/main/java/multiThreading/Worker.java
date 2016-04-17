package multiThreading;

public class Worker implements Runnable {
    private int weight;
    private Semaphore semaphore;

    public Worker(Semaphore semaphore, int weight) {
        this.weight = weight;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(2);

            Elevator.addWeight(1);
            System.out.println(Elevator.getWeight());

            semaphore.release(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SemaphoreRealization semaphore = new SemaphoreRealization(2);
        for (int i = 0; i < 1000; i++) {
            new Thread(new Worker(semaphore, i)).start();
        }
    }
}
