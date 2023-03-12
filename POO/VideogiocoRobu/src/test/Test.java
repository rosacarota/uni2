package test;

import core.Lottatore;
import core.LottatoreVolante;
import core.Mago;
import core.Player;
import eccezioni.IllegalActionException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {
    public static void main(String[] args) {
        ArrayList<Player> playerlist = new ArrayList<>();
        playerlist.add(new Lottatore(10, 20, 30));
        playerlist.add(new Lottatore(40, 50, 60));
        playerlist.add(new Lottatore(70, 200, 100));

        playerlist.add(new Mago(10, 20, 30));
        playerlist.add(new Mago(40, 50, 60));
        playerlist.add(new Mago(70, 80, 90));

        playerlist.add(new LottatoreVolante(10, 20, 30));
        playerlist.add(new LottatoreVolante(40, 50, 60));
        playerlist.add(new LottatoreVolante(70, 80, 90));


        stampaPlayer(playerlist);
        stampaPlayerPred(playerlist, p -> p.getDifesa() >= 100 && p.getAttacco() >= 100);
        stampaPlayerPred(playerlist, p-> p.getDifesa() <= p.getPuntiVita());
        // stampaPlayerClass(playerlist, Mago.class);
        stampaPlayerPred(playerlist, p -> p instanceof Mago);
        stampaPlayerPred(playerlist, p->p instanceof Lottatore);
        stampaPlayerFunction(playerlist, p-> String.valueOf(p.getAttacco()));
    }

    private static void stampaPlayer(List<Player> listaPlayer) {
        listaPlayer.forEach(System.out::println);
    }

    private static void stampaPlayerPred(List<Player> listaPlayer, Predicate<Player> predicate){
        listaPlayer.stream().filter(predicate).forEach(System.out::println);
    }

//    // robustelli way
//    private static <T> void stampaPlayerClass(List<Player> lista, Class<T> cl) {
//        lista.stream().filter(cl::isInstance).forEach(System.out::println);
//        // listaPlayer.stream().filter(p -> cl.isInstance(p))
//    }

    private static void stampaPlayerFunction(List<Player> listaPlayer, Function<Player, String> fun) {
        listaPlayer.stream().map(fun).forEach(System.out::println);
    }

}
