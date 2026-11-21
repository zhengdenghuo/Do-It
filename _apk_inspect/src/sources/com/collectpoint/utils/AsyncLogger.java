package com.collectpoint.utils;

import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes4.dex */
public class AsyncLogger {
    private static volatile AsyncLogger instance = null;
    private SimpleDateFormat mFormat;
    private WriteThread mThread;

    public class WriteThread extends Thread {
        private String filePath;
        private boolean isRunning;
        private Object lock = new Object();
        private ConcurrentLinkedQueue<String> mQueue = new ConcurrentLinkedQueue<>();

        public WriteThread() {
            this.isRunning = false;
            this.filePath = null;
            String path = getPath();
            if (path != null) {
                this.filePath = path + "/wusn_log.txt";
            }
            this.isRunning = true;
        }

        public void awake() {
            synchronized (this.lock) {
                this.lock.notify();
            }
        }

        public void deleteLogFile() {
            File file = new File(this.filePath);
            if (file.exists()) {
                file.delete();
            }
        }

        public void enqueue(String str) {
            this.mQueue.add(str);
            if (isRunning()) {
                return;
            }
            awake();
        }

        public boolean exist() {
            return Environment.getExternalStorageState().equals("mounted");
        }

        public String getPath() {
            if (exist()) {
                return Environment.getExternalStorageDirectory().toString();
            }
            return null;
        }

        public boolean isExitLogFile() {
            File file = new File(this.filePath);
            return file.exists() && file.length() > 3;
        }

        public boolean isRunning() {
            return this.isRunning;
        }

        public void recordStringLog(String str) throws IOException {
            File file = new File(this.filePath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                synchronized (this.lock) {
                    this.isRunning = true;
                    while (!this.mQueue.isEmpty()) {
                        try {
                            recordStringLog(this.mQueue.poll());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    this.isRunning = false;
                    try {
                        this.lock.wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private AsyncLogger() {
        this.mFormat = null;
        this.mThread = null;
        this.mThread = new WriteThread();
        this.mFormat = new SimpleDateFormat("MM-dd HH:mm:ss:SS");
        this.mThread.start();
    }

    public static void Logging(String str, String str2) {
        Log.e(str, str2);
        getInstance().Log(str, str2);
    }

    public static void LoggingE(String str, String str2, Exception exc) {
        Log.e(str, str2, exc);
        try {
            StringWriter stringWriter = new StringWriter();
            exc.printStackTrace(new PrintWriter(stringWriter));
            String str3 = str2 + "\r\n" + stringWriter.toString() + "\r\n";
        } catch (Exception e) {
            String str4 = str2 + " fail to print Exception";
        }
        getInstance().Log(str, str2);
    }

    public static AsyncLogger getInstance() {
        if (instance == null) {
            synchronized (AsyncLogger.class) {
                if (instance == null) {
                    instance = new AsyncLogger();
                }
            }
        }
        return instance;
    }

    public synchronized void Log(String str, String str2) {
        this.mThread.enqueue(this.mFormat.format(new Date()) + " " + str + " " + str2);
    }
}
