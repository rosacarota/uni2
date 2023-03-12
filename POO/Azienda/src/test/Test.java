package test;

import java.io.IOException;
import java.io.PrintWriter;

interface C {
    double getPi();
    double getE();
}
@FunctionalInterface
interface F {
    double getPI();
}

class R {
    public void stampa(F ciao) {
        System.out.println("Ciao " + ciao.getPI());
    }
}

public class Test {
    public static void main(String[] args) {
        C c = new C() {
            @Override
            public double getPi() {
                return 1;
            }

            @Override
            public double getE() {
                return 2;
            }
        };

        R cacca = new R();
        cacca.stampa(() -> {
            System.out.println("Cacca ");
            return 5.6;
        });

    }



}
