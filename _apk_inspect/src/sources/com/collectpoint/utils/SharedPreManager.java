package com.collectpoint.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.collectpoint.MyApp;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class SharedPreManager {
    private static SharedPreManager shared = null;
    private static SharedPreferences sp = null;
    private SharedPreferences.Editor edit;

    private static Context getContext() {
        MyApp.getInstance();
        return MyApp.getContext();
    }

    public static synchronized SharedPreManager getShared() {
        if (shared == null) {
            shared = new SharedPreManager();
        }
        if (sp == null) {
            String[] strArrSplit = getContext().getPackageName().split("\\.");
            if (strArrSplit.length > 0) {
                sp = getContext().getSharedPreferences(strArrSplit[strArrSplit.length - 1], 0);
            } else {
                sp = getContext().getSharedPreferences("shared", 0);
            }
        }
        return shared;
    }

    public static synchronized SharedPreManager getShared(Context context) {
        if (shared == null) {
            shared = new SharedPreManager();
        }
        if (sp == null) {
            String[] strArrSplit = context.getPackageName().split("\\.");
            if (strArrSplit.length > 0) {
                sp = context.getSharedPreferences(strArrSplit[strArrSplit.length - 1], 0);
            } else {
                sp = context.getSharedPreferences("shared", 0);
            }
        }
        return shared;
    }

    public String getBaseUrl() {
        return getShared().getStringShared("BaseUrl", "http://192.168.30.31:8102/");
    }

    public boolean getBooleanShared(String str, boolean z) {
        SharedPreferences sharedPreferences = sp;
        return sharedPreferences != null ? sharedPreferences.getBoolean(str, z) : z;
    }

    public float getFloatShared(String str, float f) {
        SharedPreferences sharedPreferences = sp;
        return sharedPreferences != null ? sharedPreferences.getFloat(str, f) : f;
    }

    public int getIntShared(String str, int i) {
        SharedPreferences sharedPreferences = sp;
        return sharedPreferences != null ? sharedPreferences.getInt(str, i) : i;
    }

    public String getLocationSet() {
        return getShared().getStringShared("LocationSet", BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
    }

    public long getLongShared(String str, long j) {
        SharedPreferences sharedPreferences = sp;
        return sharedPreferences != null ? sharedPreferences.getLong(str, j) : j;
    }

    public Boolean getMeetingInit() {
        return Boolean.valueOf(getShared().getBooleanShared("meetinginit", false));
    }

    public Boolean getMeetingList() {
        return Boolean.valueOf(getShared().getBooleanShared("meetinglist", false));
    }

    public String getMeetingStaute() {
        return getShared().getStringShared("meetingstaute", "Y");
    }

    public String getObjectList() {
        return getShared().getStringShared("objectList", "");
    }

    public boolean getPatrol() {
        return getShared().getBooleanShared("isPatrol", false);
    }

    public String getPatrolUrl() {
        return getShared().getStringShared("PatrolUrl", "http://192.168.30.31:8802/");
    }

    public long getPauseTime() {
        return getShared().getLongShared("pausetime", 0L);
    }

    public String getPointType() {
        return getShared().getStringShared("pointtype", BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
    }

    public String getSignalRecoveryContent() {
        return getShared().getStringShared("signalRecoveryContent", "已完成定位，可以开始巡护");
    }

    public long getStartTime() {
        long longShared = getShared().getLongShared("starttime", 0L);
        if (longShared != 0) {
            return longShared;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        setStartTime(jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    public String getStringShared(String str, String str2) {
        SharedPreferences sharedPreferences = sp;
        return sharedPreferences != null ? sharedPreferences.getString(str, str2) : str2;
    }

    public int getTimePer() {
        return getShared().getIntShared("timePer", 15);
    }

    public void init(Context context) {
        if (sp == null) {
            String[] strArrSplit = context.getPackageName().split("\\.");
            if (strArrSplit.length > 0) {
                sp = context.getSharedPreferences(strArrSplit[strArrSplit.length - 1], 0);
            } else {
                sp = context.getSharedPreferences("shared", 0);
            }
        }
    }

    public Boolean isNewDay() {
        return Boolean.valueOf(!TextUtils.equals(TimeUtil.getTime(System.currentTimeMillis(), "yyyy-MM-dd"), getShared().getStringShared("newday", "")));
    }

    public void setBaseUrl(String str) {
        getShared().setStrShared("BaseUrl", str);
    }

    public void setBooleanShared(String str, boolean z) {
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            this.edit = editorEdit;
            editorEdit.putBoolean(str, z);
            this.edit.commit();
        }
    }

    public void setDay() {
        getShared().setStrShared("newday", TimeUtil.getTime(System.currentTimeMillis(), "yyyy-MM-dd"));
    }

    public void setFloatShared(String str, float f) {
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            this.edit = editorEdit;
            editorEdit.putFloat(str, f);
            this.edit.commit();
        }
    }

    public void setIntShared(String str, int i) {
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            this.edit = editorEdit;
            editorEdit.putInt(str, i);
            this.edit.commit();
        }
    }

    public void setLocationSet(String str) {
        getShared().setStrShared("locationSet", str);
    }

    public void setLongShared(String str, long j) {
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            this.edit = editorEdit;
            editorEdit.putLong(str, j);
            this.edit.commit();
        }
    }

    public void setMeetingInit(boolean z) {
        getShared().setBooleanShared("meetinginit", z);
    }

    public void setMeetingList(boolean z) {
        getShared().setBooleanShared("meetinglist", z);
    }

    public void setMeetingStaute(String str) {
        getShared().setStrShared("meetingstaute", str);
    }

    public void setObjectList(String str) {
        System.out.println("_______objectList " + str);
        getShared().setStrShared("objectList", str);
    }

    public void setPatrol(Boolean bool) {
        getShared().setBooleanShared("isPatrol", bool.booleanValue());
    }

    public void setPatrolUrl(String str) {
        getShared().setStrShared("PatrolUrl", str);
    }

    public void setPauseTime(long j) {
        getShared().setLongShared("pausetime", j);
    }

    public void setPointType(String str) {
        getShared().setStrShared("pointtype", str);
    }

    public void setSignalRecoveryContent(String str) {
        getShared().setStrShared("signalRecoveryContent", str);
    }

    public void setStartTime(long j) {
        getShared().setLongShared("starttime", j);
    }

    public void setStrShared(String str, String str2) {
        SharedPreferences sharedPreferences = sp;
        if (sharedPreferences != null) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            this.edit = editorEdit;
            editorEdit.putString(str, str2);
            this.edit.commit();
        }
    }

    public void setTimePer(int i) {
        getShared().setIntShared("timePer", i);
    }
}
