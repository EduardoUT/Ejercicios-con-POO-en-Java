/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.discoduroderoer.persona;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 2) Haz una clase llamada Persona que siga las siguientes condiciones:
 *
 * Sus atributos son: nombre, edad, DNI, sexo (H hombre, M mujer), peso y
 * altura. No queremos que se accedan directamente a ellos. Piensa que
 * modificador de acceso es el más adecuado, también su tipo. Si quieres añadir
 * algún atributo puedes hacerlo.
 *
 * Por defecto, todos los atributos menos el DNI serán valores por defecto según
 * su tipo (0 números, cadena vacía para String, etc.). Sexo sera hombre por
 * defecto, usa una constante para ello.
 *
 * Se implantaran varios constructores:
 *
 * Un constructor por defecto.
 *
 * Un constructor con el nombre, edad y sexo, el resto por defecto.
 *
 * Un constructor con todos los atributos como parámetro.
 *
 * Los métodos que se implementaran son:
 *
 * calcularIMC(): calculara si la persona esta en su peso ideal (peso en
 * kg/(altura^2 en m)), si esta fórmula devuelve un valor menor que 20, la
 * función devuelve un -1, si devuelve un número entre 20 y 25 (incluidos),
 * significa que esta por debajo de su peso ideal la función devuelve un 0 y si
 * devuelve un valor mayor que 25 significa que tiene sobrepeso, la función
 * devuelve un 1. Te recomiendo que uses constantes para devolver estos valores.
 *
 *
 * esMayorDeEdad(): indica si es mayor de edad, devuelve un booleano.
 *
 * comprobarSexo(char sexo): comprueba que el sexo introducido es correcto. Si
 * no es correcto, sera H. No sera visible al exterior.
 *
 * toString(): devuelve toda la información del objeto.
 *
 * generaDNI(): genera un número aleatorio de 8 cifras, genera a partir de este
 * su número su letra correspondiente. Este método sera invocado cuando se
 * construya el objeto. Puedes dividir el método para que te sea más fácil. No
 * será visible al exterior.
 *
 * Métodos set de cada parámetro, excepto de DNI.
 *
 * Ahora, crea una clase ejecutable que haga lo siguiente:
 *
 * Pide por teclado el nombre, la edad, sexo, peso y altura.
 *
 * Crea 3 objetos de la clase anterior, el primer objeto obtendrá las anteriores
 * variables pedidas por teclado, el segundo objeto obtendrá todos los
 * anteriores menos el peso y la altura y el último por defecto, para este
 * último utiliza los métodos set para darle a los atributos un valor.
 *
 * Para cada objeto, deberá comprobar si esta en su peso ideal, tiene sobrepeso
 * o por debajo de su peso ideal con un mensaje.
 *
 * Indicar para cada objeto si es mayor de edad.
 *
 * Por último, mostrar la información de cada objeto.
 *
 * Puedes usar métodos en la clase ejecutable, para que os sea mas fácil.
 *
 * @author Eduardo Reyes Hernández
 */
public class Persona {

    private String nombre;
    private int edad;
    private final String dni;
    private char sexo;
    private BigDecimal peso;
    private BigDecimal altura;
    private static final char HOMBRE = 'H';
    private static final char MUJER = 'M';
    private static final BigDecimal PESO_DEFAULT = new BigDecimal(75);
    private static final BigDecimal ALTURA_DEFAULT = new BigDecimal(1.85);
    private static final int PESO_IDEAL = -1;
    private static final int PESO_REGULAR = 0;
    private static final int SOBREPESO = 1;

    public Persona() {
        this.dni = generarDNI();
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = generarDNI();
        this.sexo = comprobarSexo(sexo);
        this.peso = PESO_DEFAULT;
        this.altura = ALTURA_DEFAULT;
    }

    public Persona(String nombre, int edad, char sexo,
            BigDecimal peso, BigDecimal altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = generarDNI();
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
    }

    private char comprobarSexo(char sexo) {
        if (sexo == HOMBRE || sexo == MUJER) {
            return this.sexo = sexo;
        } else {
            return this.sexo = HOMBRE;
        }
    }

    private String generarDNI() {
        int digito;
        int numero;
        int resultadoResto;
        StringBuilder dniGenerado = new StringBuilder();
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X',
            'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        char asignarLetra;

        for (int i = 0; i < 9; i++) {
            digito = (int) (Math.random() * 9 + 1);
            dniGenerado.append(digito);
        }

        numero = (Integer.valueOf(dniGenerado.toString()));
        resultadoResto = numero % 23;
        asignarLetra = letras[resultadoResto];
        dniGenerado.append(asignarLetra);
        return dniGenerado.toString();
    }

    public static int calcularIMC(BigDecimal peso, BigDecimal altura) {
        BigDecimal resultado;
        double resultadoToDouble;
        resultado = peso
                .divide(altura
                        .pow(2)
                        .setScale(2, RoundingMode.DOWN),
                        2, RoundingMode.DOWN);
        resultadoToDouble = Double.valueOf(resultado.toString());
        if (resultadoToDouble < 20) {
            return PESO_IDEAL;
        } else if (resultadoToDouble >= 20 && resultadoToDouble <= 25) {
            return PESO_REGULAR;
        } else {
            return SOBREPESO;
        }
    }

    public static boolean esMayorDeEdad(int edad) {
        return edad >= 18;
    }

    @Override
    public String toString() {
        return String.format("{Nombre: %s\n Edad: %d\n DNI: %s\n Sexo: %s\n"
                + " Peso: %.2f\n Altura: %.2f}\n",
                this.nombre, this.getEdad(),
                this.dni,
                this.sexo,
                this.peso,
                this.altura);
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        if (nombre.isEmpty()) {
            throw new NullPointerException("Valor nulo o vacío.");
        }
        this.nombre = nombre;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        if (edad >= 1 || edad <= 100) {
            this.edad = edad;
        } else {
            System.out.println("Edad inválida.");
        }
    }

    public void setSexo(char sexo) {
        this.sexo = comprobarSexo(sexo);
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    /**
     * @return the peso
     */
    public BigDecimal getPeso() {
        return peso.setScale(2, RoundingMode.DOWN);
    }

    /**
     * @return the altura
     */
    public BigDecimal getAltura() {
        return altura.setScale(2, RoundingMode.DOWN);
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }
}
