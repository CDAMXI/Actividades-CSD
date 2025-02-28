public class Test {
    public synchronized void test (Test t) {t.SayHola ();}
    public synchronized void SayHola () {System.out.println ("Hola");}
}
// What is the result of running TestIt? (Choose all that apply.)
