/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.discoduroderoer.banco;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 1) Crea una clase llamada Cuenta que tendrá los siguientes atributos: titular
 * y cantidad (puede tener decimales).
 *
 * El titular será obligatorio y la cantidad es opcional. Crea dos constructores
 * que cumpla lo anterior.
 *
 * Crea sus métodos get, set y toString.
 *
 * Tendrá dos métodos especiales:
 *
 * ingresar(double cantidad): se ingresa una cantidad a la cuenta, si la
 * cantidad introducida es negativa, no se hará nada.
 *
 * retirar(double cantidad): se retira una cantidad a la cuenta, si restando la
 * cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa
 * a ser 0.
 *
 * @author Eduardo Reyes Hernández
 */
public class Cuenta {

    private String titular;
    private BigDecimal cantidad;
    private static final BigDecimal SALDO_INICIAL = new BigDecimal(0.0);

    public Cuenta(String titular) {
        if (titular.isEmpty()) {
            throw new RuntimeException("Debe específicar al titular.");
        }
        this.titular = titular;
        this.cantidad = SALDO_INICIAL;
    }

    public Cuenta(String titular, BigDecimal cantidad) {
        if (titular.isEmpty()) {
            throw new RuntimeException("Debe específicar al titular.");
        }
        
        if (cantidad == null || cantidad.equals(SALDO_INICIAL) || cantidad.signum() == -1) {
            this.cantidad = SALDO_INICIAL;
        } else {
            this.titular = titular;
            this.cantidad = cantidad;
        }
    }

    public void ingresar(BigDecimal cantidad) {
        if (cantidad.signum() == -1 || cantidad.signum() == 0) {
        } else {
            this.cantidad = this.cantidad.add(cantidad);
            System.out.println("Saldo ingresado con éxito :)");
        }
    }

    public void retirar(BigDecimal cantidad) {
        if (cantidad.signum() == -1 || cantidad.signum() == 0) {
        } else {
            this.cantidad = this.cantidad.subtract(cantidad);
            if (this.cantidad.signum() == -1) {
                this.cantidad = SALDO_INICIAL;
            }
            System.out.println("Saldo retirado con éxito :)");
        }
    }

    public BigDecimal consultarSaldo() {
        return this.cantidad.setScale(2, RoundingMode.UP);
    }

    /**
     * @return the titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public String toString() {
        return "Nombre titular: " + this.titular + " Saldo: $ " + this.consultarSaldo();
    }
}
