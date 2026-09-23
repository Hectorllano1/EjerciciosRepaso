import java.util.*;

public class Ejercicio20 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TreeMap para que al imprimir salga ordenado por longitud (1, 2, 4, 6...)
        Map<Integer, List<String>> mapa = new TreeMap<>();

        String palabra;
        do {
            System.out.print("Palabra (\"exit\" para terminar): ");
            palabra = sc.next();

            if (!palabra.equalsIgnoreCase("exit")) {
                int longitud = palabra.length();
                // Si la clave (longitud) no existe todavía, se crea una lista vacía;
                // si ya existe, se reutiliza la lista que ya había.
                mapa.computeIfAbsent(longitud, k -> new ArrayList<>()).add(palabra);
            }
        } while (!palabra.equalsIgnoreCase("exit"));

        for (Map.Entry<Integer, List<String>> entrada : mapa.entrySet()) {
            System.out.println(entrada.getKey() + " => " + entrada.getValue());
        }
        sc.close();
    }
}
