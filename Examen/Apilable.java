package Examen;

public interface Apilable {
    default void apilar(Juguete juguete) throws JugueteException {
        if (this.equals(juguete)) {
            throw new JugueteException("No puedes apilar a si mismo");
        }
        if (!(juguete instanceof Apilable)){
            throw new JugueteException("Tienes que ser apilable");
        }
        if (!this.getClass().equals(juguete.getClass())) {
            throw new JugueteException("No puedes apilar con objetos de otro tipo");
        }
    }
}
