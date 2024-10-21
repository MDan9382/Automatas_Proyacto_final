package uni.automatas;

import uni.automatas.Funciones.Mapas;
import uni.automatas.Funciones.Vuelto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Pruebas

        Mapas mapa = new Mapas();

        //mapa.LlenarNombres();
        //mapa.LlenarPrecios();

        //mapa.Llenartodo();

        //System.out.println(mapa.MapNombres);
        //System.out.println(mapa.MapPrecios);

        //System.out.println(mapa.MapNombres.get('A'));
        //System.out.println(mapa.MapPrecios.get('A'));

        int[] prueba = Vuelto.calcularVuelto(118);
        for (int i = 0; i < prueba.length; i++) {
            System.out.println(prueba[i]);
        }
        //System.out.println(Vuelto.mensajeVuelto(Vuelto.calcularVuelto(118)));

    }
}