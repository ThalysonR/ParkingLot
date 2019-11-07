package com.itriad.parkinglot.repositories;

import java.util.Date;
import java.util.List;

import com.itriad.parkinglot.domain.RegistroVeiculo;
import com.itriad.parkinglot.dto.RelatorioDTO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegistroVeiculoRepository extends JpaRepository<RegistroVeiculo, Long> {
    @Query(value = "SELECT r FROM RegistroVeiculo r JOIN r.veiculo v WHERE r.saida = null AND v.placa = :placa")
    public RegistroVeiculo findRegistroWithActiveVeiculoByPlaca(String placa);
    @Query(value = "SELECT r FROM RegistroVeiculo r WHERE r.saida = null")
    public List<RegistroVeiculo> findRegistrosWithActiveVeiculos();
    @Query(value = "SELECT new com.itriad.parkinglot.dto.RelatorioDTO(r.saida, COUNT(r), SUM(r.valorPago)) FROM RegistroVeiculo r WHERE r.saida BETWEEN :inicio AND :fim GROUP BY r.saida ORDER BY r.saida")
    public List<RelatorioDTO> generateReportBetween(Date inicio, Date fim);
}