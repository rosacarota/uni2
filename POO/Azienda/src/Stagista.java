public class Stagista extends Dipendente {
    private Dipendente supervisore;

    public Stagista(String nome, String cognome, String ID, float salario, Dipendente supervisore) {
        super(nome, cognome, ID, salario);
        this.supervisore = supervisore;
    }

    public Dipendente getSupervisore() {
        return supervisore;
    }

    public void setSupervisore(Dipendente supervisore) {
        this.supervisore = supervisore;
    }

    @Override
    public String toString() {
        return "Stagista{" +
                "supervisore=" + supervisore +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", ID='" + ID + '\'' +
                ", salario=" + salario +
                '}';
    }
}
