package com.itriad.parkinglot.services.validators;

import com.itriad.parkinglot.domain.RegistroVeiculo;
import com.itriad.parkinglot.repositories.RegistroVeiculoRepository;

public class EntradaVeiculoAtivoValidator extends RegistroVeiculoValidator {
    private RegistroVeiculoRepository repository;

    public EntradaVeiculoAtivoValidator(RegistroVeiculoRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void valida(RegistroVeiculo registro) {
        if (repository.findRegistroWithActiveVeiculoByPlaca(registro.getVeiculo().getPlaca()) != null) {
            throw new ValidacaoEntradaRegistroException("Veículo já possui um registro aberto.");
        }
    }
    
}