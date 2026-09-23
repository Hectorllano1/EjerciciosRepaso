class Punto {
    private double x, y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class Linea {
    private Punto puntoA, puntoB;

    public Linea(Punto puntoA, Punto puntoB) {
        this.puntoA = puntoA;
        this.puntoB = puntoB;
    }

    @Override
    public String toString() {
        // Reutilizamos el toString() de Punto dentro del de Linea
        return "Línea formada por los puntos " + puntoA + " y " + puntoB;
    }
}

public class Ejercicio08 {
    public static void main(String[] args) {
        Punto punto1 = new Punto(1.25, 5.69);
        Punto punto2 = new Punto(7.25, 3.96);
        Linea linea = new Linea(punto1, punto2);
        System.out.println(linea);
    }
}
