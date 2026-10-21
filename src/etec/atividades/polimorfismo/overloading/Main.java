package etec.atividades.polimorfismo.overloading;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        System.out.println(calculadora.somar(7, 1));
        System.out.println(calculadora.somar(7.0, 2.5));
        System.out.println(calculadora.multiplicar(7, 2));
        System.out.println(calculadora.multiplicar(7.0, 2.5));
        System.out.println(calculadora.dividir(7, 2));
        System.out.println(calculadora.dividir(7.0, 2.5));
    }
}
