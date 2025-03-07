package Tema5_Act8;

import java.util.concurrent.*;

public class Buffer {
    @SuppressWarnings("unused")
    private int head, tail, elems,size;
    private int[] data;
    private Semaphore item;
    private Semaphore slot;
    private Semaphore mutex;

    public Buffer(int s) {
        head=tail=elems=0;  size=s;
        data=new int[size];
        item=new Semaphore(0,true);
        slot=new Semaphore(size,true);
        mutex=new Semaphore(1,true);
    } 

    public int get() {
        try {item.acquire();} catch (InterruptedException e) {}
        try {mutex.acquire();} catch (InterruptedException e) {}
        int x=data[head]; head= (head+1)%size;  elems--;
        mutex.release();
        slot.release();
        return x;
    }

   public void put(int x) {
        try {slot.acquire();} catch (InterruptedException e) {}
        try {mutex.acquire();} catch (InterruptedException e) {}
        data[tail]=x; tail= (tail+1)%size;  elems++;
        mutex.release();
        item.release();
     }
}
