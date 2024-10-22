package uni.automatas;

import javax.swing.*;
import java.awt.*;

public class DevolverVuelto extends JFrame {
        private JPanel panel;
        private JLabel lblDinero;
        public static String imagen;
        public static String path = "Imagenes/";
        public static String[] monedas = {"20q.jpg", "10q.jpg","5q.jpg", "1q.png"};

        public void abrirFormulario() {
            JFrame frame = new JFrame("Formulario Dinero");
            frame.setContentPane(new DevolverVuelto().panel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);

        }

        private void createUIComponents() {
            if (imagen == "1q.png") {
                imagen = path + imagen;
                ImageIcon imagenDinero = new ImageIcon(new ImageIcon(imagen).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
                lblDinero = new JLabel();
                lblDinero.setIcon(imagenDinero);
            }
            else {
                imagen = path + imagen;
                ImageIcon imagenDinero = new ImageIcon(new ImageIcon(imagen).getImage().getScaledInstance(350, 200, Image.SCALE_SMOOTH));
                lblDinero = new JLabel();
                lblDinero.setIcon(imagenDinero);

            }
        }

    }


