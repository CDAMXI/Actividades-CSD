package Tema2_Act4;

public class Consumer1 extends Thread{
    private Box1 box;
    private int cname;
    public Consumer1(Box1 c, int cname){
        box = c;
        this.cname = cname;
    }
    
    public void run(){
        for (int i = 0; i < 10; i++) {
            int value = 0;
            value = box.get();
            System.out.println("Consumer #" + this.cname + " got: " + value);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {}
        }
    }
}
