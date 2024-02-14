package com.herbert.wanderbyway.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DateUtils  {

    public static String getTodayString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateFormat.TEQUILA.getValue());
        LocalDate today = LocalDate.now();
        return today.format(formatter);
    }

    public static String weeksFromNowString(int weeks){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateFormat.TEQUILA.getValue());
        LocalDate weekFromNow = LocalDate.now().plusWeeks(weeks);
        return weekFromNow.format(formatter);
    }

    public static String formatDateToString(LocalDateTime date, DateFormat format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format.getValue());
        return date.format(formatter);
    }

    public static String formatDateToString(ZonedDateTime date, DateFormat format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format.getValue());
        return date.format(formatter);
    }

    public static LocalDateTime startOfDay(){
        LocalDate today = LocalDate.now();
        return today.atStartOfDay();
    }
}