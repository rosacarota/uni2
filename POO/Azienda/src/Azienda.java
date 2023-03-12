import java.util.ArrayList;
import java.util.List;

public class Azienda {
    private ArrayList<Dipendente> azienda;

    public Azienda() {
        azienda = new ArrayList<>();
    }

    public List<Dipendente> getStagisti() {
        List<Dipendente> listaStagisti = new ArrayList<>();

        for(Dipendente d : azienda) {
            if(d instanceof Stagista)
                listaStagisti.add(d);
        }

        return listaStagisti;
    }

    /*float stipendio(Dipendente e) {
        if(e instanceof Stagista)
            return e.getSalario() - 300;
        if(e instanceof Indeterminati)
            return (e.getSalario() + ((((Indeterminati) e).getBONUS())/100)* e.getSalario()) ;
        if(e instanceof Determinati)
            return e.getSalario();
    }*/

    
}
