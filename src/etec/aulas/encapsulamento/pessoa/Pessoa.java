package etec.aulas.encapsulamento.pessoa;

public class Pessoa {
    private String nome, cpf, rg, raca;
    private int idade;
    private float peso, altura;
    private boolean pcd;

    public Pessoa(String nome, String cpf, String rg, String raca, int idade, float peso, float altura, boolean pcd) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.pcd = pcd;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getRaca() {
        return raca;
    }

    public int getIdade() {
        return idade;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public boolean isPcd() {
        return pcd;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public void setPcd(boolean pcd) {
        this.pcd = pcd;
    }
}
