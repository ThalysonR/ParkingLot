package com.itriad.parkinglot.repositories;

import java.util.Date;
import java.util.List;

import com.itriad.parkinglot.domain.RegistroVeiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegistroVeiculoRepository extends JpaRepository<RegistroVeiculo, Long> {
    @Query(value = "SELECT r FROM RegistroVeiculo r JOIN r.veiculo v WHERE r.saida = null AND v.placa = :placa")
    public RegistroVeiculo findRegistroWithActiveVeiculoByPlaca(String placa);
    @Query(value = "SELECT r FROM RegistroVeiculo r WHERE r.saida = null")
    public List<RegistroVeiculo> findRegistrosWithActiveVeiculos();
    public List<RegistroVeiculo> findBySaidaBetween(Date inicio, Date fim);
}