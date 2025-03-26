import java.util.concurrent.Semaphore;

public class GestorRecursion {
    private final int N = 13;
    private int dentro;
    private boolean esperando;
    private Semaphore mmutex, espera;

    public GestorRecursion() {
        mmutex = new Semaphore(1, true);
        espera = new Semaphore(0, true);
        esperando = false;
        dentro = 0;
    }

    public int getdentro() throws InterruptedException {
        try {
            mmutex.acquire();
            return dentro;
        } finally {
            mmutex.release();
        }
    }

    public void solicitar() throws InterruptedException {
        mmutex.acquire();
        if (esperando) {
            dentro++;
            espera.release();
        } else if (dentro == N - 1) {
            esperando = true;
            mmutex.release();
            espera.acquire();
            dentro++;
            esperando = false;
            mmutex.release();
        } else {
            dentro++;
            mmutex.release();
        }
    }

    public void liberar() throws InterruptedException {
        mmutex.acquire();
        if (esperando) {
            dentro--;
            espera.release();
        } else if (dentro == N + 1) {
            esperando = true;
            mmutex.release();
            espera.acquire();
            dentro--;
            esperando = false;
            mmutex.release();
        } else {
            dentro--;
            mmutex.release();
        }
    }
}
