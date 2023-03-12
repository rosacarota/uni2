public class Indeterminati extends Dipendente {
    private final float BONUS = 30;
    private String qualifica;

    public Indeterminati(String nome, String cognome, String ID, float salario, String qualifica) {
        super(nome, cognome, ID, salario);
        this.qualifica = qualifica;
    }

    public float getBONUS() {
        return BONUS;
    }

    public String getQualifica() {
        return qualifica;
    }

    public void setQualifica(String qualifica) {
        this.qualifica = qualifica;
    }

    @Override
    public String toString() {
        return "Indeterminati{" +
                "BONUS=" + BONUS +
                ", qualifica='" + qualifica + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", ID='" + ID + '\'' +
                ", salario=" + salario +
                '}';
    }
}