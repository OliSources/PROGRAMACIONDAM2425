package TEMA4.MantenimientoAvion;

public class Deposito {
    public static final double CAPACIDAD_MAX = 20;
    private double capacidadActual;

    public Deposito() {
        this.capacidadActual = CAPACIDAD_MAX;
    }

    public double getCapacidadActual() {
        return capacidadActual;
    }
}