package com.itriad.parkinglot.integracao;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.itriad.parkinglot.domain.RegistroVeiculo;
import com.itriad.parkinglot.domain.Veiculo;
import com.itriad.parkinglot.repositories.RegistroVeiculoRepository;
import com.itriad.parkinglot.services.RegistroVeiculoService;
import com.itriad.parkinglot.services.validators.EntradaVeiculoAtivoValidator;
import com.itriad.parkinglot.services.validators.EntradaVeiculoHorarioValidator;
import com.itriad.parkinglot.services.validators.RegistroVeiculoValidator;
import com.itriad.parkinglot.services.validators.ValidacaoEntradaRegistroException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RegistroEntradaTests {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");

    private RegistroVeiculoValidator validator;

    @Autowired
    RegistroVeiculoRepository repository;

    @Autowired
    RegistroVeiculoService service;

    private void initValidator() {
        validator = new EntradaVeiculoAtivoValidator(repository);
        validator.link(new EntradaVeiculoHorarioValidator());
    }

    @Test
    void entradaAposHorarioTest() {
        ValidacaoEntradaRegistroException thrown = assertThrows(ValidacaoEntradaRegistroException.class, () -> {
            try {
                this.initValidator();
                RegistroVeiculo registro = new RegistroVeiculo();
                registro.setVeiculo(new Veiculo(null, "XYZ1234", "Gol", "Preto"));
                registro.setEntrada(sdf.parse("07/11/2019 20:00:00"));
                validator.executaValidacao(registro);
            } catch (ParseException e) {
                Assertions.fail("Erro de parse na data");
            }
        });
        assertTrue(thrown.getMessage().contains("Fora do horário de expediente."));
    }

    @Test
    void duasEntradasMesmaPlacaTest() {
        ValidacaoEntradaRegistroException thrown = assertThrows(ValidacaoEntradaRegistroException.class, () -> {
            service.registrarVeiculo(new Veiculo(null, "ABC1234", "Gol", "Preto"));
            service.registrarVeiculo(new Veiculo(null, "ABC1234", "Gol", "Preto"));
        });
        assertTrue(thrown.getMessage().contains("Veículo já possui um registro aberto."));
    }
}