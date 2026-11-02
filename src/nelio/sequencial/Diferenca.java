package nelio.sequencial;

import java.util.Scanner;

/**
 * EXERCICIO QUE LE VALORES INTEIROS DE 4 VARIAVEIS
 * CALCULA E MOSTRA A DIFERENCA
 */

public class Diferenca {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a, b, c, d, diferenca;

        System.out.println("Digite o primeiro valor: ");
        a = in.nextInt();

        System.out.println("Digite o segundo valor: ");
        b = in.nextInt();

        System.out.println("Digite o terceiro valor: ");
        c = in.nextInt();

        System.out.println("Digite o quarto valor: ");
        d = in.nextInt();

        diferenca = (a * b - c * d);
        System.out.printf("Diferença = %d", diferenca);

        in.close();
    }
}
