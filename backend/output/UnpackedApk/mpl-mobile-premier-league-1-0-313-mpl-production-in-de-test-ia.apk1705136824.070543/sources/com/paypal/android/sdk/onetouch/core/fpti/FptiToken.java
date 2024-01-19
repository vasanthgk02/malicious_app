package com.paypal.android.sdk.onetouch.core.fpti;

import com.freshchat.consumer.sdk.beans.config.DefaultRemoteConfig;
import java.util.Random;

public class FptiToken {
    public String mToken;
    public long mValidUntil;

    public FptiToken() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mToken == null) {
            this.mValidUntil = currentTimeMillis;
        }
        if (this.mValidUntil + DefaultRemoteConfig.SESSION_TIMEOUT_DURATION > currentTimeMillis) {
            this.mValidUntil = currentTimeMillis + DefaultRemoteConfig.SESSION_TIMEOUT_DURATION;
            Random random = new Random(this.mValidUntil);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8; i++) {
                sb.append((char) ((Math.abs(random.nextInt()) % 10) + 48));
            }
            this.mToken = sb.toString();
        }
    }
}
