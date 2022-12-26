import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Persona {
    public String nome, cognome;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<Persona> persone = new ArrayList<>();

        persone.add(new Persona("Luca", "Casillo"));
        persone.add(new Persona("Mastone", "Mastafive"));
        persone.add(new Persona("Stellina", "Mao"));
        persone.add(new Persona("Stellina", "Bau"));
        persone.add(new Persona("Stellina", "<3"));

        Persona [] p = persone.toArray(new Persona[persone.size()]);

        Arrays.sort(p, (p1, p2) -> p1.nome.compareTo(p2.nome));
        System.out.println(p);

        // processElements(persone, p -> p.nome.charAt(0) == 'S', Persona::toString, System.out::println);
        processElements(persone, per -> per.nome.charAt(0) == 'S', per -> p.toString(), s -> System.out.println(s));
    }

    private static <X, Y> void processElements(Iterable<X> source, Predicate<X> tester,
                                     Function<X, Y> mapper, Consumer<Y> block) {
        for (X x : source)
            if (tester.test(x)) {
                Y data = mapper.apply(x);
                block.accept(data);
            }
    }
}
