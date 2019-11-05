package com.itriad.parkinglot.services.calculoPreco;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RegraSemanaManha extends CalculoPreco {
    private int LIMIT = 720;

    @Override
    protected boolean regraAtiva(Date entrada, Date saida) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(saida);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minutes = calendar.get(Calendar.MINUTE);

        return (weekDay >= Calendar.MONDAY && weekDay <= Calendar.FRIDAY) && ((hour * 60) + minutes <= LIMIT);
    }

    @Override
    protected Double calcula(Date entrada, Date saida) {
        long diffInMillis = Math.abs(saida.getTime() - entrada.getTime());
        long difHoras = TimeUnit.HOURS.convert(diffInMillis, TimeUnit.MILLISECONDS);

        return difHoras * 2.00;
    }
}