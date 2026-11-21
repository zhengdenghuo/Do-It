package com.collectpoint.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class DoubleUtil {
    private static final int DEF_DIV_SCALE = 10;

    public static String DF(double d) {
        return new DecimalFormat("0.000").format(d);
    }

    public static String DFF(String str) {
        return new DecimalFormat("#,###,###,###.00").format(Double.parseDouble(str));
    }

    public static double add(double d, double d2) {
        return new BigDecimal(Double.toString(d)).add(new BigDecimal(Double.toString(d2))).doubleValue();
    }

    public static String data2end(double d) {
        return new DecimalFormat("#.00").format(d);
    }

    public static double div(double d, double d2) {
        return div(d, d2, DEF_DIV_SCALE);
    }

    public static double div(double d, double d2, int i) {
        if (i >= 0) {
            return new BigDecimal(Double.toString(d)).divide(new BigDecimal(Double.toString(d2)), i, 4).doubleValue();
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }

    public static double mul(double d, double d2) {
        return new BigDecimal(Double.toString(d)).multiply(new BigDecimal(Double.toString(d2))).doubleValue();
    }

    public static double round(double d, int i) {
        if (i >= 0) {
            return new BigDecimal(Double.toString(d)).divide(new BigDecimal("1"), i, 4).doubleValue();
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }

    public static double sub(double d, double d2) {
        return new BigDecimal(Double.toString(d)).subtract(new BigDecimal(Double.toString(d2))).doubleValue();
    }
}
