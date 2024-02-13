package com.herbert.wanderbyway.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateUtils  {

    public static String getTodayString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate today = LocalDate.now();
        return today.format(formatter);
    }

    public static String weeksFromNowString(int weeks){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate weekFromNow = LocalDate.now().plusWeeks(weeks);
        return weekFromNow.format(formatter);
    }
}