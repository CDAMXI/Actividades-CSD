package Tema1_Act5;

public class Example_1_Corrected {
    public static void main(String[] args) {
        CalculateResults cr = new CalculateResults();
        cr.start();
        System.out.println("Main thread in execution");
        try {
            cr.join();
        } catch (InterruptedException e) {}
        System.out.println("Main thread gets the result: " + cr.getResults());
    }
}

