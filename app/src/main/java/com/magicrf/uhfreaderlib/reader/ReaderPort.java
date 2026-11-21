package com.magicrf.uhfreaderlib.reader;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

/**
 * JNI class name must stay {@code com.magicrf.uhfreaderlib.reader.ReaderPort}.
 * {@code libSerialPort.so} binds {@code Java_com_magicrf_uhfreaderlib_reader_ReaderPort_open/close}.
 */
public class ReaderPort {
    /** Name must stay {@code mFd}. libSerialPort.so reads this field in close(). */
    private FileDescriptor mFd;
    private FileInputStream inputStream;
    private FileOutputStream outputStream;

    private static native FileDescriptor open(String path, int baudrate, int flags);

    public native void close();

    static {
        System.loadLibrary("SerialPort");
    }

    public ReaderPort(String port, int baudrate, int flags) throws IOException {
        File portFile = new File(port);
        if (!portFile.canRead() || !portFile.canWrite()) {
            Process process = null;
            try {
                process = Runtime.getRuntime().exec("/system/bin/su");
                String command = "chmod 666 " + portFile.getAbsolutePath() + "\nexit\n";
                OutputStream processOut = process.getOutputStream();
                processOut.write(command.getBytes());
                processOut.flush();
                processOut.close();
                if (!process.waitFor(2, TimeUnit.SECONDS) || !portFile.canRead() || !portFile.canWrite()) {
                    process.destroy();
                    throw new SecurityException();
                }
            } catch (Exception exception) {
                if (process != null) {
                    process.destroy();
                }
                if (exception instanceof SecurityException) {
                    throw (SecurityException) exception;
                }
                throw new SecurityException();
            }
        }
        mFd = open(portFile.getAbsolutePath(), baudrate, flags);
        if (mFd == null) {
            throw new IOException("native open returns null");
        }
        inputStream = new FileInputStream(mFd);
        outputStream = new FileOutputStream(mFd);
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
