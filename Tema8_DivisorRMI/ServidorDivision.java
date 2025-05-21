import java.rmi.registry.*;

public class ServidorDivision {
    public static void main(String[] args) throws Exception {
        DivisorImpl impl = new DivisorImpl();
        Registry reg = LocateRegistry.createRegistry(Integer.parseInt(args[1]));
        reg.rebind("DivisionPorRestas", impl);
        System.out.println("Divisor preparado");
    }
}
