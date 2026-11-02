package etec.atividades.academia;

import java.util.List;

public class Aluno {
    private String nome;
    private int idade;
    private List<PlanoTreino> planos;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void apresentar() {
        System.out.println("Aluno: " + nome);
        System.out.println("Idade: " + idade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
