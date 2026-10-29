package etec.atividades.abstracao.forma;

public class Main {
    public static void main(String[] args) {
        Forma[] formas = new Forma[3];

        formas[0] = new Circulo("Círculo", 1);
        formas[1] = new Retangulo("Ratângulo", 5, 3);
        formas[2] = new Quadrado("Quadrado", 5);

        for (Forma f : formas) {
            f.exibirInfo();
        }
    }
}
