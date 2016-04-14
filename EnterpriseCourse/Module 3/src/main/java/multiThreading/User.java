package multiThreading;

public class User implements Runnable {
    private int weight;
    private Semaphore semaphore;


    public User(Semaphore semaphore, int weight) {
        this.semaphore = semaphore;
        this.weight = weight;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started to work...");
        try {
            System.out.println(Thread.currentThread().getName() + " waiting for the the elevator...");
            semaphore.acquire();
            semaphore.acquire(2);

            System.out.println(Thread.currentThread().getName() + " Entered to the elevator with mass " + weight + " kg ");

            Elevator.addWeight(weight);
            Thread.sleep(5L);

            System.out.println(Thread.currentThread().getName() + " The mass of elevator " + Elevator.getWeight() + " ");

            Thread.sleep(5L);

            semaphore.release(2);
            semaphore.release();
            Elevator.reduceWeight(weight);
            System.out.println(Thread.currentThread().getName() + " went out from the elevator with mass " + weight + " kg ");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }
}
