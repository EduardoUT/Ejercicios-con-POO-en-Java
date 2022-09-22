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
public class TestElectrodomesticos {
    
    public static void main(String[] args) {
        Electrodomestico electrodomestico = new Electrodomestico(new BigDecimal(123.99), "Negro", 'A', 20);
        System.out.println(electrodomestico.getPeso());
        System.out.println(electrodomestico.getColor());
        System.out.println(electrodomestico.getConsumoEnergetico());
        System.out.println(electrodomestico.precioFinal());
        
        Lavadora lavadora = new Lavadora(37, new BigDecimal(230.99), "Azul", 'C', 34);
        System.out.println(lavadora.getColor());
        System.out.println(lavadora.getCarga());
        System.out.println(lavadora.getConsumoEnergetico());
        System.out.println(lavadora.precioFinal());
        
    }
}
