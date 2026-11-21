package com.collectpoint.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class DateUtils {
    public static long DifferenceTime(long j, long j2) {
        return (j2 - j) / 60000;
    }

    public static String TimeDifference(long j, long j2) {
        long j3 = j2 - j;
        long j4 = j3 / 86400000;
        long j5 = (j3 / 3600000) - (j4 * 24);
        long j6 = ((j3 / 60000) - ((j4 * 24) * 60)) - (j5 * 60);
        long j7 = (((j3 - ((((24 * j4) * 60) * 60) * 1000)) - (((j5 * 60) * 60) * 1000)) - ((60 * j6) * 1000)) - (1000 * ((((j3 / 1000) - (((j4 * 24) * 60) * 60)) - ((j5 * 60) * 60)) - (j6 * 60)));
        if (j6 < 0) {
            j6 = 0;
        }
        return j4 + "天" + j5 + "小时" + j6 + "分";
    }

    public static int compareDay(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(date);
        calendar2.setTime(date2);
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        int i4 = calendar2.get(1);
        int i5 = calendar2.get(2);
        int i6 = calendar2.get(5);
        if (i < i4) {
            return -1;
        }
        if (i > i4) {
            return 1;
        }
        if (i2 < i5) {
            return -1;
        }
        if (i2 > i5) {
            return 1;
        }
        if (i3 < i6) {
            return -1;
        }
        return i3 > i6 ? 1 : 0;
    }

    public static int compareDay1(Date date, Long l) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTime(date);
        calendar2.setTimeInMillis(l.longValue());
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        int i4 = calendar2.get(1);
        int i5 = calendar2.get(2);
        int i6 = calendar2.get(5);
        if (i < i4) {
            return -1;
        }
        if (i > i4) {
            return 1;
        }
        if (i2 < i5) {
            return -1;
        }
        if (i2 > i5) {
            return 1;
        }
        if (i3 < i6) {
            return -1;
        }
        return i3 > i6 ? 1 : 0;
    }

    public static String date2Str(Date date, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        if (date == null) {
            date = new Date();
        }
        return simpleDateFormat.format(date);
    }

    public static String getCurrentDate(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        if (!"".equals(str)) {
            simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
        }
        return simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }

    public static int getHour(String str) {
        if (StringUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str) / 100;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getLastMonth(String str) {
        if ("".equals(str)) {
            str = "yyyy-MM";
        }
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, -1);
        return new SimpleDateFormat(str).format(calendar.getTime());
    }

    public static int getLocaleWeekday(int i) {
        return (((Calendar.getInstance().get(7) + i) + 7) - 2) % 7;
    }

    public static String getMonthEnd(String str) {
        if ("".equals(str)) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(5, calendar.getActualMaximum(5));
        return new SimpleDateFormat(str, Locale.getDefault()).format(calendar.getTime());
    }

    public static String getMonthStart(String str) {
        if ("".equals(str)) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, 0);
        calendar.set(5, 1);
        return new SimpleDateFormat(str, Locale.getDefault()).format(calendar.getTime());
    }

    public static long getTimeStemp(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        if (!"".equals(str2)) {
            simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        }
        try {
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public static String getWeekEnd(String str) {
        if ("".equals(str)) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(7, calendar.getActualMaximum(7));
        calendar.add(7, 1);
        return new SimpleDateFormat(str, Locale.getDefault()).format(calendar.getTime());
    }

    public static String getWeekStart(String str) {
        if ("".equals(str)) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(4, 0);
        calendar.set(7, 2);
        return new SimpleDateFormat(str, Locale.getDefault()).format(calendar.getTime());
    }

    public static String getYearEnd() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2, calendar.getActualMaximum(2));
        calendar.set(5, calendar.getActualMaximum(5));
        return new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()) + " 23:59:59";
    }

    public static String getYearStart() {
        return new SimpleDateFormat("yyyy").format(new Date()) + "-01-01";
    }

    public static String getYesterday(String str) {
        if ("".equals(str)) {
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -1);
        return new SimpleDateFormat(str, Locale.getDefault()).format(calendar.getTime());
    }

    public static boolean isSameWeek(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        calendar2.setTimeInMillis(j2);
        return calendar.get(4) == calendar2.get(4);
    }

    public static Calendar str2Calendar(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        try {
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (StringUtils.isEmpty(str)) {
            return calendar;
        }
        calendar.setTime(simpleDateFormat.parse(str));
        return calendar;
    }

    public static Date str2Date(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        Date date = new Date();
        try {
            return StringUtils.isEmpty(str) ? date : simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    public static String subStringDate(String str, String str2, String str3) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        if (str == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(str3, Locale.getDefault()).format(simpleDateFormat.parse(str));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String subStringMouth(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        if (str == null) {
            return "";
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(simpleDateFormat.parse(str));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String subStringTime(String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.getDefault());
        if (str == null) {
            return "";
        }
        try {
            return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(simpleDateFormat.parse(str));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String subYmhmTime(String str) {
        if (str == null) {
            return "";
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(Long.parseLong(str)));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public boolean hasOverlap(Date date, Date date2, Date date3, Date date4) {
        return (date.getTime() >= date3.getTime() && date.getTime() < date4.getTime()) || (date.getTime() > date3.getTime() && date.getTime() <= date4.getTime()) || ((date3.getTime() >= date.getTime() && date3.getTime() < date2.getTime()) || (date3.getTime() > date.getTime() && date3.getTime() <= date2.getTime()));
    }
}
