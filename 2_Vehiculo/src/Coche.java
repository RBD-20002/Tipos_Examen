public class Coche extends Vehiculo {

    private int numPuertas;
    private Motor motor;

    public Coche(String marca, String modelo, int numPuertas, Motor motor) {
        super(marca, modelo);
        this.numPuertas = numPuertas;
        this.motor = motor;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "Marca=" + getMarca() +
                "Modelo=" + getModelo() +
                "numPuertas=" + numPuertas +
                ", motor=" + motor +
                '}';
    }
}
