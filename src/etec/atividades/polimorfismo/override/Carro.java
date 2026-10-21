package etec.atividades.polimorfismo.override;

public class Carro extends Transporte {

    @Override
    public void mover() {
        System.out.println("\nO Carro está andando pelas ruas.");
    }
}
