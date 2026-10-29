package etec.atividades.abstracao.forma;

public class Retangulo extends Forma{
    private double largura;
    private double altura;

    public Retangulo(String nome, double largura, double altura) {
        super(nome);
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return largura * altura;
    }

    @Override
    public double calcularPerimetro() {
        return (largura + altura) * 2;
    }
}
