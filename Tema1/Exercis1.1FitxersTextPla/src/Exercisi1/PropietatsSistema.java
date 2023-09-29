package Exercisi1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropietatsSistema {
    public static void main(String[] args) {
        PropietatsSistema ps = new PropietatsSistema();
        ps.EscriurePropietats();
    }

    private void EscriurePropietats() {
        try {
            FileWriter fileWriter = new FileWriter("./src/Exercisi1/propietats_del_sistema.json");
            Properties propiedades = System.getProperties();

            // Agregar las propiedades al objeto JSON
            fileWriter.write("{" + "\n");
            fileWriter.write("\"Directorio_JRE\":" + System.getProperty("java.home") + ",\n"); // El directori on s’ha instal·lat el JRE.
            fileWriter.write("\"Sistema_Operativo\":" + "\"" + System.getProperty("os.name") + " " + System.getProperty("os.version") + "\",\n"); // Nom del sistema operatiu i versió
            fileWriter.write("\"Separador_de_Ficheros\":" + System.getProperty("file.separator") + ",\n"); // Separador del sistema de fitxers
            fileWriter.write("\"Nombre_de_Usuario\":" + System.getProperty("user.name") + ",\n"); // Nom del compte d’usuari.

            // El separador utilitzar pel sistema operatiu per separar les línies als fitxers de text.
            String separadorLineas = System.getProperty("line.separator");
            if (separadorLineas.equals("\n")) {
                separadorLineas = "\"\\n\"";
            } else if (separadorLineas.equals("\r")) {
                separadorLineas = "\"\\r\"";
            }

            fileWriter.write("\"Separador_de_Lineas\":" + separadorLineas + "\n");

            fileWriter.write("}");

            fileWriter.close();
            System.out.println("Propiedades escritas en el archivo propietats_del_sistema.json con éxito.");
        } catch (IOException e) {
            System.err.println("Error en crear el archivo: " + e.getMessage());
        }
    }
}
