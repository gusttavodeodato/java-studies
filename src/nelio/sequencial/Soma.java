package nelio.sequencial;

import java.util.Scanner;

/**
 * EXERCICIO QUE LE DOIS VALORES INTEIROS
 */

public class Soma {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a, b, soma;

        System.out.println("Digite um valor: ");
        a = in.nextInt();

        System.out.println("Digite outro valor: ");
        b = in.nextInt();

        soma = a + b;
        System.out.println("A soma entre os valores é: " + soma);

        in.close();
    }
}
