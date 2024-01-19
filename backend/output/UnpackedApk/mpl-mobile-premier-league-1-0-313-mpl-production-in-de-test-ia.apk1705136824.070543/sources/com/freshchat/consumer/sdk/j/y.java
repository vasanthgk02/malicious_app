package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.FreshchatConfig;
import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.config.AccountConfig.FAQAPIVersion;
import com.freshchat.consumer.sdk.exception.InvalidDomainException;
import com.freshchat.consumer.sdk.service.e.l;
import java.util.UUID;

public class y {
    public static void a(Context context, l lVar) {
        e i = e.i(context);
        i.setDomain(lVar.getDomain());
        i.o(lVar.getAppId());
        i.p(lVar.getAppKey());
        i.w(lVar.isResponseExpectationEnabled());
        i.d(lVar.isTeamMemberInfoVisible());
        i.e(lVar.isCameraCaptureEnabled());
        i.f(lVar.dI());
        i.g(lVar.isGallerySelectionEnabled());
        i.setUserEventsTrackingEnabled(lVar.isUserEventsTrackingEnabled());
    }

    public static void a(FreshchatConfig freshchatConfig) throws InvalidDomainException {
        if (freshchatConfig != null) {
            if (as.a(freshchatConfig.getDomain()) && !freshchatConfig.getDomain().endsWith(".freshchat.com")) {
                c.INVALID_FRESHCHAT_CONFIG_NON_FRESCHAT_DOMAIN.toString().replace("{{domain}}", freshchatConfig.getDomain());
            }
            if (!as.isEmpty(freshchatConfig.getAppId())) {
                try {
                    UUID.fromString(freshchatConfig.getAppId());
                    if (!as.isEmpty(freshchatConfig.getAppKey())) {
                        try {
                            UUID.fromString(freshchatConfig.getAppKey());
                            bt(freshchatConfig.getDomain());
                        } catch (Exception unused) {
                            throw new IllegalArgumentException(c.INVALID_FRESHCHAT_CONFIG_APP_KEY.toString() + ", got app key : " + freshchatConfig.getAppKey());
                        }
                    } else {
                        throw new IllegalArgumentException(c.INVALID_FRESHCHAT_CONFIG_APP_KEY.toString());
                    }
                } catch (Exception unused2) {
                    throw new IllegalArgumentException(c.INVALID_FRESHCHAT_CONFIG_APP_ID.toString() + ", got app id : " + freshchatConfig.getAppId());
                }
            } else {
                throw new IllegalArgumentException(c.INVALID_FRESHCHAT_CONFIG_APP_ID.toString());
            }
        } else {
            throw new IllegalArgumentException(c.INVALID_FRESHCHAT_CONFIG.toString());
        }
    }

    public static FreshchatConfig aG(Context context) {
        e i = e.i(context);
        FreshchatConfig freshchatConfig = new FreshchatConfig(i.getAppId(), i.getAppKey());
        freshchatConfig.setDomain(i.getDomain());
        freshchatConfig.setResponseExpectationEnabled(i.isResponseExpectationEnabled());
        freshchatConfig.setTeamMemberInfoVisible(i.isTeamMemberInfoVisible());
        freshchatConfig.setCameraCaptureEnabled(i.isCameraCaptureEnabled());
        freshchatConfig.setGallerySelectionEnabled(i.isGallerySelectionEnabled());
        freshchatConfig.setUserEventsTrackingEnabled(i.isUserEventsTrackingEnabled());
        return freshchatConfig;
    }

    public static void bt(String str) throws InvalidDomainException {
        if (as.a(str)) {
            str = as.aJ(str);
        }
        if (str != null && !a.qx.contains(str)) {
            ai.e("FRESHCHAT", c.INVALID_FRESHCHAT_DOMAIN_IN_CONFIG.toString());
            throw new InvalidDomainException();
        }
    }

    public static boolean cp(Context context) {
        return FAQAPIVersion.KBASE_SERVICE.asInt() == e.i(context).iM();
    }
}
