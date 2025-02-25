import java.util.Scanner;

public class MenuCLI {

    Scanner sc = new Scanner(System.in);
    Tienda tienda = new Tienda();

    public void Iniciar() {
        int opcion;
        do {
            tienda.Menu1();
            System.out.println("Selecciona una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> tienda.MostrarAlbumnes();
                case 2 -> tienda.AgregarAlbum();
                case 3 -> tienda.EditarAlbum();
                case 4 -> tienda.EliminarAlbumnes();
                case 5 -> System.out.println("Hasta Luego");
                default -> System.out.println("Opcion invalida");
            }
        } while (opcion != 5);
    }
}
