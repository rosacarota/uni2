import it.unisa.lp2.money.*;

public class MoneyTest {
    public static void main(String[] args) {
        Purse p = new Purse();

        addCoin(p);
        System.out.println("Il totale e': " + p.getTotal());


    }

    private static void addCoin(Purse p) {
        p.addCoin(new Coin("Cent", 0.50));
        p.addCoin(new Coin("Euro", 1.00));
        p.addCoin(new Coin("Cent", 0.05));
        p.addCoin(new Coin("Euro", 2.00));
    }
}
