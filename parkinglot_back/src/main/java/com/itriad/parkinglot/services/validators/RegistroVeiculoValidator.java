package com.itriad.parkinglot.services.validators;

import com.itriad.parkinglot.domain.RegistroVeiculo;

public abstract class RegistroVeiculoValidator {
    private RegistroVeiculoValidator proximo;
    
    public RegistroVeiculoValidator link(RegistroVeiculoValidator proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public void executaValidacao(RegistroVeiculo registro) {
        this.valida(registro);
        validaProximo(registro);
    }

    protected abstract void valida(RegistroVeiculo registro);

    private void validaProximo(RegistroVeiculo registro) {
        if (proximo == null) {
            return;
        }
        proximo.valida(registro);
    }
}