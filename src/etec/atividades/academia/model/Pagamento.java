package etec.atividades.academia.model;

import etec.atividades.academia.interfaces.Processavel;
import etec.atividades.academia.model.Aluno;
import etec.atividades.academia.util.Datas;

import java.time.LocalDate;

public class Pagamento implements Processavel {

    public static final String PENDENTE = "PENDENTE";
    public static final String PAGO = "PAGO";
    public static final String PARCIAL = "PARCIAL";

    private final etec.atividades.academia.model.Aluno aluno;
    private final double valor;
    private double valorPago;
    private LocalDate dataPagamento;
    private String status;

    public Pagamento(etec.atividades.academia.model.Aluno aluno, double valor) {
        if (aluno == null) {
            throw new IllegalArgumentException("O pagamento precisa de um aluno.");
        }
        if (!(valor > 0)) {
            throw new IllegalArgumentException("O valor do pagamento deve ser maior que zero: " + valor);
        }
        this.aluno = aluno;
        this.valor = valor;
        this.valorPago = 0;
        this.dataPagamento = LocalDate.now();
        this.status = PENDENTE;
    }

    @Override
    public void processarPagamento(double valorPago) {
        if (!(valorPago > 0)) {
            throw new IllegalArgumentException("O pagamento deve ser maior que zero: " + valorPago);
        }
        if (!PENDENTE.equals(status)) {
            throw new IllegalStateException("Este pagamento já foi processado.");
        }
        this.valorPago = valorPago;
        this.dataPagamento = LocalDate.now();
        this.status = valorPago >= valor ? PAGO : PARCIAL;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public double getValor() {
        return valor;
    }

    public double getValorPago() {
        return valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("%s | Aluno: %s | Cobrado: R$ %.2f | Pago: R$ %.2f | Status: %s",
                Datas.formatar(dataPagamento), aluno.getNome(), valor, valorPago, status);
    }
}
