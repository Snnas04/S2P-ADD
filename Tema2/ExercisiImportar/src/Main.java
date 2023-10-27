import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/negoci";
    private static final String usuari = "root";
    private static final String password = "1234";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(url, usuari, password)) {
            conn.setAutoCommit(false); // Desactivar autocommit
            deleteAllRecords(conn);
            conn.commit(); // Confirmar los cambios

            List<Empleat> empleats = readEmpleatsFromFile("empleats.dat");

            System.out.println("Statement");
            conn.setAutoCommit(false); // Desactivar autocommit
            long startTime = System.currentTimeMillis();
            insertEmpleatsUsingStatement(conn, empleats);
            long endTime = System.currentTimeMillis();
            double elapsedSeconds = (endTime - startTime) / 1000.0; // Calcula el tiempo en segundos
            conn.commit(); // Confirmar los cambios
            System.out.println("Tiempo de inserción con Statement: " + elapsedSeconds + " segundos");

            System.out.println("\nDelete");
            conn.setAutoCommit(false); // Desactivar autocommit
            deleteAllRecords(conn);
            conn.commit();
            System.out.println("Delete finalizado\n");
            // Confirmar los cambios

            System.out.println("PreparedStatement");
            conn.setAutoCommit(false); // Desactivar autocommit
            startTime = System.currentTimeMillis();
            insertEmpleatsUsingPreparedStatement(conn, empleats);
            endTime = System.currentTimeMillis();
            elapsedSeconds = (endTime - startTime) / 1000.0; // Calcula el tiempo en segundos
            conn.commit(); // Confirmar los cambios
            System.out.println("Tiempo de inserción con PreparedStatement: " + elapsedSeconds + " segundos");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Empleat> readEmpleatsFromFile(String fileName) {
        List<Empleat> empleats = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    Empleat empleat = (Empleat) ois.readObject();
                    empleats.add(empleat);
                } catch (EOFException e) {
                    break;  // Se alcanzó el final del archivo
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return empleats;
    }

    private static void insertEmpleatsUsingStatement(Connection conn, List<Empleat> empleats) {
        try (Statement st = conn.createStatement()) {
            int totalEmpleats = empleats.size();
            for (int i = 0; i < totalEmpleats; i++) {
                Empleat e = empleats.get(i);
                String sql = "INSERT INTO EMP (EMP_NO, COGNOM, NOM, OFICI, CAP, DATA_ALTA, SALARI, COMISSIO, DEPT_NO) VALUES (" +
                        e.getNumero() + ", '" +
                        e.getCognoms() + "', '" +
                        e.getNom() + "', 'IT', 7839, '" +
                        e.getAlta() + "', NULL, NULL, 20)";
                st.executeUpdate(sql);
//                System.out.println((i + 1) + "/" + totalEmpleats);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void insertEmpleatsUsingPreparedStatement(Connection conn, List<Empleat> empleats) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO EMP (EMP_NO, COGNOM, NOM, OFICI, CAP, DATA_ALTA, SALARI, COMISSIO, DEPT_NO) VALUES (?, ?, ?, 'IT', 7839, ?, NULL, NULL, 20)")) {
            int totalEmpleats = empleats.size();
            for (int i = 0; i < totalEmpleats; i++) {
                Empleat e = empleats.get(i);
                ps.setInt(1, e.getNumero());
                ps.setString(2, e.getCognoms());
                ps.setString(3, e.getNom());
                ps.setDate(4, Date.valueOf(e.getAlta()));
                ps.executeUpdate();
//                System.out.println((i + 1) + "/" + totalEmpleats);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteAllRecords(Connection conn) {
        try (Statement st = conn.createStatement()) {
            String sql = "DELETE FROM EMP WHERE DEPT_NO = 20 AND OFICI= 'IT' AND CAP = 7839";
            int rowsDeleted = st.executeUpdate(sql);
            System.out.println("Registros eliminados: " + rowsDeleted);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
