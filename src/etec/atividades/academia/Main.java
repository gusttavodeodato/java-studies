package etec.atividades.academia;

import etec.atividades.academia.servico.Academia;
import etec.atividades.academia.ui.Menu;

public class Main {
    public static void main(String[] args) {
        new Menu(new Academia()).executar();
    }
}
