import java.rmi.registry.*;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Registry reg = LocateRegistry.getRegistry(args[0], Integer.parseInt(args[1]));
        Restador r = (Restador) reg.lookup("restador");
        Divisor d = (Divisor) reg.lookup("DivisionPorRestas");
        ComprobadorDivision correcto = new ComprobadorDivisionImpl();
        Resultado resultado = d.dividir(r, 11, 5);
        if (!resultado.error && (correcto.comprobar(11, 5, resultado)))
            System.out.println("division correcta");
        else
            System.out.println("division incorrecta");
    }
}
