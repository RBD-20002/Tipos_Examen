public class Motor {

    private double cilindrada;
    private double potencia;

    public Motor(double cilindrada, double potencia) {
        this.cilindrada = cilindrada;
        this.potencia = potencia;
    }

    public double getPotencia() {
        return potencia;
    }
    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getCilindrada() {
        return cilindrada;
    }
    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }
}
