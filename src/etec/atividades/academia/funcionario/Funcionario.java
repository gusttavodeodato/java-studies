package etec.atividades.academia.funcionario;

public abstract class Funcionario {

    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public abstract double calcularBonus();

    public void mostrarDados() {
        System.out.printf("%s: %s | Salário: R$ %.2f | Bônus: R$ %.2f%n",
                getClass().getSimpleName(), nome, salario, calcularBonus());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(nome == null | nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do funcionário deve ser informado.");
        }
        this.nome = nome.trim();
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
    if(!(salario >= 0 )) {
        throw new IllegalArgumentException("O salário não pode ser negativo" + salario);
    }
        this.salario = salario;
    }
}
