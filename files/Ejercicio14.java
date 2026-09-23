interface ICuidable {
    void jugar(String elemento);
    void cepillar();
    void anestesiar();
}

// Clase abstracta: no se puede instanciar directamente, obliga a las hijas
// a implementar comer() y dormir()
abstract class AnimalAbstracto {
    public static final String tipo = "Mamífero doméstico";

    public abstract void comer();
    public abstract void dormir();
}

// Implementamos ICuidable aquí, en Perro, porque solo hace falta una vez
// (Gato no la necesita repetir, cada clase decide si la implementa)
class PerroCuidable extends AnimalAbstracto implements ICuidable {
    @Override
    public void comer() {
        System.out.println("El perro come pienso");
    }

    @Override
    public void dormir() {
        System.out.println("El perro duerme en su cesta");
    }

    @Override
    public void jugar(String elemento) {
        System.out.println("El perro juega con " + elemento);
    }

    @Override
    public void cepillar() {
        System.out.println("Cepillando al perro");
    }

    @Override
    public void anestesiar() {
        System.out.println("Anestesiando al perro para el veterinario");
    }
}

class GatoAbstracto extends AnimalAbstracto {
    @Override
    public void comer() {
        System.out.println("El gato come pienso de gato");
    }

    @Override
    public void dormir() {
        System.out.println("El gato duerme 16 horas al día");
    }
}

public class Ejercicio14 {
    public static void main(String[] args) {
        PerroCuidable perro = new PerroCuidable();
        perro.comer();
        perro.jugar("una pelota");
        perro.cepillar();

        GatoAbstracto gato = new GatoAbstracto();
        gato.comer();
        gato.dormir();

        System.out.println("Tipo: " + AnimalAbstracto.tipo);
    }
}
