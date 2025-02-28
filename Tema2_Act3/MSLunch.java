package Tema2_Act3;

public class MSLunch extends Thread{
    private long c1, c2 = 0;
    public void inc1() {
        c1++;
        System.out.println(Thread.currentThread().getName() + " c1 value=: " + c1);
    }
    public void inc2() {
        c2++;
        System.out.println(Thread.currentThread().getName() + " c2 value=: " + c2);
    }
}
