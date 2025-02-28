package Tema2_Act4;

public class Consumer2 extends Thread{
    private Box2 box;
    private int cname;
    public Consumer2(Box2 c, int cname){
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
