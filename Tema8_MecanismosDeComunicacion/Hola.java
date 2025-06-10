import java.rmi.*;

public interface Hola extends Remote{
    String saludar(String name) throws RemoteException;
}
