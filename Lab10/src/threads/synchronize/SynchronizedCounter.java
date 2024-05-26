package threads.synchronize;

public class SynchronizedCounter implements Runnable{
    private Integer count = 0;

    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            increment();
        }
    }

    public synchronized void increment() {
        count++;
        System.out.println(count + " " + Thread.currentThread().getName());
    }

    /*public void increment() {
        count++;
        System.out.println(count);
    }*/

}

