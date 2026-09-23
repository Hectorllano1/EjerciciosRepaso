import java.util.Date;

// Clase base con los atributos y métodos comunes a todos los animales
class Animal {
    private String nombre;
    private String tipoAlimentacion;
    private Date fechaNacimiento;
    private float peso;

    public Animal(String nombre, String tipoAlimentacion, Date fechaNacimiento, float peso) {
        this.nombre = nombre;
        this.tipoAlimentacion = tipoAlimentacion;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipoAlimentacion() { return tipoAlimentacion; }
    public void setTipoAlimentacion(String t) { this.tipoAlimentacion = t; }
    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date f) { this.fechaNacimiento = f; }
    public float getPeso() { return peso; }
    public void setPeso(float peso) { this.peso = peso; }

    public void alimentar() {
        System.out.println(nombre + " está siendo alimentado (" + tipoAlimentacion + ")");
    }

    public boolean tieneVacunas() {
        return true; // lógica de ejemplo
    }
}

// Perro hereda de Animal y añade "raza" y el método jugar()
class Perro extends Animal {
    private String raza;

    public Perro(String nombre, String tipoAlimentacion, Date fechaNacimiento, float peso, String raza) {
        super(nombre, tipoAlimentacion, fechaNacimiento, peso);
        this.raza = raza;
    }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public void jugar() {
        System.out.println(getNombre() + " está jugando");
    }
}

// Pajaro hereda de Animal
class Pajaro extends Animal {
    private boolean tienePlumaje;
    private boolean puedeVolar;

    public Pajaro(String nombre, String tipoAlimentacion, Date fechaNacimiento, float peso,
                  boolean tienePlumaje, boolean puedeVolar) {
        super(nombre, tipoAlimentacion, fechaNacimiento, peso);
        this.tienePlumaje = tienePlumaje;
        this.puedeVolar = puedeVolar;
    }

    public boolean isTienePlumaje() { return tienePlumaje; }
    public void setTienePlumaje(boolean t) { this.tienePlumaje = t; }
    public boolean isPuedeVolar() { return puedeVolar; }
    public void setPuedeVolar(boolean p) { this.puedeVolar = p; }

    public void hacerNido() {
        System.out.println(getNombre() + " está haciendo un nido");
    }

    public void cantar() {
        System.out.println(getNombre() + " está cantando");
    }

    public float cantidadComida() {
        return getPeso() * 0.1f; // ejemplo: 10% del peso en comida
    }
}

// Especie: clase relacionada con Aguila mediante agregación (el rombo del diagrama)
class Especie {
    private String nombre;
    private String habitat;
    private String dieta;

    public Especie(String nombre, String habitat, String dieta) {
        this.nombre = nombre;
        this.habitat = habitat;
        this.dieta = dieta;
    }

    public String getNombre() { return nombre; }
    public String getHabitat() { return habitat; }
    public String getDieta() { return dieta; }
}

// Aguila hereda de Pajaro y AGREGA una Especie (no la crea ella misma, se la pasan)
class Aguila extends Pajaro {
    private float envergadura;
    private Especie especie; // agregación: la especie existe independientemente del águila
    private String color;

    public Aguila(String nombre, String tipoAlimentacion, Date fechaNacimiento, float peso,
                  boolean tienePlumaje, boolean puedeVolar,
                  float envergadura, Especie especie, String color) {
        super(nombre, tipoAlimentacion, fechaNacimiento, peso, tienePlumaje, puedeVolar);
        this.envergadura = envergadura;
        this.especie = especie;
        this.color = color;
    }

    public float getEnvergadura() { return envergadura; }
    public Especie getEspecie() { return especie; }
    public String getColor() { return color; }

    private void cuidar() {
        System.out.println("Cuidando al águila " + getNombre());
    }
}

public class Ejercicio09 {
    public static void main(String[] args) {
        Especie especieAguilaReal = new Especie("Águila Real", "Montaña", "Carnívora");
        Aguila aguila = new Aguila("Golden", "Carne", new Date(), 5.5f, true, true,
                2.3f, especieAguilaReal, "Marrón");

        aguila.alimentar();
        aguila.cantar();
        System.out.println("Comida diaria estimada: " + aguila.cantidadComida());
        System.out.println("Especie: " + aguila.getEspecie().getNombre());

        Perro perro = new Perro("Toby", "Pienso", new Date(), 12f, "Labrador");
        perro.jugar();
    }
}
