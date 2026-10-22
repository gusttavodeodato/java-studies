package etec.atividades.heranca.interfaces.veiculo;

public class Moto implements Veiculo{
    private String marca;
    private int cilindrada;
    private int velocidade;


    public Moto(String marca, int cilindrada, int velocidade) {
        this.marca = marca;
        this.cilindrada = cilindrada;
        this.velocidade = velocidade;
    }

    @Override
    public void acelerar() {
        velocidade += 20;
        System.out.println("Moto acelerado! Velocidade: " + velocidade);
    }

    @Override
    public void desacelerar() {
        velocidade -= 15;
        System.out.println("Moto freando! Velocidade atual: " + velocidade + "\n");
    }

    @Override
    public void exibirInfo() {
        System.out.println("Marca: " + marca);
        System.out.println("Cilindrada: " + cilindrada);
        System.out.println("Velocidade: " + velocidade);
    }
}
