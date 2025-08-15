/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dato;

/**
 *
 * @author tomas
 */
public class Fecha {

    private int dia;
    private int mes;
    private int año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public String toString() {
        return (dia + "-" + mes + "-" + año);
    }

    public void mostrarfecha() {
        System.out.println("Dia-Mes-Año" + toString());
    }
}
