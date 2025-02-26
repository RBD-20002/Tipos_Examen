import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

    ArrayList<Tarea> tareas = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void Menu1() {
        System.out.println("|_______________________|");
        System.out.println("|     GESTOR TAREAS     |");
        System.out.println("|1. Agregar tarea       |");
        System.out.println("|2. Mostrar tareas      |"); /*H*/
        System.out.println("|3. Marcar tarea hecha  |"); /*H*/
        System.out.println("|4. Eliminar tarea      |"); /*H*/
        System.out.println("|5. Salir               |"); /*H*/
        System.out.println("|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
    }

    public void Menu2() {
        System.out.println("|________________|");
        System.out.println("|  ESTADO TAREA  |");
        System.out.println("|1. Completado   |"); /*H*/
        System.out.println("|2. Sin Finalizar|"); /*H*/
        System.out.println("|3. Volver atras |"); /*H*/
        System.out.println("|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
    }

    public void ListarTareas() {
        if(tareas.isEmpty()) {
            System.out.println("No hay tareas que mostrar");
            return;
        }
        for(int i = 0; i < tareas.size(); i++) {
            System.out.println((i+1)+" "+tareas.get(i).getTarea());
        }
    }

    public void EliminarTarea() {
        if(tareas.isEmpty()) {
            System.out.println("No hay tareas para eliminar");
            return;
        }
        ListarTareas();
        int indice = EscogerTarea();
        tareas.remove(indice);
        System.out.println("Tarea eliminada correctamente");
    }

    public void TacharTarea() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas para tachar");
            return;
        }

        ListarTareas();
        int indice = EscogerTarea();
        Tarea elegida = tareas.get(indice);

        int opcion;
        do {
            Menu2();
            try {
                System.out.println("Escoge la opcion del estado de la tarea: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> elegida.setCompletado(true);
                    case 2 -> elegida.setCompletado(false);
                    default -> System.out.println("Opcion invalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato introducido invalido");
                opcion = 0;
            }
        } while(opcion != 3);
    }

    public int EscogerTarea() {
        int pos = -1;
        while(pos < 1 || pos > tareas.size()) {
            try {
                System.out.println("Elige que tarea haz completado: ");
                pos = Integer.parseInt(sc.nextLine());
                if(pos < 1 || pos > tareas.size()) {
                    System.out.println("La tarea que escogiste para tachar parece que no existe");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un dato valido");
            }
        } return  (pos-1);
    }
}
