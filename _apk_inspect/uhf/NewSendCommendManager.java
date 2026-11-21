package com.magicrf.uhfreaderlib.reader;

import android.util.Log;
import com.just.agentweb.DefaultWebClient;
import com.magicrf.uhfreaderlib.consts.Constants;
import com.magicrf.uhfreaderlib.readerInterface.CommendManager;
import com.yanzhenjie.durban.view.CropImageView;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinVersion;

/* loaded from: D:\anzhuo\_apk_inspect\unzipped\classes16.dex */
public class NewSendCommendManager implements CommendManager {
    public static final byte ERROR_CODE_ACCESS_FAIL = 22;
    public static final byte ERROR_CODE_NO_CARD = 9;
    public static final byte ERROR_CODE_READ_SA_OR_LEN_ERROR = -93;
    public static final byte ERROR_CODE_WRITE_SA_OR_LEN_ERROR = -77;
    public static final byte RESPONSE_OK = 0;
    public static final int SENSITIVE_HIHG = 3;
    public static final int SENSITIVE_LOW = 1;
    public static final int SENSITIVE_MIDDLE = 2;
    public static final int SENSITIVE_VERY_LOW = 0;
    private InputStream in;
    private OutputStream out;
    private final byte HEAD = Constants.FRAME_BEGIN;
    private final byte END = Constants.FRAME_END;
    private byte[] selectEPC = null;
    private List<Integer> rssiList = new ArrayList();

    public NewSendCommendManager(InputStream serialPortInput, OutputStream serialportOutput) {
        this.in = serialPortInput;
        this.out = serialportOutput;
    }

    public void sendCMD(byte[] cmd) throws IOException {
        try {
            this.out.write(cmd);
            this.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public boolean setBaudrate(int baudrate) throws IOException {
        byte[] cmd = {Constants.FRAME_BEGIN, 0, Constants.CMD_SET_BAUDRATE, 0, 2, 4, -128, -105, Constants.FRAME_END};
        cmd[5] = (byte) ((baudrate / 100) >> 8);
        cmd[6] = (byte) ((baudrate / 100) & KotlinVersion.MAX_COMPONENT_VALUE);
        cmd[cmd.length - 2] = checkSum(cmd);
        sendCMD(cmd);
        return true;
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public byte[] getFirmware() throws InterruptedException, IOException {
        byte[] resolve;
        byte[] cmd = {Constants.FRAME_BEGIN, 0, 3, 0, 1, 1, 4, Constants.FRAME_END};
        cmd[6] = checkSum(cmd);
        sendCMD(cmd);
        byte[] response = read();
        if (response == null || (resolve = handlerResponse(response)) == null || resolve.length <= 1) {
            return null;
        }
        byte[] version = new byte[resolve.length - 1];
        System.arraycopy(resolve, 1, version, 0, resolve.length - 1);
        return version;
    }

    public byte[] getHardwareVersion() throws InterruptedException, IOException {
        byte[] resolve;
        byte[] cmd = {Constants.FRAME_BEGIN, 0, 3, 0, 1, 0, 5, Constants.FRAME_END};
        cmd[6] = checkSum(cmd);
        sendCMD(cmd);
        byte[] response = read();
        if (response == null || (resolve = handlerResponse(response)) == null || resolve.length <= 1) {
            return null;
        }
        byte[] version = new byte[resolve.length - 1];
        System.arraycopy(resolve, 1, version, 0, resolve.length - 1);
        return version;
    }

    public byte[] getManufacturer() throws InterruptedException, IOException {
        byte[] resolve;
        byte[] cmd = {Constants.FRAME_BEGIN, 0, 3, 0, 1, 2, 6, Constants.FRAME_END};
        cmd[6] = checkSum(cmd);
        sendCMD(cmd);
        byte[] response = read();
        if (response == null || (resolve = handlerResponse(response)) == null || resolve.length <= 1) {
            return null;
        }
        byte[] manufacturer = new byte[resolve.length - 1];
        System.arraycopy(resolve, 1, manufacturer, 0, resolve.length - 1);
        return manufacturer;
    }

    public byte[] read() throws InterruptedException, IOException {
        byte[] response = null;
        int available = 0;
        int headIndex = 0;
        for (int index = 0; index < 10; index++) {
            try {
                Thread.sleep(50L);
                available = this.in.available();
                if (available > 7) {
                    break;
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                return response;
            }
        }
        Thread.sleep(50L);
        if (available <= 0) {
            return null;
        }
        int available2 = this.in.available();
        byte[] responseData = new byte[available2];
        this.in.read(responseData);
        int i = 0;
        while (true) {
            if (i >= available2) {
                break;
            }
            if (responseData[i] != -69) {
                i++;
            } else {
                headIndex = i;
                break;
            }
        }
        int i2 = available2 - headIndex;
        response = new byte[i2];
        System.arraycopy(responseData, headIndex, response, 0, response.length);
        Log.i("read", Tools.Bytes2HexString(responseData, responseData.length));
        return response;
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public boolean setOutputPower(int power) throws InterruptedException, IOException {
        byte[] cmd = new byte[9];
        cmd[0] = Constants.FRAME_BEGIN;
        cmd[1] = 0;
        cmd[2] = Constants.CMD_SET_POWER;
        cmd[3] = 0;
        cmd[4] = 2;
        cmd[5] = (byte) (power >> 8);
        cmd[6] = (byte) (power & KotlinVersion.MAX_COMPONENT_VALUE);
        cmd[7] = checkSum(cmd);
        cmd[8] = Constants.FRAME_END;
        sendCMD(cmd);
        byte[] recv = read();
        if (recv != null) {
            byte[] content = handlerResponse(recv);
            if (content != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public boolean setSensitivity(int value) {
        int mixer;
        int if_g;
        int trd;
        switch (value) {
            case 16:
                mixer = 1;
                if_g = 1;
                trd = 432;
                break;
            case 17:
                mixer = 1;
                if_g = 3;
                trd = 432;
                break;
            case 18:
                mixer = 2;
                if_g = 4;
                trd = 432;
                break;
            case 19:
            case 20:
            case 21:
                mixer = 2;
                if_g = 6;
                trd = 560;
                break;
            case 22:
                mixer = 3;
                if_g = 6;
                trd = 624;
                break;
            case 23:
                mixer = 4;
                if_g = 6;
                trd = 624;
                break;
            default:
                mixer = 6;
                if_g = 7;
                trd = 624;
                break;
        }
        return setModemParam(mixer, if_g, trd);
    }

    public boolean setModemParam(int mixer_g, int if_g, int trd) throws InterruptedException, IOException {
        byte[] cmd = {Constants.FRAME_BEGIN, 0, Constants.CMD_SET_MODEM_PARA, 0, 4, 3, 6, 1, -80, -82, Constants.FRAME_END};
        cmd[5] = (byte) mixer_g;
        cmd[6] = (byte) if_g;
        cmd[7] = (byte) (trd / 256);
        cmd[8] = (byte) (trd % 256);
        cmd[9] = checkSum(cmd);
        sendCMD(cmd);
        byte[] recv = read();
        if (recv != null) {
            byte[] content = handlerResponse(recv);
            if (content != null) {
                return true;
            }
        }
        return false;
    }

    public byte[] getModemParam() throws InterruptedException, IOException {
        byte[] content = null;
        byte[] modemPara = new byte[4];
        byte[] cmd = {Constants.FRAME_BEGIN, 0, Constants.CMD_READ_MODEM_PARA, 0, 0, Constants.CMD_READ_MODEM_PARA, Constants.FRAME_END};
        sendCMD(cmd);
        byte[] recv = read();
        if (recv != null) {
            content = handlerResponse(recv);
        }
        if (content != null) {
            System.arraycopy(content, 1, modemPara, 0, 4);
        }
        return modemPara;
    }

    public List<byte[]> inventoryMulti() throws InterruptedException, IOException {
        int paraLen;
        int singleCardLen;
        List<byte[]> list = new ArrayList<>();
        int i = 0;
        byte[] cmd = {Constants.FRAME_BEGIN, 0, Constants.CMD_READ_MULTI, 0, 3, Constants.CMD_INVENTORY, Constants.CMD_READ_MULTI, Constants.FAIL_WRITE_MEMORY_NO_TAG, -125, Constants.FRAME_END};
        sendCMD(cmd);
        byte[] response = read();
        if (response != null) {
            int responseLength = response.length;
            int start = 0;
            if (responseLength >= 12) {
                while (responseLength > 11 && (singleCardLen = (paraLen = response[start + 4] & KotlinVersion.MAX_COMPONENT_VALUE) + 7) <= responseLength) {
                    byte[] sigleCard = new byte[singleCardLen];
                    System.arraycopy(response, start, sigleCard, i, singleCardLen);
                    byte[] resolve = handlerResponse(sigleCard);
                    if (resolve != null) {
                        if (paraLen > 5) {
                            byte[] epcBytes = new byte[paraLen - 5];
                            System.arraycopy(resolve, 4, epcBytes, i, paraLen - 5);
                            list.add(epcBytes);
                            Log.i("got EPC", Tools.Bytes2HexString(epcBytes, epcBytes.length));
                        } else {
                            list.add(null);
                            Log.e("got EPC", "empty EPC, response data: " + Tools.Bytes2HexString(resolve, resolve.length));
                        }
                    }
                    start += singleCardLen;
                    responseLength -= singleCardLen;
                    i = 0;
                }
            } else {
                handlerResponse(response);
            }
        }
        return list;
    }

    public void stopInventoryMulti() throws InterruptedException, IOException {
        byte[] cmd = {Constants.FRAME_BEGIN, 0, Constants.CMD_STOP_MULTI, 0, 0, Constants.CMD_STOP_MULTI, Constants.FRAME_END};
        sendCMD(cmd);
        read();
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public List<byte[]> inventoryRealTime() throws InterruptedException, IOException {
        int paraLen;
        int singleCardLen;
        byte[] cmd;
        unSelect();
        int i = 2;
        int i2 = 5;
        byte[] cmd2 = {Constants.FRAME_BEGIN, 0, Constants.CMD_INVENTORY, 0, 0, Constants.CMD_INVENTORY, Constants.FRAME_END};
        sendCMD(cmd2);
        List<byte[]> epcList = new ArrayList<>();
        this.rssiList.clear();
        byte[] response = read();
        if (response != null) {
            int responseLength = response.length;
            int start = 0;
            if (responseLength < 12) {
                handlerResponse(response);
            } else {
                while (responseLength > 11 && (singleCardLen = (paraLen = response[start + 4] & KotlinVersion.MAX_COMPONENT_VALUE) + 7) <= responseLength) {
                    byte[] sigleCard = new byte[singleCardLen];
                    System.arraycopy(response, start, sigleCard, 0, singleCardLen);
                    byte[] resolve = handlerResponse(sigleCard);
                    if (resolve == null) {
                        cmd = cmd2;
                    } else if (paraLen > i2) {
                        byte b = resolve[0];
                        byte rssi = resolve[1];
                        byte[] pc = new byte[i];
                        pc[0] = resolve[i];
                        pc[1] = resolve[3];
                        byte[] epcBytes = new byte[paraLen - 5];
                        cmd = cmd2;
                        System.arraycopy(resolve, 4, epcBytes, 0, paraLen - 5);
                        epcList.add(epcBytes);
                        this.rssiList.add(Integer.valueOf(rssi));
                        Log.i("got EPC", Tools.Bytes2HexString(epcBytes, epcBytes.length));
                    } else {
                        cmd = cmd2;
                        byte rssi2 = resolve[1];
                        epcList.add(null);
                        this.rssiList.add(Integer.valueOf(rssi2));
                        Log.e("got EPC", "empty EPC, response data: " + Tools.Bytes2HexString(resolve, resolve.length));
                    }
                    start += singleCardLen;
                    responseLength -= singleCardLen;
                    cmd2 = cmd;
                    i = 2;
                    i2 = 5;
                }
            }
        }
        return epcList;
    }

    public List<Integer> getRssiList() {
        return this.rssiList;
    }

    public void setSelectMode(byte mode) throws InterruptedException, IOException {
        byte[] cmd = {Constants.FRAME_BEGIN, 0, 18, 0, 1, 1, Constants.FAIL_LOCK_NO_TAG, Constants.FRAME_END};
        cmd[5] = mode;
        sendCMD(cmd);
        read();
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public void selectEpc(byte[] epc) throws InterruptedException, IOException {
        this.selectEPC = epc;
        selectEpc();
    }

    public boolean unSelect() throws InterruptedException, IOException {
        byte[] cmd = {Constants.FRAME_BEGIN, 0, 18, 0, 1, 1, 20, Constants.FRAME_END};
        sendCMD(cmd);
        read();
        return true;
    }

    private void selectEpc() throws InterruptedException, IOException {
        byte[] bArr = this.selectEPC;
        byte[] cmd = new byte[bArr.length + 14];
        cmd[0] = Constants.FRAME_BEGIN;
        cmd[1] = 0;
        cmd[2] = Constants.CMD_SET_SELECT_PARA;
        cmd[3] = 0;
        cmd[4] = (byte) (bArr.length + 7);
        cmd[5] = 1;
        cmd[6] = 0;
        cmd[7] = 0;
        cmd[8] = 0;
        cmd[9] = Constants.FAIL_FHSS_FAIL;
        cmd[10] = (byte) (bArr.length * 8);
        cmd[11] = 0;
        if (bArr != null) {
            Log.v("", "select epc");
            byte[] bArr2 = this.selectEPC;
            System.arraycopy(bArr2, 0, cmd, 12, bArr2.length);
            cmd[cmd.length - 2] = checkSum(cmd);
            cmd[cmd.length - 1] = Constants.FRAME_END;
            sendCMD(cmd);
            read();
        }
    }

    public void setSelectPara(byte b, byte b2, byte b3, int i, byte b4, boolean z, byte[] bArr) throws InterruptedException, IOException {
        byte[] bArr2 = new byte[b4 + 14];
        bArr2[0] = Constants.FRAME_BEGIN;
        bArr2[1] = 0;
        bArr2[2] = Constants.CMD_SET_SELECT_PARA;
        bArr2[3] = 0;
        bArr2[4] = (byte) (b4 + 7);
        bArr2[5] = (byte) ((b << 5) | (b2 << 2) | b3);
        bArr2[6] = (byte) (i >> 24);
        bArr2[7] = (byte) (i >> 16);
        bArr2[8] = (byte) (i >> 8);
        bArr2[9] = (byte) (i >> 0);
        bArr2[10] = b4;
        bArr2[11] = z ? (byte) 1 : (byte) 0;
        Log.i("select para: ", ((int) bArr2[5]) + " " + i + " " + ((int) b4) + " " + Tools.Bytes2HexString(bArr, b4));
        System.arraycopy(bArr, 0, bArr2, 12, b4);
        bArr2[bArr2.length - 2] = checkSum(bArr2);
        sendCMD(bArr2);
        read();
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public byte[] readFrom6C(int memBank, int startAddr, int length, byte[] accessPassword) throws InterruptedException, IOException {
        selectEpc();
        byte[] cmd = new byte[16];
        cmd[0] = Constants.FRAME_BEGIN;
        cmd[2] = Constants.CMD_READ_DATA;
        cmd[4] = 9;
        cmd[9] = 3;
        cmd[13] = 8;
        cmd[14] = 77;
        cmd[15] = Constants.FRAME_END;
        if (accessPassword != null && accessPassword.length == 4) {
            System.arraycopy(accessPassword, 0, cmd, 5, 4);
            cmd[9] = (byte) memBank;
            if (startAddr <= 255) {
                cmd[10] = 0;
                cmd[11] = (byte) startAddr;
            } else {
                int addrH = startAddr / 256;
                int addrL = startAddr % 256;
                cmd[10] = (byte) addrH;
                cmd[11] = (byte) addrL;
            }
            if (length <= 255) {
                cmd[12] = 0;
                cmd[13] = (byte) length;
            } else {
                int lengH = length / 256;
                int lengL = length % 256;
                cmd[12] = (byte) lengH;
                cmd[13] = (byte) lengL;
            }
            cmd[14] = checkSum(cmd);
            sendCMD(cmd);
            byte[] response = read();
            if (response == null) {
                return null;
            }
            Log.i("readFrom6c response", Tools.Bytes2HexString(response, response.length));
            byte[] resolve = handlerResponse(response);
            if (resolve == null) {
                return null;
            }
            Log.i("readFrom6c resolve", Tools.Bytes2HexString(resolve, resolve.length));
            if (resolve[0] == 57) {
                int lengData = (resolve.length - resolve[1]) - 2;
                byte[] data = new byte[lengData];
                System.arraycopy(resolve, resolve[1] + 2, data, 0, lengData);
                return data;
            }
            return new byte[]{resolve[1]};
        }
        return null;
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public boolean writeTo6C(byte[] password, int memBank, int startAddr, int dataLen, byte[] data) throws InterruptedException, IOException {
        byte[] resolve;
        selectEpc();
        if (password == null || password.length != 4) {
            return false;
        }
        int cmdLen = data.length + 16;
        int parameterLen = data.length + 9;
        byte[] cmd = new byte[cmdLen];
        cmd[0] = Constants.FRAME_BEGIN;
        cmd[1] = 0;
        cmd[2] = Constants.CMD_WRITE_DATA;
        if (parameterLen < 256) {
            cmd[3] = 0;
            cmd[4] = (byte) parameterLen;
        } else {
            int paraH = parameterLen / 256;
            int paraL = parameterLen % 256;
            cmd[3] = (byte) paraH;
            cmd[4] = (byte) paraL;
        }
        System.arraycopy(password, 0, cmd, 5, 4);
        cmd[9] = (byte) memBank;
        if (startAddr < 256) {
            cmd[10] = 0;
            cmd[11] = (byte) startAddr;
        } else {
            int startH = startAddr / 256;
            int startL = startAddr % 256;
            cmd[10] = (byte) startH;
            cmd[11] = (byte) startL;
        }
        if (dataLen < 256) {
            cmd[12] = 0;
            cmd[13] = (byte) dataLen;
        } else {
            int dataLenH = dataLen / 256;
            int dataLenL = dataLen % 256;
            cmd[12] = (byte) dataLenH;
            cmd[13] = (byte) dataLenL;
        }
        System.arraycopy(data, 0, cmd, 14, data.length);
        cmd[cmdLen - 2] = checkSum(cmd);
        cmd[cmdLen - 1] = Constants.FRAME_END;
        sendCMD(cmd);
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byte[] response = read();
        if (response == null || (resolve = handlerResponse(response)) == null || resolve[0] != 73 || resolve[resolve.length - 1] != 0) {
            return false;
        }
        return true;
    }

    public boolean lock6CwithPayload(byte[] password, int payload) throws InterruptedException, IOException {
        byte[] resolve;
        selectEpc();
        if (password == null || password.length != 4) {
            return false;
        }
        byte[] cmd = new byte[14];
        cmd[0] = Constants.FRAME_BEGIN;
        cmd[1] = 0;
        cmd[2] = Constants.CMD_LOCK_UNLOCK;
        cmd[3] = 0;
        cmd[4] = 7;
        System.arraycopy(password, 0, cmd, 5, 4);
        cmd[9] = (byte) ((payload >> 16) & KotlinVersion.MAX_COMPONENT_VALUE);
        cmd[10] = (byte) ((payload >> 8) & KotlinVersion.MAX_COMPONENT_VALUE);
        cmd[11] = (byte) (payload & KotlinVersion.MAX_COMPONENT_VALUE);
        cmd[14 - 2] = checkSum(cmd);
        cmd[14 - 1] = Constants.FRAME_END;
        sendCMD(cmd);
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byte[] response = read();
        if (response == null || (resolve = handlerResponse(response)) == null || resolve[0] != -126 || resolve[resolve.length - 1] != 0) {
            return false;
        }
        return true;
    }

    public int genLockPayload(int memSpace, int lockType) {
        byte byte0 = 0;
        byte byte1 = 0;
        byte byte2 = 0;
        switch (memSpace) {
            case 0:
                if (lockType == 0) {
                    byte0 = (byte) (0 | 8);
                    byte1 = (byte) (0 | 0);
                    break;
                } else if (lockType == 1) {
                    byte0 = (byte) (0 | 8);
                    byte1 = (byte) (0 | 2);
                    break;
                } else if (lockType == 2) {
                    byte0 = (byte) (0 | 12);
                    byte1 = (byte) (0 | 1);
                    break;
                } else if (lockType == 3) {
                    byte0 = (byte) (0 | 12);
                    byte1 = (byte) (0 | 3);
                    break;
                }
                break;
            case 1:
                if (lockType == 0) {
                    byte0 = (byte) (0 | 2);
                    byte2 = (byte) (0 | 0);
                    break;
                } else if (lockType == 1) {
                    byte0 = (byte) (0 | 2);
                    byte2 = (byte) (0 | 128);
                    break;
                } else if (lockType == 2) {
                    byte0 = (byte) (0 | 3);
                    byte2 = (byte) (0 | 64);
                    break;
                } else if (lockType == 3) {
                    byte0 = (byte) (0 | 3);
                    byte2 = (byte) (0 | 192);
                    break;
                }
                break;
            case 2:
                if (lockType == 0) {
                    byte1 = (byte) (0 | 128);
                    byte2 = (byte) (0 | 0);
                    break;
                } else if (lockType == 1) {
                    byte1 = (byte) (0 | 128);
                    byte2 = (byte) (0 | 32);
                    break;
                } else if (lockType == 2) {
                    byte1 = (byte) (0 | 192);
                    byte2 = (byte) (0 | 16);
                    break;
                } else if (lockType == 3) {
                    byte1 = (byte) (0 | 192);
                    byte2 = (byte) (0 | 48);
                    break;
                }
                break;
            case 3:
                if (lockType == 0) {
                    byte1 = (byte) (0 | 32);
                    byte2 = (byte) (0 | 0);
                    break;
                } else if (lockType == 1) {
                    byte1 = (byte) (0 | 32);
                    byte2 = (byte) (0 | 8);
                    break;
                } else if (lockType == 2) {
                    byte1 = (byte) (0 | 48);
                    byte2 = (byte) (0 | 4);
                    break;
                } else if (lockType == 3) {
                    byte1 = (byte) (0 | 48);
                    byte2 = (byte) (0 | 12);
                    break;
                }
                break;
            case 4:
                if (lockType == 0) {
                    byte1 = (byte) (0 | 8);
                    byte2 = (byte) (0 | 0);
                    break;
                } else if (lockType == 1) {
                    byte1 = (byte) (0 | 8);
                    byte2 = (byte) (0 | 2);
                    break;
                } else if (lockType == 2) {
                    byte1 = (byte) (0 | 12);
                    byte2 = (byte) (0 | 1);
                    break;
                } else if (lockType == 3) {
                    byte1 = (byte) (0 | 12);
                    byte2 = (byte) (0 | 3);
                    break;
                }
                break;
        }
        int payload = (byte0 << Constants.FAIL_WRITE_MEMORY_NO_TAG) | (byte1 << 8) | byte2;
        return payload;
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public boolean lock6C(byte[] password, int memSpace, int lockType) {
        int payload = genLockPayload(memSpace, lockType);
        return lock6CwithPayload(password, payload);
    }

    public boolean kill6C(byte[] password) {
        return kill6C(password, 0);
    }

    public boolean kill6C(byte[] password, int rfu) throws InterruptedException, IOException {
        byte[] resolve;
        selectEpc();
        if (password == null || password.length != 4) {
            return false;
        }
        int cmdLen = 11;
        if (rfu != 0) {
            cmdLen = 11 + 1;
        }
        byte[] cmd = new byte[cmdLen];
        cmd[0] = Constants.FRAME_BEGIN;
        cmd[1] = 0;
        cmd[2] = Constants.CMD_KILL;
        cmd[3] = 0;
        cmd[4] = 4;
        if (rfu != 0) {
            cmd[4] = (byte) (cmd[4] + 1);
            cmd[9] = (byte) rfu;
        }
        System.arraycopy(password, 0, cmd, 5, 4);
        cmd[cmdLen - 2] = checkSum(cmd);
        cmd[cmdLen - 1] = Constants.FRAME_END;
        sendCMD(cmd);
        try {
            Thread.sleep(50L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        byte[] response = read();
        if (response == null || (resolve = handlerResponse(response)) == null || resolve[0] != 101 || resolve[resolve.length - 1] != 0) {
            return false;
        }
        return true;
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public void close() throws IOException {
        try {
            this.in.close();
            this.out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public byte checkSum(byte[] data) {
        byte crc = 0;
        for (int i = 1; i < data.length - 2; i++) {
            crc = (byte) (data[i] + crc);
        }
        return crc;
    }

    private byte[] handlerResponse(byte[] response) {
        int responseLength = response.length;
        if (response[0] != -69) {
            Log.e("handlerResponse", "head error");
            return null;
        }
        if (response[responseLength - 1] != 126) {
            Log.e("handlerResponse", "end error");
            return null;
        }
        if (responseLength < 7) {
            return null;
        }
        int lengthHigh = response[3] & 255;
        int lengthLow = response[4] & 255;
        int dataLength = (lengthHigh * 256) + lengthLow;
        byte crc = checkSum(response);
        if (crc != response[responseLength - 2]) {
            Log.e("handlerResponse", "crc error");
            return null;
        }
        if (dataLength == 0 || responseLength != dataLength + 7) {
            return null;
        }
        Log.v("handlerResponse", "response right");
        byte[] data = new byte[dataLength + 1];
        data[0] = response[2];
        System.arraycopy(response, 5, data, 1, dataLength);
        return data;
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public int setFrequency(int startFrequency, int freqSpace, int freqQuality) throws InterruptedException, IOException {
        int frequency = 1;
        if (startFrequency > 840125 && startFrequency < 844875) {
            frequency = (startFrequency - 840125) / DefaultWebClient.ASK_USER_OPEN_OTHER_PAGE;
        } else if (startFrequency > 920125 && startFrequency < 924875) {
            frequency = (startFrequency - 920125) / DefaultWebClient.ASK_USER_OPEN_OTHER_PAGE;
        } else if (startFrequency > 865100 && startFrequency < 867900) {
            frequency = (startFrequency - 865100) / 200;
        } else if (startFrequency > 902250 && startFrequency < 927750) {
            frequency = (startFrequency - 902250) / CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION;
        }
        byte[] cmd = {Constants.FRAME_BEGIN, 0, Constants.CMD_SET_RF_CHANNEL, 0, 1, 4, -80, Constants.FRAME_END};
        cmd[5] = (byte) frequency;
        cmd[6] = checkSum(cmd);
        sendCMD(cmd);
        byte[] recv = read();
        if (recv != null) {
            Log.e("frequency", Tools.Bytes2HexString(recv, recv.length));
        }
        return 0;
    }

    public boolean setFrequency(int index) throws InterruptedException, IOException {
        byte[] cmd = {Constants.FRAME_BEGIN, 0, Constants.CMD_SET_RF_CHANNEL, 0, 1, (byte) index, 5, Constants.FRAME_END};
        cmd[6] = checkSum(cmd);
        sendCMD(cmd);
        byte[] recv = read();
        if (recv != null) {
            Log.i("setFrequency ", Tools.Bytes2HexString(recv, recv.length));
            handlerResponse(recv);
        }
        return true;
    }

    public boolean setWorkArea(int area) throws InterruptedException, IOException {
        byte[] cmd = {Constants.FRAME_BEGIN, 0, 7, 0, 1, 1, 9, Constants.FRAME_END};
        cmd[5] = (byte) area;
        cmd[6] = checkSum(cmd);
        sendCMD(cmd);
        byte[] recv = read();
        if (recv != null) {
            Log.i("setWorkArea", Tools.Bytes2HexString(recv, recv.length));
            handlerResponse(recv);
        }
        return true;
    }

    public int getWorkArea() throws InterruptedException, IOException {
        byte[] cmd = {Constants.FRAME_BEGIN, 0, 8, 0, 0, 8, Constants.FRAME_END};
        sendCMD(cmd);
        byte[] recv = read();
        if (recv != null) {
            Log.i("getWorkArea", Tools.Bytes2HexString(recv, recv.length));
            byte[] area = handlerResponse(recv);
            if (area[0] == 8) {
                return area[1];
            }
            return -1;
        }
        return -1;
    }

    public int getFrequency() throws InterruptedException, IOException {
        byte[] cmd = {Constants.FRAME_BEGIN, 0, Constants.CMD_GET_RF_CHANNEL, 0, 0, Constants.CMD_GET_RF_CHANNEL, Constants.FRAME_END};
        sendCMD(cmd);
        byte[] recv = read();
        if (recv != null) {
            Log.i("getFrequency", Tools.Bytes2HexString(recv, recv.length));
            handlerResponse(recv);
        }
        return 0;
    }

    @Override // com.magicrf.uhfreaderlib.readerInterface.CommendManager
    public boolean setFHSS(boolean z) throws InterruptedException, IOException {
        byte[] bArr = {Constants.FRAME_BEGIN, 0, Constants.CMD_SET_FHSS, 0, 1, z ? (byte) 1 : (byte) 0, 5, Constants.FRAME_END};
        bArr[6] = checkSum(bArr);
        sendCMD(bArr);
        Log.i("setFhss: ", z ? "on" : "off");
        byte[] bArr2 = read();
        if (bArr2 == null) {
            return false;
        }
        handlerResponse(bArr2);
        return true;
    }

    public boolean setIoDirection(int i, boolean z) throws InterruptedException, IOException {
        byte[] bArr = new byte[10];
        bArr[0] = Constants.FRAME_BEGIN;
        bArr[2] = 26;
        bArr[4] = 3;
        bArr[6] = (byte) i;
        bArr[9] = Constants.FRAME_END;
        bArr[7] = z ? (byte) 1 : (byte) 0;
        bArr[8] = checkSum(bArr);
        sendCMD(bArr);
        Log.i("setIoDirection: ", "ioNo:" + i + ",output:" + z);
        byte[] bArr2 = read();
        if (bArr2 == null) {
            return false;
        }
        handlerResponse(bArr2);
        return true;
    }

    public boolean setIoLevel(int i, boolean z) throws InterruptedException, IOException {
        byte[] bArr = new byte[10];
        bArr[0] = Constants.FRAME_BEGIN;
        bArr[2] = 26;
        bArr[4] = 3;
        bArr[5] = 1;
        bArr[6] = (byte) i;
        bArr[9] = Constants.FRAME_END;
        bArr[7] = z ? (byte) 1 : (byte) 0;
        bArr[8] = checkSum(bArr);
        sendCMD(bArr);
        Log.i("setIoLevel: ", "ioNo:" + i + ",high:" + z);
        byte[] bArr2 = read();
        if (bArr2 == null) {
            return false;
        }
        handlerResponse(bArr2);
        return true;
    }
}
