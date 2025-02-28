public class TestIt {
    public static void main(String[] args) {
        new TestIt();
    }

    public TestIt(){
        Test t1 = new Test();
        Test t2 = new Test();
        new Thread(new Runnable(){public void run(){t1.test(t2);}}).start();
        new Thread(new Runnable(){public void run(){t2.test(t1);}}).start();
    }
}
