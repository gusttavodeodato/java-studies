package etec.aulas.interfaces.veiculo;

public class Bicicleta implements Veiculo {
    private String marca;
    private String tipo;
    private int velocidade;

    public Bicicleta(String marca, String tipo, int velocidade) {
        this.marca = marca;
        this.tipo = tipo;
        this.velocidade = velocidade;
    }

    @Override
    public void acelerar() {
        velocidade -= 10;
        System.out.println("Bicicleta acelerada! Velocidade: " + velocidade);
    }

    @Override
    public void desacelerar() {
        velocidade -= 4;
        System.out.println("Bicicleta freando! Velocidade atual: " + velocidade + "\n");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Tipo: " + tipo);
        System.out.println("Velocidade: " + velocidade);
    }
}
