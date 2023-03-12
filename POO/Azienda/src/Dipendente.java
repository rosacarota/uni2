public class Dipendente {
    protected String nome, cognome, ID;
    protected float salario;

    public Dipendente(String nome, String cognome, String ID, float salario) {
        this.nome = nome;
        this.cognome = cognome;
        this.ID = ID;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", ID='" + ID + '\'' +
                ", salario=" + salario +
                '}';
    }
}