import java.rmi.registry.*;

public class TranslatorServer {

    public static void main (String[] args) throws Exception {
        Translator free = new FreeImpl ();
        TranslatorShop shop = new TranslatorShopImpl();
        Registry reg = LocateRegistry.getRegistry(args[0], Integer.parseInt(args[1]));
        reg.rebind("TraductorGratuito", free);
        reg.rebind("TiendaTraductores", shop);
    }
}
