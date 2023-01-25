package core;

public class Esame {
    private String nome;
    private int CFU, voto;

    public Esame(String nome, int CFU, int voto) {
        this.nome = nome;
        this.CFU = CFU;
        this.voto = voto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCFU() {
        return CFU;
    }

    public void setCFU(int CFU) {
        this.CFU = CFU;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    @Override
    public String toString() {
        return "core.Esame{" +
                "nome='" + nome + '\'' +
                ", CFU=" + CFU +
                ", voto=" + voto +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;

        Esame es = (Esame) obj;

        return CFU == es.CFU && voto == es.voto && nome.equals(es.nome);
    }
}