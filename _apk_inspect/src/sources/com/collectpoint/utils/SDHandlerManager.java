package com.collectpoint.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.blankj.utilcode.util.ObjectUtils;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class SDHandlerManager {
    private static Handler backgroundHandler;
    private static final Object lock = new Object();
    private static final HandlerThread thread = new HandlerThread("handler thread");
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());
    private static boolean isBackgroundHandlerStart = false;
    private static Map<String, SoftReference<Runnable>> runCache = new HashMap();

    public static final Handler getBackgroundHandler() {
        startBackgroundHandler();
        return backgroundHandler;
    }

    public static final Handler getMainHandler() {
        return mainHandler;
    }

    public static final void postThread(Runnable runnable, String str) {
        if (!ObjectUtils.isEmpty(str) && !runCache.containsKey(str)) {
            runCache.put(str, new SoftReference<>(runnable));
        }
        getBackgroundHandler().post(runnable);
    }

    public static final void postUIThread(Runnable runnable, String str) {
        if (!ObjectUtils.isEmpty(str) && !runCache.containsKey(str)) {
            runCache.put(str, new SoftReference<>(runnable));
        }
        getMainHandler().post(runnable);
    }

    public static final void postUIThreadDelayed(Runnable runnable, long j, String str) {
        if (!ObjectUtils.isEmpty(str) && !runCache.containsKey(str)) {
            runCache.put(str, new SoftReference<>(runnable));
        }
        getMainHandler().postDelayed(runnable, j);
    }

    public static final void removeThread(String str) {
        SoftReference<Runnable> softReference;
        if (!runCache.containsKey(str) || (softReference = runCache.get(str)) == null || softReference.get() == null) {
            return;
        }
        runCache.remove(str);
        getBackgroundHandler().removeCallbacks(softReference.get());
    }

    public static final void removeUIThread(String str) {
        SoftReference<Runnable> softReference;
        if (!runCache.containsKey(str) || (softReference = runCache.get(str)) == null || softReference.get() == null) {
            return;
        }
        runCache.remove(str);
        getMainHandler().removeCallbacks(softReference.get());
    }

    public static final void startBackgroundHandler() {
        synchronized (lock) {
            if (!isBackgroundHandlerStart) {
                HandlerThread handlerThread = thread;
                handlerThread.start();
                backgroundHandler = new Handler(handlerThread.getLooper());
                isBackgroundHandlerStart = true;
            }
        }
    }

    public static final void stopBackgroundHandler() {
        synchronized (lock) {
            if (isBackgroundHandlerStart) {
                thread.quit();
                isBackgroundHandlerStart = false;
            }
        }
    }
}
