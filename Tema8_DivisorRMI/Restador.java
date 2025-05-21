import java.rmi.*;

public interface Restador extends Remote {
    Integer restar(int a, int b) throws RemoteException;
}
