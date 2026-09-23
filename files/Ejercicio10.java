class Cuenta {
    private String titular;
    private double cantidad;

    // Titular obligatorio, cantidad por defecto a 0
    public Cuenta(String titular) {
        this.titular = titular;
        this.cantidad = 0;
    }

    // Titular y cantidad inicial
    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    public String getTitular() { return titular; }
    public void setTitular(String titular) { this.titular = titular; }
    public double getCantidad() { return cantidad; }
    public void setCantidad(double cantidad) { this.cantidad = cantidad; }

    // Si la cantidad es negativa, no se hace nada
    public void ingresar(double cantidad) {
        if (cantidad >= 0) {
            this.cantidad += cantidad;
        }
    }

    // Si al restar queda negativo, la cuenta se queda en 0 (no en negativo)
    public void retirar(double cantidad) {
        if (this.cantidad - cantidad < 0) {
            this.cantidad = 0;
        } else {
            this.cantidad -= cantidad;
        }
    }

    @Override
    public String toString() {
        return "Cuenta [titular=" + titular + ", cantidad=" + cantidad + "]";
    }
}

public class Ejercicio10 {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("Héctor", 100.0);
        cuenta.ingresar(50);
        System.out.println(cuenta); // 150.0
        cuenta.retirar(300); // se queda a 0, no en negativo
        System.out.println(cuenta); // 0.0
        cuenta.ingresar(-20); // se ignora
        System.out.println(cuenta); // 0.0
    }
}
