package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.UserEventsConfig;
import com.freshchat.consumer.sdk.beans.config.AccountConfig;
import com.freshchat.consumer.sdk.beans.config.AccountConfig.FAQAPIVersion;
import com.freshchat.consumer.sdk.beans.config.ConversationConfig;
import com.freshchat.consumer.sdk.beans.config.CsatConfig;
import com.freshchat.consumer.sdk.beans.config.DefaultRemoteConfig;
import com.freshchat.consumer.sdk.beans.config.LiveTranslationConfig;
import com.freshchat.consumer.sdk.beans.config.RefreshIntervals;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;
import com.freshchat.consumer.sdk.beans.config.UserAuthConfig;
import com.freshchat.consumer.sdk.c.p;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

public class ap {
    public static RemoteConfig lg;

    public static void a(Context context, RemoteConfig remoteConfig) {
        e i = e.i(context);
        i.setAccountActive(remoteConfig.isAccountActive());
        i.setSessionTimeoutInterval(remoteConfig.getSessionTimeoutInterval());
        ConversationConfig conversationConfig = remoteConfig.getConversationConfig();
        if (conversationConfig != null) {
            i.setActiveConvFetchBackoffRatio(conversationConfig.getActiveConvFetchBackoffRatio());
            i.setActiveConvWindow(conversationConfig.getActiveConvWindow());
            i.j(conversationConfig.shouldLaunchDeeplinkFromNotification());
            i.a(conversationConfig.getResolvedMsgTypes());
            i.b(conversationConfig.getReopenedMsgtypes());
        }
        CsatConfig csatConfig = remoteConfig.getCsatConfig();
        if (csatConfig != null) {
            i.setCsatAutoExpire(csatConfig.doesCsatAutoExpire());
            i.s(csatConfig.getCsatExpiryInterval());
        }
        UserAuthConfig userAuthConfig = remoteConfig.getUserAuthConfig();
        if (userAuthConfig != null) {
            i.setJwtAuthEnabled(userAuthConfig.isJwtAuthEnabled());
            i.t(userAuthConfig.isStrictModeEnabled());
            i.u(userAuthConfig.getAuthTimeOutInterval());
        }
        i.a(new JSONArray(remoteConfig.getEnabledFeatures()));
        RefreshIntervals refreshIntervals = remoteConfig.getRefreshIntervals();
        if (refreshIntervals != null) {
            i.setRemoteConfigFetchInterval(refreshIntervals.getRemoteConfigFetchInterval());
            i.setResponseTimeExpectationsFetchInterval(refreshIntervals.getResponseTimeExpectationsFetchInterval());
            i.setActiveConvMinFetchInterval(refreshIntervals.getActiveConvMinFetchInterval());
            i.setActiveConvMaxFetchInterval(refreshIntervals.getActiveConvMaxFetchInterval());
            i.setMsgFetchIntervalNormal(refreshIntervals.getMsgFetchIntervalNormal());
            i.setMsgFetchIntervalLaidback(refreshIntervals.getMsgFetchIntervalLaidback());
            i.setFaqFetchIntervalNormal(refreshIntervals.getFaqFetchIntervalNormal());
            i.setFaqFetchIntervalLaidback(refreshIntervals.getFaqFetchIntervalLaidback());
            i.setChannelsFetchIntervalNormal(refreshIntervals.getChannelsFetchIntervalNormal());
            i.setChannelsFetchIntervalLaidback(refreshIntervals.getChannelsFetchIntervalLaidback());
        }
        UserEventsConfig eventsConfig = remoteConfig.getEventsConfig();
        if (eventsConfig != null) {
            i.setMaxDelayInMillisUntilUpload(eventsConfig.getMaxDelayInMillisUntilUpload());
            i.setMaxAllowedEventsPerDay(eventsConfig.getMaxAllowedEventsPerDay());
            i.setMaxEventsPerBatch(eventsConfig.getMaxEventsPerBatch());
            i.setMaxAllowedPropertiesPerEvent(eventsConfig.getMaxAllowedPropertiesPerEvent());
            i.setTriggerUploadOnEventsCount(eventsConfig.getTriggerUploadOnEventsCount());
            i.setMaxCharsPerEventName(eventsConfig.getMaxCharsPerEventName());
            i.setMaxCharsPerEventPropertyName(eventsConfig.getMaxCharsPerEventPropertyName());
            i.setMaxCharsPerEventPropertyValue(eventsConfig.getMaxCharsPerEventPropertyValue());
        }
        bc.a(context, remoteConfig.getMessageMaskingConfig());
        bd.a(context, remoteConfig.getUnsupportedFragmentConfig());
        LiveTranslationConfig liveTranslationConfig = remoteConfig.getLiveTranslationConfig();
        if (liveTranslationConfig != null) {
            i.z(liveTranslationConfig.isEnabled());
        }
        AccountConfig accountConfig = remoteConfig.getAccountConfig();
        if (accountConfig != null) {
            i.X(accountConfig.getFcFaqApiVersion().asInt());
        }
        if (remoteConfig.getOperatingHoursResponse() != null) {
            new p(context).a(remoteConfig.getOperatingHoursResponse());
        }
        lg = null;
    }

    public static boolean aZ(Context context) {
        return e.i(context).as("RC_IS_ACCOUNT_ACTIVE");
    }

    public static RemoteConfig bD(Context context) {
        if (lg == null) {
            synchronized (RemoteConfig.class) {
                try {
                    if (lg == null) {
                        lg = aZ(context) ? bE(context) : new DefaultRemoteConfig();
                    }
                }
            }
        }
        return lg;
    }

    public static RemoteConfig bE(Context context) {
        e i = e.i(context);
        RemoteConfig remoteConfig = new RemoteConfig();
        remoteConfig.setAccountActive(i.isAccountActive());
        JSONArray cg = i.cg();
        int length = cg.length();
        HashSet hashSet = new HashSet(length);
        for (int i2 = 0; i2 < length; i2++) {
            try {
                hashSet.add(cg.getString(i2));
            } catch (Exception unused) {
            }
        }
        remoteConfig.setEnabledFeatures(hashSet);
        remoteConfig.setSessionTimeoutInterval(i.getSessionTimeoutInterval());
        ConversationConfig conversationConfig = new ConversationConfig();
        conversationConfig.setActiveConvWindow(i.getActiveConvWindow());
        conversationConfig.setActiveConvFetchBackoffRatio(i.getActiveConvFetchBackoffRatio());
        conversationConfig.setLaunchDeeplinkFromNotification(i.bU());
        conversationConfig.setResolvedMsgTypes(i.fj());
        conversationConfig.setReopenedMsgtypes(i.fk());
        remoteConfig.setConversationConfig(conversationConfig);
        CsatConfig csatConfig = new CsatConfig();
        csatConfig.setCsatAutoExpire(i.doesCsatAutoExpire());
        csatConfig.setCsatExpiryInterval(i.cQ());
        remoteConfig.setCsatConfig(csatConfig);
        UserAuthConfig userAuthConfig = new UserAuthConfig();
        userAuthConfig.setJwtAuthEnabled(i.isJwtAuthEnabled());
        userAuthConfig.setStrictModeEnabled(i.gk());
        userAuthConfig.setAuthTimeOutInterval(i.gl());
        remoteConfig.setUserAuthConfig(userAuthConfig);
        RefreshIntervals refreshIntervals = new RefreshIntervals();
        refreshIntervals.setRemoteConfigFetchInterval(i.getRemoteConfigFetchInterval());
        refreshIntervals.setResponseTimeExpectationsFetchInterval(i.getResponseTimeExpectationsFetchInterval());
        refreshIntervals.setActiveConvMinFetchInterval(i.getActiveConvMinFetchInterval());
        refreshIntervals.setActiveConvMaxFetchInterval(i.getActiveConvMaxFetchInterval());
        refreshIntervals.setMsgFetchIntervalNormal(i.getMsgFetchIntervalNormal());
        refreshIntervals.setMsgFetchIntervalLaidback(i.getMsgFetchIntervalLaidback());
        refreshIntervals.setFaqFetchIntervalNormal(i.getFaqFetchIntervalNormal());
        refreshIntervals.setFaqFetchIntervalLaidback(i.getFaqFetchIntervalLaidback());
        refreshIntervals.setChannelsFetchIntervalNormal(i.getChannelsFetchIntervalNormal());
        refreshIntervals.setChannelsFetchIntervalLaidback(i.getChannelsFetchIntervalLaidback());
        remoteConfig.setRefreshIntervals(refreshIntervals);
        remoteConfig.setMessageMaskingConfig(bc.bH(context));
        remoteConfig.setUnsupportedFragmentConfig(bd.bI(context));
        UserEventsConfig userEventsConfig = new UserEventsConfig();
        userEventsConfig.setMaxAllowedEventsPerDay(i.getMaxAllowedEventsPerDay());
        userEventsConfig.setMaxEventsPerBatch(i.getMaxEventsPerBatch());
        userEventsConfig.setMaxDelayInMillisUntilUpload(i.getMaxDelayInMillisUntilUpload());
        userEventsConfig.setMaxAllowedPropertiesPerEvent(i.getMaxAllowedPropertiesPerEvent());
        userEventsConfig.setTriggerUploadOnEventsCount(i.getTriggerUploadOnEventsCount());
        userEventsConfig.setMaxCharsPerEventName(i.getMaxCharsPerEventName());
        userEventsConfig.setMaxCharsPerEventPropertyName(i.getMaxCharsPerEventPropertyName());
        userEventsConfig.setMaxCharsPerEventPropertyValue(i.getMaxCharsPerEventPropertyValue());
        remoteConfig.setEventsConfig(userEventsConfig);
        LiveTranslationConfig liveTranslationConfig = new LiveTranslationConfig();
        liveTranslationConfig.setEnabled(i.it());
        remoteConfig.setLiveTranslationConfig(liveTranslationConfig);
        AccountConfig accountConfig = new AccountConfig();
        accountConfig.setFcFaqApiVersion(FAQAPIVersion.fromInt(i.iM()));
        remoteConfig.setAccountConfig(accountConfig);
        return remoteConfig;
    }

    public static Set<Integer> jP() {
        HashSet hashSet = new HashSet();
        if (lg.getConversationConfig() != null) {
            Set<Integer> reopenedMsgtypes = lg.getConversationConfig().getReopenedMsgtypes();
            Set<Integer> resolvedMsgTypes = lg.getConversationConfig().getResolvedMsgTypes();
            if (k.a(reopenedMsgtypes)) {
                hashSet.addAll(reopenedMsgtypes);
            }
            if (k.a(resolvedMsgTypes)) {
                hashSet.addAll(resolvedMsgTypes);
            }
        }
        return hashSet;
    }
}
