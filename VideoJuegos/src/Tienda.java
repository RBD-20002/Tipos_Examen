import java.util.ArrayList;
import java.util.List;
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
        System.out.println("|6. Filtrar por titulo   |"); /*H*/
        System.out.println("|7. Numero de VideoJuegos|"); /*H*/
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

    public void NumeroDeJuegos() {
        System.out.println("Numero de juegos almacenados: "+juegos.size());
    }

    public void FiltrarPorTitulo() {
        System.out.println("Introduce el titulo de videojuego: ");
        String tituloPro = sc.nextLine();

        boolean encontrado = false;
        for(int i = 0; i < juegos.size(); i++) {
            if(juegos.get(i).getTitulo().toLowerCase().contains(tituloPro)) {
                System.out.println((i+1)+" "+juegos.get(i).getTitulo()+" $"+ juegos.get(i).getPrecio());
                encontrado = true;
            }
        }
        if(!encontrado) {
            System.out.println("No se encuentran videojuegos con la palabra "+tituloPro);
        }
    }

    public void EditarDatosVideoJuego() {
        ListaDeVideoJuegos();
        int pos2 = -1;
        while(pos2 < 1 || pos2 > juegos.size()) {
            try {
                System.out.println("Elige que videojuego quieres modificar: ");
                pos2 = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un dato valido");
            }
        }
    }

    public void EditarVideoJuego() {
        System.out.println("VideoJuegos: ");
        ListaDeVideoJuegos();
        int pos2 = -1;
        while(pos2 < 1 || pos2 > juegos.size()) {
            try {
                System.out.println("Elige que videojuego quieres modificar: ");
                pos2 = Integer.parseInt(sc.nextLine());
                if(pos2 < 1 || pos2 > juegos.size()) {
                    System.out.println("Posicion invalida, intenta de nuevo");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un dato valido");
            }
        }
        Juego elegido = juegos.get(pos2 - 1);
        int opcion;
        do {
            Menu2();
            try {
                System.out.println("Elegi que elige una opcion: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> ModificarTitulo(elegido);
                    case 2 -> ModificarAnoPub(elegido);
                    case 3 -> ModificarPlataforma(elegido);
                    case 4 -> ModificarPrecio(elegido);
                    case 5 -> System.out.println("Hasta luego");
                    default -> System.out.println("opcion invalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un dato valido");
                opcion = 0;
            }
        } while(opcion != 5);
    }

    public void ModificarTitulo(Juego juego){
        System.out.println("Introduce el nuemvo titulo: ");
        juego.setTitulo(sc.nextLine());
        System.out.println("Dato modificaco correctamente");
    }

    public void ModificarAnoPub(Juego juego) {

    }
}
