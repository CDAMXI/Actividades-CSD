import java.rmi.server.*;
import java.rmi.*;

public class FreeImpl extends UnicastRemoteObject implements Translator {
    FreeImpl() throws RemoteException {}
    public String translate (String a) throws RemoteException{return "Traduccion gratuita de "+ a;}   
}
