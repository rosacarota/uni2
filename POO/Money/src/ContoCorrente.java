public class ContoCorrente {
    private double saldo;
    private static int contatoreConto;
    private final int NUMERO_CONTO;

    public ContoCorrente() {
        NUMERO_CONTO = contatoreConto;
        contatoreConto++;
    }

    // Precondizione: importo >= 0
    public void deposita(double importo) {
        try {
            if (importo <=0)
                throw new IllegalArgumentException();
            saldo += importo;
        }
        catch (IllegalArgumentException e) {
            System.out.println("[Impossibile depositare]");
        }
    }

    // Precondizione: importo <= saldo
    public void preleva(double importo) {
        try {
            if (importo >= saldo)
                throw new IllegalArgumentException();
            saldo -= importo;
        }
        catch (IllegalArgumentException e) {
            System.out.println("[Impossibile prelevare]");

        }
    }

    public double restituisciSaldo() {
        return saldo;
    }

    public int restituisciNumeroConto() {
        return NUMERO_CONTO;
    }






}
