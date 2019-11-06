package com.itriad.parkinglot.services;

import java.util.Date;

import com.itriad.parkinglot.domain.RegistroVeiculo;
import com.itriad.parkinglot.domain.Veiculo;
import com.itriad.parkinglot.dto.PeriodoDataDTO;
import com.itriad.parkinglot.dto.RelatorioDTO;
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

    private Double calculaValorAPagar(RegistroVeiculo registro) {
        CalculoPreco cPreco = new RegraFDS();
        cPreco.link(new RegraSemanaManha())
            .link(new RegraSemanaTarde());
        return cPreco.executaCalculo(registro.getEntrada(), new Date());
    }

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
        RegistroVeiculo registro = registroRepository.findRegistroWithActiveVeiculoByPlaca(placa);
        registro.setSaida(new Date());
        registro.setValorPago(calculaValorAPagar(registro));
        return registro;
    }

    public Double verificaValorAPagar(String placa) {
        RegistroVeiculo registro = registroRepository.findRegistroWithActiveVeiculoByPlaca(placa);
        return calculaValorAPagar(registro);
    }

    public RelatorioDTO buscaDadosRelatorio(PeriodoDataDTO periodo) {
        final RelatorioDTO relatorio = new RelatorioDTO();
        registroRepository.findBySaidaBetween(periodo.getInicio(), periodo.getFim())
            .forEach((registro) -> {
                relatorio.setNumeroCarros(relatorio.getNumeroCarros() + 1);
                relatorio.setValorRecebido(relatorio.getValorRecebido() + registro.getValorPago());
            });
        return relatorio;
    }
}