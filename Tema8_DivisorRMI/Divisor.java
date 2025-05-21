import java.rmi.*;

public interface Divisor extends Remote {
    Resultado dividir(Restador r, int a, int b) throws RemoteException;
}
