package org.eclipse.paho.client.mqttv3.internal.wire;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistable;
import org.eclipse.paho.client.mqttv3.internal.ExceptionHelper;
import sfs2x.client.entities.invitation.InvitationReply;

public abstract class MqttWireMessage {
    public static final byte MESSAGE_TYPE_CONNACK = 2;
    public static final byte MESSAGE_TYPE_CONNECT = 1;
    public static final byte MESSAGE_TYPE_DISCONNECT = 14;
    public static final byte MESSAGE_TYPE_PINGREQ = 12;
    public static final byte MESSAGE_TYPE_PINGRESP = 13;
    public static final byte MESSAGE_TYPE_PUBACK = 4;
    public static final byte MESSAGE_TYPE_PUBCOMP = 7;
    public static final byte MESSAGE_TYPE_PUBLISH = 3;
    public static final byte MESSAGE_TYPE_PUBREC = 5;
    public static final byte MESSAGE_TYPE_PUBREL = 6;
    public static final byte MESSAGE_TYPE_SUBACK = 9;
    public static final byte MESSAGE_TYPE_SUBSCRIBE = 8;
    public static final byte MESSAGE_TYPE_UNSUBACK = 11;
    public static final byte MESSAGE_TYPE_UNSUBSCRIBE = 10;
    public static final String[] PACKET_NAMES = {"reserved", "CONNECT", "CONNACK", "PUBLISH", "PUBACK", "PUBREC", "PUBREL", "PUBCOMP", "SUBSCRIBE", "SUBACK", "UNSUBSCRIBE", "UNSUBACK", "PINGREQ", "PINGRESP", "DISCONNECT"};
    public static final String STRING_ENCODING = "UTF-8";
    public boolean duplicate = false;
    public int msgId;
    public byte type;

    public MqttWireMessage(byte b2) {
        this.type = b2;
        this.msgId = 0;
    }

    public static MqttWireMessage createWireMessage(MqttPersistable mqttPersistable) throws MqttException {
        byte[] payloadBytes = mqttPersistable.getPayloadBytes();
        if (payloadBytes == null) {
            payloadBytes = new byte[0];
        }
        MultiByteArrayInputStream multiByteArrayInputStream = new MultiByteArrayInputStream(mqttPersistable.getHeaderBytes(), mqttPersistable.getHeaderOffset(), mqttPersistable.getHeaderLength(), payloadBytes, mqttPersistable.getPayloadOffset(), mqttPersistable.getPayloadLength());
        return createWireMessage((InputStream) multiByteArrayInputStream);
    }

    public static byte[] encodeMBI(long j) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        do {
            byte b2 = (byte) ((int) (j % 128));
            j /= 128;
            int i2 = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i2 > 0) {
                b2 = (byte) (b2 | 128);
            }
            byteArrayOutputStream.write(b2);
            i++;
            if (i2 <= 0) {
                break;
            }
        } while (i < 4);
        return byteArrayOutputStream.toByteArray();
    }

    public static MultiByteInteger readMBI(DataInputStream dataInputStream) throws IOException {
        byte readByte;
        long j = 0;
        int i = 0;
        int i2 = 1;
        do {
            readByte = dataInputStream.readByte();
            i++;
            j += (long) ((readByte & Byte.MAX_VALUE) * i2);
            i2 *= 128;
        } while ((readByte & 128) != 0);
        return new MultiByteInteger(j, i);
    }

    public String decodeUTF8(DataInputStream dataInputStream) throws MqttException {
        try {
            byte[] bArr = new byte[dataInputStream.readUnsignedShort()];
            dataInputStream.readFully(bArr);
            return new String(bArr, "UTF-8");
        } catch (IOException e2) {
            throw new MqttException((Throwable) e2);
        }
    }

    public byte[] encodeMessageId() throws MqttException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeShort(this.msgId);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException((Throwable) e2);
        }
    }

    public void encodeUTF8(DataOutputStream dataOutputStream, String str) throws MqttException {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            dataOutputStream.write((byte) ((bytes.length >>> 8) & InvitationReply.EXPIRED));
            dataOutputStream.write((byte) ((bytes.length >>> 0) & InvitationReply.EXPIRED));
            dataOutputStream.write(bytes);
        } catch (UnsupportedEncodingException e2) {
            throw new MqttException((Throwable) e2);
        } catch (IOException e3) {
            throw new MqttException((Throwable) e3);
        }
    }

    public byte[] getHeader() throws MqttException {
        try {
            byte type2 = ((getType() & 15) << 4) ^ (getMessageInfo() & 15);
            byte[] variableHeader = getVariableHeader();
            int length = variableHeader.length + getPayload().length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(type2);
            dataOutputStream.write(encodeMBI((long) length));
            dataOutputStream.write(variableHeader);
            dataOutputStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new MqttException((Throwable) e2);
        }
    }

    public String getKey() {
        return new Integer(getMessageId()).toString();
    }

    public int getMessageId() {
        return this.msgId;
    }

    public abstract byte getMessageInfo();

    public byte[] getPayload() throws MqttException {
        return new byte[0];
    }

    public byte getType() {
        return this.type;
    }

    public abstract byte[] getVariableHeader() throws MqttException;

    public boolean isMessageIdRequired() {
        return true;
    }

    public boolean isRetryable() {
        return false;
    }

    public void setDuplicate(boolean z) {
        this.duplicate = z;
    }

    public void setMessageId(int i) {
        this.msgId = i;
    }

    public String toString() {
        return PACKET_NAMES[this.type];
    }

    public static MqttWireMessage createWireMessage(byte[] bArr) throws MqttException {
        return createWireMessage((InputStream) new ByteArrayInputStream(bArr));
    }

    public static MqttWireMessage createWireMessage(InputStream inputStream) throws MqttException {
        try {
            CountingInputStream countingInputStream = new CountingInputStream(inputStream);
            DataInputStream dataInputStream = new DataInputStream(countingInputStream);
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            byte b2 = (byte) (readUnsignedByte >> 4);
            byte b3 = (byte) (readUnsignedByte & 15);
            long counter = (((long) countingInputStream.getCounter()) + readMBI(dataInputStream).getValue()) - ((long) countingInputStream.getCounter());
            byte[] bArr = new byte[0];
            if (counter > 0) {
                int i = (int) counter;
                byte[] bArr2 = new byte[i];
                dataInputStream.readFully(bArr2, 0, i);
                bArr = bArr2;
            }
            if (b2 == 1) {
                return new MqttConnect(b3, bArr);
            }
            if (b2 == 3) {
                return new MqttPublish(b3, bArr);
            }
            if (b2 == 4) {
                return new MqttPubAck(b3, bArr);
            }
            if (b2 == 7) {
                return new MqttPubComp(b3, bArr);
            }
            if (b2 == 2) {
                return new MqttConnack(b3, bArr);
            }
            if (b2 == 12) {
                return new MqttPingReq(b3, bArr);
            }
            if (b2 == 13) {
                return new MqttPingResp(b3, bArr);
            }
            if (b2 == 8) {
                return new MqttSubscribe(b3, bArr);
            }
            if (b2 == 9) {
                return new MqttSuback(b3, bArr);
            }
            if (b2 == 10) {
                return new MqttUnsubscribe(b3, bArr);
            }
            if (b2 == 11) {
                return new MqttUnsubAck(b3, bArr);
            }
            if (b2 == 6) {
                return new MqttPubRel(b3, bArr);
            }
            if (b2 == 5) {
                return new MqttPubRec(b3, bArr);
            }
            if (b2 == 14) {
                return new MqttDisconnect(b3, bArr);
            }
            throw ExceptionHelper.createMqttException(6);
        } catch (IOException e2) {
            throw new MqttException((Throwable) e2);
        }
    }
}
