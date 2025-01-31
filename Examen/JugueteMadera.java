package Examen;

import java.time.Year;

public abstract class JugueteMadera extends Juguete  {
    private String origen;
    private Year annoTala;

    public JugueteMadera(String nombre, String marca, String origen, Year annoTala) {
        super(nombre, marca);
        this.origen = origen;
        this.annoTala = annoTala;
    }

    public String getOrigen() {
        return origen;
    }


    public Year getAnnoTala() {
        return annoTala;
    }


}
