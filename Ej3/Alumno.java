package Ej3;



import java.time.LocalDate;

public class Alumno extends Persona {
    private LocalDate fechaNacimiento;

    public Alumno(String nombre, LocalDate fechaNacimiento) {
        super(nombre);
        this.fechaNacimiento = fechaNacimiento;
    }


    @Override
    public void enviarMensaje(Persona destinatario, String mensaje) throws MensajeException {
        if (!esMayorEdad() && destinatario instanceof Alumno) {
            throw new MensajeException("No se permite enviar mensaje a otro alumno");
        }
        destinatario.getBuzon().add(new Mensaje(mensaje, this));

    }

    public boolean esMayorEdad() {
        return this.fechaNacimiento.isBefore(LocalDate.now().minusYears(18).plusDays(1));//→ resta la fecha ingresada - [fechaNacimiento]
    }


}