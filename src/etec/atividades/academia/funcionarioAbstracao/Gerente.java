package etec.atividades.academia.funcionarioAbstracao;

public class Gerente extends Funcionario {

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public double calcularBonus() {
        return salario * 4.50;
    }

    @Override
    public void mostrarDados() {
        System.out.printf("Gerente: %s - Salário: R$%.2f%n", nome, salario);
    }

}
