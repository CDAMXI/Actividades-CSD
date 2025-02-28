package Tema2_Act4;

public class Producer1 extends Thread{
    private Box1 box;
    private int pname;
    public Producer1(Box1 c, int pname){
        box = c;
        this.pname = pname;
    }
    
    public void run(){
        for (int i = 0; i < 10; i++) {
            box.put(i);
            System.out.println("Producer #" + this.pname + " put: " + i);
            try {
                Thread.sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {}
        }
    }
}
