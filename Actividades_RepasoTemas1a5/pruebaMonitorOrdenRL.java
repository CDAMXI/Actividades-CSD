package Actividades_RepasoTemas1a5;

public class pruebaMonitorOrdenRL {
    public static void main(String[] args) {
        int n = 5;
        hiloRecurso unHilo;
        monitorOrdenRL unMonitorOrden = new monitorOrdenRL();
        for (int i=1; i <= n; i++){
        unHilo = new hiloRecurso(i, unMonitorOrden);
        unHilo.start();
        }
    }
}
