package Tema2_Act1;

public class ProducerConsumer{
    public static void main(String[] args){
        //Si el consumidor tiene un cero es porque la caja está vacía
        Box c = new Box();
        Consumer c1 = new Consumer(c,1);
        Producer p1 = new Producer(c,1);

        c1.start();
        p1.start();

        try{
            c1.join();
            p1.join();
        } catch(InterruptedException e){}
    }
}
