import java.util.ArrayList;

public class Rubrica {
    private final ArrayList<Contatto> contatti;

    public Rubrica(){
        contatti = new ArrayList<Contatto>();
    }

    public void addContatto(Contatto c) {
        contatti.add(c);
    }

    public Contatto getContatto(int index) {
        return contatti.get(index);
    }



    @Override
    public String toString() {
        return "[Rubrica]\n" + contatti;
    }

    public Contatto searchNome(String nome) {
        for (Contatto c: contatti)
            if (c.getNome().equals(nome))
                return c;

        return null;
    }

    public Contatto searchCognome(String cognome) {
        for (Contatto c: contatti)
            if (c.getCognome().equals(cognome))
                return c;

        return null;
    }

    public Contatto searchNomeCognome(String nome, String cognome) {
        for (Contatto c: contatti)
            if ((c.getNome().equals(nome)) && (c.getCognome().equals(cognome)))
                return c;

        return null;
    }

    /*public Contatto searchNumero(String numero) {
       for (int i = 0; i < contatti.size(); i++) {
           Contatto c = contatti.get(i);
           for(int j = 0; j < c.getNumeri().size(); j++)
               if(c.getNumeri().get(j).equals(numero))
                   return c;
       }

       return null;
    }*/

    public Contatto searchNumero(String numero) {
        for (Contatto c: contatti)
            for(String s: c.getNumeri())
                if(s.equals(numero))
                    return c;

        return null;
    }
}