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
                    tienda.AgregarVideoJuego();
                    break;
                case 2:
                    tienda.MostrarJuegos();
                    break;
                case 3:
                    tienda.ListaDeVideoJuegos();
                    break;
                case 4:
                    tienda.EliminarVideoJuego();
                    break;
                case 5:
                    tienda.EditarVideoJuego();
                    break;
                case 6:
                    tienda.FiltrarPorTitulo();
                    break;
                case 7:
                    tienda.NumeroDeJuegos();
                    break;
                case 8:
                    System.out.println("Adios, vuelva pronto");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;

            }
        } while (opcion != 8);
    }
}
