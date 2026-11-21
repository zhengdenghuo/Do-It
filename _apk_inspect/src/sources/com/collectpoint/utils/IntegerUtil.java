package com.collectpoint.utils;

import java.util.regex.Pattern;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class IntegerUtil {
    private static final Pattern PATTERN = Pattern.compile("^[0-9]*$");

    public static int getInter(String str) {
        if (EmptyUtils.isEmpty(str) || !isInt(str)) {
            return 0;
        }
        return Integer.parseInt(str);
    }

    private static boolean isInt(String str) {
        return PATTERN.matcher(str).matches();
    }
}
