import java.rmi.registry.*;
import java.util.*;

public class Cliente{
    public static void main(String[] args){
        try{
            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
            Hola hola = (Hola) reg.lookup("HolaService");
            System.out.println("Conectado al servidor. Ingrese su nombre:");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            System.out.println("Respuesta del servidor: " + hola.saludar(name));
            scanner.close();
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
