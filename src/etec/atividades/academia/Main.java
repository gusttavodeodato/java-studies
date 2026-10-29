package etec.atividades.academia;

import etec.atividades.academia.enums.Tipo;
import etec.atividades.academia.funcionarioAbstracao.Funcionario;
import etec.atividades.academia.funcionarioAbstracao.Instrutor;

public class Main {
    public static void main(String[] args) {

        PlanoTreino plano = new PlanoTreino("Treino A", Tipo.MUSCULACAO);
        Aluno aluno1 = new Aluno("Gustavo", 22);

        System.out.printf("%nPlano: %s | Tipo: %s%n", plano.getNome(), plano.getTipo().getDescricao());
        aluno1.apresentar();
        plano.ativar();

        Funcionario instrutor = new Instrutor("Gustavo", 1000);
        instrutor.mostrarDados();
        instrutor.calcularBonus();
    }
}
