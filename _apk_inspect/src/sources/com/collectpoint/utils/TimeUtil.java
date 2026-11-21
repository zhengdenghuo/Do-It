package com.collectpoint.utils;

import com.collectpoint.constants.Constants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class TimeUtil {
    public static final int MILLISECONDS_OF_ONE_HOUR = 3600000;
    public static final int MILLISECONDS_OF_ONE_MINUTE = 60000;
    public static final int MILLISECONDS_OF_ONE_SECOND = 1000;
    public static final int MINUTE_OF_ONE_HOUR = 60;
    public static final int SECONDS_OF_ONE_HOUR = 3600;
    public static final int SECONDS_OF_ONE_MINUTE = 60;

    public static String getCurrentTimeHHMM() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static String getDateUtcString(long j, String str) {
        Date date = new Date(j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+16:00"));
        return simpleDateFormat.format(date);
    }

    public static String getFormatDay(int i) {
        return i < 10 ? BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO + i : i + "";
    }

    public static String getRemainTime(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        long j2 = j / 3600;
        long j3 = (j % 3600) / 60;
        long j4 = (j % 3600) % 60;
        if (j2 != 0) {
            stringBuffer.append(j2 + "小时:");
        }
        stringBuffer.append(j3 + ":" + j4 + "分钟");
        return stringBuffer.toString();
    }

    public static String getTime(long j, String str) {
        return new SimpleDateFormat(str).format(new Date(j));
    }

    public static String getTime(Date date, String str) {
        return new SimpleDateFormat(str).format(date);
    }

    public static String getTimeStamp(int i) {
        return String.valueOf(System.currentTimeMillis()).substring(0, i);
    }

    public static String getWeek(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.get(1);
        calendar.get(2);
        calendar.get(5);
        switch (calendar.get(7)) {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case Constants.RED_PAGE /* 6 */:
                return "星期五";
            default:
                return "星期六";
        }
    }

    public static long hourToMillisecond(long j) {
        return 3600000 * j;
    }

    public static long hourToMinute(long j) {
        return 60 * j;
    }

    public static long hourToSecond(long j) {
        return 3600 * j;
    }

    public static boolean isSameDay(Date date, Date date2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public static String millisecondToHHMMSS(long j) {
        return toDoubleDigit((int) (j / 3600000)) + ":" + toDoubleDigit((int) ((j % 3600000) / 60000)) + ":" + toDoubleDigit((int) (((j % 3600000) % 60000) / 1000));
    }

    public static long millisecondToHour(long j) {
        return j / 3600000;
    }

    public static String millisecondToMMSS(long j) {
        return millisecondToHHMMSS(j).substring(3);
    }

    public static long millisecondToMinute(long j) {
        return j / 60000;
    }

    public static long millisecondToSecond(long j) {
        return j / 1000;
    }

    public static long minuteToMillisecond(long j) {
        return 60000 * j;
    }

    public static long minuteToSecond(long j) {
        return 60 * j;
    }

    public static String secondToHHMMSS(long j) {
        return millisecondToHHMMSS(secondToMillisecond(j));
    }

    public static long secondToMillisecond(long j) {
        return 1000 * j;
    }

    public static long timeToMillisecond(int i, int i2, int i3) {
        return timeToMillisecond(toDoubleDigit(i) + ":" + toDoubleDigit(i2) + ":" + toDoubleDigit(i3));
    }

    public static long timeToMillisecond(String str) {
        if (str == null || str.isEmpty()) {
            return 0L;
        }
        if (str.split(":").length != 3) {
            return 0L;
        }
        return (MILLISECONDS_OF_ONE_HOUR * Integer.valueOf(r2[0].substring(0, 2)).intValue()) + (MILLISECONDS_OF_ONE_MINUTE * Integer.valueOf(r2[1].substring(0, 2)).intValue()) + (Integer.valueOf(r2[2].substring(0, 2)).intValue() * MILLISECONDS_OF_ONE_SECOND);
    }

    public static long timeToSecond(int i, int i2, int i3) {
        return millisecondToSecond(timeToMillisecond(toDoubleDigit(i) + ":" + toDoubleDigit(i2) + ":" + toDoubleDigit(i3)));
    }

    public static long timeToSecond(String str) {
        return millisecondToSecond(timeToMillisecond(str));
    }

    public static String toDoubleDigit(int i) {
        String strValueOf = String.valueOf(i);
        return strValueOf.length() == 1 ? BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO + strValueOf : strValueOf;
    }
}
