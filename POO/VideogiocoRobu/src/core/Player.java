package core;
import interfacce.*;

public abstract class Player implements ComandiAvanzati, ComandiBase{
    protected int puntiVita;
    protected int attacco, difesa;
    protected int numeroUccisioni;

    public Player(int puntiVita, int attacco, int difesa, int numeroUccisioni) {
        this.puntiVita = puntiVita;
        this.attacco = attacco;
        this.difesa = difesa;
        this.numeroUccisioni = numeroUccisioni;
    }

    public Player(int puntiVita, int attacco, int difesa) {
        this.puntiVita = puntiVita;
        this.attacco = attacco;
        this.difesa = difesa;
        numeroUccisioni = 0;
    }

    public int getPuntiVita() {
        return puntiVita;
    }

    public void setPuntiVita(int puntiVita) {
        this.puntiVita = puntiVita;
    }

    public int getAttacco() {
        return attacco;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public int getDifesa() {
        return difesa;
    }

    public void setDifesa(int difesa) {
        this.difesa = difesa;
    }

    public int getNumeroUccisioni() {
        return numeroUccisioni;
    }

    public void setNumeroUccisioni(int numeroUccisioni) {
        this.numeroUccisioni = numeroUccisioni;
    }

    @Override
    public String toString() {
        return "Player{" +
                "puntiVita=" + puntiVita +
                ", attacco=" + attacco +
                ", difesa=" + difesa +
                ", numeroUccisioni=" + numeroUccisioni +
                '}';
    }
}
