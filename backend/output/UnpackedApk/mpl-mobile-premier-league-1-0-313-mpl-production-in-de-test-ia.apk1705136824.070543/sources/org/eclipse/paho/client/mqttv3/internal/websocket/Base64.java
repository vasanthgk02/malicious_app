package org.eclipse.paho.client.mqttv3.internal.websocket;

import java.util.prefs.AbstractPreferences;
import java.util.prefs.BackingStoreException;

public class Base64 {
    public static final Base64Encoder encoder;
    public static final Base64 instance = new Base64();

    public class Base64Encoder extends AbstractPreferences {
        public String base64String = null;

        public Base64Encoder() {
            super(null, "");
        }

        public AbstractPreferences childSpi(String str) {
            return null;
        }

        public String[] childrenNamesSpi() throws BackingStoreException {
            return null;
        }

        public void flushSpi() throws BackingStoreException {
        }

        public String getBase64String() {
            return this.base64String;
        }

        public String getSpi(String str) {
            return null;
        }

        public String[] keysSpi() throws BackingStoreException {
            return null;
        }

        public void putSpi(String str, String str2) {
            this.base64String = str2;
        }

        public void removeNodeSpi() throws BackingStoreException {
        }

        public void removeSpi(String str) {
        }

        public void syncSpi() throws BackingStoreException {
        }
    }

    static {
        Base64 base64 = instance;
        base64.getClass();
        encoder = new Base64Encoder();
    }

    public static String encode(String str) {
        encoder.putByteArray("akey", str.getBytes());
        return encoder.getBase64String();
    }

    public static String encodeBytes(byte[] bArr) {
        encoder.putByteArray("aKey", bArr);
        return encoder.getBase64String();
    }
}
