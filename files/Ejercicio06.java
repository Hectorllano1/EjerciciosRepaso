import java.util.Scanner;

public class Ejercicio06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas = pedirEntero(sc, "Número de filas: ");
        int columnas = pedirEntero(sc, "Número de columnas: ");

        int[][] matriz = new int[filas][columnas];

        // Pedimos cada celda indicando a qué fila/columna pertenece
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                System.out.print("Valor para la celda [" + f + "][" + c + "]: ");
                matriz[f][c] = sc.nextInt();
            }
        }

        double suma = 0;
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                suma += matriz[f][c];
            }
        }
        double media = suma / (filas * columnas);

        System.out.println("La media de la matriz es: " + media);
        sc.close();
    }

    // Método auxiliar que valida que el número introducido sea mayor que 0
    private static int pedirEntero(Scanner sc, String mensaje) {
        int valor;
        do {
            System.out.print(mensaje);
            valor = sc.nextInt();
        } while (valor <= 0);
        return valor;
    }
}
