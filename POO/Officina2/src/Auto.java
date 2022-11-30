public class Auto {
    private String proprietario;
    private String targa;
    private String modello;

    public Auto(String proprietario, String targa, String modello) {
        this.proprietario = proprietario;
        this.targa = targa;
        this.modello = modello;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    @Override
    public String toString() {
        return "[AUTO]" +
                "Proprietario = " + proprietario + '\n' +
                "targa = " + targa + '\n' +
                "Modello =" + modello + "\n\n";
    }


}
