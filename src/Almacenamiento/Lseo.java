/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Almacenamiento;

/**
 *
 * @author tomas
 */
import Dato.Cliente;

public class Lseo extends Lista {

    public Lseo() {
        super();
    }

    public void inserMed(Nodo p, Nodo ant, Nodo x) {
        x.setPs(p);
        ant.setPs(x);
    }

    public void inserFin(Nodo ant, Nodo p, Nodo x) {
        if (p == null) {
            x.setPs(null);
            ant.setPs(x);
        }
    }

    public boolean insertar(Cliente ele) {
        Nodo p = inicio();
        Nodo ant = null;
        int b = 0;
        while (p != null && b == 0) {
            Cliente elem = p.getDato();
            if (elem.esMayoroIgualQue2(ele)) {
                if (elem.esIgualQue2(ele)) {
                    b = 2;
                } else {
                    b = 1;
                }
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        if (b != 2) {
            Nodo x = new Nodo(ele);
            if (b == 1) {
                if (p == list) {
                    inserPri(ele);
                } else {
                    inserMed(p, ant, x);
                }
            } else {
                if (ant == null) {
                    list = x;
                } else {
                    inserFin(ant, p, x);
                }
            }
            return true;
        } else {
            return false;
        }

    }

    public int eliminar(int ele) {
        int b = 0;
        Nodo x = null;
        Nodo ant = null;
        Nodo p = inicio();
        while (p != null && b == 0) {
            Cliente dato = p.getDato();
            if (dato.esMayoroIgualQue(ele)) {
                if (dato.esIgualQue(ele)) {
                    b = 1;
                    x = quitar(p, ant);
                } else {
                    p = null;
                }
            } else {
                ant = p;
                p = p.getPs();
            }
        }
        return b;
    }
}
