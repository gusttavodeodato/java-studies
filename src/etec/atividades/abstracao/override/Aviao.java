package etec.atividades.abstracao.override;

public class Aviao extends Transporte {

    @Override
    public void mover() {
        System.out.println("\nO avião está voando nos céus.");
    }
}
