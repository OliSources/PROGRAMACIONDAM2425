package Examen;

import java.time.Year;

public class Principal {
    public static void main(String[] args) {
        try {
            FiguraMadera figuraMadera = new FiguraMadera("cubo", "a", "España", Year.of(2010), "rojo", 6);
            InstrumentoMusicalMadera instrumentoMusicalMadera = new InstrumentoMusicalMadera("Flauta","b","Brazil",Year.of(2014),3);
            VehiculoPlastico vehiculoPlastico = new VehiculoPlastico("coche","hotwheels",4);
            PiezasLego piezasLego = new PiezasLego("Star wars","lego",12,"azul");
            piezasLego.apilar(new PiezasLego("Star Wars","Lego",12,"rojo"));

        }catch (JugueteException e){
            System.out.println(e.getMessage());
        }
    }
}
