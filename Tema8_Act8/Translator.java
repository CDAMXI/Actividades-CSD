import java.rmi.*;

public interface Translator extends Remote {String translate (String a) throws RemoteException;}
