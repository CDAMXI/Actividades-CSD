package Tema2_Act1;

public class Producer extends Thread{
    private Box box;
    private int pname;
    public Producer(Box c, int pname){
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
