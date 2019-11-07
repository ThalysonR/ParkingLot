package com.itriad.parkinglot.services.calculoPreco;

import java.util.Date;

public abstract class CalculoPreco {
    protected CalculoPreco proximo;

    public CalculoPreco link(CalculoPreco proximo) {
        this.proximo = proximo;
        return proximo;
    }

    protected abstract boolean regraAtiva(Date entrada, Date saida);

    protected abstract Double calcula(Date entrada, Date saida);

    protected Double executaProximo(Date entrada, Date saida) {
        return this.proximo != null
            ? proximo.executaCalculo(entrada, saida)
            : 0;
    }

    public Double executaCalculo(Date entrada, Date saida) {
        return regraAtiva(entrada, saida)
            ? calcula(entrada, saida)
            : executaProximo(entrada, saida);
    }
}