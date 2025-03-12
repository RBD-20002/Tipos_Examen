import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Figura> Figuras = new LinkedList<>();

        Figuras.add(new Circulo(8));
        Figuras.add(new Rectangulo(9, 8));
        Figuras.add(new Triangulo(5, 10));

        for (Figura figura : Figuras) {
            System.out.println("Area: " + figura.calcularArea());
        }
    }
}