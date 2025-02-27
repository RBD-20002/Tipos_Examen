import java.util.Scanner;

public class MenuCLI {
    Scanner sc = new Scanner(System.in);
    Calculos cal = new Calculos();

    public void Iniciar() {
        int opcion;
        do{
            try {
                cal.Menu1();
                System.out.println("Elige una opcion: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch(opcion) {
                    case 1 -> cal.MostarAlumnos();
                    case 2 -> cal.AnadirAlumno();
                    case 3 -> cal.EliminarAlumno();
                    case 4 -> cal.MediaClase();
                    case 5 -> cal.MejorAlumno();
                    case 6 -> System.out.println("Hasta luego");
                    default -> System.out.println("Opcion no valida");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: No puedes ingresar ese dato");
                opcion = 0;
            }
        } while(opcion != 6);
    }
}
