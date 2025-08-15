package Run;

import Interfaces.Interfaz_ingreso;
import Interfaces.Interfaz_principal;
import javax.swing.UIManager;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatDarculaLaf;
import java.awt.EventQueue;
import javax.swing.JOptionPane;

public class Clase_principal {

    public static void main(String[] args) {
        // Opciones disponibles
        String[] opciones = {"Claro", "Oscuro", "IntelliJ", "Darcula"};

        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Selecciona un estilo visual:",
                "Tema de Interfaz",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        try {
            if (seleccion != null) {
                switch (seleccion) {
                    case "Claro":
                        UIManager.setLookAndFeel(new FlatLightLaf());
                        break;
                    case "Oscuro":
                        UIManager.setLookAndFeel(new FlatDarkLaf());
                        break;
                    case "IntelliJ":
                        UIManager.setLookAndFeel(new FlatIntelliJLaf());
                        break;
                    case "Darcula":
                        UIManager.setLookAndFeel(new FlatDarculaLaf());
                        break;
                }
            } else {
                // Si el usuario cancela, se aplica uno por defecto (ej: claro)
                UIManager.setLookAndFeel(new FlatLightLaf());
            }
        } catch (Exception ex) {
            System.err.println("Error al aplicar FlatLaf.");
        }

        // Iniciamos la interfaz
        java.awt.EventQueue.invokeLater(() -> new Interfaz_ingreso().setVisible(true));
    }
}
