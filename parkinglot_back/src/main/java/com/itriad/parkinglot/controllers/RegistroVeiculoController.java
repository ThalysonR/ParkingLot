package com.itriad.parkinglot.controllers;

import java.util.List;

import com.itriad.parkinglot.domain.RegistroVeiculo;
import com.itriad.parkinglot.domain.Veiculo;
import com.itriad.parkinglot.dto.PeriodoDataDTO;
import com.itriad.parkinglot.dto.RelatorioDTO;
import com.itriad.parkinglot.services.RegistroVeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registros")
@CrossOrigin(origins = "*")
public class RegistroVeiculoController {
    @Autowired
    RegistroVeiculoService registroService;

    @GetMapping
    public List<Veiculo> buscaVeiculosAtivos() {
        return registroService.buscaVeiculosAtivos();
    }
    
    @PostMapping
    public void registrarVeiculo(@RequestBody Veiculo veiculo) {
        registroService.registrarVeiculo(veiculo);
    }

    @GetMapping("saida")
    public Double calculaPrecoAPagar(@RequestParam("placa") String placa) {
        return registroService.verificaValorAPagar(placa);
    }

    @PostMapping("saida")
    public RegistroVeiculo registrarSaidaVeiculo(@RequestParam("placa") String placa) {
        return registroService.registrarSaidaVeiculo(placa);
    }

    @GetMapping("relatorio")
    public RelatorioDTO getMethodName(PeriodoDataDTO periodo) {
        return registroService.buscaDadosRelatorio(periodo);
    }
    
}