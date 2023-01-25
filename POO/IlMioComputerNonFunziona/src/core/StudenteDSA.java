package core;

public class StudenteDSA extends Studente {
    private String nomePatologia, descrizionePatologia;

    public StudenteDSA(String nome, String cognome, String matricola, int anni, String descrizionePatologia, String nomePatologia) {
        super(nome, cognome, matricola, anni);
        this.descrizionePatologia = descrizionePatologia;
        this.nomePatologia = nomePatologia;
    }

    public String getDescrizionePatologia() {
        return descrizionePatologia;
    }

    public void setDescrizionePatologia(String descrizionePatologia) {
        this.descrizionePatologia = descrizionePatologia;
    }

    public String getNomePatologia() {
        return nomePatologia;
    }

    public void setNomePatologia(String nomePatologia) {
        this.nomePatologia = nomePatologia;
    }

    @Override
    public String toString() {
        return "core.StudenteDSA{" +
                "nomePatologia ='" + nomePatologia + '\''+
                "descrizionePatologia='" + descrizionePatologia + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", matricola='" + matricola + '\'' +
                ", anni=" + anni +
                ", esamiSuperati=" + esamiSuperati +
                '}';
    }
}
