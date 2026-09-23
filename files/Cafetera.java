public class Cafetera {
    private int _capacidadMaxima;
    private int _cantidadActual;

    // Constructor predeterminado: 1000 c.c. de capacidad, vacía
    public Cafetera() {
        this._capacidadMaxima = 1000;
        this._cantidadActual = 0;
    }

    // Constructor con capacidad: se crea llena
    public Cafetera(int capacidadMaxima) {
        this._capacidadMaxima = capacidadMaxima;
        this._cantidadActual = capacidadMaxima;
    }

    // Constructor con capacidad y cantidad actual, ajustando si se pasa del máximo
    public Cafetera(int capacidadMaxima, int cantidadActual) {
        this._capacidadMaxima = capacidadMaxima;
        this._cantidadActual = (cantidadActual > capacidadMaxima) ? capacidadMaxima : cantidadActual;
    }

    public int getCapacidadMaxima() { return _capacidadMaxima; }
    public void setCapacidadMaxima(int capacidadMaxima) { this._capacidadMaxima = capacidadMaxima; }
    public int getCantidadActual() { return _cantidadActual; }
    public void setCantidadActual(int cantidadActual) { this._cantidadActual = cantidadActual; }

    public void llenarCafetera() {
        _cantidadActual = _capacidadMaxima;
    }

    // Sirve una taza; si no hay suficiente café, sirve lo que quede
    public int servirTaza(int capacidadTaza) {
        int servido = Math.min(capacidadTaza, _cantidadActual);
        _cantidadActual -= servido;
        return servido;
    }

    public void vaciarCafetera() {
        _cantidadActual = 0;
    }

    // Añade café sin superar nunca la capacidad máxima
    public void agregarCafe(int cantidad) {
        _cantidadActual = Math.min(_cantidadActual + cantidad, _capacidadMaxima);
    }

    @Override
    public String toString() {
        return "Cafetera [capacidad=" + _capacidadMaxima + ", actual=" + _cantidadActual + "]";
    }

    public static void main(String[] args) {
        Cafetera c = new Cafetera(1200, 500);
        System.out.println(c);
        c.servirTaza(700); // solo quedan 500, se sirve lo que hay
        System.out.println(c);
        c.agregarCafe(2000); // no debe superar 1200
        System.out.println(c);
    }
}
