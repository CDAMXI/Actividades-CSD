import java.rmi.*;
import java.rmi.server.*;

public class ImplHola extends UnicastRemoteObject implements Hola {
    private static final long serialVersionUID = 1L;

    public ImplHola() throws RemoteException {
        super();
    }

    @Override
    public String saludar(String name) {
        return "Hola " + name + "!";
    }
    
}
