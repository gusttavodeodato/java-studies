package etec.atividades.academia.model;

import etec.atividades.academia.enums.Tipo;

public class PlanoTreino {

    private static int totalPlanosAtivos = 0;

    private String nome;
    private Tipo tipo;
    private double valor;
    private boolean ativo;

    public PlanoTreino(String nome, Tipo tipo, double valor) {
        setNome(nome);
        setTipo(tipo);
        setValor(valor);
        this.ativo = false;
    }

    public void ativar() {
        if (ativo) {
            throw new IllegalStateException("O plano \"" + nome + "\" já está ativo.");
        }
        ativo = true;
        totalPlanosAtivos++;
    }

    public void desativar() {
        if (!ativo) {
            throw new IllegalStateException("O plano \"" + nome + "\" já está inativo.");
        }
        ativo = false;
        totalPlanosAtivos--;
    }

    public static int getTotalPlanosAtivos() {
        return totalPlanosAtivos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do plano não pode ser vazio.");
        }
        this.nome = nome.trim();
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("O tipo do plano é obrigatório.");
        }
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (!(valor > 0)) {
            throw new IllegalArgumentException("O valor do plano deve ser maior que zero.");
        }
        this.valor = valor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - R$ %.2f - %s",
                nome, tipo.getDescricao(), valor, ativo ? "ATIVO" : "INATIVO");
    }
}
