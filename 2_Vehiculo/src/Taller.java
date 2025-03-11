import java.util.ArrayList;

public class Taller {

    private final ArrayList<Vehiculo> Vehiculos;

    public Taller() {
        Vehiculos = new ArrayList<>();
    }

    public void anadirVehiculo(Vehiculo v) {
        Vehiculos.add(v);
    }

    public void repararVehiculo() {
        for (Vehiculo v : Vehiculos) {
            if (v instanceof Coche) {
                System.out.println("Reparando coche: " + v.getMarca() + " " + v.getModelo());
            } else if (v instanceof Camion) {
                System.out.println("Reparando camion: " + v.getMarca() + " " + v.getModelo());
            } else if (v instanceof Bicicleta) {
                System.out.println("Reparando bicicleta: " + v.getMarca() + " " + v.getModelo());
            }
        }
    }
}
