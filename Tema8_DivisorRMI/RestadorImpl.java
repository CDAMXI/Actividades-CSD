import java.rmi.*;
import java.rmi.server.*;

public class RestadorImpl extends UnicastRemoteObject implements Restador {
    RestadorImpl() throws RemoteException {}

    public Integer restar(int a, int b) throws RemoteException {
        System.out.println("Metodo remoto restart llamado");
        return a - b;
    }
}
