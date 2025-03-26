public class GestorRecurso {
    private int M = 13;
    private int nEsperaEntrar = 0;
    private int nEsperasalir = 0;
    private int dentro = 0;

    public synchronized int getdentro() {return dentro;}

    public synchronized void solicitar() throws InterruptedException {
        if (nEsperaEntrar > 0){notify();}
        nEsperaEntrar++;
        if (dentro == M - 1){wait();}
        nEsperaEntrar--;
        dentro++;
        if (nEsperasalir > 0){notify();}
    }

    public synchronized void liberar() throws InterruptedException {
        if (nEsperasalir > 0){notify();}
        nEsperasalir++;
        if (dentro == M+1){wait();}
        nEsperasalir--;
        dentro--;
    }
}
