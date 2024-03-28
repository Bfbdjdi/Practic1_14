package oaosalty;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1, true);
        Threader thread1 = new Threader(semaphore);
        Threader thread2 = new Threader(semaphore);
        Threader thread3 = new Threader(semaphore);

        try {
            thread1.start();
            Thread.sleep(5); //чтобы все три потока были в правильной очереди, и fair оказался полезен

            thread2.start();
            Thread.sleep(5);

            thread3.start();
        } catch (InterruptedException err) {
            throw new RuntimeException(err);
        }

        while (true) //Заверешение работы программы по любому вводу
        {
            if(!new Scanner(new InputStreamReader(System.in)).nextLine().isEmpty()) System.exit(0);
        }
    }
}