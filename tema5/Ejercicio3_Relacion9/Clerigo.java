package Ejercicio3_Relacion1T5;

public class Clerigo extends Personaje{
    // Constantes de control del clerigo
    private static final int MIN_FUERZA = 18;
    private static final int MIN_INTELIGENCIA = 12;
    private static final int MAX_INTELIGENCIA = 16;
    private static final int CANTIDAD_CURACION = 10;

    // Atributos del Clerigo
    private String dios;

    /**
     * Constructor de Personaje
     * @param nombre
     * @param raza
     * @param fuerza
     * @param inteligencia
     * @param vidaMax
     * @param dios
     * @throws PersonajeException
     */
    public Clerigo(String nombre, TipoRaza raza, int fuerza, int inteligencia, int vidaMax, String dios) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, vidaMax);
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        this.dios = dios;
    }

    // Setters con comprobacion

    @Override
    public void setFuerza(int fuerza) throws PersonajeException {
        if(fuerza<MIN_FUERZA){
           throw new PersonajeException("Un clerigo no puede tener menos de %d en fuerza".formatted(MIN_FUERZA));
        }
        super.setFuerza(fuerza);
    }

    @Override
    public void setInteligencia(int inteligencia) throws PersonajeException {
        if(inteligencia<=MIN_INTELIGENCIA || inteligencia>=MAX_INTELIGENCIA){ //ambos incluidos (no puede tener 12 o 16)
            throw new PersonajeException("Un clerigo no puede tener menos de %d ni tener mas de %d en inteligencia".formatted(MIN_INTELIGENCIA,MAX_INTELIGENCIA));
        }
        super.setInteligencia(inteligencia);
    }

    // Getter

    public String getDios() {
        return dios;
    }

    /**
     * Este metodo permite que el Clerigo cure a personajes
     * @param personajeCurado
     */
    protected void curar(Personaje personajeCurado) throws PersonajeException {
        /* Si el personaje curado con la cura que recibe la vida es superior a su máximo
           entonces su vida se establece al maximo (no admite mas salud que el max) */
        if((personajeCurado.getVida()+CANTIDAD_CURACION)>personajeCurado.getVIDA_MAX()){
            personajeCurado.setVida(personajeCurado.getVIDA_MAX());
        }else{
            // Si el personaje tiene aun capacidad para recibir cura se le suma CANTIDAD_CURACION 10
            personajeCurado.setVida(personajeCurado.getVida()+CANTIDAD_CURACION);
        }

    }

    @Override
    public String toString() {
        return super.toString()+"El dios al que venera es %s".formatted(dios);
    }
}