package Ej1;

public class EquipoApp {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("paco", "23468113V");
        Alumno alumno2 = new Alumno("Antonio", "7826492G");
        Alumno alumno3 = new Alumno("Jose","5275837583Y");
        EquipoGenerico<Alumno> equipo1 = new EquipoGenerico<>("triangulo de los bermudos");
        Alumno alumno4 = new Alumno("atisbedo","23568329P");
        Alumno alumno5 = new Alumno("respicio godefrio","32472387529Y");
        Alumno alumno6 = new Alumno("ataulfo","647238462X");
        EquipoGenerico<Alumno> equipo2 = new EquipoGenerico<>("Los juanitos golondrinos");
        try {
            equipo1.addAlumno(alumno1);
            equipo1.addAlumno(alumno2);
            equipo1.addAlumno(alumno3);
            equipo1.mostrarEquipo();
            equipo2.addAlumno(alumno4);
            equipo2.addAlumno(alumno5);
            equipo2.addAlumno(alumno6);
            equipo2.addAlumno(alumno2);
            equipo2.mostrarEquipo();

            EquipoGenerico<Alumno> equipoIterseccion = equipo1.insertarEquipos(equipo2);
            System.out.println(equipoIterseccion);
            EquipoGenerico<Integer> equipoGenerico2 = new EquipoGenerico<>("equipo2");
            EquipoGenerico<Integer>equipoGenerico = new EquipoGenerico<>("Equipo1");
            equipoGenerico2.addAlumno(5);
        }catch (EquipoException e ){
            System.out.println(e.getMessage());
        }
    }
}
