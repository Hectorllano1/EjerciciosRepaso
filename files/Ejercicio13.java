// Interfaz para todo lo que se puede prestar (formato físico)
interface IPrestable {
    void prestar();
    void devolver();
    boolean estaPrestado();
}

// Interfaz para todo lo que se puede comprar (formato digital)
interface IComprable {
    void comprar();
    boolean esComprable();
}

// Clase padre: lo común a cualquier película (física o digital)
abstract class Pelicula {
    private int idBaseDatos;
    private String titulo;
    private int anioPublicacion;

    public Pelicula(int idBaseDatos, String titulo, int anioPublicacion) {
        this.idBaseDatos = idBaseDatos;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
    }

    public int getIdBaseDatos() { return idBaseDatos; }
    public String getTitulo() { return titulo; }
    public int getAnioPublicacion() { return anioPublicacion; }
}

// Formato físico: hereda de Pelicula e implementa IPrestable
class FormatoFisico extends Pelicula implements IPrestable {
    private String numeroIFF;
    private boolean prestado;

    public FormatoFisico(int idBaseDatos, String titulo, int anioPublicacion, String numeroIFF) {
        super(idBaseDatos, titulo, anioPublicacion);
        this.numeroIFF = numeroIFF;
        this.prestado = false; // por defecto no está prestado
    }

    public String getNumeroIFF() { return numeroIFF; }

    @Override
    public void prestar() {
        if (!prestado) {
            prestado = true;
            System.out.println(getTitulo() + " ha sido prestado");
        } else {
            System.out.println(getTitulo() + " ya estaba prestado");
        }
    }

    @Override
    public void devolver() {
        prestado = false;
    }

    @Override
    public boolean estaPrestado() {
        return prestado;
    }
}

// Formato digital: hereda de Pelicula e implementa IComprable
class FormatoDigital extends Pelicula implements IComprable {
    private String numeroIFD;
    private int comprasRestantes;
    private static final int MAX_COMPRAS = 10;

    public FormatoDigital(int idBaseDatos, String titulo, int anioPublicacion, String numeroIFD) {
        super(idBaseDatos, titulo, anioPublicacion);
        this.numeroIFD = numeroIFD;
        this.comprasRestantes = MAX_COMPRAS;
    }

    public String getNumeroIFD() { return numeroIFD; }

    @Override
    public void comprar() {
        if (esComprable()) {
            comprasRestantes--;
            System.out.println(getTitulo() + " comprado. Quedan " + comprasRestantes + " compras");
        } else {
            System.out.println(getTitulo() + " ya no se puede comprar más (límite alcanzado)");
        }
    }

    @Override
    public boolean esComprable() {
        return comprasRestantes > 0;
    }
}

public class Ejercicio13 {
    public static void main(String[] args) {
        FormatoFisico f1 = new FormatoFisico(1, "Matrix", 1999, "IFF001");
        FormatoFisico f2 = new FormatoFisico(2, "Interstellar", 2014, "IFF002");
        f1.prestar();
        f1.prestar(); // ya estaba prestado
        f1.devolver();

        FormatoDigital d1 = new FormatoDigital(3, "Inception", 2010, "IFD001");
        FormatoDigital d2 = new FormatoDigital(4, "Dune", 2021, "IFD002");
        for (int i = 0; i < 11; i++) d1.comprar(); // en la última no debe dejar comprar
    }
}
