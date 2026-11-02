package nelio.sequencial;

import java.util.Locale;
import java.util.Scanner;

/**
 * EXERCICIO QUE LE NUMERO DE FUNCIONARIO, NUMERO DE HORAS TRABALHADAS E VALOR QUE RECEBE POR HORA
 * SAIDA COM PADRAO US E FORMATADA
 */

public class Funcionario {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        int funcionario, horasTrabalhadas;
        double valorHora, salario;

        System.out.println("\nDigite a identificação do Funcionário: ");
        funcionario = in.nextInt();

        System.out.println("Digite as horas trabalhadas: ");
        horasTrabalhadas = in.nextInt();

        System.out.println("Qual valor recebe por hora? ");
        valorHora = in.nextDouble();

        salario = horasTrabalhadas * valorHora;

        System.out.printf("%nNúmero: %d%n", funcionario);
        System.out.printf("Salario: U$ %.2f%n", salario);

        in.close();
    }
}
