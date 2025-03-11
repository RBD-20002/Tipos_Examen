public class Main {
    public static void main(String[] args) {
        Taller Taller = new Taller();
        Motor motorCoche = new Motor(2000, 150);
        Motor motorCamion = new Motor(5000, 300);
        Coche coche = new Coche("Seat", "Ibiza", 5, motorCoche);
        Camion camion = new Camion("Mercedes", "Actros", 20000, motorCamion);
        Bicicleta bicicleta = new Bicicleta("Orbea", "Alma", Bicicleta.Tipo.MONTANA);
        Taller.anadirVehiculo(coche);
        Taller.anadirVehiculo(camion);
        Taller.anadirVehiculo(bicicleta);
        Taller.repararVehiculo();
    }
}