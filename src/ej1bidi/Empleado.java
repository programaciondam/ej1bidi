/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1bidi;

import fecha.Fecha;

/**
 *
 * @author ADMINMJ
 */
public class Empleado {
    private String nombre;
    private int zona;
    private int situacionPersonal;
    private Fecha falta;
    private float [] ventas;

    public Empleado() {
        falta=new Fecha();
        ventas=new float[6];
    }

    public Empleado(String nombre, int zona, int situacionPersonal, Fecha falta, float[] ventas) {
        this.nombre = nombre;
        this.zona = zona;
        this.situacionPersonal = situacionPersonal;
        this.falta = falta;
        this.ventas = ventas;
    }

    public float[] getVentas() {
        return ventas;
    }
       public float getUnaVenta(int mes) {
        return ventas[mes];
    }

    public void setVentas(float[] ventas) {
        this.ventas = ventas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getSituacionPersonal() {
        return situacionPersonal;
    }

    public void setSituacionPersonal(int situacionPersonal) {
        this.situacionPersonal = situacionPersonal;
    }

    public Fecha getFalta() {
        return falta;
    }

    public void setFalta(Fecha falta) {
        this.falta = falta;
    }
    
    
}
