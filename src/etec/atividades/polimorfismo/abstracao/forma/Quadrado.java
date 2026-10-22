package etec.atividades.polimorfismo.abstracao.forma;

public class Quadrado extends Forma{
    private Integer lado;

    public Quadrado(String nome, Integer lado) {
        super(nome);
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return (lado + lado) * 2;
    }
}
