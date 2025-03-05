public class PPal {
    public static void main(String[] args) {
        PuenteEstrecho P= new PuenteEstrecho();
        for (int i=0; i<10; i++) {
            new Thread("CocheNS"+i) {
            public void run() {
                try {
                P.entrarNorte();
                System.out.println(Thread.currentThread().getName());
                P.salirSur();
                } catch (InterruptedException e) { }
            }
            }.start();
            new Thread(() -> {
            try {
            P.entrarSur();
            System.out.println(Thread.currentThread().getName());
            P.salirNorte();
            } catch (InterruptedException e) { }},"CocheSN"+i).start();
        }
    }
}
