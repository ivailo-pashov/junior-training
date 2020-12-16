package com.epam.functionalprogramming.example8properties;

import java.util.Calendar;
import java.util.Date;

public class PropertiesExample1 {

    private static Date lastYearAndMonth;
    private static Date lastResult;

    private static Date getMonthHalfEnd(Date yearAndMonth) {

        if (yearAndMonth.equals(lastYearAndMonth)) {
            return lastResult;
        } else {
            lastYearAndMonth = new Date(yearAndMonth.getTime());
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(yearAndMonth);

        int monthDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int monthHalf = monthDays / 2;

        Calendar today = Calendar.getInstance();
        int currentDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, currentDayOfMonth > monthHalf ? monthDays : monthHalf);

        yearAndMonth.setTime(calendar.getTimeInMillis());

        lastResult = yearAndMonth;
        return yearAndMonth;
    }
}
