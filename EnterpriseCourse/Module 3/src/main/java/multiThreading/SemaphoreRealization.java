package multiThreading;

public class SemaphoreRealization implements Semaphore {
    private int counter;

    public static void main(String[] args) {
        SemaphoreRealization semaphore = new SemaphoreRealization(5);
        new Thread(new User(semaphore, 100)).start();
        new Thread(new User(semaphore, 80)).start();
        new Thread(new User(semaphore, 70)).start();
        new Thread(new User(semaphore, 65)).start();


    }


    public SemaphoreRealization(int counter) {
        if (counter < 0) throw
                new IllegalArgumentException(counter + " < 0");
        this.counter = counter;
    }

    // Запрашивает разрешение. Если есть свободное захватывает его. Если нет - приостанавливает поток до тех пор пока не появится свободное разрешение.
    public synchronized void acquire() throws InterruptedException {
        while (counter == 0) {
            this.wait();
        }
        counter -= 1;
    }

    // Запрашивает переданое количество разрешений. Если есть переданое количество свободных разрешений захватывает их.
    // Если нет - приостанавливает поток до тех пор пока не появится переданое колтчество свободных разрешений.
    public synchronized void acquire(int permits) throws InterruptedException {
        while (counter < permits) {
            this.wait();
        }
        counter -= permits;

    }

    // Отпускает разрешение возвращая его семафору.
    public synchronized void release() {
        if (counter == 0) {
            this.notify();
        }
        counter += 1;
    }

    // Отпускает переданое количество разрешений возварщая их семафору.
    public synchronized void release(int permits) {
        for (int i = 0; i < permits; i++) {
            this.notify();
        }
        counter += permits;

    }

    // Возвращает количество свободных разрешений на данный момент.
    public int getAvailablePermits() {
        return counter;
    }

}
