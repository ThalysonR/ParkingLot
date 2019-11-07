package com.itriad.parkinglot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.itriad.parkinglot.services.calculoPreco.CalculoPreco;
import com.itriad.parkinglot.services.calculoPreco.RegraFDS;
import com.itriad.parkinglot.services.calculoPreco.RegraSemanaManha;
import com.itriad.parkinglot.services.calculoPreco.RegraSemanaTarde;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculoPrecoTests {
    private CalculoPreco cPreco;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private void initCPreco() {
        this.cPreco = new RegraFDS();
            cPreco.link(new RegraSemanaManha()).link(new RegraSemanaTarde());
    }

    @Test
    void testeRegraFDSAtiva() {
        this.initCPreco();
        try {
            Date entrada = this.sdf.parse("03/11/2019 10:00:00");
            Date saida = this.sdf.parse("03/11/2019 15:00:00");
            assertEquals(12.5D, cPreco.executaCalculo(entrada, saida));
        } catch (Exception e) {
            Assertions.fail("Erro de parse na data");
        };
    }

    @Test
    void testeRegraSemanaManhaAtiva() {
        this.initCPreco();
        try {
            Date entrada = this.sdf.parse("07/11/2019 08:00:00");
            Date saida = this.sdf.parse("07/11/2019 12:00:00");
            assertEquals(8D, cPreco.executaCalculo(entrada, saida));
        } catch (Exception e) {
            Assertions.fail("Erro de parse na data");
        };
    }

    @Test
    void testeRegraSemanaTardeAtiva() {
        this.initCPreco();
        try {
            Date entrada = this.sdf.parse("07/11/2019 12:00:00");
            Date saida = this.sdf.parse("07/11/2019 18:00:00");
            assertEquals(18D, cPreco.executaCalculo(entrada, saida));
        } catch (Exception e) {
            Assertions.fail("Erro de parse na data");
        };
    }
}