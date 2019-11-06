package com.itriad.parkinglot.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RelatorioDTO {
    Integer numeroCarros;
    Double valorRecebido;

    public RelatorioDTO() {
        this.numeroCarros = 0;
        this.valorRecebido = 0d;
    }
}