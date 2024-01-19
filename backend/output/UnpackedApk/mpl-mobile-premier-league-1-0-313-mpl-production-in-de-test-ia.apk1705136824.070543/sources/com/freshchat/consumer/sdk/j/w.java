package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.config.Feature;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;

public class w {
    public static boolean a(Context context, Feature feature) {
        RemoteConfig bx = bx(context);
        return bx != null && k.a(bx.getEnabledFeatures()) && bx.getEnabledFeatures().contains(feature.name());
    }

    public static boolean aA(Context context) {
        return a(context, Feature.INBOX);
    }

    public static boolean aB(Context context) {
        return a(context, Feature.AOT_USER_CREATE);
    }

    public static boolean aC(Context context) {
        return a(context, Feature.MANUAL_CAMPAIGNS);
    }

    public static boolean ay(Context context) {
        RemoteConfig bx = bx(context);
        return bx != null && bx.isAccountActive();
    }

    public static boolean az(Context context) {
        return a(context, Feature.FAQ);
    }

    public static RemoteConfig bx(Context context) {
        return ap.bD(context);
    }
}
