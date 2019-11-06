package com.itriad.parkinglot.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PeriodoDataDTO {
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date inicio;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date fim;
}