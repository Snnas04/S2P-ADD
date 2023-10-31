import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/negoci";
    private static final String user = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        String prcedureResult = generateProcedure();
        ExecuteProcedure(prcedureResult);
    }

    public static String generateProcedure() {
        var procedure = "CREATE PROCEDURE dept_stats(IN `id_departament` INT, OUT `num_empleats` INT, OUT `salari_mitja` DECIMAL(10,2)) " +
                "BEGIN " +
                "SELECT COUNT(*) INTO num_empleats FROM EMP WHERE DEPT_NO = id_departament; " +
                "IF num_empleats = 0 THEN " +
                "SET salari_mitja = -1; " +
                "SET num_empleats = 0; " +
                "ELSE " +
                "SELECT AVG(SALARI) INTO salari_mitja FROM EMP WHERE DEPT_NO = id_departament; " +
                "END IF; " +
                "END;";

        return procedure;
    }

    public static void ExecuteProcedure(String procedure) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            // Elimina el procediment si ja existeix
            String dropProcedure = "DROP PROCEDURE IF EXISTS dept_stats";
            CallableStatement dropStatement = connection.prepareCall(dropProcedure);
            dropStatement.execute();

            // Crea el procediment mitjançant una crida
            String createProcedure = procedure;
            CallableStatement createStatement = connection.prepareCall(createProcedure);
            createStatement.execute();

            // Crida al procediment emmagatzemat
            String call = "{call dept_stats(?, ?, ?)}";
            CallableStatement callableStatement = connection.prepareCall(call);

            var statment = connection.createStatement();
            var sql = "SELECT * FROM DEPT";

            var result = statment.executeQuery(sql);
            while (result.next()) {
                int DEPT_NO = result.getInt("DEPT_NO");
                String DNOM = result.getString("DNOM");
                String LOC = result.getString("LOC");

                // Paràmetres d'entrada
                callableStatement.setInt(1, DEPT_NO);

                // Paràmetres de sortida
                callableStatement.registerOutParameter(2, java.sql.Types.INTEGER); // num_empleats
                callableStatement.registerOutParameter(3, java.sql.Types.DECIMAL); // salari_mitja

                // Executa el procediment
                callableStatement.execute();

                // Obté els resultats
                int numEmpleats = callableStatement.getInt(2);
                double salariMitja = callableStatement.getDouble(3);

                System.out.println(
                        "\nDepartament ID: " + DEPT_NO +
                        "\nDepartament Nom: " + DNOM +
                        "\nDepartament Lloc: " + LOC +
                        "\nNombre d'empleats: " + numEmpleats +
                        "\nSalari mitjà: " + salariMitja);
            }

            // Obté els resultats
            int numEmpleats = callableStatement.getInt(2);
            double salariMitja = callableStatement.getDouble(3);

            // Tanca la connexió
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
