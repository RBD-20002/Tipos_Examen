import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Double> Area = new HashMap<>();
        HashMap<String, Double> Perimetro = new HashMap<>();

        Figura circulo = new Circulo(4);
        Figura rectangulo = new Rectangulo(4, 6);
        Figura triangulo = new Triangulo(5, 8);

        Area.put("Circulo", circulo.calcularArea());
        Area.put("Rectangulo", rectangulo.calcularArea());
        Area.put("Triangulo", triangulo.calcularArea());

        Perimetro.put("Circulo", circulo.calcularPerimetro());
        Perimetro.put("Rectangulo", rectangulo.calcularPerimetro());
        Perimetro.put("Triangulo", triangulo.calcularPerimetro());

        for (String figura : Area.keySet()) {
            System.out.println("Area de " + figura + " :" + Area.get(figura));
        }

        for (String figura : Perimetro.keySet()) {
            System.out.println("Area de " + figura + " :" + Perimetro.get(figura));
        }

    }
}