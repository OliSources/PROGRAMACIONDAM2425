package Examen;

public class VehiculoPlastico extends JuguetePlastico {
    private int numRuedas;

    public VehiculoPlastico(String nombre, String marca, int numRuedas) throws JugueteException {
        super(nombre, marca, TPlastico.PVC);
        this.numRuedas = numRuedas;
        setNumRuedas(numRuedas);
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    private void setNumRuedas(int numRuedas) throws JugueteException {
        if (numRuedas <= 0) {
            throw new JugueteException("Las ruedas no pueden estar por debajo de 1");
        }
        this.numRuedas = numRuedas;
    }
}
