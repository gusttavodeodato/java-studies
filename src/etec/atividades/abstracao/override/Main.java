package etec.atividades.abstracao.override;

public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro();
        Bicicleta bicicleta = new Bicicleta();
        Aviao aviao = new Aviao();

        carro.mover();
        bicicleta.mover();
        aviao.mover();
    }
}
