public class PPalModified {
    static GestorRecursoModified mdGestor = new GestorRecursoModified();
    public static void main(String[] args) {
        for (int i=0; i<50; i++)
            new Thread(new Runnable() {
                public void run() {
                    try {
                        mdGestor.solicitar();
                        System.out.println(Thread.currentThread().getName() + 
                            " use recurso: "+ mdGestor.getdentro() + " hilos");
                        Thread.sleep((int)(Math.random() * 100));
                        mdGestor.liberar();
                        System.out.println(Thread.currentThread().getName() + 
                            " fini: "+ mdGestor.getdentro() + " hilos");
                    } catch (InterruptedException e) {}
                }
            },"hilo"+i).start();
        System.out.println(Thread.currentThread().getName() + " finalizado ");
    }
}
