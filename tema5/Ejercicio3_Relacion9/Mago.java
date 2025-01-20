package Ejercicio3_Relacion1T5;

public class Mago extends Personaje{
    // Constantes de control del mago
    private static final int MIN_INTELIGENCIA = 17;
    private static final int MAX_FUERZA = 15;
    private static final int MAX_NUM_HECHIZOS = 4;
    private static final int VIDA_POR_HECHIZO = 10;
    
    // Atributos de Mago
    private String[] hechizosAprendidos;
    
    /**
     * Constructor de Personaje
     * @param nombre
     * @param raza
     * @param fuerza
     * @param inteligencia
     * @param vidaMax
     * @throws PersonajeException
     */
    public Mago(String nombre, TipoRaza raza, int fuerza, int inteligencia, int vidaMax) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, vidaMax);
        // 1. Llamada a setInteligencia para comprobar MIN_INTELIGENCIA
        setInteligencia(inteligencia);
        // 2. Llamada a setFuerza para comprobar MAX_FUERZA
        setFuerza(fuerza);
        // 3. Inicializo el array de hechizosAprendidos
        hechizosAprendidos = new String[MAX_NUM_HECHIZOS];
    }

    @Override
    /**
     * Metodo para establecer la inteligencia
     * y comprobar que esta no sea menor que MIN_INTELIGENCIA (17)
     * @return
     */
    public void setInteligencia(int inteligencia) throws PersonajeException {
        if (inteligencia < MIN_INTELIGENCIA) {
            throw new PersonajeException("Un mago no puede tener menos de %d en inteligencia".formatted(MIN_INTELIGENCIA));
        }
        super.setInteligencia(inteligencia);
    }

    /**
     * Metodo para establecer la fuerza
     * y comprobar que esta no sea mayor que MAX_FUERZA (15)
     * @param fuerza
     * @throws PersonajeException
     */
    public void setFuerza(int fuerza) throws PersonajeException {
        if (fuerza > MAX_FUERZA) {
            throw new PersonajeException("Un mago no puede tener mas de %d en fuerza".formatted(MAX_FUERZA));
        }
        super.setFuerza(fuerza);
    }

    /**
     * Este método añade un nuevo hechizo a hechizosAprendidos
     * @param nombreHechizo
     * @throws PersonajeException
     */
    public void aprendeHechizo(String nombreHechizo) throws PersonajeException{
        int posicionDisponible = getPosicionDisponible(nombreHechizo);
        // Si no ha encontrado hueco muestro el mensaje de error
        if(posicionDisponible==-1){
            throw new PersonajeException("No hay hueco disponible para un nuevo hechizo");
        }
        // Si he encontrado un espacio disponible para el hechizo lo guardo en hechizosAprendidos
        hechizosAprendidos[posicionDisponible]=nombreHechizo;
    }

    /** (Sugerencia del IDE)
     * Este metodo busca un espacio disponible en hechizosAprendidos
     * @param nombreHechizo
     * @return devuelve -1 si no ha encontrado espacio o
     * un entero indicando la posicion disponible si lo encuentra
     */
    private int getPosicionDisponible(String nombreHechizo) throws PersonajeException{
        int espacioDisponible = -1;
        for (int i = 0; i < hechizosAprendidos.length; i++) {
            if(nombreHechizo.equalsIgnoreCase(hechizosAprendidos[i])){
                throw new PersonajeException("Este hechizo ya estaba en hechizos aprendidos.");
            }
            /* Si encuentro un espacio null (disponible) guardo el valor de i
               en espacioDisponible */
            if(hechizosAprendidos[i] == null && espacioDisponible==-1){
                espacioDisponible = i;
            }
        }
        return espacioDisponible;
    }

    /**
     * Este metodo se encarga de lanzar un hechizo sobre el contrincante
     * @param contrincante sobre este personaje recae el hechizo y genera daño
     * @param nombreHechizoLanzado
     * @throws PersonajeException
     */
    public void lanzaHechizo(Personaje contrincante, String nombreHechizoLanzado) throws PersonajeException{
        boolean existeHechizo = buscaYEliminaHechizo(nombreHechizoLanzado);
        // todo: redefinir el equals que sea por nombre
        if(this.equals(contrincante)){
            throw new PersonajeException("No puedes atacarte a ti mismo");
        }
        if(existeHechizo){
            /* Si la vida del contricante cuando le resta la vitalidad
             es menor que 0, para que no salte la excepcion establecemos
             su vida a 0 */
            if((contrincante.getVida()-VIDA_POR_HECHIZO)<0){
                contrincante.setVida(0);
            }else{
                contrincante.setVida(contrincante.getVida()-VIDA_POR_HECHIZO);
            }
        }else{
            throw new PersonajeException("El hechizo no existe en la lista.");
        }
    }

    /**
     * Este metodo busca el Hechizo y devuelve true y elimina de la lista
     * si lo encuentra, en caso contrario devuelve false
     * @param nombreHechizoLanzado
     * @return
     * @throws PersonajeException
     */
    private boolean buscaYEliminaHechizo(String nombreHechizoLanzado){
        for (int i = 0; i < hechizosAprendidos.length; i++) {
            if (nombreHechizoLanzado.equalsIgnoreCase(hechizosAprendidos[i])){
                hechizosAprendidos[i]=null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("La lista de hechizos de este mago es:\n");
        for (int i = 0; i < hechizosAprendidos.length; i++) {
            if(hechizosAprendidos[i]!=null){
                sb.append("Hechizo %d es, %s\n".formatted(i+1,hechizosAprendidos[i]));
            }else{
                sb.append("El espacio %d esta libre para un nuevo hechizo \n".formatted(i+1));
            }
        }
        return sb.toString();
    }
}
