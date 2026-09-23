class Libro {
    private String titulo;
    private String autor;
    private int numeroPaginas;
    private int calificacion; // 0 a 10

    public Libro(String titulo, String autor, int numeroPaginas, int calificacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.calificacion = calificacion;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getNumeroPaginas() { return numeroPaginas; }
    public void setNumeroPaginas(int n) { this.numeroPaginas = n; }
    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }

    @Override
    public String toString() {
        return titulo + " (" + autor + ") - " + numeroPaginas + " págs. - Nota: " + calificacion;
    }
}

class ConjuntoLibros {
    private Libro[] libros;
    private int cantidadActual; // cuántos huecos del array están ocupados

    public ConjuntoLibros(int tamanoMaximo) {
        this.libros = new Libro[tamanoMaximo];
        this.cantidadActual = 0;
    }

    // Solo añade si no existe ya (mismo título+autor) y si hay hueco libre
    public boolean anadirLibro(Libro libro) {
        if (cantidadActual >= libros.length) return false;
        if (buscarPorTitulo(libro.getTitulo()) != null) return false;

        libros[cantidadActual] = libro;
        cantidadActual++;
        return true;
    }

    public Libro buscarPorTitulo(String titulo) {
        for (int i = 0; i < cantidadActual; i++) {
            if (libros[i].getTitulo().equalsIgnoreCase(titulo)) return libros[i];
        }
        return null;
    }

    public Libro buscarPorAutor(String autor) {
        for (int i = 0; i < cantidadActual; i++) {
            if (libros[i].getAutor().equalsIgnoreCase(autor)) return libros[i];
        }
        return null;
    }

    // Al eliminar, desplazamos los elementos siguientes una posición hacia la izquierda
    public boolean eliminarPorTitulo(String titulo) {
        for (int i = 0; i < cantidadActual; i++) {
            if (libros[i].getTitulo().equalsIgnoreCase(titulo)) {
                for (int j = i; j < cantidadActual - 1; j++) {
                    libros[j] = libros[j + 1];
                }
                libros[cantidadActual - 1] = null;
                cantidadActual--;
                return true;
            }
        }
        return false;
    }

    public void mostrarMejorYPeorCalificado() {
        if (cantidadActual == 0) {
            System.out.println("No hay libros");
            return;
        }
        Libro mejor = libros[0];
        Libro peor = libros[0];
        for (int i = 1; i < cantidadActual; i++) {
            if (libros[i].getCalificacion() > mejor.getCalificacion()) mejor = libros[i];
            if (libros[i].getCalificacion() < peor.getCalificacion()) peor = libros[i];
        }
        System.out.println("Mejor calificado: " + mejor);
        System.out.println("Peor calificado: " + peor);
    }

    public void mostrarTodos() {
        for (int i = 0; i < cantidadActual; i++) {
            System.out.println(libros[i]);
        }
    }
}

public class Ejercicio12 {
    public static void main(String[] args) {
        ConjuntoLibros coleccion = new ConjuntoLibros(10);
        coleccion.anadirLibro(new Libro("El Hobbit", "Tolkien", 300, 9));
        coleccion.anadirLibro(new Libro("Dune", "Herbert", 600, 10));
        coleccion.anadirLibro(new Libro("1984", "Orwell", 328, 8));

        coleccion.mostrarTodos();
        coleccion.mostrarMejorYPeorCalificado();
        coleccion.eliminarPorTitulo("1984");
        System.out.println("--- tras eliminar ---");
        coleccion.mostrarTodos();
    }
}
