import java.rmi.*;
import java.rmi.server.*;

public class DivisorImpl extends UnicastRemoteObject implements Divisor {
    DivisorImpl() throws RemoteException {}

    public Resultado dividir(Restador restador, int dividendo, int divisor) throws RemoteException {
        System.out.println("Metodo remoto dividir llamado");
        Resultado res = new Resultado();
        if (divisor == 0) {
            res.error = true;
            return res;
        }
        res.resto = dividendo;
        while (res.resto >= divisor) {
            res.resto = restador.restar(res.resto, divisor);
            res.cociente++;
        }
        return res;
    }
}
