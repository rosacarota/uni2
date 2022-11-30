abstract class Cliente {
    protected String nome, cognome;
    protected int anni;
    protected String sesso;

    public Cliente(String nome, String cognome, int anni, String sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.anni = anni;
        this.sesso = sesso;
    }

    abstract String getNome();
    abstract String getCognome();
}