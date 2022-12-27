import java.sql.*;
import java.util.Calendar;
import java.util.Scanner;

public class Query {
    private final Database database;
    private final Scanner scanner = new Scanner(System.in);

    public Query(Database database) {
        this.database = database;
    }

    public void queryTest() throws SQLException {
        Statement statement;
        ResultSet resultSet;

        statement = database.getConnection().createStatement();
        resultSet = statement.executeQuery("SELECT * FROM Cliente");

        for (int i = 0; resultSet.next(); i++)
            System.out.println(i + " " + resultSet.getString("email"));

        statement.close();
    }

    public void query1() throws SQLException {
        PreparedStatement preparedStatement;

        // Query inserimento cliente
        String query = "INSERT INTO Cliente (email, passwd, nome, cognome, datadinascita, " +
                "numeroditelefono, nazionalita) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String email;

        preparedStatement = database.getConnection().prepareStatement(query);

        System.out.print("Inserisci email: ");
        email = scanner.nextLine();
        preparedStatement.setString(1, email);

        System.out.print("Inserisci password: ");
        preparedStatement.setString(2, scanner.nextLine());

        System.out.print("Inserisci nome: ");
        preparedStatement.setString(3, scanner.nextLine());

        System.out.print("Inserisci cognome: ");
        preparedStatement.setString(4, scanner.nextLine());

        System.out.print("Inserisci data di nascita (YYYY-MM-DD): ");
        preparedStatement.setDate(5, Date.valueOf(scanner.nextLine()));

        System.out.print("Inserisci numero di telefono: ");
        preparedStatement.setString(6, scanner.nextLine());

        System.out.print("Inserisci nazionalità: ");
        preparedStatement.setString(7, scanner.nextLine());

        preparedStatement.execute();
        preparedStatement.close();

        // Query inserimento tessera
        query = "INSERT INTO TesseraFedelta (Cliente, tipo, dataEmissione, dataScadenza, scontoPremium) " +
                "VALUES (?, ?, ?, ?, ?)";
        String tipo;
        Date dataEmissione;

        preparedStatement = database.getConnection().prepareStatement(query);

        preparedStatement.setString(1, email);

        System.out.print("Inserire il tipo di tessera (0 Standard, 1 Premium): ");
        if (scanner.nextInt() == 1)
            tipo = "Premium";
        else
            tipo = "Standard";
        preparedStatement.setString(2, tipo);

        // Data emissione = data corrente
        dataEmissione = new Date(System.currentTimeMillis());
        preparedStatement.setDate(3, dataEmissione);

        // La tessera scade 10 anni dopo
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataEmissione);
        calendar.add(Calendar.YEAR, 10);
        preparedStatement.setDate(4, new Date(calendar.getTimeInMillis()));

        if (tipo.equals("Premium")) {
            System.out.print("Inserire la quantità di sconto premium: ");
            preparedStatement.setInt(5, scanner.nextInt());
        }
        else
            preparedStatement.setInt(5, 0);

        preparedStatement.execute();
        preparedStatement.close();

        System.out.println("\n-------------- Cliente registrato --------------");
    }

    public void query5() throws SQLException {
        Statement statement;
        ResultSet resultSet;
        String query = "SELECT * FROM StrutturaRicettiva " +
                "ORDER BY citta";

        statement = database.getConnection().createStatement();
        resultSet = statement.executeQuery(query);

        System.out.println("-------------- Risultato --------------");

        for (int i = 1; resultSet.next(); i++)
            System.out.printf("(%d):\t%d\t%d\t%s\t%s\t%s\t%s\n", i, resultSet.getInt("codiceStruttura"),
                    resultSet.getInt("annoDiIscrizione"), resultSet.getString("nome"),
                    resultSet.getString("citta"), resultSet.getString("via"), resultSet.getString("cap"));

        statement.close();
    }
}
