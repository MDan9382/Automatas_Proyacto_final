package uni.automatas;


import uni.automatas.Funciones.Mapas;
import uni.automatas.Funciones.Vuelto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static uni.automatas.DevolverVuelto.monedas;
import static uni.automatas.DevolverVuelto.imagen;

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
    private JTextArea textPA;
    private JTextArea textPB;
    private JTextArea textPC;
    private JTextArea textPD;
    private JTextArea textPE;
    private JTextArea textPF;
    private JTextArea textPG;
    private JTextArea textPH;
    private JTextArea textPI;
    private JTextArea textPJ;
    private JTextArea textPK;
    private JTextArea textPL;

    Mapas mapas = new Mapas();


    public void enAbrir (JTextArea text, char op) {
        text.setText("Codigo: " + op + "\n" + mapas.Nombre(op) + "\nQ" + mapas.Precio(op) + "\nExistencias: " + mapas.Exsitencia(op));
        text.setFont(text.getFont().deriveFont(text.getFont().getStyle() | Font.BOLD));
        text.setBackground(Color.DARK_GRAY);
        text.setEnabled(false);
    }

    public void abrirLote() {
        enAbrir(textPA,'A');
        enAbrir(textPB, 'B');
        enAbrir(textPC,'C');
        enAbrir(textPD,'D');
        enAbrir(textPE,'E');
        enAbrir(textPF, 'F');
        enAbrir(textPG,'G');
        enAbrir(textPH,'H');
        enAbrir(textPI,'I');
        enAbrir(textPJ,'J');
        enAbrir(textPK,'K');
        enAbrir(textPL,'L');
    }

    String formatoTransaccionFin = "Compra: %s \nPrecio %s \nVuelto total %s \nBilletes de vuelto %s";
    String nombreProducto = "", transaccionStr;
    char op;
    int precioProducto, dineroAcumulado = 0;

    public void pressProd(char op){
        if (dineroAcumulado < mapas.Precio(op)) {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
        }
        if (mapas.Exsitencia(op) <= 0) {
            JOptionPane.showMessageDialog(null, "No hay existencias", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else {
            nombreProducto = mapas.Nombre(op);
            precioProducto = mapas.Precio(op);
            textProductoNombre.setText(nombreProducto);
            textPrecioProducto.setText(precioProducto + "");

        }
    }

    public  void pressDin (int n) {
        dineroAcumulado +=n;
        textDineroAcumulado.setText(String.valueOf(dineroAcumulado));

        if(dineroAcumulado >= 25) {
            btnDinero1.setEnabled(false);
            btnDinero5.setEnabled(false);
            btnDinero10.setEnabled(false);
            btnDinero20.setEnabled(false);
        }

    }


    public Maquina_Dispensadora() {


        BtnPrdA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                op = 'A';
               pressProd(op);
            }
        });
        btnDinero1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressDin(1);

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
                    //JOptionPane.showMessageDialog(null,transaccionStr,"Factura",JOptionPane.INFORMATION_MESSAGE);

                    DevolverVuelto devolverVuelto = new DevolverVuelto();
                    int[] n = Vuelto.calcularVuelto(dineroAcumulado);
                    for (int i = 0; i<=3; i++){
                        for ( int j = 0 ; j < n[i]; j++){
                            imagen = monedas[i];
                            devolverVuelto.abrirFormulario();
                        }
                    }
                    DevolverProducto devolverProducto = new DevolverProducto(op);
                    devolverProducto.prod = op;
                    //System.out.println(devolverProducto.imagen);
                    devolverProducto.abrirFormulario();

                    dineroAcumulado = 0;
                    nombreProducto = "";
                    textDineroAcumulado.setText(String.valueOf(dineroAcumulado));
                    textProductoNombre.setText("");
                    textPrecioProducto.setText("");

                    btnDinero1.setEnabled(true);
                    btnDinero5.setEnabled(true);
                    btnDinero10.setEnabled(true);
                    btnDinero20.setEnabled(true);

                    mapas.MapExsitencias.replace(op, mapas.Exsitencia(op), mapas.Exsitencia(op) -1);
                    abrirLote();

                }
            }
        });
        btnDinero5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pressDin(5);

            }
        });
        btnDinero10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pressDin(10);
            }
        });
        btnDinero20.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            pressDin(20);
            }
        });
        BtnPrdB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'B';
               pressProd(op);
            }
        });
        BtnPrdC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'C';
                pressProd(op);

            }
        });
        BtnPrdD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'D';
                pressProd(op);
            }
        });
        BtnPrdE.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'E';
                pressProd(op);
            }
        });
        BtnPrdF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'F';
                pressProd(op);
            }
        });
        BtnPrdG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'G';
                pressProd(op);
            }
        });
        BtnPrdH.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'H';
                pressProd(op);
            }
        });
        BtnPrdI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'I';
                pressProd(op);
            }
        });
        BtnPrdJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'J';
                pressProd(op);
            }
        });
        BtnPrdK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'K';
                pressProd(op);
            }
        });
        btnPrdL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                op = 'L';
                pressProd(op);
            }
        });

        abrirLote();


    }
//
//    public void mostarProd(char n) {
//        String prod =
//    }


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

        btnDinero1 = new JButton();
        ImageIcon imagenDin1 = new ImageIcon(new ImageIcon("Imagenes/1q.png").getImage().getScaledInstance(40,40, Image.SCALE_SMOOTH));
        btnDinero1.setIcon(imagenDin1);

        btnDinero5 = new JButton();
        ImageIcon imagenDin5 = new ImageIcon(new ImageIcon("Imagenes/5q.jpg").getImage().getScaledInstance(100,40, Image.SCALE_SMOOTH));
        btnDinero5.setIcon(imagenDin5);

        btnDinero10 = new JButton();
        ImageIcon imagenDin10 = new ImageIcon(new ImageIcon("Imagenes/10q.jpg").getImage().getScaledInstance(100,40, Image.SCALE_SMOOTH));
        btnDinero10.setIcon(imagenDin10);

        btnDinero20 = new JButton();
        ImageIcon imagenDin20 = new ImageIcon(new ImageIcon("Imagenes/20q.jpg").getImage().getScaledInstance(100,40, Image.SCALE_SMOOTH));
        btnDinero20.setIcon(imagenDin20);

    }



}
