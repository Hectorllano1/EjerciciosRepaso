import java.util.*;

class Paciente {
    private String nombre;
    private String apellido;
    private String documento; // identifica al paciente de forma única
    private String enfermedad;
    private String tratamiento;
    private boolean ingresado;

    public Paciente(String nombre, String apellido, String documento, String enfermedad, String tratamiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.enfermedad = enfermedad;
        this.tratamiento = tratamiento;
        this.ingresado = false; // por defecto no requiere ingreso
    }

    public String getDocumento() { return documento; }
    public boolean isIngresado() { return ingresado; }
    public void setIngresado(boolean ingresado) { this.ingresado = ingresado; }

    @Override
    public String toString() {
        return documento + " - " + nombre + " " + apellido + " | " + enfermedad
                + " | Tratamiento: " + tratamiento + " | Ingresado: " + (ingresado ? "Sí" : "No");
    }
}

public class Ejercicio18 {
    // Usamos una lista en vez de un array de tamaño fijo, para no limitar el número de pacientes
    private static List<Paciente> pacientes = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // consumir el salto de línea pendiente

            switch (opcion) {
                case 1 -> recepcionPaciente();
                case 2 -> altaPaciente();
                case 3 -> ingresoPaciente();
                case 4 -> listarPacientes();
                case 5 -> listarIngresados();
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n1. Recepción de nuevo paciente");
        System.out.println("2. Alta del paciente");
        System.out.println("3. Ingreso del paciente");
        System.out.println("4. Listado de pacientes");
        System.out.println("5. Listado de pacientes ingresados");
        System.out.println("6. Salir");
        System.out.print("Opción: ");
    }

    // Busca por documento; devuelve null si no existe (evita duplicados)
    private static Paciente buscarPorDocumento(String documento) {
        for (Paciente p : pacientes) {
            if (p.getDocumento().equals(documento)) return p;
        }
        return null;
    }

    private static void recepcionPaciente() {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Documento: ");
        String documento = sc.nextLine();

        if (buscarPorDocumento(documento) != null) {
            System.out.println("Ya existe un paciente con ese documento");
            return;
        }

        System.out.print("Descripción de la enfermedad: ");
        String enfermedad = sc.nextLine();
        System.out.print("Tratamiento: ");
        String tratamiento = sc.nextLine();

        pacientes.add(new Paciente(nombre, apellido, documento, enfermedad, tratamiento));
        System.out.println("Paciente registrado correctamente");
    }

    private static void altaPaciente() {
        System.out.print("Documento del paciente a dar de alta: ");
        String documento = sc.nextLine();
        Paciente p = buscarPorDocumento(documento);
        if (p != null) {
            pacientes.remove(p);
            System.out.println("Paciente dado de alta");
        } else {
            System.out.println("No se ha encontrado el paciente");
        }
    }

    private static void ingresoPaciente() {
        System.out.print("Documento del paciente a ingresar: ");
        String documento = sc.nextLine();
        Paciente p = buscarPorDocumento(documento);
        if (p != null) {
            p.setIngresado(true);
            System.out.println("Paciente marcado como ingresado");
        } else {
            System.out.println("No se ha encontrado el paciente");
        }
    }

    private static void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes en el servicio");
            return;
        }
        for (Paciente p : pacientes) System.out.println(p);
    }

    private static void listarIngresados() {
        boolean hayIngresados = false;
        for (Paciente p : pacientes) {
            if (p.isIngresado()) {
                System.out.println(p);
                hayIngresados = true;
            }
        }
        if (!hayIngresados) System.out.println("No hay pacientes ingresados");
    }
}
