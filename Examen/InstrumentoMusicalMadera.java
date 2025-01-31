package Examen;

import java.time.Year;

public class InstrumentoMusicalMadera extends JugueteMadera {
    private int edadMinima;

    public InstrumentoMusicalMadera(String nombre, String marca, String origen, Year annoTala, int edadMinima) {
        super(nombre, marca, origen, annoTala);
        this.edadMinima = edadMinima;
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    public void setEdadMinima(int edadMinima) throws JugueteException {
        if (edadMinima <= 0) {
            throw new JugueteException("La edad minima no sea menor que 1");
        }
        this.edadMinima = edadMinima;
    }
}
