public class Main {
    public static void main(String[] args) {
        ContoCorrente conto1 = new ContoCorrente();
        ContoCorrente conto2 = new ContoCorrente();

        conto1.deposita(-500);
        conto2.deposita(500);

        conto1.preleva(300);

        System.out.println("Numero conto1: " + conto1.restituisciNumeroConto());
        System.out.println("Numero conto2: " + conto2.restituisciNumeroConto());
        System.out.println("Saldo conto1: " + conto1.restituisciSaldo());
        System.out.println("Saldo conto2: " + conto2.restituisciSaldo());
    }
}
