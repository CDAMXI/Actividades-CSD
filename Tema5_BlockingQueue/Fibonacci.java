package Tema5_BlockingQueue;

import java.util.concurrent.*;

public class Fibonacci {
    public static void main(String[] args) throws InterruptedException{
        BlockingQueue<Long> cola = new ArrayBlockingQueue<>(10);
        cola.put((long)0); cola.put((long)1);

        new Thread(() -> {
            long f1 = 0, f2 = 1, fn;
            try {
                for (int i = 0; i < 30; i++) {
                    fn = f1 + f2;
                    System.out.println("Fibonacci: " + fn);
                    cola.put(fn);
                    f1 = f2; f2 = fn;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"generaFibo").start();

        new Thread( () -> {
            try {
                for (int i = 0; i < 30; i++) {
                    System.out.println("Consumidor: " + cola.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"VisorFibo").start();
    }
}
