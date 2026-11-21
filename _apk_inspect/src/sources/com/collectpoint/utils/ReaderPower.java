package com.collectpoint.utils;

import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class ReaderPower {
    private void openPwr(String str) throws IOException {
        writeFile("/dev/l550_card", str.toCharArray());
    }

    private int writeFile(String str, char[] cArr) throws IOException {
        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                Log.e("log", "file not exist: " + str);
                return 1;
            }
            BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter(file));
            bufferedWriter2.write(cArr);
            bufferedWriter2.close();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            if (0 == 0) {
                return 1;
            }
            try {
                bufferedWriter.close();
                return 1;
            } catch (IOException e2) {
                return 1;
            }
        }
    }

    public void uhfPowerOff() throws IOException {
        openPwr(BitmapMemoryCache.BITMAP_CLEAR_STATUS_AUTO);
    }

    public void uhfPowerOn() throws IOException {
        openPwr("1");
    }
}
