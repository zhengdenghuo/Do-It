package com.collectpoint.utils;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.collectpoint.MyApp;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class StatusBarUtil {
    public static final int TYPE_FLYME = 1;
    public static final int TYPE_M = 3;
    public static final int TYPE_MIUI = 0;

    @Retention(RetentionPolicy.SOURCE)
    @interface ViewType {
    }

    public static boolean FlymeSetStatusBarLightMode(Window window, boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (window == null) {
            return false;
        }
        try {
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : i2 & (~i));
            window.setAttributes(attributes);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean MIUISetStatusBarLightMode(Window window, boolean z) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (window == null) {
            return false;
        }
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            if (z) {
                method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
            } else {
                method.invoke(window, 0, Integer.valueOf(i));
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (z) {
                    window.getDecorView().setSystemUiVisibility(9216);
                } else {
                    window.getDecorView().setSystemUiVisibility(0);
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void StatusBarDarkMode(Window window) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int statusBarLightMode = getStatusBarLightMode(window);
        if (statusBarLightMode == 1) {
            MIUISetStatusBarLightMode(window, false);
        } else if (statusBarLightMode == 2) {
            FlymeSetStatusBarLightMode(window, false);
        } else if (statusBarLightMode == 3) {
            window.getDecorView().setSystemUiVisibility(0);
        }
    }

    public static int getStatusBarHeight() {
        int identifier = MyApp.getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return MyApp.getContext().getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getStatusBarLightMode(Window window) {
        if (Build.VERSION.SDK_INT < 19) {
            return 0;
        }
        if (MIUISetStatusBarLightMode(window, true)) {
            return 1;
        }
        if (FlymeSetStatusBarLightMode(window, true)) {
            return 2;
        }
        if (Build.VERSION.SDK_INT < 23) {
            return 0;
        }
        window.getDecorView().setSystemUiVisibility(8192);
        return 3;
    }

    public static boolean setCommonUI(Activity activity, boolean z) {
        View decorView;
        if (Build.VERSION.SDK_INT < 23 || (decorView = activity.getWindow().getDecorView()) == null) {
            return false;
        }
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i = z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193);
        if (decorView.getSystemUiVisibility() == i) {
            return true;
        }
        decorView.setSystemUiVisibility(i);
        return true;
    }

    public static boolean setFlymeUI(Activity activity, boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        try {
            Window window = activity.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : i2 & (~i));
            window.setAttributes(attributes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setMINIStatusBarDarkMode(boolean z, Activity activity) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean setMeizuStatusBarDarkIcon(Activity activity, boolean z) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (activity == null) {
            return false;
        }
        try {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
            Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            int i = declaredField.getInt(null);
            int i2 = declaredField2.getInt(attributes);
            declaredField2.setInt(attributes, z ? i2 | i : i2 & (~i));
            activity.getWindow().setAttributes(attributes);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean setMiuiStatusBarDarkMode(Activity activity, boolean z) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = activity.getWindow().getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Window window = activity.getWindow();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean setMiuiUI(Activity activity, boolean z) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Window window = activity.getWindow();
            Class<?> cls = activity.getWindow().getClass();
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method declaredMethod = cls.getDeclaredMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            declaredMethod.setAccessible(true);
            if (z) {
                declaredMethod.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
            } else {
                declaredMethod.invoke(window, 0, Integer.valueOf(i));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setRootViewFitsSystemWindows(Activity activity, boolean z) {
        ViewGroup viewGroup;
        if (Build.VERSION.SDK_INT >= 19) {
            ViewGroup viewGroup2 = (ViewGroup) activity.findViewById(R.id.content);
            if (viewGroup2.getChildCount() <= 0 || (viewGroup = (ViewGroup) viewGroup2.getChildAt(0)) == null) {
                return;
            }
            viewGroup.setFitsSystemWindows(z);
        }
    }

    public static void setStatusBarColor(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().setStatusBarColor(i);
        } else if (Build.VERSION.SDK_INT >= 19) {
            setTranslucentStatus(activity);
            SystemBarTintManager systemBarTintManager = new SystemBarTintManager(activity);
            systemBarTintManager.setStatusBarTintEnabled(true);
            systemBarTintManager.setStatusBarTintColor(i);
        }
    }

    public static boolean setStatusBarFontIconDark(Activity activity, int i, boolean z) {
        switch (i) {
            case 0:
                return setMiuiUI(activity, z);
            case 1:
                return setFlymeUI(activity, z);
            default:
                return setCommonUI(activity, z);
        }
    }

    public static void setStatusBarLightMode(Window window) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, ClassNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        int statusBarLightMode = getStatusBarLightMode(window);
        if (statusBarLightMode == 1) {
            MIUISetStatusBarLightMode(window, true);
        } else if (statusBarLightMode == 2) {
            FlymeSetStatusBarLightMode(window, true);
        } else if (statusBarLightMode == 3) {
            window.getDecorView().setSystemUiVisibility(8192);
        }
    }

    public static void setTranslucentStatus(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = activity.getWindow();
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            Window window2 = activity.getWindow();
            WindowManager.LayoutParams attributes = window2.getAttributes();
            attributes.flags |= 67108864;
            window2.setAttributes(attributes);
        }
    }

    public static void setWindowStatusBarColor(Activity activity, int i) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = activity.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(activity.getResources().getColor(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setWindowStatusBarColor(Dialog dialog, int i) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                Window window = dialog.getWindow();
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(dialog.getContext().getResources().getColor(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
