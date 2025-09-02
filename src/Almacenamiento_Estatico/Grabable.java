/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Almacenamiento_Estatico;

/**
 *
 * @author tomas
 */
import java.io.*;

public interface Grabable {

    /**
     * Calcula el tamaño en bytes del objeto, tal como será grabado
     *
     * @return el tamaño en bytes del objeto
     */
    int tamRegistro();

    /**
     * Obtiene la cantidad de registros que se desea en el archivo
     *
     * @return la cantidad de registros
     */
    int tamArchivo();

    /**
     * Indica cómo grabar un objeto
     *
     * @param el archivo donde será grabado el objeto
     */
    void grabar(RandomAccessFile a);

    /**
     * Indica cómo leer un objeto
     *
     * @param a el archivo donde se hará la lectura
     */
    void leer(RandomAccessFile a);

    /**
     * Muestra un registro por consola estandar
     */
    void mostrarRegistro();

    /**
     * Carga datos de un registro por consola estandar
     */
    void cargarDatos();

}
