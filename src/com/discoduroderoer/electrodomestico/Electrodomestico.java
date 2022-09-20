/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.discoduroderoer.electrodomestico;

import java.math.BigDecimal;

/**
 *
 * @author Eduardo Reyes Hernández
 */
public class Electrodomestico implements IColoresElectrodomestico {

    //Variables de instancia.
    private BigDecimal precioBase;
    private String color;
    private char consumoEnergetico;
    private BigDecimal peso;
    //Variables de clase.(Constantes en este caso)
    private static final BigDecimal PRECIO_INICIAL = new BigDecimal(100);
    private static final char CONSUMO_ENERGETICO_INICIAL = 'F';
    private static final BigDecimal PESO_INICIAL = new BigDecimal(5);

    public Electrodomestico() {
        this.precioBase = PRECIO_INICIAL;
        this.color = BLANCO;
        this.consumoEnergetico = CONSUMO_ENERGETICO_INICIAL;
        this.peso = PESO_INICIAL;
    }

    public Electrodomestico(BigDecimal precioBase, String color, char consumoEnergetico, BigDecimal peso) {
        if (esNegativoOMenorQueCero(precioBase) || esNegativoOMenorQueCero(peso)) {
            throw new RuntimeException("El valor ingresado es negativo o menor que cero.");
        }

        if (esMenorOIgualQuePrecioInicial(precioBase)) {
            throw new RuntimeException("El precio base debe ser mayor y diferente de 100");
        }

        if (color == null || color.isEmpty()) {
            throw new NullPointerException("No se ha específicado el color.");
        }

        if (consumoEnergetico == Character.MIN_VALUE) {
            throw new NullPointerException("No se ha ingresado el consumo energético.");
        }

        if (!Character.isLetter(consumoEnergetico)) {
            throw new IllegalArgumentException("Sólo se pérmiten letras de la A a la F");
        }

        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    //Sobrecargando método constructor.
    public Electrodomestico(BigDecimal precioBase, BigDecimal peso) {
        //Sobre-escritura del constructor anterior.
        this(precioBase, BLANCO, CONSUMO_ENERGETICO_INICIAL, peso);
    }

    /**
     * @return the precioBase
     */
    public BigDecimal getPrecioBase() {
        return precioBase;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @return the consumoEnergetico
     */
    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    /**
     * @return the peso
     */
    public BigDecimal getPeso() {
        return peso;
    }

    private char comprobarConsumoEnergetico(char letra) {
        char letraToUpperCase = Character.toUpperCase(letra);
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F'};
        for (char l : letras) {
            if (l == letraToUpperCase) {
                return l;
            }
        }
        return CONSUMO_ENERGETICO_INICIAL;
    }

    private String comprobarColor(String color) {
        String[] colores = {BLANCO, NEGRO, ROJO, AZUL, GRIS};
        for (String c : colores) {
            if (c.equalsIgnoreCase(color)) {
                return c;
            }
        }
        return BLANCO;
    }

    private boolean esMenorOIgualQuePrecioInicial(BigDecimal precioBase) {
        return (precioBase.compareTo(PRECIO_INICIAL) == -1)
                || (precioBase.compareTo(PRECIO_INICIAL) == 0);
    }

    private boolean esNegativoOMenorQueCero(BigDecimal precioBase) {
        return (precioBase.signum() == -1) || (precioBase.signum() == 0);
    }
}
