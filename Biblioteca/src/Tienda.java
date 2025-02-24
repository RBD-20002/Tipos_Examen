import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {

    ArrayList<Libro> libros = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void Menu1() {
        System.out.println(" ________________________");
        System.out.println("|       BIENVENIDO       |");
        System.out.println("|1. Mostrar Libros       |"); /*H*/
        System.out.println("|2. Añadir Libro         |"); /*H*/
        System.out.println("|3. Editar datos de libro|"); /*H*/
        System.out.println("|4. Eliminar un libro    |"); /*H*/
        System.out.println("|5. Filtrar por nombre   |"); /*H*/
        System.out.println("|6. Numero de libros     |"); /*H*/
        System.out.println("|7. Salir                |"); /*H*/
        System.out.println(" ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
    }
    public void Menu2() {
        System.out.println("|   MODIFICAR DATOS   |");
        System.out.println("|1. Titulo            |"); /*H*/
        System.out.println("|2. Autor             |"); /*H*/
        System.out.println("|3. Año de publicacion|"); /*H*/
        System.out.println("|4. Numero de paginas |"); /*H*/
        System.out.println("|5. Precio            |"); /*H*/
        System.out.println("|6. Volver al inicio  |"); /*H*/
    }

    public void MostrarLibros() {
        if(libros.isEmpty()) {
            System.out.println("No hay libros para mostrar");
        }
        for(Libro libro : libros) {
            System.out.println(libro.toString());
        }
    }
    public void MostrarLibroAbreviado() {
        if(libros.isEmpty()) {
            System.out.println("No hay libros para editar");
        }
        for(int i = 0; i < libros.size(); i++) {
            System.out.println((i+1)+" "+libros.get(i).getTitulo()+" $"+libros.get(i).getPrecio());
        }
    }

    public void EliminarLibro() {
        if(libros.isEmpty()) {
            System.out.println("No hay libros para eliminar");
            return;
        }
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
        while(!Libro.ValidarAnoPub(anoPub)) {
            System.out.println("El año es invalido, vuelve a intentar");
            anoPub = Integer.parseInt(sc.nextLine());
        }
        System.out.println("-".repeat(30));

        System.out.println("Introduce el numero de paginas: ");
        int numPag = Integer.parseInt(sc.nextLine());
        while(!Libro.ValidarNumPag(numPag)) {
            System.out.println("El numero de paginas es invalido, vuelve a intentar");
            numPag = Integer.parseInt(sc.nextLine());
        }
        System.out.println("-".repeat(30));

        System.out.println("Introduce el precio del libro: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.println("-".repeat(30));

        libros.add(new Libro(titulo,autor,anoPub,numPag,precio));
    }

    public void EditarDatosLibros() {
        if(libros.isEmpty()) {
            System.out.println("No hay libros almacenados");
            return;
        }
        MostrarLibroAbreviado();
        System.out.println("Elige el libro que quieres modificar: ");
        int pos = Integer.parseInt(sc.nextLine());
        while(pos > libros.size()) {
            System.out.println("Posicion invalida");
            pos = Integer.parseInt(sc.nextLine());
        }

        Libro elegido = libros.get(pos-1);
        int opcion;

        do {
            Menu2();
            System.out.println("Elige que dato quieres modificar (o 6 para volver): ");
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> ModificarTitulo(elegido);
                case 2 -> ModificarAutor(elegido);
                case 3 -> ModificarAnoPub(elegido);
                case 4 -> ModificarNumPag(elegido);
                case 5 -> ModificarPrecio(elegido);
                case 6 -> System.out.println("Hasta luego");
                default -> System.out.println("Opcion invalida, vuelve a intentar");
            }
        } while(opcion != 6);
    }
    public void ModificarTitulo(Libro libro) {
        System.out.println("Introduce el nuevo titulo: ");
        libro.setTitulo(sc.nextLine());
        System.out.println("Dato modificado correctamente");
    }
    public void ModificarAutor(Libro libro) {
        System.out.println("Introduce el nuevo autor: ");
        libro.setAutor(sc.nextLine());
        System.out.println("Dato modificado correctamente");
    }
    public void ModificarAnoPub(Libro libro) {
        System.out.println("Introduce el nuevo año de publicacion: ");
        int anoPub = Integer.parseInt(sc.nextLine());
        while(anoPub <= 1000 || anoPub > 2025) {
            System.out.println("El año es invalido, vuelve a intentar");
            anoPub = Integer.parseInt(sc.nextLine());
        }
        libro.setAnoPub(anoPub);
        System.out.println("Dato modificado correctamente");
    }
    public void ModificarNumPag(Libro libro) {
        System.out.println("Introduce el nuevo numero de paginas: ");
        int numPag = Integer.parseInt(sc.nextLine());
        while(numPag < 1) {
            System.out.println("El numero de paginas es invalido, vuelve a intentarlo");
            numPag = Integer.parseInt(sc.nextLine());
        }
        libro.setNumPag(numPag);
        System.out.println("Dato modificado correctamente");
    }
    public void ModificarPrecio(Libro libro) {
        System.out.println("Introduce el nuevo precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        while(precio < 1) {
            System.out.println("El precio es invalido, vuelve a intentar");
            precio = Double.parseDouble(sc.nextLine());
        }
        libro.setPrecio(precio);
        System.out.println("Dato modificado correctamente");
    }

    public void FiltrarPorTitulo() {
        System.out.println("Introduce un titulo: ");
        String tituloPro = sc.nextLine().toLowerCase();

        boolean encontrado = false;
        for(int i = 0; i < libros.size(); i++) {
            if(libros.get(i).getTitulo().toLowerCase().contains(tituloPro)) {
            System.out.println((i+1)+" "+libros.get(i).getTitulo()+" $"+libros.get(i).getPrecio());
            encontrado = true;
            }
        }
        if(!encontrado) {
            System.out.println("No se encuentran libros que tienen ese titulo: "+tituloPro);
        }
    }

    public void NumeroDeLibros() {
        System.out.println("El numero de libros es: "+libros.size());
    }
}
