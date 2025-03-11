public class Camion extends Vehiculo {

    private double cargaMax;
    private Motor motor;

    public Camion(String marca, String modelo, double cargaMax, Motor motor) {
        super(marca, modelo);
        this.cargaMax = cargaMax;
        this.motor = motor;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public double getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(double cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "Marca=" + getMarca() +
                "Modelo=" + getModelo() +
                "cargaMax=" + cargaMax +
                ", motor=" + motor +
                '}';
    }
}
