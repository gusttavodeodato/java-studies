package etec.atividades.academia.funcionario;

public class Gerente extends Funcionario{

    public static final double BONUS_GERENTE = 0.15;

    private double bonus;

    public Gerente(String nome, double salario) {
        super(nome, salario);
        this.bonus = calcularBonus();
    }

    @Override
    public double calcularBonus() {
        bonus = getSalario() * BONUS_GERENTE;
        return bonus;
    }

    public double getBonus() {
        return bonus;
    }
}
