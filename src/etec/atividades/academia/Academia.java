package etec.atividades.academia;

import java.util.List;

public class Academia {
    static final int MAX_PLANOS_POR_ALUNO = 3;
    static final double MENSALIDADE_BASE = 120.0;

    public void adicionarPlano(String nome, List<PlanoTreino> planos) {
        if(planos.size() >= MAX_PLANOS_POR_ALUNO) {
            System.out.println("O aluno %s já atingiu o limite de planos!");
        }
    }



}
