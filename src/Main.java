import java.io.IOException;
import java.util.List;

/**
 * Clase principal que coordina la lectura de números desde un archivo, calcula su suma y escribe el resultado en otro archivo.
 */
public class Main {

    /**
     * Método principal que se ejecuta al iniciar el programa.
     *
     * @param args Argumentos de línea de comando (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        String inputFile = "numeros.txt";
        String outputFile = "suma.txt";

        System.out.println("Directorio de trabajo = " + System.getProperty("user.dir"));
        System.out.println("Valor máximo de Integer = " + Integer.MAX_VALUE);

        FileProcessor fileProcessor = new FileProcessor();
        NumberSummator summator = new NumberSummator();

        try {
            List<String> lines = fileProcessor.readFromFile(inputFile);
            long totalSum = summator.sumNumbersFromString(lines);
            System.out.println("La suma TOTAL es " + totalSum);

            fileProcessor.writeToFile(outputFile, "Suma: " + totalSum);
            System.out.println("La suma se ha guardado en " + outputFile);
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
