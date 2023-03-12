package interfacce;
import eccezioni.*;
import core.*;

public interface ComandiAvanzati {
    boolean fusione(Player two) throws IllegalActionException;
    boolean attaccoAereo(Player other) throws IllegalActionException;
}
