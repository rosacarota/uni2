package core;

import eccezioni.IllegalActionException;

public class Mago extends Player {
    protected int livelloMagia;

    public Mago(int puntiVita, int attacco, int difesa, int numeroUccisioni) {
        super(puntiVita, attacco, difesa, numeroUccisioni);
        this.livelloMagia = 50;
    }

    public Mago(int puntiVita, int attacco, int difesa) {
        super(puntiVita, attacco, difesa);
        this.livelloMagia = 50;
    }

    @Override
    public boolean fusione(Player two) throws IllegalActionException {
       throw new IllegalActionException("Il mago non può invocare la fusione");
    }

    @Override
    public boolean attaccoAereo(Player other) throws IllegalActionException {
        throw new IllegalActionException ("Il mago non può effettuare un attacco aereo");
    }

    @Override
    public boolean attacco(Player other) {
        return false;
    }

    @Override
    public void potenziamento() {

    }

    @Override
    public String toString() {
        return "Mago{" +
                "puntiVita=" + puntiVita +
                ", attacco=" + attacco +
                ", difesa=" + difesa +
                ", numeroUccisioni=" + numeroUccisioni +
                '}';
    }
}
