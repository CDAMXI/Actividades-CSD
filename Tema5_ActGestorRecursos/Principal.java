package Tema5_ActGestorRecursos;

public class Principal {
    public static void main(String[] args) {
        GestorRecursoPrioridad elGestor=new GestorRecursoPrioridad();
        for (int i = 1; i <= 5; i++) {
            new Thread(()-> {
                for (int j = 1; j <= 6; j++) {
                    try {elGestor.solicitarBaja();
                    } catch (InterruptedException e) {};
                    System.out.println("Dentro "+Thread.currentThread().getName()+ " ndentro: "+elGestor.getdentro());
                    elGestor.liberar();
                }
            },"Baja"+i).start();
            new Thread(new usuarioMedia(elGestor),"Media"+i).start();
            new usuarioAlta(i,elGestor).start();
        }
        System.out.println("fin");
        try {Thread.sleep(5000);} catch (InterruptedException e) {};
        System.out.println("Num. reintentos: "+elGestor.getretry());
     }
}
