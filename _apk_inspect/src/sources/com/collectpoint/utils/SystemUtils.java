package com.collectpoint.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class SystemUtils {
    public static boolean DeleteFolder(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile() ? deleteFile(str) : deleteDirectory(str);
        }
        return false;
    }

    public static boolean checkDirExists(String str) {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists()) {
                return true;
            }
            return file.mkdirs();
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean checkphone(String str) {
        if (str == null) {
            return false;
        }
        String[] strArrSplit = str.replace(",", ",").replace(";", ",").replace(";", ",").replace("\u3000", ",").replace(" ", ",").replace("/", ",").replace("\\", ",").split(",");
        String[] strArr = new String[strArrSplit.length];
        if (strArrSplit == null || strArrSplit.length <= 0) {
            return false;
        }
        for (int i = 0; i < strArrSplit.length; i++) {
            boolean z = false;
            if (strArrSplit[i].matches("(^[0-9]{3,4}-[0-9]{3,8}$)|^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|2|3|5|6|7|8|9]) \\d{8}$")) {
                strArr[i] = strArrSplit[i];
                z = true;
            }
            if (!z && strArrSplit[i].matches("(^[0-9]{3,4}-[0-9]{3,8}-[0-9]{0,100}$)|^((\\+86)|(86))?(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|2|3|5|6|7|8|9]) \\d{8}$")) {
                strArr[i] = strArrSplit[i];
            }
        }
        return strArr.length > 0;
    }

    public static boolean deleteDirectory(String str) {
        if (!str.endsWith(File.separator)) {
            str = str + File.separator;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return false;
        }
        boolean zDeleteDirectory = true;
        File[] fileArrListFiles = file.listFiles();
        for (int i = 0; i < fileArrListFiles.length; i++) {
            if (fileArrListFiles[i].isFile()) {
                zDeleteDirectory = deleteFile(fileArrListFiles[i].getAbsolutePath());
                if (!zDeleteDirectory) {
                    break;
                }
            } else {
                zDeleteDirectory = deleteDirectory(fileArrListFiles[i].getAbsolutePath());
                if (!zDeleteDirectory) {
                    break;
                }
            }
        }
        if (zDeleteDirectory) {
            return file.delete();
        }
        return false;
    }

    public static boolean deleteFile(String str) {
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }

    public static String getConnectInfo(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return connectivityManager.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ? "2G/3G/4G" : connectivityManager.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED ? "WIFI" : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static double getDistance(double d, double d2, double d3, double d4) {
        double dRad = rad(d2);
        double dRad2 = rad(d4);
        return (Math.round(10000.0d * ((Math.asin(Math.sqrt(Math.pow(Math.sin((dRad - dRad2) / 2.0d), 2.0d) + ((Math.cos(dRad) * Math.cos(dRad2)) * Math.pow(Math.sin((rad(d) - rad(d3)) / 2.0d), 2.0d)))) * 2.0d) * 6378137.0d)) / 10000) / 1000.0d;
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean hasFroyo() {
        return Build.VERSION.SDK_INT >= 8;
    }

    public static boolean hasGingerbread() {
        return Build.VERSION.SDK_INT >= 9;
    }

    public static boolean hasHoneycomb() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static boolean hasHoneycombMR1() {
        return Build.VERSION.SDK_INT >= 12;
    }

    public static boolean hasJellyBean() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean hasKitKat() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static void hideSoftInput(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static boolean isGrantedPermisson(Context context, String str) {
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isOdd(int i) {
        return i % 2 != 0;
    }

    public static boolean isPad(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private static double rad(double d) {
        return (3.141592653589793d * d) / 180.0d;
    }

    public static String readStringFromAssets(Context context, String str) throws IOException {
        AssetManager assets = context.getApplicationContext().getAssets();
        InputStream inputStreamOpen = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                try {
                    inputStreamOpen = assets.open(str);
                    inputStreamReader = new InputStreamReader(inputStreamOpen);
                    bufferedReader = new BufferedReader(inputStreamReader);
                    sb.append(bufferedReader.readLine());
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        sb.append("\n").append(line);
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    inputStreamOpen.close();
                    bufferedReader.close();
                    inputStreamReader.close();
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                }
            } catch (Throwable th) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        throw th;
                    }
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                throw th;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        return sb.toString();
    }

    public static void showSoftInput(Context context, View view) {
        ((InputMethodManager) context.getSystemService("input_method")).showSoftInput(view, 2);
    }
}
