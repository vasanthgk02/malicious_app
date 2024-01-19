package org.spongycastle.util;

import com.mpl.androidapp.utils.Constant;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import okio.Utf8;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

public final class Strings {

    public static class StringListImpl extends ArrayList<String> implements StringList {
        public StringListImpl() {
        }

        public void add(int i, Object obj) {
            super.add(i, (String) obj);
        }

        public /* bridge */ /* synthetic */ String get(int i) {
            return (String) super.get(i);
        }

        public Object set(int i, Object obj) {
            return (String) super.set(i, (String) obj);
        }

        public StringListImpl(AnonymousClass1 r1) {
        }

        public boolean add(Object obj) {
            return super.add((String) obj);
        }

        public boolean add(String str) {
            return super.add(str);
        }
    }

    static {
        try {
            String str = (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
                public Object run() {
                    return System.getProperty("line.separator");
                }
            });
        } catch (Exception unused) {
            try {
                String.format("%n", new Object[0]);
            } catch (Exception unused2) {
            }
        }
    }

    public static String fromByteArray(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i != length; i++) {
            cArr[i] = (char) (bArr[i] & 255);
        }
        return new String(cArr);
    }

    public static String fromUTF8ByteArray(byte[] bArr) {
        char c2;
        int i;
        byte b2;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            i4++;
            if ((bArr[i3] & 240) == 240) {
                i4++;
                i3 += 4;
            } else if ((bArr[i3] & 224) == 224) {
                i3 += 3;
            } else {
                i3 = (bArr[i3] & 192) == 192 ? i3 + 2 : i3 + 1;
            }
        }
        char[] cArr = new char[i4];
        int i5 = 0;
        while (i2 < bArr.length) {
            if ((bArr[i2] & 240) == 240) {
                int i6 = (((((bArr[i2] & 3) << 18) | ((bArr[i2 + 1] & Utf8.REPLACEMENT_BYTE) << MqttWireMessage.MESSAGE_TYPE_PINGREQ)) | ((bArr[i2 + 2] & Utf8.REPLACEMENT_BYTE) << 6)) | (bArr[i2 + 3] & Utf8.REPLACEMENT_BYTE)) - 65536;
                c2 = (char) ((i6 & Constant.PERMISSIONS_REQUEST_AUDIO) | Utf8.LOG_SURROGATE_HEADER);
                cArr[i5] = (char) (55296 | (i6 >> 10));
                i2 += 4;
                i5++;
            } else if ((bArr[i2] & 224) == 224) {
                c2 = (char) (((bArr[i2] & 15) << MqttWireMessage.MESSAGE_TYPE_PINGREQ) | ((bArr[i2 + 1] & Utf8.REPLACEMENT_BYTE) << 6) | (bArr[i2 + 2] & Utf8.REPLACEMENT_BYTE));
                i2 += 3;
            } else {
                if ((bArr[i2] & 208) == 208) {
                    i = (bArr[i2] & 31) << 6;
                    b2 = bArr[i2 + 1];
                } else if ((bArr[i2] & 192) == 192) {
                    i = (bArr[i2] & 31) << 6;
                    b2 = bArr[i2 + 1];
                } else {
                    c2 = (char) (bArr[i2] & 255);
                    i2++;
                }
                c2 = (char) (i | (b2 & Utf8.REPLACEMENT_BYTE));
                i2 += 2;
            }
            cArr[i5] = c2;
            i5++;
        }
        return new String(cArr);
    }

    public static StringList newList() {
        return new StringListImpl(null);
    }

    public static String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z = false;
        for (int i = 0; i != charArray.length; i++) {
            char c2 = charArray[i];
            if ('A' <= c2 && 'Z' >= c2) {
                charArray[i] = (char) ((c2 - 'A') + 97);
                z = true;
            }
        }
        return z ? new String(charArray) : str;
    }
}
