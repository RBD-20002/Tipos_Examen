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
        System.out.println("|5. Editar VideoJuego    |"); /*H*/
        System.out.println("|6. Filtrar por titulo   |"); /*H*/
        System.out.println("|7. Numero de VideoJuegos|"); /*H*/
        System.out.println("|8. Salir                |"); /*H*/
        System.out.println("|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
    }

    public void Menu2() {
        System.out.println("|_____________________|");
        System.out.println("|     EDITAR DATOS    |");
        System.out.println("|1. Titulo            |"); /*H*/
        System.out.println("|2. Año de Publicacion|"); /*H*/
        System.out.println("|3. Plataforma        |"); /*H*/
        System.out.println("|4. Precio            |"); /*H*/
        System.out.println("|5. Volver atras      |"); /*H*/
        System.out.println("|¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯|");
    }

    public void Menu3() {
        System.out.println("|PLATAFORMAS|");
        System.out.println("|1. PS3     |"); /*H*/
        System.out.println("|2. PS2     |"); /*H*/
        System.out.println("|3. Switch  |"); /*H*/
        System.out.println("|4. PC      |"); /*H*/
        System.out.println("|5. Nintendo|"); /*H*/
        System.out.println("|6. Cancelar|"); /*H*/
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
        if(juegos.isEmpty()) {
            System.out.println("No hay juegos para listar");
        }
        for(int i = 0; i < juegos.size(); i++) {
            System.out.println((i+1)+" "+juegos.get(i).getTitulo()+" $"+juegos.get(i).getPrecio());
        }
    }

    public void EliminarVideoJuego() {
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
        int anoPub = 0;
        while (anoPub < 1984) {
            try {
                System.out.println("Introduce el nuevo año de publicacion: ");
                anoPub = Integer.parseInt(sc.nextLine());
                if(anoPub < 184) {
                    System.out.println("El año es invalido, vuelve a intentar");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un numero valido");
            }
        }
        juego.setAnoPub(anoPub);
        System.out.println("Dato modificado correctamente");
    }

    public void ModificarPrecio(Juego juego) {
        double precio = 0;
        while(precio < 1) {
            try {
            System.out.println("Introduce el nuevo precio: ");
            precio = Integer.parseInt(sc.nextLine());
            if(precio < 1) {
                System.out.println("El precio es invalido, vuelve a intentar");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un numero valido");
            }
        }
        juego.setPrecio(precio);
        System.out.println("Dato modificado correctamente");
    }

    public void MostrarEnum() {
        for(int i = 0; i < Juego.Plataforma.values().length; i++ ) {
            System.out.println((i+1)+" "+Juego.Plataforma.values());
        }
    }

    public void ModificarPlataforma(Juego juego) {
        MostrarEnum();
        int pos2 = -1;
        while(pos2 > Juego.Plataforma.values().length) {
            try {
                System.out.println("Elige la posicion de la nueva platafrorma: ");
                pos2 = Integer.parseInt(sc.nextLine());
                if(pos2 > Juego.Plataforma.values().length) {
                    System.out.println("Posicioninvalida");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa una posicion valida");
            }
        }
        juego.setPlataforma(Juego.Plataforma.values()[pos2-1]);
        System.out.println("Dato modificaco correctamente");
    }

    public void AgregarVideoJuego() {

    }
}
