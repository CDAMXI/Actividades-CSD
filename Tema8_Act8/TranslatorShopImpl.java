import java.rmi.*;
import java.rmi.server.*;

public class TranslatorShopImpl extends UnicastRemoteObject implements TranslatorShop {
    TranslatorShopImpl () throws RemoteException {}
    public Translator buyProfessionalTranslator () throws RemoteException {return new ProImpl();}
    public Translator buyCheapTranslator () throws RemoteException {return new CheapImpl();}
}
