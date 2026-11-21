package com.collectpoint.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class StringUtils {
    public static String bigDecimal2String(BigDecimal bigDecimal) {
        return new DecimalFormat("#,##0.00").format(bigDecimal);
    }

    public static String bigDouble2String(double d) {
        return new DecimalFormat("#,##0.00").format(d);
    }

    public static String ditanceSwitch(float f) {
        return f > 1000.0f ? new DecimalFormat("#.00").format(f / 1000.0f) + "KM" : f + "M";
    }

    public static String filterNullStr(String str) {
        return str == null ? "" : str;
    }

    public static boolean getJingdu(double d, int i) {
        int iIndexOf;
        return EmptyUtils.isEmpty(String.valueOf(d)) || (iIndexOf = String.valueOf(d).indexOf(".")) <= 0 || String.valueOf(d).length() - (iIndexOf + 1) > i;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() <= 0;
    }

    public static boolean isValidPassword(String str) {
        return str.matches("^(?=.*\\d.*)(?=.*[a-zA-Z].*).{6,20}$");
    }

    public static BigDecimal string2BigDecimal(String str) {
        BigDecimal bigDecimal = new BigDecimal(BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
        try {
            return isEmpty(str) ? bigDecimal : new BigDecimal(new DecimalFormat("#,##0.00").parseObject(str).toString());
        } catch (Exception e) {
            e.printStackTrace();
            return bigDecimal;
        }
    }

    public static double string2Double(String str) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        try {
            if (isEmpty(str)) {
                return 0.0d;
            }
            return decimalFormat.parse(str).doubleValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0d;
        }
    }

    public static String string2SInt(String str) {
        return EmptyUtils.isEmpty(str) ? "" : !str.contains(".") ? str : str.substring(0, str.indexOf("."));
    }
}
