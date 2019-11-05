package com.itriad.parkinglot.repositories;

import com.itriad.parkinglot.domain.RegistroVeiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RegistroVeiculoRepository extends JpaRepository<RegistroVeiculo, Long> {
    // public RegistroVeiculo findOneByPlaca(String placa);
    @Query(value = "SELECT r FROM RegistroVeiculo r JOIN r.veiculo v where r.saida = null AND v.placa = :placa")
    public RegistroVeiculo findRegistroWithActiveVeiculoByPlaca(String placa);
}