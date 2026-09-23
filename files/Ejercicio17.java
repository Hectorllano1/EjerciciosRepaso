import java.io.*;
import java.util.Scanner;

// Implements Serializable: sin esto Java no permite guardar el objeto en un fichero
class AnimalSerializable implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private float peso;
    private String raza;

    public AnimalSerializable(String nombre, float peso, String raza) {
        this.nombre = nombre;
        this.peso = peso;
        this.raza = raza;
    }

    public String getNombre() { return nombre; }
    public float getPeso() { return peso; }
    public String getRaza() { return raza; }
}

public class Ejercicio17 {

    // Genera 3 animales pedidos por teclado y los serializa en animales.dat
    public static void generarYGuardarAnimales() {
        Scanner sc = new Scanner(System.in);
        // ObjectOutputStream es el que permite escribir objetos completos, no solo texto
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animales.dat"))) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Animal " + i + ":");
                System.out.print("  Nombre: ");
                String nombre = sc.next();
                System.out.print("  Peso: ");
                float peso = sc.nextFloat();
                System.out.print("  Raza: ");
                String raza = sc.next();

                oos.writeObject(new AnimalSerializable(nombre, peso, raza));
            }
        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
        }
    }

    // Lee animales del fichero hasta que no queden más objetos (EOFException)
    public static void leerAnimales() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animales.dat"))) {
            while (true) {
                AnimalSerializable animal = (AnimalSerializable) ois.readObject();
                System.out.println(animal.getNombre() + " - " + animal.getPeso() + "kg - " + animal.getRaza());
            }
        } catch (EOFException e) {
            // Fin del fichero: es la forma normal de terminar, no es un error real
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        generarYGuardarAnimales();
        System.out.println("--- Leyendo del fichero ---");
        leerAnimales();
    }
}
