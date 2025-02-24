import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

    Scanner sc = new Scanner(System.in);
    ArrayList<Juego> juegos = new ArrayList<>();

    public void Menu1() {
        System.out.println("|________________________|");
        System.out.println("|       BIENVENIDO       |");
        System.out.println("|1. Agregar VideoJuego   |");
        System.out.println("|2. Mostrar VideoJuegos  |"); /*H*/
        System.out.println("|3. Lista de VideoJuegos |"); /*H*/
        System.out.println("|4. Eliminar VideoJuego  |"); /*H*/
        System.out.println("|5. Editar VideoJuego    |");
        System.out.println("|6. Filtrar por titulo   |");
        System.out.println("|7. Numero de VideoJuegos|");
        System.out.println("|8. Salir                |");
        System.out.println("|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
    }
    public void Menu2() {
        System.out.println("|_____________________|");
        System.out.println("|     EDITAR DATOS    |");
        System.out.println("|1. Titulo            |");
        System.out.println("|2. Año de Publicacion|");
        System.out.println("|3. Plataforma        |");
        System.out.println("|4. Precio            |");
        System.out.println("|5. Volver atras      |");
        System.out.println("|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
    }
    public void Menu3() {
        System.out.println("|PLATAFORMAS|");
        System.out.println("|1. PS3     |");
        System.out.println("|2. PS2     |");
        System.out.println("|3. Switch  |");
        System.out.println("|4. PC      |");
        System.out.println("|5. Nintendo|");
        System.out.println("|6. Cancelar|");
    }

    public void MostrarJuegos() {
        if(juegos.isEmpty()) {
            System.out.println("No hay juegos que mostrar");
        }
        for(int i = 0; i < juegos.size(); i++) {
            System.out.println((i+1)+" "+juegos.get(i).toString());
        }
    }

    public void ListaDeVideoJuegos() {
        for(int i = 0; i < juegos.size(); i++) {
            System.out.println((i+1)+" "+juegos.get(i).getTitulo()+" $"+juegos.get(i).getPrecio());
        }
    }

    public void EleminarVideoJuego() {
        ListaDeVideoJuegos();
        int pos = -1;
        while(pos < 1 || pos > juegos.size()) {
            try {
                System.out.println("Introduce la posicion del juego que quieres eliminar: ");
                pos = Integer.parseInt(sc.nextLine());
                if(pos < 1 || pos > juegos.size()) {
                    System.out.println("Posicion invalida, intenta de nuevo");
                    System.out.println("-".repeat(30));
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Dato invalido, vuelve a intentar");
            }
        }
    }


}
