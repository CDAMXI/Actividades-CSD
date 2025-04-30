import java.rmi.*;
import java.rmi.server.*;

public class ProImpl extends UnicastRemoteObject implements Translator {
    ProImpl() throws RemoteException {}
    public String translate (String a) throws RemoteException {return "Traduccion profesional de "+ a;}
}
