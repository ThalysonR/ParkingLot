package com.itriad.parkinglot.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class RelatorioDTO {
    @JsonFormat(pattern = "dd/MM/yyyy")
    Date dia;
    Long numeroCarros;
    Double valorRecebido;

    public RelatorioDTO() {
        this.numeroCarros = 0L;
        this.valorRecebido = 0d;
    }
}