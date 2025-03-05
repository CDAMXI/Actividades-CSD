package Tema5_ActGestorRecursos;

public class usuarioAlta extends Thread {
    private GestorRecursoPrioridad miGestor;
    private int id;
    public usuarioAlta(int i,GestorRecursoPrioridad g) { id=i; miGestor=g;}
    
    public void run(){
        Thread.currentThread().setName("Alta"+id);
        try { miGestor.solicitarAlta();} catch (InterruptedException e) {};
        System.out.println("Dentro "+Thread.currentThread().getName()+"ndentro:"+miGestor.getdentro());
        miGestor.liberar();
    }
}
