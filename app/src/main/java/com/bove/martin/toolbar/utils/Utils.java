package com.bove.martin.toolbar.utils;

import java.util.ArrayList;
import com.bove.martin.toolbar.model.Pais;
import com.bove.martin.toolbar.model.Persona;

/**
 * Created by Martín Bove on 04/05/2018.
 * E-mail: mbove77@gmail.com
 */
public class Utils {
    private static ArrayList<Persona> personas = new ArrayList<Persona>();

    public static ArrayList<Pais> getComboArry() {

        ArrayList<Pais> paises = new ArrayList<Pais>();
        paises.add(new Pais("España", "ES"));
        paises.add(new Pais("Argentina", "AR"));
        paises.add(new Pais("Bolivia", "BO"));
        paises.add(new Pais("Chile", "CL"));
        paises.add(new Pais("Colombia", "CO"));
        paises.add(new Pais("Mexico", "MX"));
        paises.add(new Pais("Peru", "PE"));
        paises.add(new Pais("Uruguay", "UY"));
        paises.add(new Pais("Venezuela","VE"));

        return paises;
    }

    public static ArrayList<Persona> getPersonas() {
        return personas;
    }

    public static void addPersona(Persona persona) {
        personas.add(persona);
    }
}
