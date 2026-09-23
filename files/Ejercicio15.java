// Cada tipo de error tiene su propia excepción, como pide el enunciado
class NombreInvalidoException extends Exception {
    public NombreInvalidoException(String mensaje) { super(mensaje); }
}

class ApellidosInvalidosException extends Exception {
    public ApellidosInvalidosException(String mensaje) { super(mensaje); }
}

class DNIInvalidoException extends Exception {
    public DNIInvalidoException(String mensaje) { super(mensaje); }
}

// Objeto complejo: el DNI se representa como número + letra, no como String suelto
class DNI {
    // Tabla oficial de letras según el resto de dividir el número entre 23
    private static final char[] LETRAS = {
        'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'
    };

    private int numero;
    private char letra;

    public DNI(int numero, char letra) throws DNIInvalidoException {
        char letraCorrecta = LETRAS[numero % 23];
        if (Character.toUpperCase(letra) != letraCorrecta) {
            throw new DNIInvalidoException("La letra no corresponde al número (debería ser " + letraCorrecta + ")");
        }
        this.numero = numero;
        this.letra = Character.toUpperCase(letra);
    }

    @Override
    public String toString() {
        return numero + letra;
    }
}

class Alumno {
    private String nombre;
    private String apellidos;
    private DNI dni;

    public Alumno(String nombre, String apellidos, DNI dni)
            throws NombreInvalidoException, ApellidosInvalidosException {
        if (nombre.length() < 3 || nombre.length() >= 25) {
            throw new NombreInvalidoException("El nombre debe tener entre 3 y 24 caracteres");
        }
        if (apellidos.length() < 3 || apellidos.length() >= 50) {
            throw new ApellidosInvalidosException("Los apellidos deben tener entre 3 y 49 caracteres");
        }
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni; // ya viene validado, porque el propio constructor de DNI valida
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " - " + dni;
    }
}

public class Ejercicio15 {
    public static void main(String[] args) {
        try {
            DNI dni = new DNI(12345678, 'Z'); // 12345678 % 23 = 14 -> 'Z'
            Alumno alumno = new Alumno("Héctor", "Llano Lama", dni);
            System.out.println(alumno);
        } catch (DNIInvalidoException | NombreInvalidoException | ApellidosInvalidosException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            DNI dniMalo = new DNI(12345678, 'A'); // letra incorrecta a propósito
        } catch (DNIInvalidoException e) {
            System.out.println("Error esperado: " + e.getMessage());
        }
    }
}
