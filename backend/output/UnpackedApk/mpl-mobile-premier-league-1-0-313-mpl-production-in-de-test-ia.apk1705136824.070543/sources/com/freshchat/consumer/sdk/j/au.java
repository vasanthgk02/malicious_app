package com.freshchat.consumer.sdk.j;

import com.freshchat.consumer.sdk.beans.Csat;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;

public class au {
    public static boolean a(RemoteConfig remoteConfig) {
        return remoteConfig.getCsatConfig().doesCsatAutoExpire();
    }

    public static boolean a(RemoteConfig remoteConfig, long j) {
        if (j <= 0) {
            return false;
        }
        return System.currentTimeMillis() - j > remoteConfig.getCsatConfig().getCsatExpiryInterval();
    }

    public static boolean a(RemoteConfig remoteConfig, Csat csat) {
        if (csat == null) {
            return true;
        }
        return a(remoteConfig, csat.getInitiatedTime());
    }
}
