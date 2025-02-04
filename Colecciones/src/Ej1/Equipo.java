package Ej1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equipo {
    String nombre;
    Set<Alumno> alumnos;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.alumnos = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void addAlumno(Alumno alumno) throws EquipoException {
        if (alumnos.contains(alumno)) {
            throw new EquipoException("ya está este alumno");
        }
        alumnos.add(alumno);
    }

    public void eliminarAlumno(Alumno alumno) throws EquipoException {
        if (!alumnos.contains(alumno)) {
            throw new EquipoException("Este alumno ya fue eliminado o no está en el equipo");
        }
        alumnos.remove(alumno);
    }

    public Alumno comprobarAlumno(Alumno alumno) {
        if (alumnos.contains(alumno)) {
            return alumno;
        }
        return null;
    }

    public List<Alumno> mostrarEquipo() {
        return new ArrayList<>(alumnos);
    }

    public Equipo unirEquipos(Equipo equipo) throws EquipoException {
        Equipo equipo1 = new Equipo("Nuevo equipo");
        equipo1.getAlumnos().addAll(this.alumnos);
        equipo1.getAlumnos().addAll(equipo.getAlumnos());
        return equipo1;
    }

    public Equipo insertarEquipos(Equipo equipo) {
        Equipo equipo2 = new Equipo("equipo2 ");
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
