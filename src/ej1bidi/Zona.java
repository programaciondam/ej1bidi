/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1bidi;

/**
 *
 * @author ADMINMJ
 */
public class Zona {
    private String denominacion;
    private float sueldoBase;

    public Zona(String denominacion, float sueldoBase) {
        this.denominacion = denominacion;
        this.sueldoBase = sueldoBase;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public float getSueldoBase() {
        return sueldoBase;
    }
    
    
}
