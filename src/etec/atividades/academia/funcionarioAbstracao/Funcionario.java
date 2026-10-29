package etec.atividades.academia.funcionarioAbstracao;

import etec.atividades.academia.interfaces.Pagamento;

public abstract class Funcionario implements Pagamento {
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

    @Override
    public void processarPagamento(double valor) {
        System.out.printf("\nProcessando pagamento de -> R$%.2f\n", valor);
    }
}