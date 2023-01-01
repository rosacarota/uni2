import java.sql.*;
import java.time.Year;
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
        resultSet = statement.executeQuery("SELECT MAX(codiceStruttura) as MAX FROM StrutturaRicettiva");

        resultSet.next();
        System.out.println(resultSet.getInt("MAX"));
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

    public void query2() throws SQLException {
        PreparedStatement statementStruttura, statementTipo = null;
        String queryStruttura = "INSERT INTO StrutturaRicettiva (annoDiIscrizione, nome, citta, via, cap) " +
                "VALUES (?, ?, ?, ?, ?)";
        String queryTipo;
        char tipo;
        int StrutturaRicettiva;

        statementStruttura = database.getConnection().prepareStatement(queryStruttura);

        System.out.println("-------------- Inserisci Struttura --------------");

        // Richiesta informazioni struttura ricettiva
        statementStruttura.setInt(1, Year.now().getValue());

        System.out.print("Inserire il nome: ");
        statementStruttura.setString(2, scanner.nextLine());

        System.out.print("Inserire la città: ");
        statementStruttura.setString(3, scanner.nextLine());

        System.out.print("Inserire la via: ");
        statementStruttura.setString(4, scanner.nextLine());

        System.out.print("Inserire il cap: ");
        statementStruttura.setString(5, scanner.nextLine());

        // Ottenimento ultima struttura inserita
        Statement statement;
        ResultSet resultSet;

        statement = database.getConnection().createStatement();
        resultSet = statement.executeQuery("SELECT MAX(codiceStruttura) as Max FROM StrutturaRicettiva");

        resultSet.next();
        StrutturaRicettiva = resultSet.getInt("Max") + 1;
        statement.close();

        // Richiesta di tipologia
        System.out.println("\n1. Hotel\n2. Ostello\n3. Appartamento\n");
        System.out.print("Quale tipo di struttura ricettiva si desidera registrare?: ");
        tipo = scanner.nextLine().charAt(0);

        switch (tipo) {
            case '1' -> {
                queryTipo = "INSERT INTO Hotel VALUES (?)";
                statementTipo = database.getConnection().prepareStatement(queryTipo);

                statementTipo.setInt(1, StrutturaRicettiva);
            }
            case '2' -> {
                queryTipo = "INSERT INTO Ostello (StrutturaRicettiva, prezzoNottePostoLetto, postiLettoTotali) " +
                        "VALUES(?, ?, ?)";
                statementTipo = database.getConnection().prepareStatement(queryTipo);

                statementTipo.setInt(1, StrutturaRicettiva);

                System.out.print("Inserire il prezzo a notte per posto letto: ");
                statementStruttura.setFloat(2, scanner.nextFloat());

                System.out.print("Inserire i posti letto totali: ");
                statementStruttura.setInt(3, scanner.nextInt());
            }
            case '3' -> {
                queryTipo = "INSERT INTO Appartamento (StrutturaRicettiva, prezzoNotte, postiLetto, metriQuadri, vani) " +
                        "VALUES (?, ?, ?, ?, ?)";
                statementTipo = database.getConnection().prepareStatement(queryTipo);

                statementTipo.setInt(1, StrutturaRicettiva);

                System.out.print("Inserire il prezzo a notte: ");
                statementStruttura.setFloat(2, scanner.nextFloat());

                System.out.print("Inserire i posti letto totali: ");
                statementStruttura.setInt(3, scanner.nextInt());

                System.out.print("Inserire i metri quadri: ");
                statementStruttura.setInt(4, scanner.nextInt());

                System.out.print("Inserire i vani quadri: ");
                statementStruttura.setInt(5, scanner.nextInt());
            }
            default -> System.out.println("Codice struttura non coretto");
        }

        if (statementTipo != null) {
            statementStruttura.execute();
            statementStruttura.close();
            statementTipo.execute();
            statementTipo.close();

            System.out.println("-------------- Struttura Registrata --------------");
        }
        else {
            statementStruttura.close();
        }
    }

    public void query4() throws SQLException {
        PreparedStatement statementEmail;
        ResultSet resultSet;
        String email;

        System.out.println("-------------- Aggiornamento a tessera premium --------------");
        System.out.print("Inserire l'email del cliente: ");
        email = scanner.nextLine();

        statementEmail = database.getConnection().prepareStatement("SELECT email FROM Cliente " +
                "WHERE email = ?");
        statementEmail.setString(1, email);
        resultSet = statementEmail.executeQuery();

        if (!resultSet.next())
            System.out.println("Il cliente non è presente nel database");
        else {
            PreparedStatement statementPremium;

            statementPremium = database.getConnection().prepareStatement("SELECT tipo " +
                    "FROM TesseraFedelta WHERE Cliente = ?");
            statementPremium.setString(1, email);
            resultSet = statementPremium.executeQuery();

            resultSet.next();
            String tipo = resultSet.getString("tipo");

            if (tipo.equals("Premium"))
                System.out.println("Il cliente è già premium");
            else if (tipo.equals("Standard")) {
                PreparedStatement updatePremium = database.getConnection().prepareStatement("UPDATE " +
                        "TesseraFedelta SET tipo = ?, scontoPremium = ? WHERE Cliente = ?");

                updatePremium.setString(1, "Premium");

                System.out.print("Inserire lo sconto da assegnare: ");
                updatePremium.setInt(2, scanner.nextInt());

                updatePremium.setString(3, email);

                updatePremium.execute();
                updatePremium.close();

                System.out.println("\n-------------- Aggiornamento effettuato --------------");
            }

            statementPremium.close();
        }

        statementEmail.close();
    }

    public void query5() throws SQLException {
        Statement statement;
        ResultSet resultSet;
        String query = "SELECT * FROM StrutturaRicettiva ORDER BY citta";

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
