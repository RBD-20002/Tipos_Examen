public class Bicicleta extends Vehiculo {

    private Tipo tipo;

    public enum Tipo {CARRETERA, MONTANA, CIUDAD}

    public Bicicleta(String marca, String modelo, Tipo tipo) {
        super(marca, modelo);
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
