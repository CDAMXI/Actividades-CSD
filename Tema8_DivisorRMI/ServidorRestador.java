import java.rmi.registry.*;

public class ServidorRestador {
    public static void main(String[] args) throws Exception {
        RestadorImpl impl = new RestadorImpl();
        Registry reg = LocateRegistry.createRegistry(Integer.parseInt(args[1]));
        reg.rebind("restador", impl);
        System.out.println("Restador preparado");
    }
}
