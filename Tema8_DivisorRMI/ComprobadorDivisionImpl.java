public class ComprobadorDivisionImpl implements ComprobadorDivision {
    public boolean comprobar(int a, int b, Resultado r) {
        return (a == (b * r.cociente + r.resto)) ? true : false;
    }
}
