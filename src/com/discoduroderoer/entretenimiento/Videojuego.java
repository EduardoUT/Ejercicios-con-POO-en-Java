/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.discoduroderoer.entretenimiento;

/**
 *
 * @author Eduardo Reyes Hernández
 */
public class Videojuego  implements Entregable {

    private String titulo;
    private int horasEstimadas;
    private boolean entregado;
    private String genero;
    private String company;

    private static final int HORAS_DEFAULT = 10;
    private static final boolean STATUS_ENTREGADO = false;
    private static final String GENERO_DEFAULT = "AVENTURA";
    private static final String COMPANY_DEFAULT = "ACTIVISION";

    public Videojuego() {
        this.horasEstimadas = HORAS_DEFAULT;
        this.entregado = STATUS_ENTREGADO;
        this.genero = GENERO_DEFAULT;
        this.company = COMPANY_DEFAULT;
    }

    public Videojuego(String titulo, int horasEstimadas) {
        this(titulo, horasEstimadas, GENERO_DEFAULT, COMPANY_DEFAULT);
    }

    public Videojuego(String titulo, int horasEstimadas,
            String genero, String company) {
        validarVideojuego(titulo, horasEstimadas, genero, company);
        this.titulo = titulo;
        this.horasEstimadas = horasEstimadas;
        this.entregado = STATUS_ENTREGADO;
        this.genero = genero;
        this.company = company;
    }

    private void validarVideojuego(String titulo, int horasEstimadas,
            String genero, String company) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Es necesario incluir el titulo.");
        }

        if (horasEstimadas <= 0) {
            throw new IllegalArgumentException("El número de horas estimadas es negativo o cero.");
        }

        if (genero == null || genero.isEmpty()) {
            throw new IllegalArgumentException("Es necesario incluir el género.");
        }

        if (company == null || company.isEmpty()) {
            throw new IllegalArgumentException("Es necesario incluir la compañía.");
        }
    }

    @Override
    public String toString() {
        return String.format("[Titulo: %s | Horas: %d | "
                + "Entregado: %b | Género: %s | Compañía: %s]",
                this.titulo,
                this.horasEstimadas,
                this.entregado,
                this.genero,
                this.company);
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return the horasEstimadas
     */
    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    @Override
    public boolean entregar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean devolver() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEntregado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
