package etec.atividades.academia.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public final class Datas {

    private static final DateTimeFormatter FORMATO_BR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Datas() {
    }

    public static String formatar(LocalDate data) {
        return data == null ? "-" : data.format(FORMATO_BR);
    }

    public static String hoje() {
        return formatar(LocalDate.now());
    }

    /** Tempo decorrido entre a data informada e hoje, em texto. */
    public static String tempoDesde(LocalDate inicio) {
        Period p = Period.between(inicio, LocalDate.now());
        return p.getYears() + " ano(s), " + p.getMonths() + " mês(es) e " + p.getDays() + " dia(s)";
    }
}
