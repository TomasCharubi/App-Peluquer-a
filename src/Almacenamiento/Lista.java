
package Almacenamiento;

/**
 *
 * @author tomas
 */
import Dato.Cliente;

public class Lista {

    protected Nodo list;

    public Lista() {
        list = null;
    }

    public Nodo getList() {
        return list;
    }

    public void setList(Nodo list) {
        this.list = list;
    }

    public void inserPri(Cliente elem) {
        Nodo X = new Nodo(elem);
        if (list == null) {
            list = X;
        } else {
            X.setPs(list);
            list = X;
        }
    }

    public Nodo quitar(Nodo p, Nodo ant) {
        Nodo x = p;
        if (p == list) {
            list = p.getPs();
        } else {
            ant.setPs(p.getPs());
        }
        return x;
    }

    public Nodo inicio() {
        return list;
    }

    public boolean listaVacia() {
        if (list == null) {
            return true;
        } else {
            return false;
        }
    }
}
