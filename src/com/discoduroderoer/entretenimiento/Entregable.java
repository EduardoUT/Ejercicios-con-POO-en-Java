/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.discoduroderoer.entretenimiento;

/**
 *
 * @author Eduardo Reyes Hernández
 */
public interface Entregable extends Comparable<Object> {

    /**
     * Cambia el atributo entregado a true.
     *
     * @return true
     */
    public boolean entregar();

    /**
     * Cambia el atributo entregado a false.
     *
     * @return false
     */
    public boolean devolver();

    /**
     * Devuelve el estado del atributo entregado.
     *
     * @return true/false
     */
    public boolean isEntregado();

    /**
     * Retornará:
     *
     * Negativo si es menor.
     *
     * Positivo si es mayor.
     *
     * Cero si es igual.
     *
     * Para la clase Videojuego compara las horas.
     *
     * Para la clase Serie compara el número de temporadas.
     *
     * @param o Objeto de tipo Serie o Videojuego a ser comparado.
     * @return Numero negativo, positivo o igual a cero.
     */
    @Override
    public abstract int compareTo(Object o);
}
