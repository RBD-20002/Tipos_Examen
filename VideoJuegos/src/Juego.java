public class Juego {
    private String titulo;
    private int anoPub;
    private Plataforma plataforma;
    private double precio;

    public enum Plataforma {
        PS3,PS2,SWITCH,PC,NINTENDO
    }

    public Juego(String titulo,int anoPub, Plataforma plataforma, double precio) {
        this.titulo = titulo;
        this.anoPub = anoPub;
        this.plataforma = plataforma;
        this.precio = precio;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPub() {
        return anoPub;
    }
    public void setAnoPub(int anoPub) {
        if(anoPub < 1984) {
            System.out.println("El año es invalido");
        } else this.anoPub = anoPub;
    }

    public Plataforma getPlataforma() {
        return  plataforma;
    }
    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        if(precio < 1) {
            System.out.println("El precio es invalido");
        } else this.precio = precio;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VideoJuego: ")
                .append("\n Titulo: ").append(titulo)
                .append("\n Año de publicacion: ").append(anoPub)
                .append("\n Plataforma: ").append(plataforma)
                .append("\n Precio: ").append(precio);
        return sb.toString();
    }

}
