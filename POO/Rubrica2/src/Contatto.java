import java.util.ArrayList;

public class Contatto {
    private String titolo;
    private String nome, cognome;
    private String indirizzo;

    private final ArrayList<String> numeri;
    private final ArrayList<String> emails;

    public Contatto(String titolo, String nome,
                    String cognome, String indirizzo,
                    String numero, String email) {
        numeri = new ArrayList<String>();
        emails = new ArrayList<String>();

        this.titolo = titolo;
        this.nome = nome;
        this.cognome = cognome;
        this.indirizzo = indirizzo;
        numeri.add(numero);
        emails.add(email);
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public ArrayList<String> getNumeri() {
        return numeri;
    }

    public void addNumero(String numero) {
        this.numeri.add(numero);
    }

    public ArrayList<String> getEmail() {
        return emails;
    }

    public void addEmail(String email) {
        this.emails.add(email);
    }

    @Override
    public String toString() {
        return 	"\n[Contatto]\n"+
                "Nome: " + nome + '\n'+
                "Cognome: " + cognome + '\n'+
                "Indirizzo: " + indirizzo + '\n'+
                "Emails: " + emails + '\n' +
                "Number: " + numeri + '\n';
    }
}
