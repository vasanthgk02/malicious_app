package com.clevertap.android.xps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.ManifestInfo;
import com.clevertap.android.sdk.pushnotification.CTPushProvider;
import com.clevertap.android.sdk.pushnotification.CTPushProviderListener;
import com.clevertap.android.sdk.pushnotification.PushConstants.PushType;
import com.clevertap.android.sdk.pushnotification.UnregistrableCTPushProvider;
import com.xiaomi.mipush.sdk.MiPushClient;

public class XiaomiPushProvider implements CTPushProvider, UnregistrableCTPushProvider {
    public final CTPushProviderListener ctPushListener;
    public IMiSdkHandler miSdkHandler;

    @SuppressLint({"unused"})
    public XiaomiPushProvider(CTPushProviderListener cTPushProviderListener, Context context, CleverTapInstanceConfig cleverTapInstanceConfig) {
        this(cTPushProviderListener, context, cleverTapInstanceConfig, Boolean.TRUE);
    }

    public int getPlatform() {
        return 1;
    }

    public PushType getPushType() {
        return PushType.XPS;
    }

    public boolean isAvailable() {
        XiaomiSdkHandler xiaomiSdkHandler = (XiaomiSdkHandler) this.miSdkHandler;
        if (xiaomiSdkHandler.manifestInfo != null) {
            if (!TextUtils.isEmpty(ManifestInfo.xiaomiAppID)) {
                if (xiaomiSdkHandler.manifestInfo == null) {
                    throw null;
                } else if (!TextUtils.isEmpty(ManifestInfo.xiaomiAppKey)) {
                    return true;
                }
            }
            return false;
        }
        throw null;
    }

    public boolean isSupported() {
        return true;
    }

    public int minSDKSupportVersionCode() {
        return 30800;
    }

    public void requestToken() {
        CTPushProviderListener cTPushProviderListener = this.ctPushListener;
        XiaomiSdkHandler xiaomiSdkHandler = (XiaomiSdkHandler) this.miSdkHandler;
        if (!xiaomiSdkHandler.isRegistered) {
            xiaomiSdkHandler.init();
        }
        String str = null;
        try {
            str = MiPushClient.getRegId(xiaomiSdkHandler.context);
            CleverTapInstanceConfig cleverTapInstanceConfig = xiaomiSdkHandler.mConfig;
            cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("PushProvider"), XpsConstants.XIAOMI_LOG_TAG + "Xiaomi Token Success- " + str);
        } catch (Throwable unused) {
            CleverTapInstanceConfig cleverTapInstanceConfig2 = xiaomiSdkHandler.mConfig;
            cleverTapInstanceConfig2.logger.verbose(cleverTapInstanceConfig2.getDefaultSuffix("PushProvider"), GeneratedOutlineSupport.outline62(new StringBuilder(), XpsConstants.XIAOMI_LOG_TAG, "Xiaomi Token Failed"));
        }
        cTPushProviderListener.onNewToken(str, getPushType());
    }

    public void setMiSdkHandler(IMiSdkHandler iMiSdkHandler) {
        this.miSdkHandler = iMiSdkHandler;
    }

    public void unregisterPush(Context context) {
        XiaomiSdkHandler xiaomiSdkHandler = (XiaomiSdkHandler) this.miSdkHandler;
        if (xiaomiSdkHandler != null) {
            try {
                MiPushClient.unregisterPush(context);
                CleverTapInstanceConfig cleverTapInstanceConfig = xiaomiSdkHandler.mConfig;
                cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("PushProvider"), XpsConstants.XIAOMI_LOG_TAG + "Xiaomi Unregister Success");
            } catch (Throwable unused) {
                CleverTapInstanceConfig cleverTapInstanceConfig2 = xiaomiSdkHandler.mConfig;
                cleverTapInstanceConfig2.logger.verbose(cleverTapInstanceConfig2.getDefaultSuffix("PushProvider"), GeneratedOutlineSupport.outline62(new StringBuilder(), XpsConstants.XIAOMI_LOG_TAG, "Xiaomi Unregister Failed"));
            }
        } else {
            throw null;
        }
    }

    @SuppressLint({"unused"})
    public XiaomiPushProvider(CTPushProviderListener cTPushProviderListener, Context context, CleverTapInstanceConfig cleverTapInstanceConfig, Boolean bool) {
        this.ctPushListener = cTPushProviderListener;
        this.miSdkHandler = new XiaomiSdkHandler(context, cleverTapInstanceConfig, bool.booleanValue());
    }
}
