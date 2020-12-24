package com.epam.functionalprogramming.example8properties;

import java.time.LocalDate;

public class PropertiesExample1 {

    //2018-02-03
    //2018-03-03
    //2018-03-01
    //2018-02-29
    private static boolean isFirstHalfOfMonth(LocalDate date) {
        int dayOfMonth = date.getDayOfMonth();
        int monthDays = date.plusMonths(1).withDayOfMonth(1).minusDays(1).getDayOfMonth();
        int monthHalf = monthDays / 2;
        return dayOfMonth <= monthHalf;
    }
}
