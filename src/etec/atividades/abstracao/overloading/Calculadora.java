package etec.atividades.abstracao.overloading;

public class Calculadora {

    int somar(int a, int b) {
        return a + b;
    }

    double somar(double a, double b) {
        return a + b;
    }

    int multiplicar(int a, int b) {
        return a * b;
    }

    double multiplicar(double a, double b) {
        return a * b;
    }

    int dividir(int a, int b) {
        return a / b;
    }

    double dividir(double a, double b) {
        return a / b;
    }
}
