/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Almacenamiento_Estatico;

/**
 *
 * @author tomas
 */
import interfaz.Consola;
import java.io.*;

public class Register implements Grabable {

    private int nroOrden;
    private boolean activo;
    private Grabable datos;

    public Register() {
        activo = false;
        datos = null;
    }

    public Register(Grabable d, int orden) {
        nroOrden = orden;
        activo = false;
        datos = d;
    }

    public int getNroOrden() {
        return nroOrden;
    }

    public void setNroOrden(int nroOrden) {
        this.nroOrden = nroOrden;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean x) {
        activo = x;
    }

    public void setDatos(Grabable d) {
        datos = d;
    }

    public Grabable getDatos() {
        return datos;
    }

    public void cargarNroOrden() {
        System.out.print("Ingrese el Nro. de Orden: ");
        int orden = Consola.readInt();
        setNroOrden(orden);
    }

    @Override
    public int tamRegistro() {
        return datos.tamRegistro() + 5;
    }

    @Override
    public int tamArchivo() {
        return datos.tamArchivo();
    }

    @Override
    public void grabar(RandomAccessFile a) {
        try {
            a.writeInt(nroOrden);
            a.writeBoolean(activo);
            datos.grabar(a);
        } catch (IOException e) {
            System.out.println("Error al grabar los datos del registro: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void leer(RandomAccessFile a) {
        try {
            nroOrden = a.readInt();
            activo = a.readBoolean();
            datos.leer(a);
        } catch (IOException e) {
            System.out.println("Error al leer los datos del registro: " + e.getMessage());
            System.exit(1);
        }
    }

    public static final String readString(RandomAccessFile arch, int tam) {
        String cad = "";

        try {
            char vector[] = new char[tam];
            for (int i = 0; i < tam; i++) {
                vector[i] = arch.readChar();
            }
            cad = new String(vector, 0, tam);
        } catch (IOException e) {
            System.out.println("Error al leer una cadena: " + e.getMessage());
            System.exit(1);
        }
        return cad;
    }

    public static final void writeString(RandomAccessFile arch, String cad, int tam) {
        try {
            int i;
            char vector[] = new char[tam];
            for (i = 0; i < tam; i++) {
                vector[i] = ' ';
            }
            cad.getChars(0, cad.length(), vector, 0);
            for (i = 0; i < tam; i++) {
                arch.writeChar(vector[i]);
            }
        } catch (IOException e) {
            System.out.println("Error al grabar una cadena: " + e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void mostrarRegistro() {
        System.out.println("Nro.Orden: " + getNroOrden());
        getDatos().mostrarRegistro();
        System.out.println("Activo?: " + getActivo());
        System.out.println("\t");
    }

    @Override
    public void cargarDatos() {
        datos.cargarDatos();
    }

}
