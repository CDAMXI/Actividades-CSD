package Tema2_Act4;

public class ProducerConsumer2{
    public static void main(String[] args){
        //Si el consumidor tiene un cero es porque la caja está vacía
        Box2 c = new Box2();
        Consumer2 c1 = new Consumer2(c,1);
        Producer2 p1 = new Producer2(c,1);

        c1.start();
        p1.start();

        try{
            c1.join();
            p1.join();
        } catch(InterruptedException e){}
    }
}
