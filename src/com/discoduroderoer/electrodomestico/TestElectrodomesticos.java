/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.discoduroderoer.electrodomestico;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduardo Reyes Hernández
 */
public class TestElectrodomesticos {

    public static void main(String[] args) {
        /*
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

        System.out.println("<--->");
        Television television = new Television(60, false, new BigDecimal(400.00), "Negro", 'E', 30);
        System.out.println(television.precioFinal());
         */

        
        Electrodomestico[] electrodomesticos = {
            new Electrodomestico(new BigDecimal(123.99), "Negro", 'A', 20),
            new Lavadora(37, new BigDecimal(230.99), "Azul", 'B', 34),
            new Television(60, false, new BigDecimal(400.00), "Negro", 'C', 22),
            new Electrodomestico(new BigDecimal(349.23), "Rojo", 'D', 75),
            new Lavadora(30, new BigDecimal(459.90), "Gris", 'E', 34),
            new Television(33, false, new BigDecimal(400.00), "Negro", 'F', 30),
            new Electrodomestico(new BigDecimal(640.78), "Blanco", 'A', 88),
            new Lavadora(45, new BigDecimal(310.79), "Azul", 'B', 60),
            new Television(20, true, new BigDecimal(400.00), "Negro", 'C', 18),
            new Lavadora(new BigDecimal(256.99), 50),};

        mostrarTelevisores(electrodomesticos);
        mostrarLavadoras(electrodomesticos);

        System.out.println("|-----Precio final Electrodomesticos-----|");
        BigDecimal total = new BigDecimal(0.0);
        for (Electrodomestico e: electrodomesticos) {
            total = total.add(e.precioFinal());
        }
        System.out.println(total);
    }

    public static void mostrarTelevisores(Electrodomestico[] electrodomesticos) {
        System.out.println("|-----Precio final de Televisores-----|");
        for (Electrodomestico e : electrodomesticos) {
            if (e instanceof Television) {
                System.out.println(e.precioFinal());
            }
        }
        System.out.println("");
    }

    public static void mostrarLavadoras(Electrodomestico[] electrodomesticos) {
        System.out.println("|-----Precio final de Lavadoras-----|");
        for (Electrodomestico e : electrodomesticos) {
            if (e instanceof Lavadora) {
                System.out.println(e.precioFinal());
            }
        }
        System.out.println("");
    }
}
