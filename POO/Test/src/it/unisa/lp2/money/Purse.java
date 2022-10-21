package it.unisa.lp2.money;

public class Purse {
     private final Coin[] purse;
     int count;
     private static final int NUM_COINS = 50;

     public Purse() {
          purse = new Coin[NUM_COINS];
     }

     public boolean addCoin(Coin c) {
          if(count == NUM_COINS || c == null)
               return false;

          purse[count] = c;
          count++;
          return true;
     }

     public double getTotal() {
          double total = 0;

          for (int i = 0; i < count; i++) {
               total += purse[i].getValue();
          }

          /*for(Coin c : purse)
               total += c.getValue();*/

          return total;
     }
     private int isPresent(Coin c) {
          for (int i = 0; i < count; i++) {
               if (purse[i].getValue() == c.getValue()) {
                    return i;
               }
          }
          return -1;
     }

     public boolean removeCoin(Coin c) {
          int j = isPresent(c);

          if (j == -1) return false;

          for(int i = j; i < count; i++) {
               purse[i] = purse[i + 1];
          }

          return true;
     }
}
