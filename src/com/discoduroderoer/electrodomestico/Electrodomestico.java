/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.discoduroderoer.electrodomestico;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Eduardo Reyes Hernández
 */
public class Electrodomestico implements ILetrasConsumoEnergetico {

    //Variables de instancia.
    private BigDecimal precioBase;
    private String color;
    private char consumoEnergetico;
    private double peso;
    //Variables de clase.(Constantes en este caso)
    private static final BigDecimal PRECIO_INICIAL = new BigDecimal(100);
    private static final char CONSUMO_ENERGETICO_INICIAL = LETRA_F;
    private static final double PESO_INICIAL = 5;

    public Electrodomestico() {
        this.precioBase = PRECIO_INICIAL;
        this.color = ColorElectrodomestico.BLANCO.toString();
        this.consumoEnergetico = CONSUMO_ENERGETICO_INICIAL;
        this.peso = PESO_INICIAL;
    }

    public Electrodomestico(BigDecimal precioBase, String color,
            char consumoEnergetico, double peso) {
        if (esNegativoOMenorQueCero(precioBase)) {
            throw new RuntimeException("El valor ingresado es "
                    + "negativo o menor que cero.");
        }

        if (peso <= 0) {
            throw new RuntimeException("El peso ingresado no puede ser negativo.");
        }

        if (esMenorOIgualQuePrecioInicial(precioBase)) {
            throw new RuntimeException("El precio base debe ser "
                    + "mayor y diferente de 100");
        }

        if (color == null || color.isEmpty()) {
            throw new NullPointerException("No se ha específicado el color.");
        }

        if (consumoEnergetico == Character.MIN_VALUE) {
            throw new NullPointerException("No se ha ingresado "
                    + "el consumo energético.");
        }

        if (!Character.isLetter(consumoEnergetico)) {
            throw new IllegalArgumentException("Sólo se pérmiten "
                    + "letras de la A a la F");
        }

        this.precioBase = precioBase;
        this.color = comprobarColor(color);
        this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    //Sobrecargando método constructor.
    public Electrodomestico(BigDecimal precioBase, double peso) {
        //Sobre-escritura del constructor anterior.
        this(precioBase, ColorElectrodomestico.BLANCO.toString(),
                CONSUMO_ENERGETICO_INICIAL, peso);
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
    public double getPeso() {
        return peso;
    }

    private char comprobarConsumoEnergetico(char letra) {
        char letraToUpperCase = Character.toUpperCase(letra);
        char[] letras = {LETRA_A, LETRA_B, LETRA_C, LETRA_D, LETRA_E, LETRA_F};
        for (char l : letras) {
            if (l == letraToUpperCase) {
                return l;
            }
        }
        return CONSUMO_ENERGETICO_INICIAL;
    }

    private String comprobarColor(String color) {
        String colorToUpperCase = String.valueOf(color).toUpperCase();
        for (ColorElectrodomestico c : ColorElectrodomestico.values()) {
            if (c.toString().equals(colorToUpperCase)) {
                return c.toString();
            }
        }
        return ColorElectrodomestico.BLANCO.toString();
    }

    private boolean esMenorOIgualQuePrecioInicial(BigDecimal precioBase) {
        return (precioBase.compareTo(PRECIO_INICIAL) == -1)
                || (precioBase.compareTo(PRECIO_INICIAL) == 0);
    }

    private boolean esNegativoOMenorQueCero(BigDecimal precioBase) {
        return (precioBase.signum() == -1) || (precioBase.signum() == 0);
    }

    public BigDecimal precioFinal() {
        return this.precioBase.add(impuestoSegunConsumoEnergetico())
                .add(impuestoSegunPeso())
                .setScale(2, RoundingMode.CEILING);
    }

    private BigDecimal impuestoSegunConsumoEnergetico() {
        BigDecimal resultado = new BigDecimal(0.0);
        char letraIngresada = this.consumoEnergetico;
        switch (letraIngresada) {
            case LETRA_A:
                return resultado.add(new BigDecimal(100))
                        .setScale(2, RoundingMode.CEILING);
            case LETRA_B:
                return resultado.add(new BigDecimal(80))
                        .setScale(2, RoundingMode.CEILING);
            case LETRA_C:
                return resultado.add(new BigDecimal(60))
                        .setScale(2, RoundingMode.CEILING);
            case LETRA_D:
                return resultado.add(new BigDecimal(50))
                        .setScale(2, RoundingMode.CEILING);
            case LETRA_E:
                return resultado.add(new BigDecimal(30))
                        .setScale(2, RoundingMode.CEILING);
            case LETRA_F:
                return resultado.add(new BigDecimal(10))
                        .setScale(2, RoundingMode.CEILING);
            default:
                return resultado;
        }
    }

    private BigDecimal impuestoSegunPeso() {
        BigDecimal resultado = new BigDecimal(0.0);
        if (this.peso >= 0 && this.peso <= 19) {
            return resultado.add(new BigDecimal(10))
                    .setScale(2, RoundingMode.CEILING);
        } else if (this.peso >= 20 && this.peso <= 49) {
            return resultado.add(new BigDecimal(50))
                    .setScale(2, RoundingMode.CEILING);
        } else if (this.peso >= 50 && this.peso <= 79) {
            return resultado.add(new BigDecimal(80))
                    .setScale(2, RoundingMode.CEILING);
        } else if (this.peso > 80) {
            return resultado.add(new BigDecimal(100))
                    .setScale(2, RoundingMode.CEILING);
        } else {
            return resultado;
        }
    }
}
