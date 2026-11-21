package com.magicrf.uhfreaderlib.reader;

import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes16.dex */
public class ReaderPort {
    private static final String TAG = "SerialPort";
    private FileDescriptor mFd;
    private FileInputStream mFileInputStream;
    private FileOutputStream mFileOutputStream;
    private boolean trig_on = false;

    private static native FileDescriptor open(String str, int i, int i2);

    public native void close();

    public ReaderPort(String port, int baudrate, int flags) throws IOException, SecurityException {
        File portFile = new File(port);
        if (!portFile.canRead() || !portFile.canWrite()) {
            try {
                Process localProcess = Runtime.getRuntime().exec("/system/bin/su");
                String str = "chmod 666 " + portFile.getAbsolutePath() + "\nexit\n";
                localProcess.getOutputStream().write(str.getBytes());
                if (localProcess.waitFor() != 0 || !portFile.canRead() || !portFile.canWrite()) {
                    throw new SecurityException();
                }
            } catch (Exception localException) {
                localException.printStackTrace();
                throw new SecurityException();
            }
        }
        FileDescriptor fileDescriptorOpen = open(portFile.getAbsolutePath(), baudrate, flags);
        this.mFd = fileDescriptorOpen;
        if (fileDescriptorOpen == null) {
            Log.e(TAG, "native open returns null");
            throw new IOException();
        }
        this.mFileInputStream = new FileInputStream(this.mFd);
        this.mFileOutputStream = new FileOutputStream(this.mFd);
    }

    public InputStream getInputStream() {
        return this.mFileInputStream;
    }

    public OutputStream getOutputStream() {
        return this.mFileOutputStream;
    }

    static {
        System.loadLibrary(TAG);
    }
}
