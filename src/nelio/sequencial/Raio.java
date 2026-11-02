package nelio.sequencial;

import java.util.Scanner;

/**
 *  EXERCICIO QUE LE O VALOR DO RAIO DE UM CIRCULO, UTILIZANDO MATH
 */

public class Raio {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double raio, area;

        System.out.println("Digite o valor do raio");
        raio = in.nextDouble();

        area = Math.PI * Math.pow(raio, 2);

        System.out.printf("O valor da área deste círculo é -> %.4f\n", area);

        in.close();
    }
}
