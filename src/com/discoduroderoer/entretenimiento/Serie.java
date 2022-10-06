/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.discoduroderoer.entretenimiento;

/**
 *
 * @author Eduardo Reyes Hernández
 */
public class Serie implements Entregable {

    private String titulo;
    private int numeroTemporadas;
    private boolean entregado;
    private String genero;
    private String creador;

    private static final int NUM_TEMPORADAS = 3;
    private static final boolean STATUS_ENTREGADO_DEFAULT = false;
    private static final String GENERO_DEFAULT = "TERROR";

    public Serie() {
        this.numeroTemporadas = NUM_TEMPORADAS;
        this.entregado = STATUS_ENTREGADO_DEFAULT;
        this.genero = GENERO_DEFAULT;
    }

    public Serie(String titulo, String creador) {
        this(titulo, NUM_TEMPORADAS, GENERO_DEFAULT, creador);
    }

    public Serie(String titulo, int numeroTemporadas,
            String genero, String creador) {
        validarSerie(titulo, numeroTemporadas, genero, creador);
        this.titulo = titulo;
        this.numeroTemporadas = numeroTemporadas;
        this.entregado = STATUS_ENTREGADO_DEFAULT;
        this.genero = genero;
        this.creador = creador;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return the numeroTemporadas
     */
    public int getNumeroTemporadas() {
        return numeroTemporadas;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @return the creador
     */
    public String getCreador() {
        return creador;
    }

    private void validarSerie(String titulo, int numeroTemporadas,
            String genero, String creador) {
        if (titulo == null || titulo.isEmpty()) {
            throw new IllegalArgumentException("Es necesario incluir el titulo.");
        }

        if (numeroTemporadas <= 0) {
            throw new IllegalArgumentException("El número de películas es negativo o cero.");
        }

        if (genero == null || genero.isEmpty()) {
            throw new IllegalArgumentException("Es necesario incluir el genero.");
        }

        if (creador == null || creador.isEmpty()) {
            throw new IllegalArgumentException("Es necesario incluir el creador.");
        }

    }

    @Override
    public String toString() {
        return String.format("[Titulo: %s | Número Temporadas: %d | "
                + "Entregado: %b | Género: %s | Creador: %s]",
                this.titulo,
                this.numeroTemporadas,
                this.entregado,
                this.genero,
                this.creador);
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
