package Ejercicio3_Relacion1T5;

public abstract class Personaje {

    // Constantes para construir y controlar a cada personaje
    private static final int FUERZA_MAX = 20;
    private static final int FUERZA_MIN = 0;
    private static final int INTELIGENCIA_MAX = 20;
    private static final int INTELIGENCIA_MIN = 0;
    private static final int VIDA_MIN = 0;

    // Atributos del personaje
    private final int VIDA_MAX;
    private String nombre;
    private TipoRaza raza;
    private int fuerza;
    private int inteligencia;
    private int vida;

    /**
     * Constructor de Personaje
     * @param nombre
     * @param raza
     * @param fuerza
     * @param inteligencia
     * @param vidaMax
     * @throws PersonajeException
     */
    public Personaje(String nombre, TipoRaza raza, int fuerza, int inteligencia, int vidaMax) throws PersonajeException {
        // 1. Comprobamos que la vida maxima esté en los limites correctos 0 minimo 100 maximo.
        comprobarVIDA_MAX(vidaMax);
        // 2. Asignamos el valor máximo posible de vida.
        VIDA_MAX = vidaMax;
        // 3. Inicializamos la vida, la fuerza y la inteligencia con cada setter correspondiente.
        setVida(vidaMax);
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        // 4. Inicializamos nombre y raza.
        this.nombre = nombre;
        this.raza = raza;
    }

    // SETTERS

    /**
     * Este método comprueba que el atributo fuerza, esté dentro de 0 y 100
     * @param fuerza
     * @throws PersonajeException
     */
    public void setFuerza(int fuerza) throws PersonajeException{
        if(fuerza<FUERZA_MIN || fuerza>FUERZA_MAX){
            throw new PersonajeException("El valor de fuerza no puede ser inferior a %d ni mayor a %d".formatted(FUERZA_MIN,FUERZA_MAX));
        }
        this.fuerza = fuerza;
    }

    /**
     * Este método comprueba que el atributo inteligencia, este dentro 0 y 100
     * @param inteligencia
     * @throws PersonajeException
     */
    public void setInteligencia(int inteligencia) throws PersonajeException {
        if(inteligencia<INTELIGENCIA_MIN || inteligencia>INTELIGENCIA_MAX){
            throw new PersonajeException("El valor de inteligencia no puede ser inferior a %d ni mayor a %d".formatted(INTELIGENCIA_MIN,INTELIGENCIA_MAX));
        }
        this.inteligencia = inteligencia;
    }

    /**
     * Este setter comprueba que la vida este dentro de los limites establecidos y despues asigna el valor
     * al atributo vida
     * @param vida
     * @throws PersonajeException
     */
    public void setVida(int vida) throws PersonajeException{
        if (vida<VIDA_MIN || vida>VIDA_MAX){
            throw new PersonajeException("El valor de la vida maxima no puede ser 0 o menos, o mayor que 100");
        }
        this.vida = vida;
    }

    /**
     * Este metodo comprueba que la VIDA_MAX esté dentro 0 y 100
     * @param vidaMax
     * @throws PersonajeException
     */
    private void comprobarVIDA_MAX(int vidaMax) throws PersonajeException{
        if (vidaMax<=0 || vidaMax>100){
            throw new PersonajeException("El valor de la vida no puede ser inferior a %d ni mayor a %d".formatted(VIDA_MIN,VIDA_MAX));
        }
    }


    // GETTERS

    /**
     * Getter de VIDA_MAX
     * @return
     */
    public int getVIDA_MAX() {
        return VIDA_MAX;
    }

    /**
     * Getter de nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Getter de raza
     * @return
     */
    public TipoRaza getRaza() {
        return raza;
    }

    /**
     * Getter de fuerza
     * @return
     */
    public int getFuerza() {
        return fuerza;
    }

    /**
     * Getter de inteligencia
     * @return
     */
    public int getInteligencia() {
        return inteligencia;
    }

    /**
     * Getter de vida
     * @return
     */
    public int getVida() {
        return vida;
    }

    @Override
    public String toString() {
        return ("El nombre es: %s\n" +
                "La raza es: %s\n" +
                "La fuerza vale: %d\n" +
                "La inteligencia vale %d\n" +
                "La vida vale %d\n").formatted(nombre,raza,fuerza,inteligencia,vida);
    }
}