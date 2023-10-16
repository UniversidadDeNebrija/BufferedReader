import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Esta clase gestiona las operaciones de lectura y escritura de archivos.
 */
public class FileProcessor {

    /**
     * Lee el contenido de un archivo y devuelve una lista con sus líneas.
     *
     * @param filename El nombre del archivo a leer.
     * @return Una lista de cadenas, donde cada cadena es una línea del archivo.
     * @throws IOException Si ocurre un error durante la lectura del archivo.
     */
    public List<String> readFromFile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        return lines;
    }

    /**
     * Escribe una cadena de texto en un archivo.
     *
     * @param filename El nombre del archivo donde se escribirá.
     * @param content El contenido a escribir en el archivo.
     * @throws IOException Si ocurre un error durante la escritura en el archivo.
     */
    public void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }
}
