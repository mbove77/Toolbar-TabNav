package com.bove.martin.toolbar.model;

/**
 * Created by Martín Bove on 04/05/2018.
 * E-mail: mbove77@gmail.com
 */
public class Persona {
    private String Nombre;
    private Pais pais;

    public Persona(String nombre, Pais pais) {
        Nombre = nombre;
        this.pais = pais;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }
}
