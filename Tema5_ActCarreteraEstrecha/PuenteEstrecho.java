public class PuenteEstrecho {
    private int nNS = 0;
    private int nSN = 0;
    private int nwNorte = 0;
    private int nwSur = 0;
    private boolean turnoN = false;

    public synchronized void entrarSur() throws InterruptedException{
        nwSur++;
        while (nNS >0 || (turnoN == true && nwNorte >0)) {wait();}
        nwSur--;
        turnoN=true;
        nSN++;
    }
    public synchronized void entrarNorte()throws InterruptedException{
        nwNorte++;
        while (nSN > 0 || (turnoN == false && nwSur >0)) {wait();}
        nwNorte--;
        turnoN=false;
        nNS ++;
    }
    public synchronized void salirNorte(){
        nSN--;
        notifyAll();
    }
    public synchronized void salirSur(){
        nNS--;
        notifyAll();
    }
}
