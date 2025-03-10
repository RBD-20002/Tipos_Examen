import java.util.Scanner;

public class MenuCLI {

    Scanner sc = new Scanner(System.in);
    Tienda tienda = new Tienda();

    public void Iniciar() {
        int opcion;
        do{
            try{
                System.out.println("Elige un opcion: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> tienda.AgregarTarea();
                    case 2 -> tienda.ListarTareas();
                    case 3 -> tienda.MostrarTareaEstado();
                    case 4 -> tienda.TacharTarea();
                    case 5 -> tienda.EliminarTarea();
                    default -> System.out.println("Opcion invalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Opcion invalida, vuelve a intentar");
                opcion = 0;
            }
        } while(opcion != 6);
    }
}
