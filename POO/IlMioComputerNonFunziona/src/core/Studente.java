package core;// Le classi lettera maiuscola e singolari
// Il file deve avere lo stesso nome della classe

import core.Esame;

import java.util.ArrayList;

public class Studente {
    protected String nome, cognome, matricola;
    protected int anni;
    protected ArrayList<Esame> esamiSuperati;

    public Studente(String nome, String cognome, String matricola, int anni) {
        this.nome = nome;
        this.cognome = cognome;
        this.matricola = matricola;
        this.anni = anni;

        esamiSuperati = new ArrayList<>();
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

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public int getAnni() {
        return anni;
    }

    public void setAnni(int anni) {
        this.anni = anni;
    }

    public ArrayList<Esame> getEsamiSuperati() {
        return esamiSuperati;
    }

    public void setEsamiSuperati(ArrayList<Esame> esamiSuperati) {
        this.esamiSuperati = esamiSuperati;
    }

    @Override
    public String toString() {
        return "core.Studente{" +
                "nome = '" + nome + '\'' +
                ", cognome = '" + cognome + '\'' +
                ", matricola = '" + matricola + '\'' +
                ", anni = " + anni +
                ", esamiSuperati=" + esamiSuperati +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;

        Studente s = (Studente) obj;

        return s.matricola.equals(matricola) && s.anni == anni && s.nome.equals(nome)
                && s.cognome.equals(cognome);
    }
}
