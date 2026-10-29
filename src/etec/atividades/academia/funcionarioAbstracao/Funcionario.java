package etec.atividades.academia.funcionarioAbstracao;

public abstract class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public double calcularBonus() {
        return salario * 0.1;
    }

    public void mostrarDados() {
        System.out.printf("Funcionário: %s - Salário com bônus: %.2f\n", nome, salario);
    }
}
