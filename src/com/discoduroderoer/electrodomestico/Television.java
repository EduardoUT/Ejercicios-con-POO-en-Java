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
public class Television extends Electrodomestico {
    
    private int resolucion;
    private boolean sintonizadorTDT;
    
    private static final int RESOLUCION_INICIAL = 20;
    private static final boolean SINTONIZADOR_INICIAL = false;
    
    public Television() {
        super();
        this.resolucion = RESOLUCION_INICIAL;
        this.sintonizadorTDT = SINTONIZADOR_INICIAL;
    }
    
    public Television(BigDecimal precioBase, double peso) {
        
        super(precioBase, peso);
        
        this.resolucion = RESOLUCION_INICIAL;
        this.sintonizadorTDT = SINTONIZADOR_INICIAL;
    }
    
    public Television(int resolucion, boolean sintonizadorTDT,
            BigDecimal precioBase, String color,
            char consumoEnergetico, double peso) {
        
        super(precioBase, color, consumoEnergetico, peso);
        
        if (resolucion <= 0) {
            throw new RuntimeException("La resolución ingresada "
                    + "no puede ser negativa");
        }
        
        this.resolucion = resolucion;
        this.sintonizadorTDT = sintonizadorTDT;
    }

    /**
     * @return the resolucion
     */
    public int getResolucion() {
        return resolucion;
    }

    /**
     * @return the sintonizadorTDT
     */
    public boolean isSintonizadorTDT() {
        return sintonizadorTDT;
    }
    
    @Override
    public BigDecimal precioFinal() {
        BigDecimal porcentajeAgregado = new BigDecimal(1.30);
        if (this.resolucion > 40) {
            return super.precioFinal()
                    .multiply(porcentajeAgregado)
                    .add(valorAgregadoPorSintonizador())
                    .setScale(2, RoundingMode.HALF_EVEN);
        }
        return super.precioFinal()
                .add(valorAgregadoPorSintonizador())
                .setScale(2, RoundingMode.HALF_EVEN);
    }
    
    private BigDecimal valorAgregadoPorSintonizador() {
        BigDecimal resultado = new BigDecimal(0.0);
        if (this.sintonizadorTDT == true) {
            return resultado.add(new BigDecimal(50));
        }
        return resultado;
    }
}
