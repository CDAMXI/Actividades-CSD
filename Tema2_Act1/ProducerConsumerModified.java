package Tema2_Act1;

public class ProducerConsumerModified{
    public static void main(String[] args){
        //Si el consumidor tiene un cero es porque la caja está vacía
        BoxModified c = new BoxModified();
        ConsumerModified c1 = new ConsumerModified(c,1);
        ProducerModified p1 = new ProducerModified(c,1);

        c1.start();
        p1.start();

        try{
            c1.join();
            p1.join();
        } catch(InterruptedException e){}
    }
}
