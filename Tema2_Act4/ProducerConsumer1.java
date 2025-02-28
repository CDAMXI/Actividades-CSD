package Tema2_Act4;

public class ProducerConsumer1{
    public static void main(String[] args){
        //Si el consumidor tiene un cero es porque la caja está vacía
        Box1 c = new Box1();
        Consumer1 c1 = new Consumer1(c,1);
        Producer1 p1 = new Producer1(c,1);

        c1.start();
        p1.start();

        try{
            c1.join();
            p1.join();
        } catch(InterruptedException e){}
    }
}
