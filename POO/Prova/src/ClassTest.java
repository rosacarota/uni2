abstract class PadreTest {
    int y = 9;

}
class RosaTest extends PadreTest {
    int c = 67;
}

public class ClassTest {
    public static void main(String[] args) {
        RosaTest r = new RosaTest();
        System.out.println(r.y);
    }
}
