package Ej3;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Mensaje implements Comparable <Mensaje>{ // → para comparar los elementos
    private String texto;
    private LocalDateTime fechaHora;
    //Relación de entidades
    private Persona remitente;

    public Mensaje(String texto, Persona remitente) {
        this.texto = texto;
        this.fechaHora = LocalDateTime.now();
        this.remitente = remitente;
    }


    public String getTexto() {
        return texto;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public Persona getRemitente() {
        return remitente;
    }

    @Override
    public String toString() {

       return String.format("De: %s\nTexto: %s\n Fecha y hora:%s\n",
                remitente.getNombre(),
                texto,
                fechaHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM" ))
        );

    }

    @Override
    public int compareTo(Mensaje o) {

        return this.getRemitente().getNombre().compareTo(o.getRemitente().getNombre());

    }
}