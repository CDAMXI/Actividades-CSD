package Tema2_Act1;

public class BoxModified {
    private int content = 0;
    @SuppressWarnings("unused")
    private boolean full = false;

    public synchronized int get(){
        int value = content;
        content = 0;
        full = false;
        return value;
    }

    public synchronized void put(int value){
        content = value;
        full = true;
    }
}
