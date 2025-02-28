package Tema3_Act4;

public class ProducerConsumer {
    static BoundedBuffer buf = new BoundedBuffer(1);

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    buf.put(i);
                }
            }
        }, "producer").start();

        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(buf.get());
                }
            }
        }, "consumer").start();
    }
}
