public class Alumno {

    private String nombre;
    private String apellidos;
    private double nota1;
    private double nota2;
    private double nota3;
    private double nota4;

    public Alumno(String nombre, String apellidos, double nota1, double nota2, double nota3, double nota4) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public double getNota1() {
        return nota1;
    }
    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }
    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }
    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public double getNota4() {
        return nota4;
    }
    public void setNota4(double nota4) {
        this.nota4 = nota4;
    }

    public String capitalize(String s) {
        return s.substring(0,1).toUpperCase()+s.substring(1).toLowerCase();
    }

    public String toString() {
        String sb = capitalize(apellidos) + ", " + capitalize(nombre) +
                "\nTema 1: " + String.format("%.2f", nota1) +
                "\nTema 2: " + String.format("%.2f", nota2) +
                "\nTema 3: " + String.format("%.2f", nota3) +
                "\nTema 4: " + String.format("%.2f", nota4);
        return sb;
    }
}
