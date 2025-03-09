package Tema1_Act3;

public class ExThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i < 10; i++){
            Thread t = new Thread("MyThread-" + i) {
                public void run() {
                    System.out.println("Excecuted by " + Thread.currentThread().getName());
                }
            };
            t.start();
        }
    }
}
