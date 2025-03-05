package Tema5_ActGestorRecursos;

public class GestorRecursoPrioridad {
    private Boolean recursoLibre = true;
    private int nAlta,nMedia = 0;
    private int dentro,retry = 0;
    
    public synchronized void solicitarAlta() throws InterruptedException{
        nAlta = nAlta + 1;
        while (!recursoLibre) {wait(); retry++;}
        nAlta = nAlta - 1;
        recursoLibre = false; dentro++;
    }
    
    public synchronized void solicitarMedia() throws InterruptedException{
        nMedia = nMedia + 1;
        while (!recursoLibre || nAlta > 0) {wait(); retry++;}
        nMedia = nMedia - 1;
        recursoLibre = false; dentro++;
    }
    
    public synchronized void solicitarBaja() throws InterruptedException{
        while (!recursoLibre || nAlta > 0 || nMedia > 0) {wait(); retry++;}
        recursoLibre = false; dentro++;
    }
    
    public synchronized void liberar() {
        recursoLibre = true; dentro--;
        notifyAll();
    }    
    public synchronized int getdentro(){ return(dentro);}
    public synchronized int getretry(){ return(retry);}
}
