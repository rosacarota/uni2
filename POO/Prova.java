class A {
   // public int x = 9;

    
}

class B extends A {
    public int x = 10;
}

public class Prova {
    public static void main(String[] args) {
        A a = new B();

        System.out.println(a.x); 
    }
}
