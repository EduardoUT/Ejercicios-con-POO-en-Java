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
public class TestListadoElectrodomesticos {

    public static void main(String[] args) {
        Electrodomesticos listaElectrodomesticos = new Electrodomesticos();
        listaElectrodomesticos.agregarElectrodomestico(new Electrodomestico(new BigDecimal(123.99), "Negro", 'A', 20));
        listaElectrodomesticos.agregarElectrodomestico(new Lavadora(37, new BigDecimal(230.99), "Azul", 'B', 34));
        listaElectrodomesticos.agregarElectrodomestico(new Television(60, false, new BigDecimal(400.00), "Negro", 'C', 22));
        listaElectrodomesticos.agregarElectrodomestico(new Electrodomestico(new BigDecimal(349.23), "Rojo", 'D', 75));
        listaElectrodomesticos.agregarElectrodomestico(new Lavadora(30, new BigDecimal(459.90), "Gris", 'E', 34));
        listaElectrodomesticos.agregarElectrodomestico(new Television(33, false, new BigDecimal(400.00), "Negro", 'F', 30));
        listaElectrodomesticos.agregarElectrodomestico(new Electrodomestico(new BigDecimal(640.78), "Blanco", 'A', 88));
        listaElectrodomesticos.agregarElectrodomestico(new Lavadora(45, new BigDecimal(310.79), "Azul", 'B', 60));
        listaElectrodomesticos.agregarElectrodomestico(new Television(20, true, new BigDecimal(400.00), "Negro", 'C', 18));
        listaElectrodomesticos.agregarElectrodomestico(new Lavadora(new BigDecimal(256.99), 50));
        System.out.println("<----------Precio final Electrodomesticos(Electrodomestico, Television, Lavadora)---------->");
        listaElectrodomesticos.mostrarTodos();
        System.out.println("<----------Precio final Televisores---------->");
        listaElectrodomesticos.mostrarTelevisiones();
        System.out.println("<----------Precio final Lavadoras---------->");
        listaElectrodomesticos.mostrarLavadoras();
        System.out.println("<----------Precio Final Todo---------->");
        System.out.println(listaElectrodomesticos.precioFinalEletrodomesticos());
    }
}
