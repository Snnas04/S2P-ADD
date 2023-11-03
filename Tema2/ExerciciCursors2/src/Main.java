import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/negoci";
    private static final String user = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Scanner scanner = new Scanner(System.in)) {

            boolean exit = false;

            while (!exit) {
                System.out.println("Menu:");
                System.out.println("1. Primer (Show the first client)");
                System.out.println("2. Següent (Show the next client)");
                System.out.println("3. Anterior (Show the previous client)");
                System.out.println("4. Darrer (Show the last client)");
                System.out.println("5. Sortir (Exit the program)");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();

                var statment = connection.createStatement();
                var result = "0";

                switch (choice) {
                    case 1: // primer
                        var sql =primer();
                        var resultPrimer = statment.executeQuery(sql);
                        resultPrimer.next();
                        var CLIENT_COD = resultPrimer.getString("CLIENT_COD");
                        var NOM = resultPrimer.getString("NOM");
                        var ADRECA = resultPrimer.getString("ADRECA");
                        var TELEFON = resultPrimer.getString("TELEFON");

                        result = CLIENT_COD;

                        System.out.println(
                                "\nID: " + CLIENT_COD +
                                "\nNom: " + NOM +
                                "\nAdreca: " + ADRECA +
                                "\nTelefon: " + TELEFON +
                                "\n"
                        );
                        break;
                    case 2: // seguent
                        sql = seguent(result);
                        resultPrimer = statment.executeQuery(sql);
                        resultPrimer.next();
                        CLIENT_COD = resultPrimer.getString("CLIENT_COD");
                        NOM = resultPrimer.getString("NOM");
                        ADRECA = resultPrimer.getString("ADRECA");
                        TELEFON = resultPrimer.getString("TELEFON");

                        result = CLIENT_COD;

                        System.out.println(
                                "\nID: " + CLIENT_COD +
                                        "\nNom: " + NOM +
                                        "\nAdreca: " + ADRECA +
                                        "\nTelefon: " + TELEFON +
                                        "\n"
                        );
                        break;
                    case 3: // anterior
                        result = anterior(result);
                        statment.executeQuery(result);
                        break;
                    case 4: // darrer
                        statment.executeQuery(darrer());
                        break;
                    case 5: // sortir
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String primer() {
        var sql = "SELECT * FROM CLIENT WHERE CLIENT_COD = (SELECT MIN(CLIENT_COD) FROM CLIENT)";
        return sql;
    }

    public static String seguent(String client) {
        var sql = "SELECT * FROM CLIENT WHERE CLIENT_COD = " + client + " + 1";
        return sql;
    }

    public static String anterior(String client) {
        var sql = "SELECT * FROM CLIENT WHERE CLIENT_COD = " + client + " - 1";
        return sql;
    }

    public static String darrer() {
        var sql = "SELECT * FROM CLIENT WHERE CLIENT_COD = (SELECT MAX(CLIENT_COD) FROM CLIENT)";
        return sql;
    }
}
