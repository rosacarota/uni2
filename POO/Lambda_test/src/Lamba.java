import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.Iterator;

@FunctionalInterface
interface Ciao {
    void stampa(String a);
}

class Ehi{
    Iterable<X> ciao= new Iterable<X>() {
        @Override
        public Iterator<X> iterator() {
            return null;
        }
    }
}
public class Lamba {
    public static void nulla(Ciao ciao) {

    }

    public static void main(String[] args) {

        //nulla((s1,s2) -> s1.length() - s2.length());
        nulla((String s1) -> System.out.println("Mar"));

    }


}
