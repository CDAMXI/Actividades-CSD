import java.rmi.registry.*;

public class Client {
    public static void main (String[] args) throws Exception{
        String t = "Hola a todos";
        Registry reg = LocateRegistry.getRegistry(args[0], Integer.parseInt(args[1]));
        Translator tg = (Translator) reg.lookup("TraductorGratuito");
        TranslatorShop ct= (TranslatorShop) reg.lookup("TiendaTraductores");
        Translator tp = ct.buyProfessionalTranslator ();
        System.out.println (tg.translate (t));
        System.out.println (tp.translate (t));
        System.out.println (ct.buyCheapTranslator().translate (t));
    }
}
