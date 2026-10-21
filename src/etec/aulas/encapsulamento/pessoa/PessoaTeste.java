package etec.aulas.encapsulamento.pessoa;

public class PessoaTeste {
    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa("Aline", "111.222.333-44", "10.222.333-58", "branca", 25,
                70, 170, false);

        System.out.printf("\nOi %s, seu cpf é %s e seu rg %s,%n", pessoa1.getNome(), pessoa1.getCpf(), pessoa1.getRg());
        System.out.printf("Você se considera %s e tem %d anos.\n", pessoa1.getRaca(), pessoa1.getIdade());

    }
}
