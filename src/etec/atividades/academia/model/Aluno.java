package etec.atividades.academia.model;

import etec.atividades.academia.exception.RegistroNaoEncontradoException;
import etec.atividades.academia.model.PlanoTreino;
import etec.atividades.academia.servico.Academia;
import etec.atividades.academia.util.Datas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aluno {
    private static final int QTD_NOTAS = 5;

    private String nome;
    private int idade;
    private String telefone;
    private final LocalDate dataCadastro;
    private int planosAtivos;
    private final List<PlanoTreino> planos = new ArrayList<>();
    private final double[] notasAvaliacao = new double[QTD_NOTAS];
    private boolean avaliacaoRegistrada;

    public Aluno(String nome, int idade, String telefone) {
        setNome(nome);
        setIdade(idade);
        setTelefone(telefone);
        this.dataCadastro = LocalDate.now();
        this.planosAtivos = 0;
    }

    public void adicionarPlano(PlanoTreino plano) {
        if (plano == null) {
            throw new IllegalArgumentException("Plano inválido.");
        }
        for (PlanoTreino p : planos) {
            if (p.getNome().equalsIgnoreCase(plano.getNome())) {
                throw new IllegalArgumentException(
                        "O aluno " + nome + " já possui um plano chamado \"" + plano.getNome() + "\".");
            }
        }
        planos.add(plano);
    }

    public PlanoTreino buscarPlano(String nomePlano) {
        for (PlanoTreino p : planos) {
            if (p.getNome().equalsIgnoreCase(nomePlano == null ? "" : nomePlano.trim())) {
                return p;
            }
        }
        throw new RegistroNaoEncontradoException(
                "O aluno " + nome + " não possui o plano \"" + nomePlano + "\".");
    }

    public void ativarPlano(PlanoTreino plano) {
        if (!planos.contains(plano)) {
            throw new IllegalArgumentException("Esse plano não pertence ao aluno " + nome + ".");
        }
        if (plano.isAtivo()) {
            throw new IllegalStateException("O plano \"" + plano.getNome() + "\" já está ativo.");
        }
        if (planosAtivos >= Academia.MAX_PLANOS_POR_ALUNO) {
            throw new IllegalStateException("O aluno " + nome + " já atingiu o limite de "
                    + Academia.MAX_PLANOS_POR_ALUNO + " planos ativos.");
        }
        plano.ativar();
        planosAtivos++;
    }

    public void desativarPlano(PlanoTreino plano) {
        if (!planos.contains(plano)) {
            throw new IllegalArgumentException("Esse plano não pertence ao aluno " + nome + ".");
        }
        plano.desativar();
        planosAtivos--;
    }

    public void setNotasAvaliacao(double[] notas) {
        if (notas == null || notas.length != QTD_NOTAS) {
            throw new IllegalArgumentException("São necessárias exatamente " + QTD_NOTAS + " notas.");
        }
        for (double n : notas) {
            if (!(n >= 0 && n <= 10)) {
                throw new IllegalArgumentException("Cada nota deve estar entre 0 e 10.");
            }
        }
        for (int i = 0; i < QTD_NOTAS; i++) {
            notasAvaliacao[i] = notas[i];
        }
        avaliacaoRegistrada = true;
    }

    public double calcularMediaNotas() {
        double soma = 0;
        for (int i = 0; i < notasAvaliacao.length; i++) {
            soma += notasAvaliacao[i];
        }
        return soma / notasAvaliacao.length;
    }

    public static int getQtdNotas() {
        return QTD_NOTAS;
    }


    public void apresentar() {
        System.out.println("Aluno: " + nome.toUpperCase() + " (" + nome.length() + " caracteres)");
        System.out.println("  Idade: " + idade + " anos");
        System.out.println("  Telefone: " + telefone);
        System.out.println("  Cadastro: " + Datas.formatar(dataCadastro)
                + " (há " + Datas.tempoDesde(dataCadastro) + ")");
        System.out.println("  Planos ativos: " + planosAtivos + "/" + Academia.MAX_PLANOS_POR_ALUNO);
        if (planos.isEmpty()) {
            System.out.println("  Planos cadastrados: nenhum");
        } else {
            System.out.println("  Planos cadastrados:");
            for (PlanoTreino p : planos) {
                System.out.println("    - " + p);
            }
        }
        if (avaliacaoRegistrada) {
            System.out.printf("  Média da avaliação física: %.2f%n", calcularMediaNotas());
        } else {
            System.out.println("  Avaliação física: não registrada");
        }
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do aluno não pode ser vazio.");
        }
        this.nome = nome.trim();
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade <= 0 || idade > 120) {
            throw new IllegalArgumentException("Idade inválida: " + idade + " (deve ser maior que zero).");
        }
        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("O telefone não pode ser vazio.");
        }
        this.telefone = telefone.trim();
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public int getPlanosAtivos() {
        return planosAtivos;
    }

    public List<PlanoTreino> getPlanos() {
        return Collections.unmodifiableList(planos);
    }
}
