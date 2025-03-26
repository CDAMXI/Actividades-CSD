public class GestorRecursoModified {
    private int N = 13;
    private int dentro = 0;

    public synchronized int getdentro() {return dentro;}

    public synchronized void solicitar() throws InterruptedException {
        while (dentro == N-1){wait();}
        dentro++;
    }
     
     public synchronized void liberar() throws InterruptedException {
        while (dentro == N+1){wait();}
        dentro--;
        notifyAll();
    }
}
