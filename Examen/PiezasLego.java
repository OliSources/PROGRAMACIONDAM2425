package Examen;

public class PiezasLego extends JuguetePlastico implements Apilable {
    private int longitud;
    private String color;

    public PiezasLego(String nombre, String marca, int longitud, String color) {
        super(nombre, marca, TPlastico.ABS);
        this.longitud = longitud;
        this.color = color;
    }

    public int getLongitud() {
        return longitud;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void apilar(Juguete juguete) throws JugueteException {
        Apilable.super.apilar(juguete);
        System.out.println("Apilando piezas de lego");
    }

    @Override
    public String toString() {
        return "PiezasLego{" +
                "nombre" + super.getNombre() +
                "marca" + super.getMarca() +
                "longitud=" + longitud +
                ", color='" + color + '\'' +
                '}';
    }
}
