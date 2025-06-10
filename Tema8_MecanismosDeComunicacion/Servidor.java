import java.rmi.registry.*;

public class Servidor {
    public static void main(String[] args){
        try{
            Hola hola = new ImplHola();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("HolaService", hola);
            System.out.println("Servidor listo y esperando peticiones...");
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
