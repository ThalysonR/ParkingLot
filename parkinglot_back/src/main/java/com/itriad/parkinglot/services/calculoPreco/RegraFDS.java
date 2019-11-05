package com.itriad.parkinglot.services.calculoPreco;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RegraFDS extends CalculoPreco {

    @Override
    protected boolean regraAtiva(Date entrada, Date saida) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(saida);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);

        return weekDay == Calendar.SATURDAY || weekDay == Calendar.SUNDAY;
    }

    @Override
    protected Double calcula(Date entrada, Date saida) {
        long diffInMillis = Math.abs(saida.getTime() - entrada.getTime());
        long difHoras = TimeUnit.HOURS.convert(diffInMillis, TimeUnit.MILLISECONDS);

        return difHoras * 2.50;
    }
    
}