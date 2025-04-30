import java.rmi.*;
import java.rmi.server.*;

public class CheapImpl extends UnicastRemoteObject implements Translator {
    CheapImpl() throws RemoteException {}
    public String translate (String a) throws RemoteException {
        Translator impl = new FreeImpl ();
        return impl.translate (a);
    }
}
