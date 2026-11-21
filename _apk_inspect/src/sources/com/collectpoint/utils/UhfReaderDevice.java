package com.collectpoint.utils;

import java.io.IOException;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class UhfReaderDevice {
    private static ReaderPower devPower = null;
    private static UhfReaderDevice readerDevice;

    public static UhfReaderDevice getInstance() throws IOException {
        if (devPower == null) {
            try {
                ReaderPower readerPower = new ReaderPower();
                devPower = readerPower;
                readerPower.uhfPowerOn();
            } catch (Exception e) {
                return null;
            }
        }
        if (readerDevice == null) {
            readerDevice = new UhfReaderDevice();
        }
        return readerDevice;
    }

    public void powerOff() throws IOException {
        ReaderPower readerPower = devPower;
        if (readerPower != null) {
            readerPower.uhfPowerOff();
            devPower = null;
        }
    }

    public void powerOn() throws IOException {
        ReaderPower readerPower = devPower;
        if (readerPower != null) {
            readerPower.uhfPowerOn();
        }
    }
}
