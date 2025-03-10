public class Libro {
    private String titulo;
    private String autor;
    private int anoPub;
    private int numPag;
    private double precio;

    public Libro(String titulo, String autor, int anoPub, int numPag, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        setAnoPub(anoPub);
        setNumPag(numPag);
        setPrecio(precio);
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPub() {
        return anoPub;
    }
    public void setAnoPub(int anoPub) {
        if(anoPub >= 1000 && anoPub <= 2025) {
            this.anoPub = anoPub;
        } else System.out.println("El año del libro es invalido");
    }

    public int getNumPag() {
        return numPag;
    }
    public void setNumPag(int numPag) {
        if(numPag <= 0) {
            System.out.println("El numero de paginas del libro es invalido");
        } else this.numPag = numPag;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        if(precio <= 0) {
            System.out.println("El precio es invalido para el libro");
        } else this.precio = precio;
    }

    public String toString() {
        String sb = "Libro: " +
                "\n Titulo: " + titulo +
                "\n Autor: " + autor +
                "\n Año de publicacion: " + anoPub +
                "\n Numero de paginas: " + numPag +
                "\n Precio: " + precio;
        return sb;
    }
}
