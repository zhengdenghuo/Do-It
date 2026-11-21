package com.magicrf.uhfreaderlib.reader;

import com.magicrf.uhfreaderlib.readerInterface.CommendManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes16.dex */
public class UhfReader implements CommendManager {
    private static InputStream in;
    private static NewSendCommendManager manager;
    private static OutputStream os;
    private static UhfReader reader;
    private static ReaderPort serialPort;
    private static String port = "/dev/ttyS1";
    private static int baudRate = 115200;

    public static UhfReader getInstance() {
        if (serialPort == null) {
            try {
                ReaderPort readerPort = new ReaderPort(port, baudRate, 0);
                serialPort = readerPort;
                in = readerPort.getInputStream();
                os = serialPort.getOutputStream();
            } catch (Exception e) {
                return null;
            }
        }
        if (manager == null) {
            manager = new NewSendCommendManager(in, os);
        }
        if (reader == null) {
            reader = new UhfReader();
        }
        return reader;
    }

    public static void setPortPath(String portPath) {
        port = portPath;
    }

    public String getPortPath() {
        return port;
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public boolean setBaudrate(int baudrate) {
        return manager.setBaudrate(baudrate);
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public byte[] getFirmware() {
        return manager.getFirmware();
    }

    public byte[] getHardwareVersion() {
        return manager.getHardwareVersion();
    }

    public byte[] getManufacturer() {
        return manager.getManufacturer();
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public boolean setOutputPower(int value) {
        return manager.setOutputPower(value);
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public List<byte[]> inventoryRealTime() {
        return manager.inventoryRealTime();
    }

    public List<Integer> getRssiList() {
        return manager.getRssiList();
    }

    public void setSelectMode(byte mode) throws InterruptedException, IOException {
        manager.setSelectMode(mode);
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public void selectEpc(byte[] epc) throws InterruptedException, IOException {
        manager.selectEpc(epc);
    }

    public void setSelectPara(byte target, byte action, byte memBank, int pointer, byte maskLen, boolean truncated, byte[] mask) throws InterruptedException, IOException {
        manager.setSelectPara(target, action, memBank, pointer, maskLen, truncated, mask);
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public byte[] readFrom6C(int memBank, int startAddr, int length, byte[] accessPassword) {
        return manager.readFrom6C(memBank, startAddr, length, accessPassword);
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public boolean writeTo6C(byte[] password, int memBank, int startAddr, int dataLen, byte[] data) {
        return manager.writeTo6C(password, memBank, startAddr, dataLen, data);
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public boolean setSensitivity(int value) {
        return manager.setSensitivity(value);
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public boolean lock6C(byte[] password, int memBank, int lockType) {
        return manager.lock6C(password, memBank, lockType);
    }

    public boolean lock6CwithPayload(byte[] password, int payload) {
        return manager.lock6CwithPayload(password, payload);
    }

    public boolean kill6C(byte[] password) {
        return manager.kill6C(password);
    }

    public boolean kill6C(byte[] password, int rfu) {
        return manager.kill6C(password, rfu);
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public void close() throws IOException {
        NewSendCommendManager newSendCommendManager = manager;
        if (newSendCommendManager != null) {
            newSendCommendManager.close();
            manager = null;
        }
        ReaderPort readerPort = serialPort;
        if (readerPort != null) {
            readerPort.close();
            serialPort = null;
        }
        if (reader != null) {
            reader = null;
        }
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public byte checkSum(byte[] paramArrayOfByte) {
        byte checksum = 0;
        for (byte b : paramArrayOfByte) {
            checksum = (byte) (checksum + b);
        }
        return checksum;
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public int setFrequency(int startFrequency, int freqSpace, int freqQuality) {
        return manager.setFrequency(startFrequency, freqSpace, freqQuality);
    }

    public boolean setFrequency(int index) {
        return manager.setFrequency(index);
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public boolean setFHSS(boolean on) {
        return manager.setFHSS(on);
    }

    public void setDistance(int distance) {
    }

    public void close(InputStream input, OutputStream output) throws IOException {
        if (manager != null) {
            manager = null;
            try {
                input.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean setWorkArea(int area) {
        return manager.setWorkArea(area);
    }

    public List<byte[]> inventoryMulti() {
        return manager.inventoryMulti();
    }

    public void stopInventoryMulti() throws InterruptedException, IOException {
        manager.stopInventoryMulti();
    }

    public int getFrequency() {
        return manager.getFrequency();
    }

    public boolean unSelect() {
        return manager.unSelect();
    }

    public void setRecvParam(int mixer_g, int if_g, int trd) throws InterruptedException, IOException {
        manager.setModemParam(mixer_g, if_g, trd);
    }

    public boolean setModemParam(int mixer_g, int if_g, int trd) {
        return manager.setModemParam(mixer_g, if_g, trd);
    }

    public byte[] getModemParam() {
        return manager.getModemParam();
    }
}
