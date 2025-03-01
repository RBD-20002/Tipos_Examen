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
            return;
        }
        for(Libro libro : libros) {
            System.out.println(libro.toString());
        }
    }

    public void MostrarLibroAbreviado() {
        if(libros.isEmpty()) {
            System.out.println("No hay libros para editar");
            return;
        }
        for(int i = 0; i < libros.size(); i++) {
            System.out.println((i+1)+" "+libros.get(i).getTitulo()+" $"+libros.get(i).getPrecio());
        }
    }

    public void EliminarLibro() {
        if(libros.isEmpty()) {
            return;
        }
        MostrarLibroAbreviado();
        int pos = -1;
        while(pos < 1 || pos > libros.size()) {
            try{
                System.out.println("Elige la posicion del libro a eliminar");
                pos = Integer.parseInt(sc.nextLine());
                if(pos < 1 || pos > libros.size()) {
                    System.out.println("Posicion invalida, intenta denuvo");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un numero valido");
            }
        }
        libros.remove(pos-1);
        System.out.println("Libro eliminado correctamente");
    }

    public void EditarDatosLibros() {
        if(libros.isEmpty()) {
            System.out.println("No hay libros para editar");
            return;
        }
        System.out.println("Libros: ");
        MostrarLibroAbreviado();
        int pos2 = -1;
        while(pos2 < 1 || pos2 > libros.size()) {
            try {
                System.out.println("Elige el libro que quieres modificar: ");
                pos2 = Integer.parseInt(sc.nextLine());
                if(pos2 < 1 || pos2 > libros.size()) {
                    System.out.println("Posicion invalida, vuelve a intentarlo");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un numero valido");
            }
        }

        Libro elegido = libros.get(pos2-1);
        int opcion;
        do {
            Menu2();
            try {
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
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa una opcion valida");
                opcion = 0;
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
        int anoPub = 0;
        while(anoPub < 1000 || anoPub > 2025) {
            try {
                System.out.println("Introduce el nuevo año de publicacion: ");
                anoPub = Integer.parseInt(sc.nextLine());
                if(anoPub < 1000 || anoPub > 2025) {
                    System.out.println("El año es invalido, intenta de nuevo");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un numero valido");
            }
        }
        libro.setAnoPub(anoPub);
        System.out.println("Dato modificado correctamente");
    }

    public void ModificarNumPag(Libro libro) {
       int numPag = 0;
       while(numPag < 1) {
           try {
               System.out.println("Introduce el nuevo numero de paginas: ");
               numPag = Integer.parseInt(sc.nextLine());
               if(numPag < 0) {
                   System.out.println("El numero de paginas es invalido");
               }
           } catch (NumberFormatException e) {
               System.out.println("ERROR: Ingresa un numero valido");
           }
       }
        libro.setNumPag(numPag);
        System.out.println("Dato modificado correctamente");
    }

    public void ModificarPrecio(Libro libro) {
        double precio = 0;
        while(precio < 1) {
            try {
                System.out.println("Introduce el nuevo precio: ");
                precio = Double.parseDouble(sc.nextLine());
                if(precio < 1) {
                    System.out.println("El precio es invalido ");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un precio valido");
            }
        }
        libro.setPrecio(precio);
        System.out.println("Dato modificado correctamente");
    }

    public void FiltrarPorTitulo() {
        if(libros.isEmpty()) {
            System.out.println("No hay libros");
            return;
        }
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

    public void AgregarLibro() {
        String titulo = AgregarTitulo();
        String autor = AgregarAutor();
        int anoPub = AgregarAnoPub();
        int numPag = AgregarNumPag();
        double precio = AgregarPrecio();
        libros.add(new Libro(titulo,autor,anoPub,numPag,precio));
    }

    public String AgregarTitulo() {
        String titulo = "";
        while(titulo.isBlank()) {
            System.out.println("Introduce el titulo: ");
            titulo = sc.nextLine();
            if(titulo.isBlank()) {
                System.out.println("El dato no puede estar en blanco");
            }
        } return titulo;
    }

    public String AgregarAutor() {
        String autor = "";
        while(autor.isBlank()) {
            System.out.println("Introduce a los artistas: ");
            autor = sc.nextLine();
            if(autor.isBlank()) {
                System.out.println("El dato no puede estar en blanco");
            }
        } return autor;
    }

    public int AgregarAnoPub() {
        int anoPub = 0;
        while(anoPub < 1000 || anoPub > 2025) {
            try {
                System.out.println("Introduce el nuevo año de publicacion: ");
                anoPub = Integer.parseInt(sc.nextLine());
                if(anoPub < 1000 || anoPub > 2025) {
                    System.out.println("El año es invalido, intenta de nuevo");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un numero valido");
            }
        } return anoPub;
    }

    public int AgregarNumPag() {
        int numPag = 0;
        while(numPag < 1) {
            try {
                System.out.println("Introduce el nuevo numero de paginas: ");
                numPag = Integer.parseInt(sc.nextLine());
                if(numPag < 0) {
                    System.out.println("El numero de paginas es invalido");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un numero valido");
            }
        } return numPag;
    }

    public double AgregarPrecio() {
        double precio = 0;
        while(precio < 1) {
            try {
                System.out.println("Introduce el nuevo precio: ");
                precio = Double.parseDouble(sc.nextLine());
                if(precio < 1) {
                    System.out.println("El precio es invalido ");
                }
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Ingresa un precio valido");
            }
        } return precio;
    }
}
