package etec.atividades.polimorfismo.animal;

public class Cachorro extends Animal {

    @Override
    public void emitirSom() {
        System.out.println("\nO cachorro late: Au Au!");
    }
}
