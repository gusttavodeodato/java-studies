package etec.atividades.polimorfismo.abstracao.forma;

public abstract class Forma {
    protected String nome;

    public Forma(String nome) {
        this.nome = nome;
    }

    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    public void exibirInfo() {
        System.out.printf("%nNome da forma: %s - ", nome);
        System.out.printf("Area do %s: %.2f - ", nome, calcularArea());
        System.out.printf("Perimetro do %s: %.2f\n", nome, calcularPerimetro());
    }

}
