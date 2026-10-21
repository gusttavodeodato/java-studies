package etec.atividades.heranca.funcionario;

public class Gerente extends Funcionario {
    private final double bonus;

    public double getBonus() {
        return bonus;
    }

    public Gerente(String nome, double salario, double bonus) {
        super(nome, salario);
        this.bonus = bonus;
    }

    @Override
    public void exibirInfo() {
        System.out.printf("\nNome: %s - Salário: %.2f - Bônus: %.1f%n", getNome(), getSalario(), bonus);
    }
}
