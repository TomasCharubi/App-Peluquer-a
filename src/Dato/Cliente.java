package Dato;

/**
 *
 * @author tomas
 */
public class Cliente {

    private String peluquero;
    private String nombre;
    private int horario;
    private int monto;
    private Fecha fec;
    private int clave;

    public Cliente(String peluquero, String nombre, int horario, int monto, Fecha fec, int clave) {
        this.peluquero = peluquero;
        this.nombre = nombre;
        this.horario = horario;
        this.monto = monto;
        this.fec = fec;
        this.clave = clave;
    }

    public String getPeluquero() {
        return peluquero;
    }

    public void setPeluquero(String peluquero) {
        this.peluquero = peluquero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Fecha getFec() {
        return fec;
    }

    public void setFec(Fecha fec) {
        this.fec = fec;
    }

    public String mostrar() {
        String peluquero_ = peluquero;
        String monto_ = Integer.toString(monto);
        String fec_año = Integer.toString(fec.getAño());
        String fec_mes = Integer.toString(fec.getMes());
        String fec_dia = Integer.toString(fec.getDia());
        return (nombre + "   " + monto_ + "   " + fec_dia + "-" + fec_año + "-" + fec_mes + "   " + peluquero_);
    }

    public boolean esMayoroIgualQue(int ele) {
        if (clave >= ele) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esIgualQue(int ele) {
        return clave == ele;
    }

    public boolean esMayoroIgualQue2(Cliente ele) {
        if (clave >= ele.clave) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esIgualQue2(Cliente ele) {
        return clave == ele.clave;
    }

}
