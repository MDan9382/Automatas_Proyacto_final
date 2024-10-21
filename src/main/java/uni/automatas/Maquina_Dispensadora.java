package uni.automatas;


import uni.automatas.Funciones.Mapas;
import uni.automatas.Funciones.Vuelto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Maquina_Dispensadora {
    private JPanel pnlMain;
    private JLabel lblTitulo;
    private JButton btnPrdL;
    private JButton BtnPrdB;
    private JButton BtnPrdC;
    private JButton BtnPrdD;
    private JButton BtnPrdA;
    private JButton BtnPrdE;
    private JButton BtnPrdF;
    private JButton BtnPrdG;
    private JButton BtnPrdH;
    private JButton BtnPrdI;
    private JButton BtnPrdJ;
    private JButton BtnPrdK;
    private JPanel pnlDinero;
    private JPanel pnlSelecProd;
    private JLabel lblSelecProd;
    private JLabel lblDineroEnter;
    private JButton btnDinero1;
    private JButton btnDinero20;
    private JButton btnDinero10;
    private JButton btnDinero5;
    private JButton btnComprar;
    private JPanel pnlTodosIngresos;
    private JTextArea textDineroAcumulado;
    private JTextArea textProductoNombre;
    private JLabel lblNombreProducto;
    private JLabel lblPrecioProducto;
    private JTextArea textPrecioProducto;
    private JPanel pnlImagenes;
    private JLabel lblPrdAImg;
    private JLabel lblPrdB;
    private JLabel lblPrdC;
    private JLabel lblPrdD;
    private JLabel lblPrdE;
    private JLabel lblPrdF;
    private JLabel lblPrdG;
    private JLabel lblPrdH;
    private JLabel lblPrdI;
    private JLabel lblPrdJ;
    private JLabel lblPrdK;
    private JLabel lblPrdL;
    private JLabel lblSaldo;

    Mapas mapas = new Mapas();
    String formatoTransaccionFin = "Compra: %s \nPrecio %s \nVuelto total %s \nBilletes de vuelto %s";
    String nombreProducto = "", transaccionStr;
    char op;
    int precioProducto, dineroAcumulado = 0;

    public Maquina_Dispensadora() {
        BtnPrdA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                op = 'A';
                if (dineroAcumulado < mapas.Precio(op)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    nombreProducto = mapas.Nombre(op);
                    precioProducto = mapas.Precio(op);
                    textProductoNombre.setText(nombreProducto);
                    textPrecioProducto.setText(precioProducto + "");
                }
            }
        });
        btnDinero1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dineroAcumulado +=1;
                textDineroAcumulado.setText(String.valueOf(dineroAcumulado));

                if(dineroAcumulado >= 25) {
                    btnDinero1.setEnabled(false);
                    btnDinero5.setEnabled(false);
                    btnDinero10.setEnabled(false);
                    btnDinero20.setEnabled(false);
                }

            }
        });
        btnComprar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nombreProducto.equals("")) {
                    JOptionPane.showMessageDialog(null, "Seleccione un producto","Error", JOptionPane.ERROR_MESSAGE);
                }
                else{

                    dineroAcumulado -= precioProducto;
                    transaccionStr = String.format(formatoTransaccionFin,nombreProducto, precioProducto, dineroAcumulado, Vuelto.mensajeVuelto(dineroAcumulado));
                    JOptionPane.showMessageDialog(null,transaccionStr,"Factura",JOptionPane.INFORMATION_MESSAGE);
                    dineroAcumulado = 0;
                    nombreProducto = "";
                    textDineroAcumulado.setText(String.valueOf(dineroAcumulado));
                    textProductoNombre.setText("");
                    textPrecioProducto.setText("");

                    btnDinero1.setEnabled(true);
                    btnDinero5.setEnabled(true);
                    btnDinero10.setEnabled(true);
                    btnDinero20.setEnabled(true);

                }
            }
        });
        btnDinero5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dineroAcumulado += 5;
                textDineroAcumulado.setText(String.valueOf(dineroAcumulado));

                if(dineroAcumulado >= 25) {
                    btnDinero1.setEnabled(false);
                    btnDinero5.setEnabled(false);
                    btnDinero10.setEnabled(false);
                    btnDinero20.setEnabled(false);
                }

            }
        });
        btnDinero10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dineroAcumulado += 10;
                textDineroAcumulado.setText(String.valueOf(dineroAcumulado));

                if(dineroAcumulado >= 25) {
                    btnDinero1.setEnabled(false);
                    btnDinero5.setEnabled(false);
                    btnDinero10.setEnabled(false);
                    btnDinero20.setEnabled(false);
                }

            }
        });
        btnDinero20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dineroAcumulado += 20;
                textDineroAcumulado.setText(String.valueOf(dineroAcumulado));

                if(dineroAcumulado >= 25) {
                    btnDinero1.setEnabled(false);
                    btnDinero5.setEnabled(false);
                    btnDinero10.setEnabled(false);
                    btnDinero20.setEnabled(false);
                }

            }
        });
        BtnPrdB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'B';
                if (dineroAcumulado < mapas.Precio(op)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    nombreProducto = mapas.Nombre(op);
                    precioProducto = mapas.Precio(op);
                    textProductoNombre.setText(nombreProducto);
                    textPrecioProducto.setText(precioProducto + "");
                }
            }
        });
        BtnPrdC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'C';
                if (dineroAcumulado < mapas.Precio(op)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    nombreProducto = mapas.Nombre(op);
                    precioProducto = mapas.Precio(op);
                    textProductoNombre.setText(nombreProducto);
                    textPrecioProducto.setText(precioProducto + "");
                }

            }
        });
        BtnPrdD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'D';
                if (dineroAcumulado < mapas.Precio(op)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    nombreProducto = mapas.Nombre(op);
                    precioProducto = mapas.Precio(op);
                    textProductoNombre.setText(nombreProducto);
                    textPrecioProducto.setText(precioProducto + "");
                }
            }
        });
        BtnPrdE.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'E';
                //precioProducto = 0;
                if (dineroAcumulado < mapas.Precio(op)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    nombreProducto = mapas.Nombre(op);
                    precioProducto = mapas.Precio(op);
                    textProductoNombre.setText(nombreProducto);
                    textPrecioProducto.setText(precioProducto + "");
                }
            }
        });
        BtnPrdF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'F';
                if (dineroAcumulado < mapas.Precio(op)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    nombreProducto = mapas.Nombre(op);
                    precioProducto = mapas.Precio(op);
                    textProductoNombre.setText(nombreProducto);
                    textPrecioProducto.setText(precioProducto + "");
                }
            }
        });
        BtnPrdG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'G';
                if (dineroAcumulado < mapas.Precio(op)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    nombreProducto = mapas.Nombre(op);
                    precioProducto = mapas.Precio(op);
                    textProductoNombre.setText(nombreProducto);
                    textPrecioProducto.setText(precioProducto + "");
                }
            }
        });
        BtnPrdH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'H';
                if (dineroAcumulado < mapas.Precio(op)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    nombreProducto = mapas.Nombre(op);
                    precioProducto = mapas.Precio(op);
                    textProductoNombre.setText(nombreProducto);
                    textPrecioProducto.setText(precioProducto + "");
                }
            }
        });
        BtnPrdI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'I';
                if (dineroAcumulado < mapas.Precio(op)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    nombreProducto = mapas.Nombre(op);
                    precioProducto = mapas.Precio(op);
                    textProductoNombre.setText(nombreProducto);
                    textPrecioProducto.setText(precioProducto + "");
                }
            }
        });
        BtnPrdJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'J';
                if (dineroAcumulado < mapas.Precio(op)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    nombreProducto = mapas.Nombre(op);
                    precioProducto = mapas.Precio(op);
                    textProductoNombre.setText(nombreProducto);
                    textPrecioProducto.setText(precioProducto + "");
                }
            }
        });
        BtnPrdK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'K';
                if (dineroAcumulado < mapas.Precio(op)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    nombreProducto = mapas.Nombre(op);
                    precioProducto = mapas.Precio(op);
                    textProductoNombre.setText(nombreProducto);
                    textPrecioProducto.setText(precioProducto + "");
                }
            }
        });
        btnPrdL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'L';
                if (dineroAcumulado < mapas.Precio(op)) {
                    JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    nombreProducto = mapas.Nombre(op);
                    precioProducto = mapas.Precio(op);
                    textProductoNombre.setText(nombreProducto);
                    textPrecioProducto.setText(precioProducto + "");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Maquina_Dispensadora");
        frame.setContentPane(new Maquina_Dispensadora().pnlMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);




    }


    private void createUIComponents() {

        lblPrdAImg = new JLabel();
        ImageIcon imagenA = new ImageIcon(new ImageIcon("Imagenes/PrdAImg.PNG").getImage().getScaledInstance(90,50, Image.SCALE_SMOOTH));
        lblPrdAImg.setIcon(imagenA);

        lblPrdB = new JLabel();
        ImageIcon imagenB = new ImageIcon(new ImageIcon("Imagenes/PrdBImg.PNG").getImage().getScaledInstance(90,50, Image.SCALE_SMOOTH));
        lblPrdB.setIcon(imagenB);

        lblPrdC = new JLabel();
        ImageIcon imagenc = new ImageIcon(new ImageIcon("Imagenes/PrdCImg.PNG").getImage().getScaledInstance(60,100, Image.SCALE_SMOOTH));
        lblPrdC.setIcon(imagenc);

        lblPrdD = new JLabel();
        ImageIcon imagenD = new ImageIcon(new ImageIcon("Imagenes/PrdDImg.PNG").getImage().getScaledInstance(60,100, Image.SCALE_SMOOTH));
        lblPrdD.setIcon(imagenD);

        lblPrdE = new JLabel();
        ImageIcon imagenE = new ImageIcon(new ImageIcon("Imagenes/PrdEImg.jpg").getImage().getScaledInstance(60,100, Image.SCALE_SMOOTH));
        lblPrdE.setIcon(imagenE);

        lblPrdF = new JLabel();
        ImageIcon imagenF= new ImageIcon(new ImageIcon("Imagenes/PrdFImg.jpg").getImage().getScaledInstance(60,100, Image.SCALE_SMOOTH));
        lblPrdF.setIcon(imagenF);

        lblPrdG = new JLabel();
        ImageIcon imagenG = new ImageIcon(new ImageIcon("Imagenes/PrdGImg.jpg").getImage().getScaledInstance(90,50, Image.SCALE_SMOOTH));
        lblPrdG.setIcon(imagenG);

        lblPrdH = new JLabel();
        ImageIcon imagenH = new ImageIcon(new ImageIcon("Imagenes/PrdHImg.jpg").getImage().getScaledInstance(60,90, Image.SCALE_SMOOTH));
        lblPrdH.setIcon(imagenH);

        lblPrdI = new JLabel();
        ImageIcon imagenI = new ImageIcon(new ImageIcon("Imagenes/PrdIImg.jpg").getImage().getScaledInstance(60,100, Image.SCALE_SMOOTH));
        lblPrdI.setIcon(imagenI);

        lblPrdJ = new JLabel();
        ImageIcon imagenJ = new ImageIcon(new ImageIcon("Imagenes/PrdJImg.jpg").getImage().getScaledInstance(110,50, Image.SCALE_SMOOTH));
        lblPrdJ.setIcon(imagenJ);

        lblPrdK = new JLabel();
        ImageIcon imagenK = new ImageIcon(new ImageIcon("Imagenes/PrdKImg.jpg").getImage().getScaledInstance(120,70, Image.SCALE_SMOOTH));
        lblPrdK.setIcon(imagenK);

        lblPrdL = new JLabel();
        ImageIcon imagenL = new ImageIcon(new ImageIcon("Imagenes/PrdLImg.jpg").getImage().getScaledInstance(110,80, Image.SCALE_SMOOTH));
        lblPrdL.setIcon(imagenL);

    }
}
