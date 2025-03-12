public class Triangulo implements Figura {

    private final double base;
    private final double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (1 / 2) * base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return base + altura + Math.sqrt(base * base + altura * altura);
    }
}
