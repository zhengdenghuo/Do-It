package com.collectpoint.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class DateIntervalUtils {
    public static List<String> getBetweenDates(String str, String str2, boolean z) {
        ArrayList arrayList = new ArrayList();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(str);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(str2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            if (z) {
                arrayList.add(simpleDateFormat.format(date));
            }
            while (calendar.getTime().before(date2)) {
                calendar.add(5, 1);
                arrayList.add(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static List<String> getMonthsBetweenDates(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
            Date date = new SimpleDateFormat("yyyy-MM").parse(str);
            Date date2 = new SimpleDateFormat("yyyy-MM").parse(str2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            arrayList.add(simpleDateFormat.format(date));
            while (calendar.getTime().before(date2)) {
                calendar.add(2, 1);
                arrayList.add(new SimpleDateFormat("yyyy-MM").format(calendar.getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public static List<String> getNearlyMonthDates() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String str = simpleDateFormat.format(new Date());
        calendar.add(2, -1);
        return getBetweenDates(simpleDateFormat.format(calendar.getTime()), str, false);
    }

    public static List<String> getNearlySixMonthDates() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String str = simpleDateFormat.format(new Date());
        calendar.add(2, -6);
        return getBetweenDates(simpleDateFormat.format(calendar.getTime()), str, false);
    }

    public static List<String> getNearlyThMonthDates() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String str = simpleDateFormat.format(new Date());
        calendar.add(2, -3);
        return getBetweenDates(simpleDateFormat.format(calendar.getTime()), str, false);
    }

    public static List<String> getNearlyWeekDates() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String str = simpleDateFormat.format(new Date());
        calendar.add(5, -7);
        return getBetweenDates(simpleDateFormat.format(calendar.getTime()), str, false);
    }

    public static List<String> getNearlyYearDates() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        String str = simpleDateFormat.format(new Date());
        calendar.add(2, -11);
        return getBetweenDates(simpleDateFormat.format(calendar.getTime()), str, false);
    }

    public static List<String> getWeeksBetweenDates(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = simpleDateFormat.parse(str);
            Date date2 = simpleDateFormat.parse(str2);
            Calendar calendar = Calendar.getInstance();
            calendar.setFirstDayOfWeek(2);
            calendar.setTime(date);
            arrayList.add(calendar.get(1) + "-" + calendar.get(3));
            while (calendar.getTime().before(date2)) {
                calendar.add(3, 1);
                arrayList.add(calendar.get(1) + "-" + calendar.get(3));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
