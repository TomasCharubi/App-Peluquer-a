/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Almacenamiento.Nodo;
import Interfaces.Interfaz_registro;
import java.awt.BorderLayout;
import java.awt.Color;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

/**
 *
 * @author tomas
 */
public class Interfaz_turnos extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz_turnos
     */
    public Interfaz_turnos() {
        initComponents();
        setTitle("SISTEMA DE TURNOS");//Coloco el titulo
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Cierra solo esta ventana.
        this.setResizable(false); //Esto permite que no deslizen la interfaz.
        this.setLocationRelativeTo(null); //Esto encuadra en el medio a la interfaz.
        // Panel principal con borde blanco
        JPanel panel = (JPanel) this.getContentPane();
        panel.setBackground(Color.GRAY);
        panel.setBorder(BorderFactory.createLineBorder(Color.black, 5)); // borde blanco de 15px
        // Crear el contenido HTML con estilo visual
        StringBuilder listaUsuarios = new StringBuilder("<html><style>"
                + "body { font-family: 'Segoe UI', 'Trebuchet MS', sans-serif; }"
                + "table {"
                + "    margin: 0 auto;"
                + "    border-collapse: collapse;"
                + "    width: 85%;"
                + "    border: 2px solid white;"
                + "}"
                + "th {"
                + "    padding: 8px 12px;"
                + "    text-align: center;"
                + "    background-color: rgba(0, 0, 0, 0.85);"
                + "    color: white;"
                + "    font-size: 13px;"
                + "    font-weight: bold;"
                + "    border: 1px solid white;"
                + "}"
                + "td {"
                + "    padding: 6px 10px;"
                + "    text-align: center;"
                + "    border: 1px solid white;"
                + "    color: black;"
                + "    font-size: 12px;"
                + "    font-family: 'Segoe UI', 'Trebuchet MS', sans-serif;"
                + "}"
                + "tr:nth-child(even) td { background-color: #ff4d4d; }"
                + "tr:nth-child(odd) td { background-color: #ff1a1a; }"
                + "</style><div style='text-align:center;'>"
                + "<h1 style='font-size: 22px; text-align:center; margin-bottom: 20px; color: black; letter-spacing: 1px; font-weight: bold; border-bottom: 2px solid black; display: inline-block;'>TURNOS EN LA SEMANA</h1>"
                + "<table>");

        listaUsuarios.append("<tr>"
                + "<th>PELUQUERO</th>"
                + "<th>NOMBRE<br>Y APELLIDO</th>"
                + "<th>HORARIO</th>"
                + "<th>MONTO</th>"
                + "<th>FECHA</th>"
                + "<th>TIEMPO</th>" // NUEVA COLUMNA
                + "</tr>");

        Nodo p = Interfaz_registro.lista.inicio();
        int b = 0;//Creo contador
        while (p != null) {
            LocalDate fechaElemento = LocalDate.of(p.getDato().getFec().getAño(),
                    p.getDato().getFec().getMes(),
                    p.getDato().getFec().getDia());

            LocalDate hoy = LocalDate.now();
            LocalDate dentroDe7dias = hoy.plusDays(7);
            if (!fechaElemento.isBefore(hoy) && !fechaElemento.isAfter(dentroDe7dias)) {
                long diferenciaDias = ChronoUnit.DAYS.between(hoy, fechaElemento);
                String tiempoTexto = "";

                if (diferenciaDias == 0) {
                    tiempoTexto = "Hoy";
                } else if (diferenciaDias > 0) {
                    tiempoTexto = "En " + diferenciaDias + " días";
                }

                listaUsuarios.append("<tr>")
                        .append("<td>").append(p.getDato().getPeluquero()).append("</td>")
                        .append("<td>").append(p.getDato().getNombre()).append("</td>")
                        .append("<td>").append(p.getDato().getHorario()).append("</td>")
                        .append("<td>").append(p.getDato().getMonto()).append("</td>")
                        .append("<td>").append(p.getDato().getFec().getDia()).append("/")
                        .append(p.getDato().getFec().getMes()).append("/")
                        .append(p.getDato().getFec().getAño()).append("</td>")
                        .append("<td>").append(tiempoTexto).append("</td>") // NUEVA COLUMNA
                        .append("</tr>");
            }
            p = p.getPs();
        }
        listaUsuarios.append("</table></div></html>");

        // Crear el JLabel y aplicar estilos
        jLabel1 = new JLabel(listaUsuarios.toString());
        jLabel1.setOpaque(true);
        jLabel1.setBackground(Color.MAGENTA);
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setVerticalAlignment(SwingConstants.TOP);

        // Envolver el JLabel en un JScrollPane para scroll automático
        JScrollPane scrollPane = new JScrollPane(jLabel1);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.setBackground(Color.RED);
        scrollPane.getViewport().setBackground(Color.RED);

        // Agregar el JScrollPane al panel o ventana principal
        // Supongamos que estás usando un JPanel llamado "panelTurnos"
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
