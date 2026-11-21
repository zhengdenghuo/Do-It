package com.collectpoint.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class AlwaysLive {
    static final String IS_HUAWEI = "isHuawei";
    static final String IS_LETV = "isLetv";
    static final String IS_MEIZU = "isMeizu";
    static final String IS_OPPO = "isOppo";
    static final String IS_SAMSUNG = "isSamsung";
    static final String IS_SMARTISAN = "isSmartisan";
    static final String IS_VIVO = "isVivo";
    static final String IS_XIAOMI = "isXiaomi";

    public static String checkPhoneFirm() {
        String lowerCase = Build.BRAND.toLowerCase();
        return (lowerCase.equals("huawei") || lowerCase.equals("honor")) ? IS_HUAWEI : (!lowerCase.equals("xiaomi") || Build.BRAND == null) ? (!lowerCase.equals("oppo") || Build.BRAND == null) ? (!lowerCase.equals("vivo") || Build.BRAND == null) ? (!lowerCase.equals("meizu") || Build.BRAND == null) ? (!lowerCase.equals("samsung") || Build.BRAND == null) ? (!lowerCase.equals("letv") || Build.BRAND == null) ? (!lowerCase.equals("smartisan") || Build.BRAND == null) ? "" : IS_SMARTISAN : IS_LETV : IS_SAMSUNG : IS_MEIZU : IS_VIVO : IS_OPPO : IS_XIAOMI;
    }

    public static void gotoWhiteListSetting(Context context) {
        if (checkPhoneFirm().equals(IS_HUAWEI)) {
            try {
                showActivity("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity", context);
                return;
            } catch (Exception e) {
                showActivity("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.bootstart.BootStartActivity", context);
                return;
            }
        }
        if (checkPhoneFirm().equals(IS_XIAOMI)) {
            showActivity("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity", context);
            return;
        }
        if (checkPhoneFirm().equals(IS_OPPO)) {
            try {
                showActivity("com.coloros.phonemanager", context);
                return;
            } catch (Exception e2) {
                try {
                    showActivity("com.oppo.safe", context);
                    return;
                } catch (Exception e3) {
                    try {
                        showActivity("com.coloros.oppoguardelf", context);
                        return;
                    } catch (Exception e4) {
                        showActivity("com.coloros.safecenter", context);
                        return;
                    }
                }
            }
        }
        if (checkPhoneFirm().equals(IS_VIVO)) {
            showActivity("com.iqoo.secure", context);
            return;
        }
        if (checkPhoneFirm().equals(IS_MEIZU)) {
            showActivity("com.meizu.safe", context);
            return;
        }
        if (checkPhoneFirm().equals(IS_SAMSUNG)) {
            try {
                showActivity("com.samsung.android.sm_cn", context);
            } catch (Exception e5) {
                showActivity("com.samsung.android.sm", context);
            }
        } else if (checkPhoneFirm().equals(IS_LETV)) {
            showActivity("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity", context);
        } else if (checkPhoneFirm().equals(IS_SMARTISAN)) {
            showActivity("com.smartisanos.security", context);
        }
    }

    public static boolean isIgnoringBatteryOptimizations(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            return powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
        }
        return false;
    }

    public static void requestIgnoreBatteryOptimizations(Context context) {
        try {
            Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
            intent.setData(Uri.parse("package:" + context.getPackageName()));
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showActivity(String str, Context context) {
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
    }

    public static void showActivity(String str, String str2, Context context) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        intent.addFlags(268435456);
        context.startActivity(intent);
    }
}
