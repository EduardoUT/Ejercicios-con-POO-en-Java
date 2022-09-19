/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.discoduroderoer.persona;

import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Reyes Hernández
 */
public class TestPersona {

    /**
     * Crea 3 objetos de la clase anterior, el primer objeto obtendrá las
     * anteriores variables pedidas por teclado, el segundo objeto obtendrá
     * todos los anteriores menos el peso y la altura y el último por defecto,
     * para este último utiliza los métodos set para darle a los atributos un
     * valor.
     *
     * @param args
     */
    public static void main(String[] args) {
        int i = 1;
        int edad;
        String nombre;
        String sexo;
        char s;
        BigDecimal peso;
        BigDecimal altura;
        ArrayList<Persona> personas = new ArrayList<>();
        while (i <= 2) {
            JOptionPane.showMessageDialog(null, "Ingresa los datos de persona " + i);
            if (i < 2) {
                nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del usuario:");
                edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la edad:"));
                sexo = JOptionPane.showInputDialog(null, "Ingrese el sexo:");
                peso = new BigDecimal(JOptionPane.showInputDialog(null, "Ingrese el peso:"));
                altura = new BigDecimal(JOptionPane.showInputDialog(null, "Ingrese la altura:"));
                s = sexo.charAt(0);
                personas.add(new Persona(nombre, edad, s, peso, altura));
            } else {
                nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del usuario:");
                edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la edad:"));
                sexo = JOptionPane.showInputDialog(null, "Ingrese el sexo:");
                s = sexo.charAt(0);
                personas.add(new Persona(nombre, edad, s));
            }
            i++;
        }

        Persona personaTres = new Persona();
        personaTres.setNombre("Patricio");
        personaTres.setEdad(25);
        personaTres.setSexo('H');
        personaTres.setPeso(new BigDecimal(70));
        personaTres.setAltura(new BigDecimal(1.91));
        personas.add(personaTres);

        personas.forEach(persona -> {
            System.out.println(persona);
            mensajeStatusIMC(Persona.calcularIMC(persona.getPeso(), persona.getAltura()));
            mensajeStatusEdad(persona.getEdad());
            System.out.println("");
        });

        /**
         * Salida con datos de prueba: 
         * 
         * {Nombre: Eduardo Edad: 13 DNI: 911539715N
         * Sexo: H Peso: 90.00 Altura: 1.45}
         *
         * Tiene sobrepeso.
         *
         * Es menor de edad.
         *
         *
         * {Nombre: Valeria Edad: 23 DNI: 122258134R Sexo: M Peso: 75.00 Altura:
         * 1.85}
         *
         * Está por debajo de su peso ideal.
         *
         * Es mayor de edad.
         *
         *
         * {Nombre: Patricio Edad: 25 DNI: 223949835P Sexo: H Peso: 70.00
         * Altura: 1.91}
         *
         * Está en su peso ideal.
         *
         * Es mayor de edad.
         */
    }

    public static void mensajeStatusIMC(int statusIMC) {
        switch (statusIMC) {
            case -1:
                System.out.println("Está en su peso ideal.");
                break;
            case 0:
                System.out.println("Está por debajo de su peso ideal.");
                break;
            default:
                System.out.println("Tiene sobrepeso.");
                break;
        }
    }

    public static void mensajeStatusEdad(int edad) {
        if (Persona.esMayorDeEdad(edad)) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println("Es menor de edad.");
        }
    }

}
