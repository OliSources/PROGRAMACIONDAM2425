package Examen;

import java.time.Year;

public class FiguraMadera extends JugueteMadera implements Apilable {
    private String color;
    private int numLados;

    public FiguraMadera(String nombre, String marca, String origen, Year annoTala, String color, int numLados) throws JugueteException {
        super(nombre, marca, origen, annoTala);
        this.color = color;
        setNumLados(numLados);
    }

    public String getColor() {
        return color;
    }

    public int getNumLados() {
        return numLados;
    }

    private void setNumLados(int numLados) throws JugueteException {
        if (numLados <= 0) {
            throw new JugueteException("No puede tener lados por debajo de 1");
        }
        this.numLados = numLados;
    }

    @Override
    public void apilar(Juguete juguete) throws JugueteException {
        Apilable.super.apilar(juguete);
        System.out.println("Apilando juguete de madera");
    }

    @Override
    public String toString() {
        return "FiguraMadera{" +
                "nombre" + super.getNombre() +
                "Marca" + super.getMarca() +
                "Año de tala" + super.getAnnoTala() +
                "Origen" + super.getOrigen() +
                "color='" + color + '\'' +
                ", numLados=" + numLados +
                '}';
    }
}
