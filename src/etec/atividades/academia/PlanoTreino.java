package etec.atividades.academia;

import etec.atividades.academia.enums.Tipo;

public class PlanoTreino {
    private String nome;
    private boolean ativo;
    public static int totalPlanosAtivos = 0;

    private Tipo tipo;

    public PlanoTreino(String nome, Tipo tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }


    public void ativar() {
        if(!ativo) {
            this.ativo = true;
            totalPlanosAtivos++;
        }
    }

    public void desativar() {
        if(ativo) {
            this.ativo = false;
            totalPlanosAtivos--;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
