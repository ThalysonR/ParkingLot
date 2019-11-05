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

    public Double executaCalculo(Date entrada, Date saida) {
        if (regraAtiva(entrada, saida)) {
            return calcula(entrada, saida);
        }
        return proximo.executaCalculo(entrada, saida);
    }


}