/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.discoduroderoer.electrodomestico;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 *
 * @author Eduardo Reyes Hernández
 */
public class Lavadora extends Electrodomestico {

    private double carga;

    private static final double CARGA_INICIAL = 5;

    public Lavadora() {
        super();
        this.carga = CARGA_INICIAL;
    }

    public Lavadora(BigDecimal precioBase, double peso) {
        super(precioBase, peso);
        this.carga = CARGA_INICIAL;
    }

    public Lavadora(double carga, BigDecimal precioBase, String color,
            char consumoEnergetico, double peso) {

        super(precioBase, color, consumoEnergetico, peso);

        if (carga <= 0) {
            throw new RuntimeException("La carga ingresada es "
                    + "negativa o menor que cero.");
        }

        this.carga = carga;
    }

    /**
     * @return the carga
     */
    public double getCarga() {
        return carga;
    }

    @Override
    public BigDecimal precioFinal() {
        if (this.carga > 30) {
            return super.precioFinal().add(new BigDecimal(50))
                    .setScale(2, RoundingMode.HALF_EVEN);
        }
        return super.precioFinal();
    }
}
