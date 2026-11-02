package nelio.sequencial;

import java.util.Scanner;

/**
 * EXERICIO QUE LE CODIGO DE PEÇA, NUMERO DE PEÇAS E VALOR UNITÁRIO DE CADA
 * CALCULA O VALOR E MOSTRA O VALOR A SER PAGO
 */

public class Pecas {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int codigo1, numero1, codigo2, numero2;
        double unitario1, unitario2, total;

        System.out.println("\nDigite o código, número da peça e valor unitário da peça 1: ");
        codigo1 = in.nextInt();
        numero1 = in.nextInt();
        unitario1 = in.nextDouble();

        System.out.println("\nDigite o código, número da peça e valor unitário da peça 2: ");
        codigo2 = in.nextInt();
        numero2 = in.nextInt();
        unitario2 = in.nextDouble();

        total = unitario1 * numero1  + unitario2 * numero2;

        System.out.printf("%nValor a pagar: R$ %.2f%n", total);

        in.close();
    }
}
