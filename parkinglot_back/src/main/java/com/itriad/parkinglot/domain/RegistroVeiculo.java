package com.itriad.parkinglot.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RegistroVeiculo {
    @Id
    @GeneratedValue
    @JsonProperty(access = Access.READ_ONLY)
    @ApiModelProperty(readOnly = true)
    Long id;
    @ManyToOne(cascade = CascadeType.PERSIST)
    Veiculo veiculo;
    Date entrada;
    Date saida;
    Double valorPago;
}