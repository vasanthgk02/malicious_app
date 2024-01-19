package com.freshchat.consumer.sdk.beans.config;

public class AccountConfig {
    public FAQAPIVersion fcFaqApiVersion;

    public enum FAQAPIVersion {
        STANDALONE(1),
        KBASE_SERVICE(2);
        
        public final int apiVersionCode;

        /* access modifiers changed from: public */
        FAQAPIVersion(int i) {
            this.apiVersionCode = i;
        }

        public static FAQAPIVersion fromInt(int i) {
            for (FAQAPIVersion fAQAPIVersion : values()) {
                if (fAQAPIVersion.asInt() == i) {
                    return fAQAPIVersion;
                }
            }
            return STANDALONE;
        }

        public int asInt() {
            return this.apiVersionCode;
        }
    }

    public FAQAPIVersion getFcFaqApiVersion() {
        if (this.fcFaqApiVersion == null) {
            this.fcFaqApiVersion = DefaultAccountConfig.DEFAULT_FAQ_API_VERSION;
        }
        return this.fcFaqApiVersion;
    }

    public void setFcFaqApiVersion(FAQAPIVersion fAQAPIVersion) {
        this.fcFaqApiVersion = fAQAPIVersion;
    }
}
