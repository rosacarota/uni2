import java.util.Date;

public class Scheda {
    private final String targa, modello;
    private static int num_scheda_prog;
    private final int num_scheda;
    private Date dataArrivo;
    //sbagliato enum
    public enum Stati {IN_RIPARAZIONE, RIPARATO, CONSEGNATO};
    private Stati stato;

    public Scheda(String targa, String modello, Date dataArrivo) {
        this.targa = targa;
        this.modello = modello;

        stato = Stati.IN_RIPARAZIONE;
        num_scheda = num_scheda_prog++;

        this.dataArrivo = dataArrivo;
    }

    public void statoVeicolo() {
        System.out.println("[STATO VEICOLO]");
        System.out.println(dataArrivo);
        System.out.println(stato);
    }

    public int getVeicoliTot() {
        return num_scheda_prog;
    }

    public String getTarga() {
        return targa;
    }

    public String getModello() {
        return modello;
    }

    public int getNum_scheda() {
        return num_scheda;
    }

    public Date getDataArrivo() {
        return dataArrivo;
    }

    public Stati getStato() {
        return stato;
    }

    public void setStato(Stati stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Targa:" + targa +
                "\nModello: " + modello +
                "\nStato: " + stato +
                "\nData arrivo: " + dataArrivo.getDay() + "/"
                                  + dataArrivo.getMonth() + "/"
                                  + dataArrivo.getYear() + "\n\n";
    }
}
