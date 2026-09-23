import java.util.*;

public class Ejercicio05 {

    // Genera una matriz 5x5 con los números del 1 al 25 sin repetir,
    // usando una lista "barajada" para no tener que comprobar duplicados.
    public static int[][] generarMatriz() {
        List<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= 25; i++) numeros.add(i);
        Collections.shuffle(numeros); // desordena la lista

        int[][] matriz = new int[5][5];
        int indice = 0;
        for (int f = 0; f < 5; f++) {
            for (int c = 0; c < 5; c++) {
                matriz[f][c] = numeros.get(indice++);
            }
        }
        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) System.out.printf("%4d", valor);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = generarMatriz();
        imprimirMatriz(matriz);

        System.out.print("¿Fila (F) o columna (C)? ");
        String tipo = sc.next().trim().toUpperCase();

        int indice;
        do {
            System.out.print("Introduce el número (0-4): ");
            indice = sc.nextInt();
        } while (indice < 0 || indice > 4); // validación

        int suma = 0;
        if (tipo.equals("F")) {
            for (int c = 0; c < 5; c++) suma += matriz[indice][c];
        } else if (tipo.equals("C")) {
            for (int f = 0; f < 5; f++) suma += matriz[f][indice];
        } else {
            System.out.println("Opción no válida");
            return;
        }

        System.out.println("La suma es: " + suma);
        sc.close();
    }
}
