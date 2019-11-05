package com.itriad.parkinglot.controllers;

import com.itriad.parkinglot.domain.RegistroVeiculo;
import com.itriad.parkinglot.domain.Veiculo;
import com.itriad.parkinglot.services.RegistroVeiculoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registros")
public class RegistroVeiculoController {
    @Autowired
    RegistroVeiculoService registroService;

    @PostMapping
    public void registrarVeiculo(@RequestBody Veiculo veiculo) {
        registroService.registrarVeiculo(veiculo);
    }

    @PostMapping("saida")
    public RegistroVeiculo registrarSaidaVeiculo(@RequestParam("placa") String placa) {
        return registroService.registrarSaidaVeiculo(placa);
    }
}