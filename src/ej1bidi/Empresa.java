/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1bidi;

import fecha.Fecha;
import utilidades.Utilidad;

/**
 *
 * @author ADMINMJ
 */
public class Empresa {

    Empleado[] empleados;
    Zona[] zonas;
    String[] situaciones;
    float[] limites;
    float[][] irpf;

    public Empresa() {
        empleados = new Empleado[2];
        inicializar();
    }

    public Empresa(int nempleados) {
        empleados = new Empleado[nempleados];
        inicializar();
    }

    private void inicializar() {
        situaciones = new String[]{"soltero", "casado", "otras situaciones"};
        limites = new float[]{3000, 5000, 10000, Float.MAX_VALUE};
        zonas = new Zona[]{new Zona("castilla y leon", 2000),
            new Zona("andalucia", 2200),
            new Zona("Levante", 2500),
            new Zona("Madrid", 3000)
        };
        irpf = new float[][]{
            {0.1f, 0.15f, 0.2f, 0.25f},
            {0.12f, 0.14f, 0.16f, 0.18f},
            {0.05f, 0.07f, 0.1f, 0.15f}
        };
    }

    public void pedirDatos() {
        String nombre;
        int zona;
        String situacion;
        int sit;
        float[] ventas;
        Fecha falta;

        for (int nemple = 0; nemple < empleados.length; nemple++) {
            nombre = Utilidad.pedirString("Nombre del empleado");
            visualizarZonas();
            zona = Utilidad.pedirNumeroEntero("Zona: ", 0, zonas.length);
            sit = pedirSituacion();
            falta = Utilidad.pedirFecha("fecha alta");
            ventas = new float[6];
            for (int mes = 0; mes < ventas.length; mes++) {
                ventas[mes] = Utilidad.pedirNumero("ventas del Mes " + mes + 1);
            }
            empleados[nemple] = new Empleado(nombre, zona, sit, falta, ventas);
        }
    }

    private void visualizarZonas() {
        for (int i = 0; i < zonas.length; i++) {
            System.out.println(i + "\t" + zonas[i].getDenominacion());
        }
    }

    private int pedirSituacion() {
        String situacion;
        int valor;
        situacion = Utilidad.pedirString("SITUACION ");
        valor = buscarSituacion(situacion);
        while (valor == -1) {
            System.out.println("No existe esa situacion");
            situacion = Utilidad.pedirString("SITUACION ");
            valor = buscarSituacion(situacion);
        }
        return valor;
    }

    /**
     *
     * @param dato valor a buscar
     * @return posicion donde lo encuentra o -1 en el caso de no existir
     */
    private int buscarSituacion(String dato) {
        int pos = 0;
        boolean encontrado = false;
        while (pos < situaciones.length && !encontrado) {
            if (situaciones[pos].equalsIgnoreCase(dato)) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        if (!encontrado) {
            pos = -1;
        }
        return pos;

    }

    public void informe() {
       float total=0;
       float sueldoBruto,sueldoNeto;
       int fila, columna;
        for (int pos = 0; pos < empleados.length; pos++) {
            total = 0;
            System.out.print(zonas[empleados[pos].getZona()].getDenominacion() + "\t");
            System.out.print(empleados[pos].getNombre() + "\t");
            System.out.print(empleados[pos].getFalta().fechaEnLetra() + "\t");
            for (int mes = 0; mes < empleados[pos].getVentas().length; mes++) {
                System.out.print(empleados[pos].getVentas()[mes] + "\t");
                // System.out.println(empleados[pos].getUnaVenta(mes));
                total=total+empleados[pos].getVentas()[mes] ;
            }
            sueldoBruto= zonas[empleados[pos].getZona()].getSueldoBase();
            sueldoBruto= sueldoBruto+ (empleados[pos].getFalta().calculaAnnos()/5*10);
            sueldoBruto= sueldoBruto+ 0.1f*total;
             System.out.print(total+ "\t");
            System.out.print(sueldoBruto+ "\t");
            fila= empleados[pos].getSituacionPersonal();
            columna=busquedaLimite(sueldoBruto);
            sueldoNeto= sueldoBruto*(1-irpf[fila][columna]);
             System.out.println(sueldoNeto);
            
       

        }
    }
    public int busquedaLimite ( float valor)
    {
        int pos = 0;
        boolean encontrado = false;
        while (pos < limites.length && !encontrado) {
            if (limites[pos]> valor) {
                encontrado = true;
            } else {
                pos++;
            }
        }
        return pos;
    }
}
