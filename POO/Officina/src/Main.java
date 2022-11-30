import java.io.*;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        Officina o = new Officina();
        Scheda s1, s2, s3;

        Date d = new Date(2022, Calendar.JULY, Calendar.DATE );

        s1 = new Scheda("EHI", "CIAO", d);
        s2 = new Scheda("BELLA", "TI", d);
        s3 = new Scheda("BIONDA", "SCASSO", d);

        o.addScheda(s1);
        o.addScheda(s2);
        o.addScheda(s3);

        o.getNomeFile("Mammt");
        o.stampaVeicoli();

        /*
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new DataOutputStream(new FileOutputStream("ktm")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("kt3"));
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("ktm2"));
        PrintStream printStream = new PrintStream(new DataOutputStream(new FileOutputStream("ktm4")));
        PrintWriter printWriter = new PrintWriter(new FileWriter("ktm5"));

        printStream.print(s1);
        printStream.close();
        bufferedWriter.write("tua mamma è una zoccola (di merda)", 0, 23);
        bufferedWriter.close();
        dataOutputStream.write(24);
        bufferedOutputStream.write(91);
        bufferedOutputStream.close(); */

    }
}
