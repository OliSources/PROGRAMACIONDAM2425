package Ej3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class Persona {
    private String nombre;
    private List<Mensaje> buzon;

    public Persona(String nombre) {
        this.nombre = nombre;
        this.buzon = new LinkedList<>(); //→ tiene un enlace al primer y al último elemento añadido.
    }

    public String getNombre() {
        return nombre;
    }

    public List<Mensaje> getBuzon() {
        return buzon;
    }

    public abstract void enviarMensaje(Persona destinatario, String mensaje) throws Ej3.MensajeException;


    public String leerMensaje() throws MensajeException {
        StringBuilder sb = new StringBuilder();

        if (buzon.isEmpty()) {
            throw new MensajeException("No existen mensajes");
        }

        Iterator<Mensaje> it = buzon.iterator();
        int contador = 1;
        while (it.hasNext()) {
            Mensaje m = it.next();
            sb.append("Mensaje " + contador++ + ": \n");
            sb.append(m).append("\n");
        }
        return sb.toString();

    }

    public String leerMensajesOrdenados() throws MensajeException {

        buzon.sort(null);
        return leerMensaje();

    }

    public void borrarMensaje(int m) throws MensajeException {
        if (m <= 0) {
            throw new MensajeException("Introduce un numero correcto");
        }
        if (m > buzon.size()) {
            throw new MensajeException("El mensaje no existe");
        }
        buzon.remove(m - 1);
    }

    public String buscarFrase(String mensaje) throws MensajeException {
        StringBuilder sb = new StringBuilder();
        for (Mensaje e : buzon) {
            if (e.getTexto().contains(mensaje)) {
                sb.append(e);
            }
        }

        if (sb.isEmpty()) {
            throw new MensajeException("No se encuentra la frase");
        }
        return sb.toString();

    }


}
