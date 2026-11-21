package com.collectpoint.utils;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class PreferencesUtil {
    private static final String FILENAME = "config_file";
    private static final int MODE = 0;

    private PreferencesUtil() {
    }

    public static int getIntPreference(Context context, String str, int i) {
        return context.getSharedPreferences(FILENAME, 0).getInt(str, i);
    }

    public static String getStringPreference(Context context, String str, String str2) {
        return context.getSharedPreferences(FILENAME, 0).getString(str, str2);
    }

    public static void setIntPreference(Context context, String str, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(FILENAME, 0).edit();
        editorEdit.putInt(str, i);
        editorEdit.commit();
    }

    public static void setStringPreferences(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(FILENAME, 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }
}
