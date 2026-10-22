package etec.atividades.heranca.interfaces.veiculo;

public class Carro implements Veiculo {
    private String marca;
    private String modelo;
    private int velocidade;

    public Carro(String marca, String modelo, int velocidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.velocidade = velocidade;
    }

    @Override
    public void acelerar() {
        velocidade += 10;
        System.out.println("Carro acelerado! Velocidade: " + velocidade);
    }

    @Override
    public void desacelerar() {
        velocidade -= 5;
        System.out.println("Carro freando! Velocidade atual: " + velocidade + "\n");
    }

    @Override
    public void exibirInfo() {
        System.out.println("\nMarca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Velocidade: " + velocidade);
    }
}
