package core;

import eccezioni.IllegalActionException;

public class Lottatore extends Player{

    public Lottatore(int puntiVita, int attacco, int difesa, int numeroUccisioni) {
        super(puntiVita * 2, attacco * 4, difesa, numeroUccisioni);
    }

    public Lottatore(int puntiVita, int attacco, int difesa) {
        super(puntiVita * 2, attacco * 4, difesa);
    }

    @Override
    public boolean fusione(Player two) throws IllegalActionException {
        if(!(two instanceof Lottatore && this.puntiVita > 0 && two.puntiVita > 0))
            throw new IllegalActionException();
        else {
            this.puntiVita = this.puntiVita + two.puntiVita;
            this.attacco = this.attacco + two.attacco;
            this.difesa = this.difesa + two.difesa;

            return true;
        }
    }

    @Override
    public boolean attaccoAereo(Player other) throws IllegalActionException {
        throw new IllegalActionException("Il lottatore non attacca in modo aereo");
    }

    @Override
    public boolean attacco(Player other) {
      if(this.attacco > other.difesa &&  this.puntiVita > 0 && other.puntiVita > 0) {
          int damage = this.attacco * 2;
          other.puntiVita -= damage;

          if(other.puntiVita <= 0)
              this.numeroUccisioni++;

          return true;
      }
      return false;
    }

    @Override
    public void potenziamento() {
        if(this.puntiVita > 0 && numeroUccisioni == 5) {
            difesa *= 2;
            numeroUccisioni = 0;
        }
    }

    @Override
    public String toString() {
        return "Lottatore{" +
                "puntiVita=" + puntiVita +
                ", attacco=" + attacco +
                ", difesa=" + difesa +
                ", numeroUccisioni=" + numeroUccisioni +
                '}';
    }
}
