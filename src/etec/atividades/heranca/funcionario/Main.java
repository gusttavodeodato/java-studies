package etec.atividades.heranca.funcionario;

public class Main {
    public static void main(String[] args) {

        Funcionario funcionario = new Funcionario("André", 2000);
        Gerente gerente = new Gerente("Gustavo", 60000, 0.2);
        Estagiario estagiario = new Estagiario("Ryan", 3000, 2);

        funcionario.exibirInfo();
        gerente.exibirInfo();
        estagiario.exibirInfo();
    }

}
