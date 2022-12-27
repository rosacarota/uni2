import java.util.Calendar;
import java.sql.Date;

public class Debug {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        c.add(Calendar.YEAR, 5);
        Date d = new Date(c.getTimeInMillis());
        System.out.println(d);
    }
}
