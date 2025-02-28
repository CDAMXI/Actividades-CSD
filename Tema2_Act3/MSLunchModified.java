package Tema2_Act3;

public class MSLunchModified {
    private long c1, c2 = 0;
    private Object l1 = new Object();
    private Object l2 = new Object();

    public void inc1() {
        synchronized (l1) {
            c1++;
            System.out.println(Thread.currentThread().getName() + " c1 value=: " + c1);
        }
    }

    public void inc2() {
        synchronized (l2) {
            c2++;
            System.out.println(Thread.currentThread().getName() + " c2 value=: " + c2);
        }
    }
}
