import java.util.GregorianCalendar;

public class Determinati extends Dipendente{
    private GregorianCalendar fineContratto;

    public Determinati(String nome, String cognome, String ID, float salario, GregorianCalendar fineContratto) {
        super(nome, cognome, ID, salario);
        this.fineContratto = fineContratto;
    }

    public GregorianCalendar getFineContratto() {
        return fineContratto;
    }

    public void setFineContratto(GregorianCalendar fineContratto) {
        this.fineContratto = fineContratto;
    }

    @Override
    public String toString() {
        return "Determinati{" +
                "fineContratto=" + fineContratto +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", ID='" + ID + '\'' +
                ", salario=" + salario +
                '}';
    }
}

