package Interfaces;

import java.awt.Color;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

/**
 *
 * @author tomas charubi
 */
public class Interfaz_principal extends javax.swing.JFrame {

    public Interfaz_principal() {
        setWindowIcon();//Llamo al metodo que coloca el icono
        initComponents();
        setTitle("PELUQUERIA"); //Coloco el titulo de la interfaz.
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Cierra solo esta ventana.
        this.setResizable(false); //Esto permite que no deslizen la interfaz.
        this.setLocationRelativeTo(null); //Esto encuadra en el medio a la interfaz.
        // Panel principal con borde blanco
        JPanel panel = (JPanel) this.getContentPane();
        panel.setBackground(Color.GREEN);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5)); // borde blanco de 15px
        //Agrego imagenes a JLabels
        SetImageLabel(jLabel2, "/Imagenes/1753640411738.png");
        SetImageLabel(jLabel3, "/Imagenes/1753640411738.png");
        SetImageLabel(jLabel4, "/Imagenes/20250727_161058.png");
        SetImageLabel(jLabel6, "/Imagenes/20250727_160941.png");
        SetImageLabel(jLabel7, "/Imagenes/20250727_161027.png");
        SetImageLabel(jLabel10, "/Imagenes/20250728_152929.png");
        SetImageLabel(jLabel11, "/Imagenes/20250728_152929.png");
        //Agrego la animacion a los botones
        aplicarEfectoHoverMouse(boton_registro);
        aplicarEfectoHoverMouse(boton_turnos);
        aplicarEfectoHoverMouse(boton_clientes);
        //Agrego imagenes a JButtons
        SetImagebutton(boton_turnos, "/Imagenes/20250727_164619.png");
        SetImagebutton(boton_clientes, "/Imagenes/20250727_164917.png");
        SetImagebutton(boton_registro, "/Imagenes/20250727_164559.png");
        SetImagebutton(boton_cerrar, "/Imagenes/1753729881840.png");
    }

    //Metodo que coloca icono a la app.
    private void setWindowIcon() {
        // Cargar la imagen desde los recursos
        java.net.URL imgURL = getClass().getResource("/Imagenes/20250727_164559.png");
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            this.setIconImage(icon.getImage());
        }
    }

    //Metodo para dar imagen a JLabel.
    private void SetImageLabel(JLabel labelName, String resourcePath) {
        java.net.URL imgURL = getClass().getResource(resourcePath);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image scaledImage = icon.getImage().getScaledInstance(labelName.getWidth(), labelName.getHeight(), Image.SCALE_SMOOTH);
            labelName.setIcon(new ImageIcon(scaledImage));
            this.repaint();
        } else {
            System.err.println("No se pudo encontrar la imagen: " + resourcePath);
        }
    }

    //Metodo para dar imagen a JButton.
    private void SetImagebutton(JButton buttonName, String resourcePath) {
        java.net.URL imgURL = getClass().getResource(resourcePath);
        if (imgURL != null) {
            ImageIcon icon = new ImageIcon(imgURL);
            Image scaledImage = icon.getImage().getScaledInstance(buttonName.getWidth(), buttonName.getHeight(), Image.SCALE_SMOOTH);
            buttonName.setIcon(new ImageIcon(scaledImage));
            this.repaint();
        } else {
            System.err.println("No se pudo encontrar la imagen: " + resourcePath);
        }
    }
    // Ejemplo de efecto hover para un JButton

    private void aplicarEfectoHoverMouse(JButton boton) {
        Color colorBordeNormal = Color.BLACK; // Color inicial del borde
        Color colorBordeHover = Color.YELLOW; // Color al pasar el mouse

        Border bordeNormal = BorderFactory.createLineBorder(colorBordeNormal, 3);
        Border bordeHover = BorderFactory.createLineBorder(colorBordeHover, 3);

        boton.setBorder(bordeNormal);

        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                boton.setBorder(bordeHover);
                boton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                boton.setBorder(bordeNormal);
                boton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boton_turnos = new javax.swing.JButton();
        boton_clientes = new javax.swing.JButton();
        boton_registro = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        boton_cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Unispace", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Sistema De Informacion Peluqueria");

        boton_turnos.setBackground(new java.awt.Color(102, 102, 102));
        boton_turnos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        boton_turnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_turnosActionPerformed(evt);
            }
        });

        boton_clientes.setBackground(new java.awt.Color(102, 102, 102));
        boton_clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        boton_clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_clientesActionPerformed(evt);
            }
        });

        boton_registro.setBackground(new java.awt.Color(102, 102, 102));
        boton_registro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        boton_registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_registroActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setAlignmentX(2.0F);
        jSeparator1.setAlignmentY(2.0F);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setAlignmentX(2.0F);
        jSeparator2.setAlignmentY(2.0F);
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Segoe UI Light", 0, 10)); // NOI18N
        jLabel9.setForeground(java.awt.Color.black);
        jLabel9.setText("Creado por Tomas Charubi");

        boton_cerrar.setBackground(java.awt.Color.green);
        boton_cerrar.setBorder(null);
        boton_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boton_registro, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(boton_turnos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(128, 128, 128)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(boton_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(134, 134, 134)))
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addGap(582, 582, 582)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton_registro, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_turnos, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(boton_cerrar, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(270, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_registroActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == boton_registro) {
            Interfaz_registro objeto = new Interfaz_registro();
            objeto.setVisible(true);
        }

    }//GEN-LAST:event_boton_registroActionPerformed

    private void boton_turnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_turnosActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == boton_turnos) {
            // VERIFICO SI LA LISTA ESTA VACIA O NO
            if (Interfaz_registro.lista.listaVacia()) {
                JOptionPane.showMessageDialog(null, "NO HAY TURNOS CARGADOS");
            } else {
                new Interfaz_turnos().setVisible(true);
            }
        }

    }//GEN-LAST:event_boton_turnosActionPerformed

    private void boton_clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_clientesActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == boton_clientes) {
            // VERIFICO SI LA LISTA ESTA VACIA O NO
            if (Interfaz_registro.lista.listaVacia()) {
                JOptionPane.showMessageDialog(null, "NO HAY TURNOS CARGADOS");
            } else {
                new Interfaz_clientes().setVisible(true);
            }
        }

    }//GEN-LAST:event_boton_clientesActionPerformed

    private void boton_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cerrarActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == boton_cerrar) {
            System.exit(0);
        }
    }//GEN-LAST:event_boton_cerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_cerrar;
    private javax.swing.JButton boton_clientes;
    private javax.swing.JButton boton_registro;
    private javax.swing.JButton boton_turnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
