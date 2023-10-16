import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String inputFile = "numeros.txt"; // Nombre del archivo de entrada
        String outputFile = "suma.txt"; // Nombre del archivo de salida

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        System.out.println("Maximum Integer = " + Integer.MAX_VALUE);


        try {
            // Abrir el archivo de entrada para lectura
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            int suma = 0;
            String linea;

            // Leer cada línea del archivo
            while ((linea = reader.readLine()) != null) {
                // Dividir la línea en números separados por espacios
                String[] palabra = linea.split(" ");

                // Sumar los números enteros presentes en la línea
                for (String posibleNumero : palabra) {
                    try {
                        long num = Long.parseLong(posibleNumero);
                        System.out.println("Long : " + num);
                        suma += num;
                    } catch (NumberFormatException e) {
                        // Ignorar valores no enteros
                    }
                }
            }

            // Cerrar el archivo de entrada
            reader.close();

            // Abrir el archivo de salida para escritura
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            // Escribir la suma en el archivo de salida
            writer.write("Suma: " + suma);
            System.out.println("La suma TOTAL es " + suma);
            // Cerrar el archivo de salida
            writer.close();

            System.out.println("La suma se ha guardado en " + outputFile);
        } catch (IOException e) {
            System.err.println("Error al procesar el archivo: " + e.getMessage());
        }
    }
}