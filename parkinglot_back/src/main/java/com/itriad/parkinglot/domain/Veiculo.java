package com.itriad.parkinglot.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Veiculo {
    @Id
    @GeneratedValue
    @ApiModelProperty(readOnly = true)
    Long id;
    @NotNull
    String placa;
    @NotNull
    String modelo;
    @NotNull
    String cor;
}