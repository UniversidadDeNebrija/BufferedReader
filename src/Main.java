import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase principal que lee números de un archivo, calcula su suma y escribe el resultado en otro archivo.
 */
public class Main {
    /**
     * Punto de entrada para el programa.
     *
     * @param args Argumentos de línea de comando (no se utilizan en esta aplicación).
     */
    public static void main(String[] args) {
        // Nombre del archivo de entrada.
        String inputFile = "numeros.txt";

        // Nombre del archivo de salida.
        String outputFile = "suma.txt";

        System.out.println("Directorio de trabajo = " + System.getProperty("user.dir"));

        System.out.println("Valor máximo de Integer = " + Integer.MAX_VALUE);

        try {
            // Abre el archivo de entrada para lectura
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            int suma = 0;
            String linea;

            // Lee cada línea del archivo
            while ((linea = reader.readLine()) != null) {
                // Divide la línea en números separados por espacios
                String[] palabra = linea.split(" ");

                // Suma los enteros presentes en la línea
                for (String posibleNumero : palabra) {
                    try {
                        long num = Long.parseLong(posibleNumero);
                        System.out.println("Número largo: " + num);
                        suma += num;
                    } catch (NumberFormatException e) {
                        // Ignora valores que no sean enteros
                    }
                }
            }

            // Cierra el archivo de entrada
            reader.close();

            // Abre el archivo de salida para escritura
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            // Escribe la suma en el archivo de salida
            writer.write("Suma: " + suma);
            System.out.println("La suma TOTAL es " + suma);

            // Cierra el archivo de salida
            writer.close();

            System.out.println("La suma se ha guardado en " + outputFile);
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}
