package com.collectpoint.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class Util {
    public static Context context;
    public static SoundPool sp;
    public static Map<Integer, Integer> suondMap;

    public static void initSoundPool(Context context2) {
        context = context2;
        sp = new SoundPool(1, 3, 1);
        HashMap map = new HashMap();
        suondMap = map;
        map.put(1, Integer.valueOf(sp.load(context2, 2131755008, 1)));
    }

    public static void play(int i, int i2) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        float streamMaxVolume = audioManager.getStreamMaxVolume(3);
        float streamVolume = audioManager.getStreamVolume(3);
        float f = streamVolume / streamMaxVolume;
        sp.play(suondMap.get(Integer.valueOf(i)).intValue(), streamVolume, streamVolume, 1, i2, 1.0f);
    }
}
