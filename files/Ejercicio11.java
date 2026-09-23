class PuntoLinea {
    private double x, y;

    public PuntoLinea(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class LineaMovible {
    private PuntoLinea puntoA, puntoB;

    public LineaMovible() {
        this.puntoA = new PuntoLinea(0, 0);
        this.puntoB = new PuntoLinea(0, 0);
    }

    public LineaMovible(PuntoLinea puntoA, PuntoLinea puntoB) {
        this.puntoA = puntoA;
        this.puntoB = puntoB;
    }

    public PuntoLinea getPuntoA() { return puntoA; }
    public void setPuntoA(PuntoLinea puntoA) { this.puntoA = puntoA; }
    public PuntoLinea getPuntoB() { return puntoB; }
    public void setPuntoB(PuntoLinea puntoB) { this.puntoB = puntoB; }

    // Mover ambos puntos la misma distancia mantiene la línea con su forma,
    // solo cambia de posición en el plano.
    public void mueveArribaDerecha(double distancia) {
        desplazar(distancia, distancia);
    }

    public void mueveArribaIzquierda(double distancia) {
        desplazar(-distancia, distancia);
    }

    public void mueveAbajoDerecha(double distancia) {
        desplazar(distancia, -distancia);
    }

    public void mueveAbajoIzquierda(double distancia) {
        desplazar(-distancia, -distancia);
    }

    // Método común al que llaman los 4 anteriores, para no repetir código
    private void desplazar(double dx, double dy) {
        puntoA.setX(puntoA.getX() + dx);
        puntoA.setY(puntoA.getY() + dy);
        puntoB.setX(puntoB.getX() + dx);
        puntoB.setY(puntoB.getY() + dy);
    }

    @Override
    public String toString() {
        return "[" + puntoA + ", " + puntoB + "]";
    }
}

public class Ejercicio11 {
    public static void main(String[] args) {
        LineaMovible linea = new LineaMovible(new PuntoLinea(0, 0), new PuntoLinea(1, 1));
        System.out.println(linea); // [(0.0,0.0), (1.0,1.0)]
        linea.mueveArribaDerecha(2);
        System.out.println(linea); // [(2.0,2.0), (3.0,3.0)]
    }
}
