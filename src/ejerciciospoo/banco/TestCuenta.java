/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciospoo.banco;

import ejerciciospoo.banco.Cuenta;
import java.math.BigDecimal;

/**
 *
 * @author Eduardo Reyes Hernández
 */
public class TestCuenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta("Eduardo", new BigDecimal(-123.99));
        System.out.println(cuenta.consultarSaldo());
        cuenta.ingresar(new BigDecimal(23.80));
        System.out.println(cuenta.consultarSaldo());
        System.out.println(cuenta.toString());
        cuenta.retirar(new BigDecimal(123.79));
        System.out.println(cuenta.consultarSaldo());
        System.out.println("");
        Cuenta cuentaDos = new Cuenta("Paco");
        System.out.println(cuentaDos.getTitular());
        System.out.println(cuentaDos.toString());
    }
    
}
