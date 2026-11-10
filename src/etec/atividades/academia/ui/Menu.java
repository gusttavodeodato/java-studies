package etec.atividades.academia.ui;

import etec.atividades.academia.enums.Tipo;
import etec.atividades.academia.exception.RegistroNaoEncontradoException;
import etec.atividades.academia.funcionario.Funcionario;
import etec.atividades.academia.funcionario.Gerente;
import etec.atividades.academia.funcionario.Instrutor;
import etec.atividades.academia.model.Aluno;
import etec.atividades.academia.model.Pagamento;
import etec.atividades.academia.servico.Academia;
import etec.atividades.academia.util.Datas;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Academia academia;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(Academia academia) {
        this.academia = academia;
    }

    public void executar() {
        int opcao;
        do {
            exibirMenu();
            opcao = lerInt("Escolha uma opção: ");
            System.out.println();
            try {
                switch (opcao) {
                    case 1:
                        cadastrarAluno();
                        break;
                    case 2:
                        consultarAlunos();
                        break;
                    case 3:
                        cadastrarPlano();
                        break;
                    case 4:
                        ativarPlano();
                        break;
                    case 5:
                        desativarPlano();
                        break;
                    case 6:
                        cadastrarFuncionario();
                        break;
                    case 7:
                        consultarFuncionarios();
                        break;
                    case 8:
                        calcularBonus();
                        break;
                    case 9:
                        registrarPagamento();
                        break;
                    case 10:
                        consultarPagamentos();
                        break;
                    case 11:
                        System.out.println(academia.gerarRelatorio());
                        break;
                    case 12:
                        pesquisarAluno();
                        break;
                    case 13:
                        alterarAluno();
                        break;
                    case 14:
                        removerAluno();
                        break;
                    case 15:
                        registrarAvaliacao();
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema. Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida! Escolha um número do menu.");
                }
            } catch (IllegalArgumentException | IllegalStateException | RegistroNaoEncontradoException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println();
        System.out.println("====================================");
        System.out.println("       SISTEMA DE ACADEMIA");
        System.out.println("       Hoje: " + Datas.hoje());
        System.out.println("====================================");
        System.out.println();
        System.out.println(" 1 - Cadastrar aluno");
        System.out.println(" 2 - Consultar alunos");
        System.out.println(" 3 - Cadastrar plano de treino");
        System.out.println(" 4 - Ativar plano");
        System.out.println(" 5 - Desativar plano");
        System.out.println(" 6 - Cadastrar funcionário");
        System.out.println(" 7 - Consultar funcionários");
        System.out.println(" 8 - Calcular bônus");
        System.out.println(" 9 - Registrar pagamento");
        System.out.println("10 - Consultar pagamentos");
        System.out.println("11 - Relatório geral");
        System.out.println("12 - Pesquisar aluno por nome");
        System.out.println("13 - Alterar dados do aluno");
        System.out.println("14 - Remover aluno");
        System.out.println("15 - Registrar avaliação física");
        System.out.println(" 0 - Sair");
        System.out.println();
        System.out.println("====================================");
    }

    private void cadastrarAluno() {
        String nome = lerTexto("Nome: ");
        int idade = lerInt("Idade: ");
        String telefone = lerTexto("Telefone: ");
        Aluno aluno = academia.cadastrarAluno(nome, idade, telefone);
        System.out.println("Aluno " + aluno.getNome().toUpperCase() + " cadastrado em "
                + Datas.formatar(aluno.getDataCadastro()) + ".");
    }

    private void consultarAlunos() {
        List<Aluno> alunos = academia.getAlunos();
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (Aluno a : alunos) {
            a.apresentar();
            System.out.println();
        }
    }

    private void pesquisarAluno() {
        String trecho = lerTexto("Digite o nome (ou parte dele): ");
        List<Aluno> encontrados = academia.pesquisarAlunos(trecho);
        if (encontrados.isEmpty()) {
            System.out.println("Nenhum aluno encontrado para \"" + trecho + "\".");
            return;
        }
        System.out.println(encontrados.size() + " aluno(s) encontrado(s):");
        for (Aluno a : encontrados) {
            a.apresentar();
            System.out.println();
        }
    }

    private void alterarAluno() {
        Aluno aluno = academia.buscarAluno(lerTexto("Nome do aluno a alterar: "));
        System.out.println("(Deixe em branco para manter o valor atual)");

        String nome = lerTexto("Novo nome [" + aluno.getNome() + "]: ");
        Integer idade = null;
        String txtIdade = lerTexto("Nova idade [" + aluno.getIdade() + "]: ");
        if (!txtIdade.isEmpty()) {
            try {
                idade = Integer.parseInt(txtIdade);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Idade inválida: digite apenas números inteiros.");
            }
        }
        String telefone = lerTexto("Novo telefone [" + aluno.getTelefone() + "]: ");

        academia.alterarAluno(aluno,
                nome.isEmpty() ? null : nome,
                idade,
                telefone.isEmpty() ? null : telefone);
        System.out.println("Dados do aluno atualizados.");
    }

    private void removerAluno() {
        Aluno aluno = academia.buscarAluno(lerTexto("Nome do aluno a remover: "));
        academia.removerAluno(aluno);
        System.out.println("Aluno " + aluno.getNome() + " removido (os planos dele também foram removidos).");
    }

    private void registrarAvaliacao() {
        Aluno aluno = academia.buscarAluno(lerTexto("Nome do aluno: "));
        double[] notas = new double[Aluno.getQtdNotas()];
        for (int i = 0; i < notas.length; i++) {
            notas[i] = lerDouble("Nota " + (i + 1) + " (0 a 10): ");
        }
        aluno.setNotasAvaliacao(notas);
        System.out.printf("Avaliação registrada. Média: %.2f%n", aluno.calcularMediaNotas());
    }

    private void cadastrarPlano() {
        Aluno aluno = academia.buscarAluno(lerTexto("Nome do aluno dono do plano: "));
        String nome = lerTexto("Nome do plano: ");

        Tipo[] tipos = Tipo.values();
        System.out.println("Tipos disponíveis:");
        for (int i = 0; i < tipos.length; i++) {
            System.out.println("  " + (i + 1) + " - " + tipos[i].getDescricao());
        }
        int escolha = lerInt("Tipo: ");
        if (escolha < 1 || escolha > tipos.length) {
            throw new IllegalArgumentException("Tipo inválido: " + escolha);
        }
        double valor = lerDouble("Valor do plano (R$): ");

        academia.cadastrarPlano(aluno, nome, tipos[escolha - 1], valor);
        System.out.println("Plano cadastrado (inativo). Use a opção 4 para ativá-lo.");
    }

    private void ativarPlano() {
        Aluno aluno = academia.buscarAluno(lerTexto("Nome do aluno: "));
        String plano = lerTexto("Nome do plano a ativar: ");
        academia.ativarPlano(aluno, plano);
        System.out.println("Plano ativado! Planos ativos de " + aluno.getNome() + ": "
                + aluno.getPlanosAtivos() + "/" + Academia.MAX_PLANOS_POR_ALUNO);
    }

    private void desativarPlano() {
        Aluno aluno = academia.buscarAluno(lerTexto("Nome do aluno: "));
        String plano = lerTexto("Nome do plano a desativar: ");
        academia.desativarPlano(aluno, plano);
        System.out.println("Plano desativado! Planos ativos de " + aluno.getNome() + ": "
                + aluno.getPlanosAtivos() + "/" + Academia.MAX_PLANOS_POR_ALUNO);
    }

    private void cadastrarFuncionario() {
        System.out.println("1 - Instrutor");
        System.out.println("2 - Gerente");
        int tipo = lerInt("Tipo de funcionário: ");
        if (tipo != 1 && tipo != 2) {
            throw new IllegalArgumentException("Tipo de funcionário inválido: " + tipo);
        }
        String nome = lerTexto("Nome: ");
        double salario = lerDouble("Salário (R$): ");

        Funcionario funcionario;
        if (tipo == 1) {
            String especialidade = lerTexto("Especialidade: ");
            funcionario = new Instrutor(nome, salario, especialidade);
        } else {
            funcionario = new Gerente(nome, salario);
        }
        academia.cadastrarFuncionario(funcionario);
        System.out.println("Funcionário cadastrado com sucesso.");
    }

    private void consultarFuncionarios() {
        List<Funcionario> funcionarios = academia.getFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        for (Funcionario f : funcionarios) {
            f.mostrarDados();
        }
    }

    private void calcularBonus() {
        List<Funcionario> funcionarios = academia.getFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        for (Funcionario f : funcionarios) {
            System.out.printf("%s %s -> bônus: R$ %.2f%n",
                    f.getClass().getSimpleName(), f.getNome(), f.calcularBonus());
        }
    }

    private void registrarPagamento() {
        Aluno aluno = academia.buscarAluno(lerTexto("Nome do aluno: "));
        double mensalidade = academia.calcularMensalidade(aluno);
        System.out.printf("Mensalidade de %s (%d plano(s) ativo(s)): R$ %.2f%n",
                aluno.getNome(), aluno.getPlanosAtivos(), mensalidade);
        double valorPago = lerDouble("Valor pago (R$): ");

        Pagamento pagamento = academia.registrarPagamento(aluno, valorPago);
        System.out.println("Pagamento registrado em " + Datas.formatar(pagamento.getDataPagamento())
                + " - status: " + pagamento.getStatus());
    }

    private void consultarPagamentos() {
        List<Pagamento> pagamentos = academia.getPagamentos();
        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento registrado.");
            return;
        }
        System.out.println("Histórico de pagamentos:");
        for (Pagamento p : pagamentos) {
            System.out.println("  " + p);
        }
        System.out.printf("Total arrecadado: R$ %.2f%n", academia.totalArrecadado());
    }

    private String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().trim();
    }

    private int lerInt(String mensagem) {
        while (true) {
            String texto = lerTexto(mensagem);
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: digite apenas números inteiros.");
            }
        }
    }

    private double lerDouble(String mensagem) {
        while (true) {
            String texto = lerTexto(mensagem).replace(',', '.');
            try {
                double valor = Double.parseDouble(texto);
                if (Double.isNaN(valor) || Double.isInfinite(valor)) {
                    throw new NumberFormatException();
                }
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida: digite um número (ex.: 120,50).");
            }
        }
    }
}
