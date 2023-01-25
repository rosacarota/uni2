package core;

import interfacce.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListaStudenti implements EsameSuperato, StampaStudenti {
    private ArrayList<Studente> listaStudenti;

    public ListaStudenti() {
        listaStudenti = new ArrayList<>();
    }

    public ArrayList<Studente> getListaStudenti() {
        return listaStudenti;
    }

    @Override
    public String toString() {
        return "core.ListaStudenti{" +
                "listaStudenti=" + listaStudenti +
                '}';
    }


    public List<Studente> getStudentiByEsame(Esame e) {
        List<Studente> listaSuperati = new ArrayList<>();

        for (Studente s : listaStudenti)
            for (Esame es : s.getEsamiSuperati())
                if (es.equals(e))
                    listaSuperati.add(s);

        return listaSuperati;
    }

    public void printInfoDSA() {
        for(Studente s : listaStudenti)
            if(s instanceof StudenteDSA)
                System.out.println(s);
    }

    public List<StudenteDSA> patologiaComune(String nomePatologia) {
        List<StudenteDSA> stessaPatologia = new ArrayList<>();

        for(Studente s : listaStudenti)
            if(s instanceof StudenteDSA)
                if( ((StudenteDSA) s).getNomePatologia().equals(nomePatologia))
                    stessaPatologia.add((StudenteDSA) s);

        return stessaPatologia;
    }

    @Override
    public boolean addEsameSuperato(Studente s, Esame e) {
        if(e.getVoto() < 18 || e.getVoto() > 33)
            return false;
        for(Studente x: listaStudenti)
            if(x.equals(s))
                return x.getEsamiSuperati().add(e);

        return false;
    }


    @Override
    public void stampaListaStudentiNonDSA() {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("listaStudentiNonDSA.txt")))) {
            for(Studente s : listaStudenti)
                if(!(s instanceof StudenteDSA))
                    pw.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void stampaListaStudentiDSA() {
        try(PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("listaStudentiDSA.txt")))) {
            for(Studente s : listaStudenti)
                if(s instanceof StudenteDSA)
                    pw.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
