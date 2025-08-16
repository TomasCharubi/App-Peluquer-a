
package Interfaces;

import Almacenamiento.Lseo;
import Dato.Cliente;
import Dato.Fecha;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 *
 * @author tomas Charubi
 */
public class Interfaz_registro extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz_registro
     */
    //Creamos una lista.
    public static Lseo lista = new Lseo();
    private Color colorActual = Color.BLUE;
    private JPanel panel;
    private Color colorObjetivo = Color.ORANGE;
    private float progreso = 0f;
    private Timer animacion;
    private Timer cambioColor;

    public Interfaz_registro() {
        initComponents();
        // Colocamos la tecla espacio hacia el boton "cargar"
        getRootPane().setDefaultButton(cargar);
        setTitle("SISTEMA DE REGISTRO");//Coloco el titulo
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); // Cierra solo esta ventana.
        this.setResizable(false); //Esto permite que no deslizen la interfaz.
        this.setLocationRelativeTo(null); //Esto encuadra en el medio a la interfaz.
        //Agrego imagenes a JLabels
        SetImageLabel(jLabel1, "/Imagenes/20250729_134924.png");
        SetImageLabel(peluqueroo, "/Imagenes/1753894700302.png");
        SetImageLabel(reloj, "/Imagenes/1755206357130.png");
        //Agrego imagenes a JButtons
        SetImagebutton(cerrar, "/Imagenes/1753729881840.png");
        SetImagebutton(color, "/Imagenes/1755096299333.png");
        //Detalles al Jpanel.
        jPanel1.setBackground(Color.WHITE);
        jPanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3)); // color y grosor
        // Panel principal con borde negro
        panel = (JPanel) this.getContentPane(); // Asignar una vez
        panel.setBackground(Color.ORANGE);
        panel.setBorder(BorderFactory.createLineBorder(Color.black, 5)); // borde negro de 15px
        //Agrego hora
        hora.setFont(new Font("Consolas", Font.BOLD, 12));
        hora.setHorizontalAlignment(SwingConstants.RIGHT);
        hora.setBorder(BorderFactory.createEmptyBorder(3, 8, 3, 8)); // Espaciado interno
        Timer timer = new Timer(1000, e -> {
            String hora_nuevo = new SimpleDateFormat("HH:mm:ss").format(new Date());
            hora.setText("" + hora_nuevo);
        });
        timer.start();
    }

    // Timer para cambio de color (pausado al inicio)
    private void configurarColores() {
        // Timer de animación
        animacion = new Timer(20, e -> {
            if (progreso < 1f) {
                progreso += 0.09f; // Velocidad
                Color nuevoColor = interpolar(colorActual, colorObjetivo, progreso);
                panel.setBackground(nuevoColor);
                jPanel1.setBackground(nuevoColor);
                cerrar.setBackground(nuevoColor);
                cargar.setBackground(nuevoColor);
                color.setBackground(nuevoColor);
            }
        });

        // Timer para cambio de color cada 2 segundos
        cambioColor = new Timer(2000, e -> {
            colorActual = colorObjetivo;
            colorObjetivo = generarColorLlamativo();
            progreso = 0f;
            animacion.start();
        });
    }

    //Crea las combinaciones de colores
    private Color interpolar(Color c1, Color c2, float t) {
        t = Math.max(0f, Math.min(1f, t)); // Limita t entre 0 y 1
        int r = (int) Math.max(0, Math.min(255, c1.getRed() + (c2.getRed() - c1.getRed()) * t));
        int g = (int) Math.max(0, Math.min(255, c1.getGreen() + (c2.getGreen() - c1.getGreen()) * t));
        int b = (int) Math.max(0, Math.min(255, c1.getBlue() + (c2.getBlue() - c1.getBlue()) * t));
        return new Color(r, g, b);
    }


    //Crea el color
    private Color generarColorLlamativo() {
        int r, g, b;
        do {
            r = (int) (Math.random() * 256);
            g = (int) (Math.random() * 256);
            b = (int) (Math.random() * 256);
            // Evita colores muy claros (> 700 en la suma) o muy oscuros (< 200)
        } while ((r + g + b) > 700 || (r + g + b) < 200);
        return new Color(r, g, b);
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        cerrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        horario = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        peluquero = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        monto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dia = new javax.swing.JComboBox<>();
        mes = new javax.swing.JComboBox<>();
        anio = new javax.swing.JComboBox<>();
        cargar = new javax.swing.JButton();
        peluqueroo = new javax.swing.JLabel();
        color = new javax.swing.JButton();
        hora = new javax.swing.JLabel();
        reloj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        cerrar.setBackground(java.awt.Color.orange);
        cerrar.setBorder(null);
        cerrar.setBorderPainted(false);
        cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarActionPerformed(evt);
            }
        });

        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("SISTEMA DE REGISTRO DE CLIENTES");

        jLabel3.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("NOMBRE Y APELLIDO");

        nombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("HORARIO");

        horario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "14.00", "15.00", "16.00", "17.00", "18.00", "19.00", "20.00", "21.00", "22.00" }));
        horario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        horario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horarioActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("PELUQUERO");

        peluquero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MATI", "MARTIN", "JUAN" }));
        peluquero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("    MONTO");

        monto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("  FECHA ");

        dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        dia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        mes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        anio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2025", "2026", "2027" }));
        anio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cargar.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        cargar.setForeground(java.awt.Color.black);
        cargar.setText("CARGAR CLIENTE");
        cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nombre)
                                    .addComponent(horario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(peluquero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(monto))
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(anio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(peluqueroo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(peluquero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addComponent(peluqueroo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        color.setBackground(java.awt.Color.orange);
        color.setBorder(null);
        color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(reloj, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)
                        .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(hora, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reloj, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(color, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == cerrar) {
            dispose();
        }
    }//GEN-LAST:event_cerrarActionPerformed

    private void horarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_horarioActionPerformed

    private void cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarActionPerformed
        //Verificamos mediante interrupciones
        try {
            //Verificamos que los textField sean rellenados
            if (monto.getText().isEmpty() || nombre.getText().isEmpty()) {
                throw new IllegalArgumentException("TODOS LOS DATOS DEBEN SER RELLENADOS");
            }

            //Verifiamos string , luego parseamos
            String nombre_ = nombre.getText();
            if (nombre_.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+")) {
                // El texto es válido (solo letras y espacios)
            } else {
                throw new IllegalArgumentException("INGRESE SOLO LETRAS EN EL NOMBRE Y APELLIDO");
            }
            //Verificamos que el monto no sea texto
            String montoTexto = monto.getText().trim();
            if (!montoTexto.matches("\\d+")) {
                throw new IllegalArgumentException("INGRESE SOLO NÚMEROS EN EL MONTO");
            }

            //Parseamos datos para crear el objeto
            String peluquero_ = (String) peluquero.getSelectedItem();
            int horario_ = (int) Double.parseDouble((String) horario.getSelectedItem());
            int monto_ = Integer.parseInt((String) monto.getText());

            //Parseamos el objeto fecha
            int dia_ = Integer.parseInt((String) dia.getSelectedItem());
            int mes_ = Integer.parseInt((String) mes.getSelectedItem());
            int año_ = Integer.parseInt((String) anio.getSelectedItem());

            //Verifico que sea fecha valida
            if (!esFechaValida(dia_, mes_, año_)) {
                //Lanzo excepcion en el programa
                throw new IllegalArgumentException("¡LA FECHA ES ERRONEA, VUELVE A INTENTARLO!");
            }

            //Verifico que no sea fecha pasada
            if (esFechaAnterior(dia_, mes_, año_)) {
                //Lanzo excepcion en el programa
                throw new IllegalArgumentException("¡LA FECHA ES PASADA, VUELVE A INTENTARLO!");
            }

            Fecha objeto_fecha = new Fecha(dia_, mes_, año_);

            //Creamos una clave unica mediante funcion hash
            String clave = horario_ + "-" + peluquero_ + "-" + dia_ + "-" + mes_ + "-" + año_;
            int hashCode = clave.hashCode(); // Genera un entero único para esa combinación

            //CREAMOS EL OBJETO DE TIPO CLIENTE
            Cliente objeto_cliente = new Cliente(peluquero_, nombre_, horario_, monto_, objeto_fecha, hashCode);

            //INSERTAMOS EL OBJETO A LA LISTA
            if (lista.insertar(objeto_cliente)) {
                JOptionPane.showMessageDialog(null, "¡SE CARGO EL TURNO!");
            } else {
                JOptionPane.showMessageDialog(null, "¡YA HAY UN TURNO PARA ESE HORARIO, FECHA Y PELUQUERO!");
            }
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_cargarActionPerformed

    private void colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colorActionPerformed
        // TODO add your handling code here:
        if (cambioColor == null || !cambioColor.isRunning()) {
            // Si todavía no está corriendo, lo arranco
            configurarColores();
            cambioColor.start();
        } else {
            // Si ya está corriendo, lo detengo
            cambioColor.stop();
            animacion.stop();
        }
    }//GEN-LAST:event_colorActionPerformed

    //Verifico si es fecha pasada
    public boolean esFechaAnterior(int dia, int mes, int año) {
        // Fecha ingresada
        LocalDate fechaIngresada = LocalDate.of(año, mes, dia);
        // Fecha actual
        LocalDate hoy = LocalDate.now();

        // Retorna true si la fecha ingresada es anterior a hoy
        return fechaIngresada.isBefore(hoy);
    }

    //Verifico fecha valida
    public static boolean esFechaValida(int dia, int mes, int año) {
        try {
            // Intenta crear un LocalDate con los valores dados
            LocalDate.of(año, mes, dia);
            return true; // Si no lanza excepción, es válida
        } catch (DateTimeException e) {
            return false; // Si lanza excepción, es inválida
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> anio;
    private javax.swing.JButton cargar;
    private javax.swing.JButton cerrar;
    private javax.swing.JButton color;
    private javax.swing.JComboBox<String> dia;
    private javax.swing.JLabel hora;
    private javax.swing.JComboBox<String> horario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> mes;
    private javax.swing.JTextField monto;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> peluquero;
    private javax.swing.JLabel peluqueroo;
    private javax.swing.JLabel reloj;
    // End of variables declaration//GEN-END:variables
}
