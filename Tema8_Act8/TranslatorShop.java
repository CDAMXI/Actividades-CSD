import java.rmi.*;

public interface TranslatorShop extends Remote {
    Translator buyProfessionalTranslator () throws RemoteException;
    Translator buyCheapTranslator () throws RemoteException;
}
