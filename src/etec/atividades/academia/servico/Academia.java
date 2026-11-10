package etec.atividades.academia.servico;

import etec.atividades.academia.enums.Tipo;
import etec.atividades.academia.exception.RegistroNaoEncontradoException;
import etec.atividades.academia.funcionario.Funcionario;
import etec.atividades.academia.interfaces.Processavel;
import etec.atividades.academia.model.Aluno;
import etec.atividades.academia.model.Pagamento;
import etec.atividades.academia.model.PlanoTreino;
import etec.atividades.academia.util.Datas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Academia {
    public static final int MAX_PLANOS_POR_ALUNO = 3;
    public static final double MENSALIDADE_BASE = 120.00;
    public static final double VALOR_PLANO_EXTRA = 40.00;

    private final List<Aluno> alunos = new ArrayList<>();
    private final List<PlanoTreino> planos = new ArrayList<>();
    private final List<Funcionario> funcionarios = new ArrayList<>();
    private final List<Pagamento> pagamentos = new ArrayList<>();

    public Aluno cadastrarAluno(String nome, int idade, String telefone) {
        Aluno novo = new Aluno(nome, idade, telefone);
        verificarNomeLivre(novo.getNome(), null);
        alunos.add(novo);
        return novo;
    }

    public Aluno buscarAluno(String nome) {
        String procurado = nome == null ? "" : nome.trim();
        for (Aluno a : alunos) {
            if (a.getNome().equalsIgnoreCase(procurado)) {
                return a;
            }
        }
        throw new RegistroNaoEncontradoException("Aluno não encontrado: \"" + procurado + "\".");
    }

    public List<Aluno> pesquisarAlunos(String trecho) {
        List<Aluno> encontrados = new ArrayList<>();
        String t = trecho == null ? "" : trecho.trim().toLowerCase();
        for (Aluno a : alunos) {
            if (a.getNome().toLowerCase().contains(t)) {
                encontrados.add(a);
            }
        }
        return encontrados;
    }

    public void alterarAluno(Aluno aluno, String novoNome, Integer novaIdade, String novoTelefone) {
        String nome = novoNome != null ? novoNome : aluno.getNome();
        int idade = novaIdade != null ? novaIdade : aluno.getIdade();
        String telefone = novoTelefone != null ? novoTelefone : aluno.getTelefone();

        new Aluno(nome, idade, telefone);
        verificarNomeLivre(nome.trim(), aluno);

        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setTelefone(telefone);
    }

    public void removerAluno(Aluno aluno) {
        for (PlanoTreino p : new ArrayList<>(aluno.getPlanos())) {
            if (p.isAtivo()) {
                aluno.desativarPlano(p);
            }
            planos.remove(p);
        }
        alunos.remove(aluno);
    }

    private void verificarNomeLivre(String nome, Aluno ignorar) {
        for (Aluno a : alunos) {
            if (a != ignorar && a.getNome().equalsIgnoreCase(nome)) {
                throw new IllegalArgumentException("Já existe um aluno cadastrado com o nome \"" + nome + "\".");
            }
        }
    }

    public PlanoTreino cadastrarPlano(Aluno aluno, String nome, Tipo tipo, double valor) {
        PlanoTreino plano = new PlanoTreino(nome, tipo, valor);
        aluno.adicionarPlano(plano);
        planos.add(plano);
        return plano;
    }

    public void ativarPlano(Aluno aluno, String nomePlano) {
        aluno.ativarPlano(aluno.buscarPlano(nomePlano));
    }

    public void desativarPlano(Aluno aluno, String nomePlano) {
        aluno.desativarPlano(aluno.buscarPlano(nomePlano));
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário inválido.");
        }
        funcionarios.add(funcionario);
    }

    public double calcularMensalidade(Aluno aluno) {
        int ativos = aluno.getPlanosAtivos();
        return MENSALIDADE_BASE + Math.max(0, ativos - 1) * VALOR_PLANO_EXTRA;
    }

    public Pagamento registrarPagamento(Aluno aluno, double valorPago) {
        Pagamento pagamento = new Pagamento(aluno, calcularMensalidade(aluno));
        Processavel processavel = pagamento;
        processavel.processarPagamento(valorPago);
        pagamentos.add(pagamento);
        return pagamento;
    }

    public double totalArrecadado() {
        double total = 0;
        for (Pagamento p : pagamentos) {
            total += p.getValorPago();
        }
        return total;
    }

    public String gerarRelatorio() {
        int ativos = PlanoTreino.getTotalPlanosAtivos();
        StringBuilder sb = new StringBuilder();
        sb.append("========== RELATÓRIO GERAL DA ACADEMIA ==========\n");
        sb.append("Data: ").append(Datas.hoje()).append('\n');
        sb.append("Alunos cadastrados: ").append(alunos.size()).append('\n');
        sb.append("Planos cadastrados: ").append(planos.size()).append('\n');
        sb.append("  Ativos: ").append(ativos).append('\n');
        sb.append("  Inativos: ").append(planos.size() - ativos).append('\n');
        sb.append("Funcionários: ").append(funcionarios.size()).append('\n');
        sb.append("Pagamentos registrados: ").append(pagamentos.size()).append('\n');
        sb.append(String.format("Total arrecadado: R$ %.2f%n", totalArrecadado()));
        sb.append("Mensalidade base: R$ ").append(String.format("%.2f", MENSALIDADE_BASE)).append('\n');
        sb.append("Limite de planos ativos por aluno: ").append(MAX_PLANOS_POR_ALUNO).append('\n');
        sb.append("=================================================");
        return sb.toString();
    }

    public List<Aluno> getAlunos() {
        return Collections.unmodifiableList(alunos);
    }

    public List<PlanoTreino> getPlanos() {
        return Collections.unmodifiableList(planos);
    }

    public List<Funcionario> getFuncionarios() {
        return Collections.unmodifiableList(funcionarios);
    }

    public List<Pagamento> getPagamentos() {
        return Collections.unmodifiableList(pagamentos);
    }
}
