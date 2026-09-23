import java.io.*;
import java.util.*;

public class Ejercicio16 {

    public static void main(String[] args) {
        // Primero generamos un fichero de ejemplo para poder probar el método
        crearFicheroDeEjemplo("alturas.txt");
        calcularEstadisticas("alturas.txt");
    }

    private static void crearFicheroDeEjemplo(String ruta) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ruta))) {
            pw.println("Ana,175");
            pw.println("Luis,162");
            pw.println("Marta,158");
            pw.println("Pedro,190");
        } catch (IOException e) {
            System.out.println("Error creando el fichero: " + e.getMessage());
        }
    }

    public static void calcularEstadisticas(String rutaFichero) {
        int total = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int contador = 0;

        // BufferedReader lee el fichero línea a línea
        try (BufferedReader br = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int altura = Integer.parseInt(partes[1].trim());

                total += altura;
                contador++;
                if (altura > max) max = altura;
                if (altura < min) min = altura;
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el fichero: " + e.getMessage());
            return;
        }

        if (contador == 0) {
            System.out.println("El fichero está vacío");
            return;
        }

        double media = (double) total / contador;
        System.out.println("Altura total: " + total);
        System.out.println("Altura media: " + media);
        System.out.println("Altura máxima: " + max);
        System.out.println("Altura mínima: " + min);
    }
}
