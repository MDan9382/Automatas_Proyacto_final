package uni.automatas.Funciones;

import java.util.HashMap;
import java.util.Map;

public class Mapas {


    //Mapa para los Precios
    public  Map<Character,Integer> MapPrecios = new HashMap<>();

    public  void LlenarPrecios() {
        MapPrecios.put('A',5);
        MapPrecios.put('B',8);
        MapPrecios.put('C',3);
        MapPrecios.put('D',10);
        MapPrecios.put('E',6);
        MapPrecios.put('F',7);
        MapPrecios.put('G',20);
        MapPrecios.put('H',6);
        MapPrecios.put('I',5);
        MapPrecios.put('J',15);
        MapPrecios.put('K',18);
        MapPrecios.put('L',25);
    }

    public Map<Character,String> MapNombres = new HashMap<>();

    public void LlenarNombres() {

        MapNombres.put('A',"Galletas Chokis");
        MapNombres.put('B',"Barra de Granola");
        MapNombres.put('C',"Negrto");
        MapNombres.put('D',"Buñuelos");
        MapNombres.put('E',"Donas Glaseadas");
        MapNombres.put('F',"Pan de Banano");
        MapNombres.put('G',"Bollos de Canela");
        MapNombres.put('H',"Pinguinos");
        MapNombres.put('I',"Pastelitos");
        MapNombres.put('J',"Pie de Queso");
        MapNombres.put('K',"Pie de limon");
        MapNombres.put('L',"Muffin");
    }

    public void Llenartodo() {
        LlenarPrecios();
        LlenarNombres();
    }

    public String Nombre(char c) {
        return MapNombres.get(c);
    }

    public int Precio(char c) {
        return MapPrecios.get(c);
    }

    public Mapas() {
        Llenartodo();
    }

}
