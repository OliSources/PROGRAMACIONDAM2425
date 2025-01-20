package Ejercicio3_Relacion1T5;

public class Test {
    public static void main(String[] args) {
       //Personaje p1 = new Personaje("Pedro",TipoRaza.ELFO,10,12,100);
       //System.out.println(p1.toString());
       //Porque cuando creo un Personaje p2 = new Mago no puedo ver el método aprendeHechizo siendo este protected
       try {
           Mago a = new Mago("Genimo", TipoRaza.ELFO, 10, 17, 80);
           Mago b = new Mago("Alastor",TipoRaza.ELFO,12,17,80);
           Clerigo c = new Clerigo("Curin",TipoRaza.ENANO,18,15,80,"Mísipo");
           a.aprendeHechizo("Avada Kedabra");
           a.aprendeHechizo("Imperio");
           b.aprendeHechizo("Crucio");
           System.out.println(a.toString());
           System.out.println(b.toString());
           a.lanzaHechizo(b,"Avada Kedabra");
           b.lanzaHechizo(a,"Crucio");
           c.curar(b);
           a.lanzaHechizo(b,"Imperio");
           System.out.println(a.toString());
           System.out.println(b.toString());
           System.out.println(c.toString());
       }catch (PersonajeException e){
           System.out.println(e.getMessage());
       }


    }
}
