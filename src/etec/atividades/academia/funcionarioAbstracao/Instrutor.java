package etec.atividades.academia.funcionarioAbstracao;

public class Instrutor extends Funcionario {

    public Instrutor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
       return salario * 0.50;
    }

    @Override
    public void mostrarDados() {
        double salarioBonus = salario + calcularBonus();
        System.out.printf("Instrutor: %s - Salário: R$%.2f%n", nome, salarioBonus);
    }
}
