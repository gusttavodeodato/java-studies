package etec.atividades.abstracao.override;

public class Bicicleta extends Transporte {

    @Override
    public void mover() {
        System.out.println("\nA bicicleta está pedalando pela ciclovia.");
    }
}
