package com.example.desafiocnab.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
public class DateUtil {

    static DateTimeFormatter localDatePattern = DateTimeFormatter.ofPattern("yyyyMMdd");
    static DateTimeFormatter localTimePattern = DateTimeFormatter.ofPattern("HHmmss");

    public static LocalDate CNABStringToLocalDate(String localDate) {
        return LocalDate.parse(localDate, localDatePattern);
    }

    public static LocalTime CNABStringToLocalTime(String localTime) {
        return LocalTime.parse(localTime, localTimePattern);
    }
}
