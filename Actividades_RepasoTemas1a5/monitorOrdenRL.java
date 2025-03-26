package Actividades_RepasoTemas1a5;
    
import java.util.concurrent.locks.*;
    
public class monitorOrdenRL {
    numerosOrden numeroOrden = new numerosOrden();
    long numeroActual = 1;
    Lock milock=new ReentrantLock();
    Condition espera=milock.newCondition();
    
    public long solicitarTurno() {
        try {
            milock.lock();
            return numeroOrden.numeroSiguiente();
        }finally { milock.unlock();}
    }

    public void accederRecurso(long numeroOrden) throws InterruptedException {
        try {
            milock.lock();
            while (numeroOrden > numeroActual){espera.await();}
        }finally { milock.unlock();}
    }

    public void liberarRecurso() {
        try{
            milock.lock();
            numeroActual ++;
            espera.signalAll();
        } finally {milock.unlock();}
    }
}
