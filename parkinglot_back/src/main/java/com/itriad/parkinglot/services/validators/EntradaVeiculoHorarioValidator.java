package com.itriad.parkinglot.services.validators;

import java.util.Calendar;

import com.itriad.parkinglot.domain.RegistroVeiculo;

public class EntradaVeiculoHorarioValidator extends RegistroVeiculoValidator {

    @Override
    protected void valida(RegistroVeiculo registro) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(registro.getEntrada());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour > 18 || hour < 8) {
            throw new ValidacaoEntradaRegistroException("Fora do horário de expediente.");
        }
    }

}