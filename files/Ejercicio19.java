import java.util.*;

public class Ejercicio19 {

    public static List<Integer> numerosDivisibles(int divisor) {
        List<Integer> resultado = new ArrayList<>();
        for (int i = 50; i <= 150; i++) {
            if (i % divisor == 0) {
                resultado.add(i);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int divisor;
        do {
            System.out.print("Introduce un número entre 3 y 9: ");
            divisor = sc.nextInt();
        } while (divisor < 3 || divisor > 9); // validación del enunciado

        List<Integer> lista = numerosDivisibles(divisor);
        System.out.println("Números del 50 al 150 divisibles por " + divisor + ":");
        System.out.println(lista);
        sc.close();
    }
}
