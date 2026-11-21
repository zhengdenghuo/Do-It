package com.collectpoint.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.collectpoint.MyApp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class STextUtil {
    private static Context getApplication() {
        MyApp.getInstance();
        return MyApp.getContext();
    }

    public static SpannableString getHighLightScaleSizeString(String str, String str2) {
        return getHighLightScaleSizeString(str, str2, 2131100226, 0.8f);
    }

    public static SpannableString getHighLightScaleSizeString(String str, String str2, int i, float f) {
        String strTransString = transString(str2);
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(strTransString, 2).matcher(spannableString);
        while (matcher.find()) {
            int iStart = matcher.start();
            int iEnd = matcher.end();
            spannableString.setSpan(new RelativeSizeSpan(f), iStart, iEnd, 33);
            spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getApplication(), i)), iStart, iEnd, 33);
        }
        return spannableString;
    }

    public static SpannableString getHighLightString(String str, int i, boolean z, String... strArr) {
        SpannableString spannableString = new SpannableString(str);
        for (String str2 : strArr) {
            Matcher matcher = Pattern.compile(transString(str2), 2).matcher(spannableString);
            while (matcher.find()) {
                int iStart = matcher.start();
                int iEnd = matcher.end();
                spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getApplication(), i)), iStart, iEnd, 33);
                if (z) {
                    spannableString.setSpan(new StyleSpan(1), iStart, iEnd, 33);
                }
            }
        }
        return spannableString;
    }

    public static SpannableString getHighLightString(String str, int i, String... strArr) {
        SpannableString spannableString = new SpannableString(str);
        for (String str2 : strArr) {
            Matcher matcher = Pattern.compile(transString(str2), 2).matcher(spannableString);
            while (matcher.find()) {
                spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getApplication(), i)), matcher.start(), matcher.end(), 33);
            }
        }
        return spannableString;
    }

    public static SpannableString getHighLightString(String str, String str2) {
        return getHighLightString(str, str2, 2131100226);
    }

    public static SpannableString getHighLightString(String str, String str2, int i) {
        try {
            String strTransString = transString(str2);
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(strTransString, 2).matcher(spannableString);
            while (matcher.find()) {
                spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getApplication(), i)), matcher.start(), matcher.end(), 33);
            }
            return spannableString;
        } catch (Exception e) {
            e.printStackTrace();
            return new SpannableString("");
        }
    }

    public static SpannableString getHighLightString(boolean z, String str, int i, String... strArr) {
        SpannableString spannableString = new SpannableString(str);
        for (String str2 : strArr) {
            Matcher matcher = Pattern.compile(transString(str2), 2).matcher(spannableString);
            while (matcher.find()) {
                spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getApplication(), i)), matcher.start(), matcher.end(), 33);
                if (z) {
                    break;
                }
            }
        }
        return spannableString;
    }

    public static SpannableString getHighLightStringFirst(String str, String str2, int i) {
        try {
            String strTransString = transString(str2);
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(strTransString, 2).matcher(spannableString);
            if (matcher.find()) {
                spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getApplication(), i)), matcher.start(), matcher.end(), 33);
            }
            return spannableString;
        } catch (Exception e) {
            e.printStackTrace();
            return new SpannableString("");
        }
    }

    public static SpannableString getHighLightStringLast(String str, String str2, int i) {
        try {
            String strTransString = transString(str2);
            SpannableString spannableString = new SpannableString(str);
            Matcher matcher = Pattern.compile(strTransString, 2).matcher(spannableString);
            int iStart = -1;
            int iEnd = -1;
            while (matcher.find()) {
                iStart = matcher.start();
                iEnd = matcher.end();
            }
            if (iStart > 0) {
                spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getApplication(), i)), iStart, iEnd, 33);
            }
            return spannableString;
        } catch (Exception e) {
            e.printStackTrace();
            return new SpannableString("");
        }
    }

    public static SpannableString getScaleSizeString(String str, String str2) {
        return getScaleSizeString(str, str2, 0.8f);
    }

    public static SpannableString getScaleSizeString(String str, String str2, float f) {
        String strTransString = transString(str2);
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(strTransString, 2).matcher(spannableString);
        while (matcher.find()) {
            spannableString.setSpan(new RelativeSizeSpan(f), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }

    public static SpannableString getScaleSizeString(String str, String str2, String str3, float f) {
        String strTransString = transString(str2);
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(strTransString, 2).matcher(spannableString);
        boolean z = false;
        while (matcher.find()) {
            spannableString.setSpan(new RelativeSizeSpan(f), matcher.start(), matcher.end(), 33);
            z = true;
        }
        if (z) {
            return spannableString;
        }
        String strTransString2 = transString(str3);
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        Matcher matcher2 = Pattern.compile(strTransString2, 2).matcher(spannableString);
        while (matcher2.find()) {
            spannableString.setSpan(new RelativeSizeSpan(f), matcher2.start(), matcher2.end(), 33);
        }
        return spannableString;
    }

    public static SpannableString getScaleSizeStringFirst(String str, String str2, float f) {
        String strTransString = transString(str2);
        if (TextUtils.isEmpty(str)) {
            return new SpannableString("");
        }
        SpannableString spannableString = new SpannableString(str);
        Matcher matcher = Pattern.compile(strTransString, 2).matcher(spannableString);
        if (matcher.find()) {
            spannableString.setSpan(new RelativeSizeSpan(f), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }

    public static void setHighLightText(TextView textView, String str, String str2) {
        textView.setText(getHighLightString(str, str2));
    }

    public static String transString(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("+")) {
            str = str.replace("+", "[+]");
        }
        if (str.contains("?")) {
            str = str.replace("?", "[?]");
        }
        return str.contains("*") ? str.replace("*", "[*]") : str;
    }
}
