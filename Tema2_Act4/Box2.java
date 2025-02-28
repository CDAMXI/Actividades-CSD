package Tema2_Act4;

public class Box2 {
    private int content = 0;
    private boolean full = false;

    public synchronized int get(){
        while (!full) {Thread.yield();}
        int value = content;
        content = 0;
        full = false;
        return value;
    }

    public synchronized void put(int value){
        while (full) {Thread.yield();}
        content = value;
        full = true;
    }
}
