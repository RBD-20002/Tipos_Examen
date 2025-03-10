import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

    ArrayList<Album> albumnes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void Menu1() {
        System.out.println("|     BIENVENIDO     |");
        System.out.println("|1. Mostrar Albumnes |");
        System.out.println("|2. Crear Albumnes   |");
        System.out.println("|3. Editar Albumnes  |");
        System.out.println("|4. Eliminar Albumnes|");
        System.out.println("|5. Salir            |");
    }

    public void Menu2() {
        System.out.println("|         DATOS        |");
        System.out.println("|1. Titulo             |");
        System.out.println("|2. Artistas           |");
        System.out.println("|3. Año de publicacion |");
        System.out.println("|4. Numero de canciones|");
        System.out.println("|5. Volver atras       |");
    }

    public void MostrarAlbumnes() {
        if(albumnes.isEmpty()) {
            System.out.println("No hay nada para mostrar");
            return;
        }
        for(int i = 0; i < albumnes.size(); i++) {
            System.out.println((i+1)+" "+albumnes.get(i).toString());
        }
    }

    public void MostrarAlbumnes2() {
        if(albumnes.isEmpty()) {
            System.out.println("No hay nada para mostrar");
            return;
        }
        for(int i = 0; i <albumnes.size(); i++) {
            System.out.println((i+1)+" "+albumnes.get(i).getTitulo());
        }
    }

    public void EliminarAlbumnes() {
        if(albumnes.isEmpty()) {
            System.out.println("No hay nada para eliminar");
            return;
        }
        MostrarAlbumnes2();

        int pos = -1;
        while(pos < 1 ||pos > albumnes.size()) {
           try{
               System.out.println("Introduce la posicion del album a eliminar: ");
               pos = Integer.parseInt(sc.nextLine());
               if(pos < 1 || pos > albumnes.size()) {
                   System.out.println("Posicion no valida");
               }
           } catch (NumberFormatException e) {
               System.out.println("ERROR: Ingrese un dato que sea valido");
           }
        }
        albumnes.remove(pos-1);
        System.out.println("Album eliminado correctamente");
    }

    public void EditarAlbum() {
        if(albumnes.isEmpty()) {
            System.out.println("No hay nada para editar");
            return;
        }

        System.out.println("Albums: ");
        MostrarAlbumnes2();

        int pos = -1;
        while(pos < 1 ||pos > albumnes.size()) {
            try {
                System.out.println("Introduce la posicion del album a editar: ");
                pos = Integer.parseInt(sc.nextLine());
                if(pos < 1 || pos > albumnes.size()) {
                    System.out.println("Posicion no valida");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingrese un dato que sea valido");
            }
        }

        Album elegido = albumnes.get(pos-1);
        int opcion;
        do {
            Menu2();
            try{
                System.out.println("Elige que datos quieres modificar: ");
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1 -> ModificarTitulo(elegido);
                    case 2 -> ModificarArtista(elegido);
                    case 3 -> ModificarAnoPub(elegido);
                    case 4 -> ModificarNumCan(elegido);
                    case 5 -> System.out.println("Hasta luego");
                    default -> System.out.println("Opcion no valida");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingrese un dato que sea valido");
                opcion = 0;
            }
        } while(opcion != 5);

    }

    public void ModificarTitulo(Album elegido) {
        System.out.println("Introduce el nuevo tituo: ");
        elegido.setTitulo(sc.nextLine());
        System.out.println("Titulo modificado correctamente");
    }

    public void ModificarArtista(Album elegido) {
        System.out.println("Introduce el nuevo o nuevos artistas: ");
        elegido.setArtistas(sc.nextLine());
        System.out.println("Artista modificado correctamente");
    }

    public void ModificarAnoPub(Album elegido) {
        int anoPub = 0;
        while(anoPub < 1930) {
            try {
                System.out.println("Introduce el nuevo año de publicacion: ");
                anoPub = Integer.parseInt(sc.nextLine());
                if(anoPub < 1930) {
                    System.out.println("El año es invalido");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingrese un dato valido");
            }
        }
        elegido.setAnoPub(anoPub);
        System.out.println("Ano de publicacion modificado correctamente");
    }

    public void ModificarNumCan(Album elegido) {
        int numCan = 0;
        while(numCan < 1) {
            try {
                System.out.println("Introduce el numero nuevo de canciones: ");
                numCan = Integer.parseInt(sc.nextLine());
                if(numCan < 1) {
                    System.out.println("Numero de canciones invalido");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingrese un dato valido");
            }
        }
        elegido.setNumCan(numCan);
        System.out.println("Num de canciones modificado correctamente");
    }

    public void AgregarAlbum() {
        String titulo = IngresarTitulo();
        String artistas = IngresarArtistas();
        int anoPub = IngresarAnoPub();
        int numCan = IngresarNumCan();
        albumnes.add(new Album(titulo,artistas,anoPub,numCan));
    }

    public String IngresarTitulo() {
        String titulo = "";
        while(titulo.isBlank()) {
            System.out.println("Introduce el titulo: ");
            titulo = sc.nextLine();
            if(titulo.isBlank()) {
                System.out.println("El dato no puede estar en blanco");
            }
        } return titulo;
    }

    public String IngresarArtistas() {
        String artistas = "";
        while(artistas.isBlank()) {
            System.out.println("Introduce los nombres de artistas: ");
            artistas = sc.nextLine();
            if(artistas.isBlank()) {
                System.out.println("El dato no puede estar en blanco");
            }
        } return artistas;
    }

    public int IngresarAnoPub() {
        int anoPub = 0;
        while(anoPub < 1930) {
            try{
                System.out.println("Ingrese el año de publicacion: ");
                anoPub = Integer.parseInt(sc.nextLine());
                if(anoPub < 1930) {
                    System.out.println("El ano es invalido");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingrese un dato valido");
            }
        }
        return anoPub;
    }

    public int IngresarNumCan() {
        int numCan = 0;
        while(numCan < 1) {
            try {
                System.out.println("Ingresa el numero de canciones: ");
                numCan = Integer.parseInt(sc.nextLine());
                if(numCan < 1) {
                    System.out.println("Numero de canciones invalido");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingrese un dato valido");
            }
        }
        return numCan;
    }
}
