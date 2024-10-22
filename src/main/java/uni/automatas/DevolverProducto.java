package uni.automatas;

import javax.swing.*;
import java.awt.*;

public class DevolverProducto {
    private JPanel pnldp;
    private JLabel lblPrdDev;

    public  char prod;
    public  String path  = "Imagenes/Prd";

    public static String imagen ; //path = "Imagenes/Prd"

    public String setpath(char p, String im) {

        if('A' == p || 'B' == p || 'C' == p || 'D' == p) {
            im = path + p + "Img.png";
            System.out.println(im);
        }
        else {
            im = path + p + "Img.jpg";
        }
        return im;

    }

    public DevolverProducto(char q) {
        prod = q;
        setpath(q,imagen);
        imagen = setpath(q, imagen);
    }

    public DevolverProducto() {}

    public void abrirFormulario() {
        JFrame frame = new JFrame("Formulario Dinero");
        frame.setContentPane(new DevolverProducto().pnldp);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private void createUIComponents() {

        ImageIcon img = new ImageIcon(new ImageIcon(imagen).getImage().getScaledInstance(400,400, Image.SCALE_SMOOTH));
        System.out.println(imagen);

        lblPrdDev = new JLabel();
        lblPrdDev.setIcon(img);
    }


}
