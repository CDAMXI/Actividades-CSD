package Actividades_RepasoTemas1a5;

public class hiloRecurso extends Thread{
    int id = 0;
    static final int n = 3;
    monitorOrdenRL unMonitorOrden;

    public hiloRecurso (int unId, monitorOrdenRL unMonitorOrden){
        id = unId;
        this.unMonitorOrden = unMonitorOrden;
    }

    public void run () {
        long turno = 0;
        for (int i=0; i < n; i++ ){
            turno = unMonitorOrden.solicitarTurno();
            System.out.println(">Hilo " + id + " obtiene numero " + turno);
            try {Thread.sleep((long) (Math.random()*100));}catch (InterruptedException e) {};
            try {unMonitorOrden.accederRecurso(turno);
            } catch (InterruptedException e) {}
            System.out.println("<Hilo " + id + " accede al recurso. Turno " + turno);
            unMonitorOrden.liberarRecurso();
        }
    }
}
