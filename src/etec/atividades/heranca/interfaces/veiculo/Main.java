package etec.atividades.heranca.interfaces.veiculo;

public class Main {
    public static void main(String[] args) {

        Veiculo[] veiculos = new Veiculo[3];

        veiculos[0] = new Carro("Volks", "Gol Quadrado", 100);
        veiculos[1] = new Moto("BMW", 450, 150);
        veiculos[2] = new Bicicleta("Caloi", "BMX", 20);

        for(Veiculo v : veiculos) {
            v.exibirInfo();
            v.acelerar();
            v.desacelerar();
        }
    }
}
