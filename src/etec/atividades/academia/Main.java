package etec.atividades.academia;

import etec.atividades.academia.enums.Tipo;

public class Main {
    public static void main(String[] args) {

        PlanoTreino plano = new PlanoTreino("Treino A", Tipo.MUSCULACAO);
        Aluno aluno1 = new Aluno("Gustavo", 22);

        System.out.printf("%nPlano: %s | Tipo: %s%n", plano.getNome(), plano.getTipo().getDescricao());
        /*System.out.printf(plano.getNome() + " - " + plano.getTipo() + " - Ativo: " + plano.isAtivo());*/
        aluno1.apresentar();
        plano.ativar();
    }
}
