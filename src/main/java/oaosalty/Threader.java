package oaosalty;

import java.util.concurrent.Semaphore;

public class Threader extends Thread
{
    private final Semaphore semaphore;

    public Threader(Semaphore semaphore)
    {
        this.semaphore = semaphore;
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName());
                wait(1000);
            } catch (InterruptedException exception) {
                System.out.print("Произошла ошибка в потоке " + Thread.currentThread().getName());
                break;
            }

            semaphore.release();
            notify();
        }
    }
}
