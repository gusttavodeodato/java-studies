package etec.atividades.academia.enums;

public enum Tipo {
    MUSCULACAO("Musculação"),
    FUNCIONAL("Funcional"),
    HIT("HIT"),
    CROSSFIT("Crossfit"),
    PLIOMETRICO("Pliométrico");

    private final String descricao;

    Tipo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
