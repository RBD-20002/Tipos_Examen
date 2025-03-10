public class Album {

    private String titulo;
    private String artistas;
    private int anoPub;
    private int numCan;

    public Album(String titulo, String artistas, int anoPub, int numCan) {
        this.titulo = titulo;
        this.artistas = artistas;
        this.anoPub = anoPub;
        this.numCan = numCan;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtistas() {
        return artistas;
    }
    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }

    public int getAnoPub() {
        return anoPub;
    }
    public void setAnoPub(int anoPub) {
        if(anoPub < 1800 || anoPub > 2026) {
            System.out.println("El año es invalido");
        } else this.anoPub = anoPub;
    }

    public int getNumCan() {
        return numCan;
    }
    public void setNumCan(int numCan) {
        if(numCan < 1) {
            System.out.println("El numero de canciones invalido");
        } else this.numCan = numCan;
    }

    public String toString() {
        String sb = "Album: " +
                "\n Titulo: " + titulo +
                "\n Artistas: " + artistas +
                "\n Año de publicacion: " + anoPub +
                "\n Cantidad de canciones: " + numCan;
        return sb;
    }
}
