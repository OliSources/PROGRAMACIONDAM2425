package Examen;

public class JuguetePlastico extends Juguete {
   private TPlastico tipoPlastico;

    public JuguetePlastico(String nombre, String marca, TPlastico tipoPlastico) {
        super(nombre, marca);
        this.tipoPlastico = tipoPlastico;
    }

    public TPlastico getTipoPlastico() {
        return tipoPlastico;
    }

}
