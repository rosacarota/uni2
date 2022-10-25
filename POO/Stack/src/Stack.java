public class Stack {
    private final int[] s;
    private final int NUM;
    private int size;


    Stack(int num) {
        NUM = num;
        s = new int[NUM];
    }

    Stack() {
        this(50); // chiama il costruttore che prende un intero come parametro
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
       return (size == 0);
    }

    public boolean pop () {
        if(size <= 0) {
            System.out.println("Lo stack è vuoto");
            return false;
        }
        size--;
        return true;
    }

    public boolean push(int x) {
        if(size >= NUM){
            System.out.println("Lo stack è pieno");
            return false;
        }

        s[size++] = x;
        return true;
    }

    public Integer top() {
        try{
            if (size <= 0) {
                throw new ArrayIndexOutOfBoundsException("Lo stack è vuoto");
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Lo stack è vuoto");
            return null;
        }
        return s[size - 1];
    }
}
