package com.itriad.parkinglot.services;

import java.util.Date;

import com.itriad.parkinglot.domain.RegistroVeiculo;
import com.itriad.parkinglot.domain.Veiculo;
import com.itriad.parkinglot.repositories.RegistroVeiculoRepository;
import com.itriad.parkinglot.services.calculoPreco.CalculoPreco;
import com.itriad.parkinglot.services.calculoPreco.RegraFDS;
import com.itriad.parkinglot.services.calculoPreco.RegraSemanaManha;
import com.itriad.parkinglot.services.calculoPreco.RegraSemanaTarde;
import com.itriad.parkinglot.services.validators.EntradaVeiculoAtivoValidator;
import com.itriad.parkinglot.services.validators.EntradaVeiculoHorarioValidator;
import com.itriad.parkinglot.services.validators.RegistroVeiculoValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroVeiculoService {
    @Autowired
    RegistroVeiculoRepository registroRepository;

    public void registrarVeiculo(Veiculo veiculo) {
        RegistroVeiculo registro = new RegistroVeiculo();
        registro.setVeiculo(veiculo);
        registro.setEntrada(new Date());

        RegistroVeiculoValidator validator = new EntradaVeiculoAtivoValidator(registroRepository);
        validator.link(new EntradaVeiculoHorarioValidator());
        validator.executaValidacao(registro);

        registroRepository.save(registro);
    }

    public RegistroVeiculo registrarSaidaVeiculo(String placa) {
        // TODO Fazer validações

        RegistroVeiculo registro = registroRepository.findRegistroWithActiveVeiculoByPlaca(placa);
        registro.setSaida(new Date());
        return registro;
    }

    public Double calculaValorAPagar(String placaVeiculo) {
        RegistroVeiculo registro = registroRepository.findRegistroWithActiveVeiculoByPlaca(placaVeiculo);
        CalculoPreco cPreco = new RegraFDS();
        cPreco.link(new RegraSemanaManha())
            .link(new RegraSemanaTarde());
        return cPreco.executaCalculo(registro.getEntrada(), new Date());
    }
}