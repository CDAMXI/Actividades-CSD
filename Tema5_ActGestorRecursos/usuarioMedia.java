package Tema5_ActGestorRecursos;

public class usuarioMedia implements Runnable {
    private GestorRecursoPrioridad miGestor;
    public usuarioMedia(GestorRecursoPrioridad g) { miGestor=g;}
    
    public void run(){
        for (int i = 1; i <= 3; i++) {
            try {miGestor.solicitarMedia();
            } catch (InterruptedException e) {};
            System.out.println("Dentro "+Thread.currentThread().getName()+ " ndentro: "+miGestor.getdentro());
            miGestor.liberar();
        }
    }
}
