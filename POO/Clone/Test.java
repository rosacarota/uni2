public class Test implements Cloneable {
    String a = "Ciao";

    public Object clone() {
        try {
            return super.clone();
        }
        catch(CloneNotSupportedException e ){
            return null;
        }
    }

    public static void main(String[] args) {
        Test b = new Test();

        Test c = (Test) b.clone();
        
        System.out.println(b.a == c.a);
    }

}
