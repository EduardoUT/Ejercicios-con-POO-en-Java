/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.discoduroderoer.electrodomestico;

import java.math.BigDecimal;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Eduardo Reyes Hernández
 */
public class TestJUnitElectrodomestico {

    private Electrodomestico electrodomestico;

    @Before
    public void prepararEscenario() {
        this.electrodomestico = new Electrodomestico(new BigDecimal(123.98), "Azul", 'A', 20);
    }
}
