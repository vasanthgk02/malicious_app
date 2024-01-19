package com.google.android.datatransport.cct.internal;

public abstract class ClientInfo {

    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);
        
        public final int value;

        /* access modifiers changed from: public */
        ClientType(int i) {
            this.value = i;
        }
    }
}
