import java.sql.SQLException;
import java.util.Scanner;

public class InterfacciaQuery {
    private Database database;
    private Query query;
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        InterfacciaQuery interfacciaQuery = new InterfacciaQuery();

        interfacciaQuery.connessione();
        interfacciaQuery.dashboard();
        interfacciaQuery.database.close();
    }

    private void connessione() throws SQLException, ClassNotFoundException {
        System.out.println("-------------- Connessione al database --------------");

//        System.out.print("Inserire il nome del database: ");
//        String databaseName = scanner.nextLine();
//        System.out.print("Inserire nome utente: ");
//        String username = scanner.nextLine();
//        System.out.print("Inserire password: ");
//        String password = scanner.nextLine();

//        database = new Database(databaseName, username, password);
        database = new Database("ddl_progetto", "root", "");
        query = new Query(database);

        database.connect();
    }

    private void dashboard() throws SQLException {
        char sel;

        while (true) {
            System.out.println("\n-------------- Interfaccia query --------------");
            System.out.println("""
                    1. Esegui query 1 (Registrazione cliente)
                    2. Esegui query 2
                    3. Esegui query 3
                    4. Esegui query 4
                    5. Esegui query 5 (Visualizzazione strutture ricettive per città)
                    0. Esci
                    """);

            System.out.print("Selezione: ");
            sel = scanner.nextLine().charAt(0);

            System.out.println();

            switch (sel) {
                case '1' -> query.query1();
                case '2' -> System.out.println("Paolone");
                case '3' -> System.out.println("Paoletto");
                case '4' -> query.queryTest();
                case '5' -> query.query5();
                case '0' -> System.exit(0);
                default -> System.out.println("Paolissimo");
            }
        }
    }
}