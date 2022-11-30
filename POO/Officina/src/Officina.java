import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Officina {
    private ArrayList<Scheda> schede;
    private String nome_file;

    public Officina() {
        schede = new ArrayList<Scheda>();
    }

    public void addScheda(Scheda s) {
        schede.add(s);
    }

    public ArrayList getSchede() {
        return schede;
    }

    public void getNomeFile(String nome_file) {
        this.nome_file = nome_file;
    }

    public void stampaVeicoli() throws IOException {
        PrintWriter p = new PrintWriter(new FileWriter(nome_file));

        for(Scheda s: schede)
            p.print(s);

        p.close();
    }
}
