public class Main {
    public static void main(String[] args) {
        Taller taller = new Taller();
        Motor motorCoche = new Motor(2000, 150);
        Motor motorCamion = new Motor(5000, 300);
        Coche coche = new Coche("Seat", "Ibiza", 5, motorCoche);
        Camion camion = new Camion("Mercedes", "Actros", 20000, motorCamion);

        taller.anadirVehiculo(coche);
        taller.anadirVehiculo(camion);

        taller.repararVehiculo();
    }
}