package etec.atividades.heranca.funcionario;

public class Estagiario extends Funcionario {
    private final int horasTrabalhadas;

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public Estagiario(String nome, double salario, int horasTrabalhadas) {
        super(nome, salario);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public void exibirInfo() {
        System.out.printf("\nNome: %s - Salário: %.2f - Horas Trabalhadas: %dh%n", getNome(), getSalario(), horasTrabalhadas);
    }
}
