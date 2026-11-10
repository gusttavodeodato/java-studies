package etec.atividades.academia.funcionario;

public class Instrutor extends Funcionario{

    public static final double BONUS_INSTRUTOR = 0.05;

    private String especialidade;

    public Instrutor(String nome, double salario, String especialidade) {
        super(nome, salario);
        setEspecialidade(especialidade);
    }

    @Override
    public double calcularBonus() {
        return getSalario() * BONUS_INSTRUTOR;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println(" Especialidade: " + especialidade);
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        if(especialidade == null || especialidade.trim().isEmpty()) {
            throw new IllegalArgumentException("A especialidade deve ser preenchida.");
        }
        this.especialidade = especialidade;
    }
}
