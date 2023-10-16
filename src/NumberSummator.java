import java.util.List;

/**
 * Esta clase gestiona la lógica de sumar números desde cadenas de texto.
 */
public class NumberSummator {

    /**
     * Suma los números presentes en las líneas de una lista de cadenas.
     *
     * @param lines Una lista de cadenas, donde cada cadena puede contener números.
     * @return La suma total de todos los números encontrados en las cadenas.
     */
    public long sumNumbersFromString(List<String> lines) {
        long suma = 0;

        for (String line : lines) {
            String[] palabras = line.split(" ");

            for (String posibleNumero : palabras) {
                try {
                    long num = Long.parseLong(posibleNumero);
                    suma += num;
                } catch (NumberFormatException e) {
                    // Ignora valores que no sean enteros
                }
            }
        }

        return suma;
    }
}
