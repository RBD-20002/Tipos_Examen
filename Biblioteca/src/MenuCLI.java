import java.util.Scanner;

public class MenuCLI {

    Scanner sc = new Scanner(System.in);
    Tienda tienda = new Tienda();

    public void Iniciar() {
        int opcion;
        do {
            tienda.Menu1();
            System.out.println("Introduce una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1:
                    tienda.MostrarLibros();
                    break;
                case 2:
                    tienda.AgregarLibro();
                    break;
                case 3:
                    tienda.EditarDatosLibros();
                    break;
                case 4:
                    tienda.EliminarLibro();
                    break;
                case 5:
                    tienda.FiltrarPorTitulo();
                    break;
                case 6:
                    tienda.NumeroDeLibros();
                    break;
                case 7:
                    System.out.println("Hasta luego, vuelve pronto");
                default:
                    System.out.println("Opcion invalida");
            }
        } while(opcion != 7);
    }
}
