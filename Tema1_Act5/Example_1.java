package Tema1_Act5;

public class Example_1 {
    public static void main(String[] args) {
        CalculateResults cr = new CalculateResults();
        cr.start();
        System.out.println("Main thread in execution");
        System.out.println("Main thread gets the result: " + cr.getResults());
    }
}

