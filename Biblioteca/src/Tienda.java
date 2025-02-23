import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

    ArrayList<Libro> libros = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void Menu1() {
        System.out.println("|       BIENVENIDO       |");
        System.out.println("|1. Mostrar Libros       |");
        System.out.println("|2. Añadir Libro         |");
        System.out.println("|3. Editar datos de libro|");
        System.out.println("|4. Eliminar un libro    |");
        System.out.println("|5. Filtrar por nombre   |");
        System.out.println("|6. Salir                |");
    }
    public void Menu2() {
        System.out.println("|   MODIFICAR DATOS   |");
        System.out.println("|1. Titulo            |");
        System.out.println("|2. Autor             |");
        System.out.println("|3. Año de publicacion|");
        System.out.println("|4. Numero de paginas |");
        System.out.println("|5. Precio            |");
        System.out.println("|6. Volver al inicio  |");
    }

    public void MostrarLibros() {
        for(Libro libro : libros) {
            System.out.println(libro.toString());
        }
    }
    public void MostrarLibroAbreviado() {
        for(int i = 0; i < libros.size(); i++) {
            System.out.println((i+1)+" "+libros.get(i).getTitulo()+" $"+libros.get(i).getPrecio());
        }
    }

    public void EliminarLibro() {
        MostrarLibroAbreviado();
        int pos = Integer.parseInt(sc.nextLine());
        while(pos > libros.size()) {
            System.out.println("Posicion invalida, vuelve a intentarlo");
            pos = Integer.parseInt(sc.nextLine());
        }
        libros.remove(pos-1);
        System.out.println("Libro eliminado correctamente");
    }

    public void AgregarLibro() {
        System.out.println("Introduce el titulo del libro: ");
        String titulo = sc.nextLine();
        System.out.println("-".repeat(30));

        System.out.println("Introduce el autor del libro: ");
        String autor = sc.nextLine();
        System.out.println("-".repeat(30));

        System.out.println("Introduce el año de publicacion: ");
        int anoPub = Integer.parseInt(sc.nextLine());
        System.out.println("-".repeat(30));

        System.out.println("Introduce el numero de paginas: ");
        int numPag = Integer.parseInt(sc.nextLine());
        System.out.println("-".repeat(30));

        System.out.println("Introduce el precio del libro: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.println("-".repeat(30));

        libros.add(new Libro(titulo,autor,anoPub,numPag,precio));
    }

}
