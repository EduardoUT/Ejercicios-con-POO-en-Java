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
public class Electrodomesticos {

    private final List<Electrodomestico> listaElectrodomesticos;
    private BigDecimal precioFinal = new BigDecimal(0.0);

    public Electrodomesticos() {
        this.listaElectrodomesticos = new ArrayList<>();
    }

    public void agregarElectrodomestico(Electrodomestico electrodomestico) {
        if (electrodomestico == null) {
            throw new NullPointerException("Ningún objeto Electrodomestico ingresado.");
        }
        this.listaElectrodomesticos.add(electrodomestico);
    }

    public void mostrarTodos() {
        this.listaElectrodomesticos.forEach(System.out::println);
    }

    public void mostrarTelevisiones() {
        this.listaElectrodomesticos.stream()
                .filter(e -> e instanceof Television)
                .map(e -> e.precioFinal())
                .forEach(System.out::println);
    }

    public void mostrarLavadoras() {
        this.listaElectrodomesticos.stream()
                .filter(e -> e instanceof Lavadora)
                .map(e -> e.precioFinal())
                .forEach(System.out::println);
    }

    public BigDecimal precioFinalEletrodomesticos() {
        this.listaElectrodomesticos.forEach((e) -> {
            this.precioFinal = this.precioFinal.add(e.precioFinal());
        });
        return this.precioFinal;
    }
}
