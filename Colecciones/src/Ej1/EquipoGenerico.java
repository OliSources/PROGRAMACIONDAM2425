package Ej1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EquipoGenerico<T> {
    String nombre;
    Set<T> alumnos;

    public EquipoGenerico(String nombre) {
        this.nombre = nombre;
        this.alumnos = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<T> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<T> alumnos) {
        this.alumnos = alumnos;
    }

    public void addAlumno(T alumno) throws EquipoException {
        if (alumnos.contains(alumno)) {
            throw new EquipoException("ya está este alumno");
        }
        alumnos.add(alumno);
    }

    public void eliminarAlumno(T alumno) throws EquipoException {
        if (!alumnos.contains(alumno)) {
            throw new EquipoException("Este alumno ya fue eliminado o no está en el equipo");
        }
        alumnos.remove(alumno);
    }

    public T comprobarAlumno(T alumno) {
        if (alumnos.contains(alumno)) {
            return alumno;
        }
        return null;
    }

    public List<T> mostrarEquipo() {
        return new ArrayList<>(alumnos);
    }

    public EquipoGenerico<T> unirEquipos(EquipoGenerico<T> equipo) throws EquipoException {
        EquipoGenerico<T> equipo1 = new EquipoGenerico<T>("Nuevo equipo");
        equipo1.getAlumnos().addAll(this.alumnos);
        equipo1.getAlumnos().addAll(equipo.getAlumnos());
        return equipo1;
    }

    public EquipoGenerico<T> insertarEquipos(EquipoGenerico<T> equipo) {
        EquipoGenerico<T> equipo2 = new EquipoGenerico<T>("equipo2 ");
        equipo2.getAlumnos().addAll(alumnos);
        equipo2.getAlumnos().retainAll(equipo.getAlumnos());
        return equipo2;
    }

    @Override
    public String toString() {
        return "Equipos: " +
                "nombre: '" + getNombre() + ',' +
                ", alumnos: " + getAlumnos() + "\n"+
                '.';
    }
}
