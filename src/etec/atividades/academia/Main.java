package etec.atividades.academia;

import etec.atividades.academia.enums.Tipo;
import etec.atividades.academia.funcionarioAbstracao.Funcionario;
import etec.atividades.academia.funcionarioAbstracao.Gerente;
import etec.atividades.academia.funcionarioAbstracao.Instrutor;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        System.out.print("\n------ Dados do Aluno -------");
        PlanoTreino plano = new PlanoTreino("Treino A", Tipo.MUSCULACAO);
        Aluno aluno1 = new Aluno("Rakim", 22);

        System.out.printf("%nPlano: %s | Tipo: %s%n", plano.getNome(), plano.getTipo().getDescricao());
        aluno1.apresentar();
        plano.ativar();

        System.out.print("\n------ Dados do Instrutor -------");
        Funcionario instrutor = new Instrutor("Gustavo", 1000);
        instrutor.processarPagamento(1500);
        instrutor.mostrarDados();
        instrutor.calcularBonus();

        System.out.print("\n------ Dados do Gerente -------");
        Funcionario gerente = new Gerente("Larissa", 5000);
        gerente.processarPagamento(5000);
        gerente.mostrarDados();
        gerente.calcularBonus();
    }
}
