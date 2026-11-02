package nelio.sequencial;

import java.util.Locale;
import java.util.Scanner;

/**
 * EXERCICIO QUE LE TRES VALORES COM PONTO FLUTUANTE DE DUPLA PRECISÃO E
 * CALCULA VALORES DE FORMAS GEOMETRICAS
 */

public class Formas {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        double A, B, C, pi = 3.14159, triangulo, circulo, trapezio, quadrado, retangulo;

        System.out.println("\nDigite três valores: ");
        A = in.nextDouble();
        B = in.nextDouble();
        C = in.nextDouble();

        triangulo = A * C / 2;
        circulo = pi * C * C;
        trapezio = (A + B) / 2.00 * C ;
        quadrado = B * B;
        retangulo = A * B;

        System.out.printf("%nTRIANGULO: %.3f\n", triangulo);
        System.out.printf("CIRCULO: %.3f\n", circulo);
        System.out.printf("TRAPEZIO: %.3f\n", trapezio);
        System.out.printf("QUADRADO: %.3f\n", quadrado);
        System.out.printf("RETANGULO: %.3f\n", retangulo);

        in.close();

    }
}
