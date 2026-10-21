package etec.atividades.encapsulamento.funcionario;

public class FuncionarioTeste {
    public static void main(String[] args) {

        Funcionario funcionario1 = new Funcionario("Ryan", "SRE", 70000);
        Funcionario funcionario2 = new Funcionario("Gustavo", "Gerente de Desenvolvimento JAVA", 80000);

        System.out.printf("\nFuncionário 1 - NOME: %s - CARGO: %s - SALÁRIO: %.2f ", funcionario1.getNome(),
                funcionario1.getCargo(), funcionario1.getSalario());

        System.out.printf("\nFuncionário 2 - NOME: %s - CARGO: %s - SALÁRIO: %.2f ", funcionario2.getNome(),
                funcionario2.getCargo(), funcionario2.getSalario());


        /**
         * TROCANDO VALORES DE FUNCIONARIO 1
         */

        funcionario1.setNome("\nFUNCIONÁRIO 1 ATUALIZADO - Gustavo Garcia");
        System.out.println(funcionario1.getNome());


        System.out.println(funcionario1.nomeEmpresa);

        /**
         * ACESSO STATIC
         */

        System.out.printf("NOME EMPRESA - %s\n", funcionario1.nomeEmpresa);

    }
}
