package com.collectpoint.utils;

import android.speech.tts.TextToSpeech;
import com.blankj.utilcode.util.ToastUtils;
import com.collectpoint.MyApp;
import java.util.Locale;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class TextToSpeechUtil {
    private static TextToSpeech mTextToSpeech;

    public static void speak(final String str) {
        TextToSpeech textToSpeech = mTextToSpeech;
        if (textToSpeech != null) {
            textToSpeech.speak(str, 0, null);
        } else {
            speakChina();
            SDHandlerManager.getMainHandler().postDelayed(new Runnable() { // from class: com.collectpoint.utils.TextToSpeechUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    TextToSpeechUtil.mTextToSpeech.speak(str, 0, null);
                }
            }, 333L);
        }
    }

    public static void speakChina() {
        mTextToSpeech = new TextToSpeech(MyApp.getContext(), new TextToSpeech.OnInitListener() { // from class: com.collectpoint.utils.TextToSpeechUtil.2
            @Override // android.speech.tts.TextToSpeech.OnInitListener
            public void onInit(int i) {
                int language;
                if (i != 0 || (language = TextToSpeechUtil.mTextToSpeech.setLanguage(Locale.CHINA)) == 0 || language == 1) {
                    return;
                }
                ToastUtils.showShort("不支持当前语言");
            }
        });
    }

    public static void stop() {
        TextToSpeech textToSpeech = mTextToSpeech;
        if (textToSpeech != null) {
            textToSpeech.stop();
            mTextToSpeech.shutdown();
            mTextToSpeech = null;
        }
    }
}
