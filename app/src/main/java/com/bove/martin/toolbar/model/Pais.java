package com.bove.martin.toolbar.model;

/**
 * Created by Martín Bove on 04/05/2018.
 * E-mail: mbove77@gmail.com
 */

public class Pais {
    private String nombre;
    private String codigoPais;

    public Pais(String nombre, String codigoPais) {
        this.nombre = nombre;
        this.codigoPais = codigoPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }


    //to display object as a string in spinner
    @Override
    public String toString() {
        return nombre;
    }
}

