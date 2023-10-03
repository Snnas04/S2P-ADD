package Exercisi3;

import java.io.*;

public class Configmysql {
    private static final String FILE_NAME = "src/Exercisi3/mysql.conf";

    // Mètode per escriure la configuració de MySQL al fitxer "mysql.conf"
    public static void escriureConfiguracioMySQL() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_NAME);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            // Escrivim la configuració de MySQL al fitxer
            bufferedWriter.write("mysql.host = localhost");
            bufferedWriter.newLine();
            bufferedWriter.write("mysql.port = 3306");
            bufferedWriter.newLine();
            bufferedWriter.write("mysql.user = usuari");
            bufferedWriter.newLine();
            bufferedWriter.write("mysql.password = contrasenya");
            bufferedWriter.newLine();

            bufferedWriter.close();
            System.out.println("Configuració de MySQL escrita al fitxer " + FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Mètode per llegir i mostrar per pantalla les propietats del fitxer "mysql.conf"
    public static void llegirConfiguracioMySQL() {
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linia;

            System.out.println("Contingut de " + FILE_NAME + ":");
            while ((linia = bufferedReader.readLine()) != null) {
                System.out.println(linia);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Escriure la configuració de MySQL al fitxer
        escriureConfiguracioMySQL();

        // Llegir i mostrar la configuració de MySQL del fitxer
        llegirConfiguracioMySQL();
    }
}
