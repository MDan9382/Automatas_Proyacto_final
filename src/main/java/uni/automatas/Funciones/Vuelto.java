package uni.automatas.Funciones;

import uni.automatas.DevolverVuelto;



public class Vuelto {

    public static int[] calcularVuelto(int n) {
        int[] NumdeMoneda = new int[4];

            NumdeMoneda[0] = n / 20;
            n %= 20;

            NumdeMoneda[1] = n / 10;
            n %= 10;

            NumdeMoneda[2] = n / 5;
            n %= 5;

            NumdeMoneda[3] = n;
            n %= 1;

        return NumdeMoneda;
    }

    public static String mensajeVuelto (int x) {

        int[] n = calcularVuelto(x);
        String formato = "\n %d billetes de 20\n %d billetes de 10\n %d billetes de 5\n %d monedas de quetzal";
        String mensaje= String.format(formato, n[0], n[1], n[2], n[3]);


        return mensaje;
    }


}
