package com.clevertap.android.xps;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.ManifestInfo;
import com.xiaomi.channel.commonutils.android.Region;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Iterator;
import java.util.List;

public class XiaomiSdkHandler implements IMiSdkHandler {
    public final Context context;
    public boolean isRegistered;
    public final CleverTapInstanceConfig mConfig;
    public ManifestInfo manifestInfo;

    public XiaomiSdkHandler(Context context2, CleverTapInstanceConfig cleverTapInstanceConfig, boolean z) {
        this.context = context2.getApplicationContext();
        this.mConfig = cleverTapInstanceConfig;
        this.manifestInfo = ManifestInfo.getInstance(context2);
        if (z) {
            init();
        }
    }

    public final void init() {
        boolean z;
        String packageName = this.context.getPackageName();
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.context.getSystemService("activity")).getRunningAppProcesses();
        int myPid = Process.myPid();
        Iterator<RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            RunningAppProcessInfo next = it.next();
            if (next.pid == myPid && packageName.equals(next.processName)) {
                z = true;
                break;
            }
        }
        if (!z) {
            return;
        }
        if (this.manifestInfo != null) {
            try {
                register(ManifestInfo.xiaomiAppID, ManifestInfo.xiaomiAppKey);
            } catch (Throwable unused) {
            }
        } else {
            throw null;
        }
    }

    public void register(String str, String str2) throws RegistrationException {
        Logger.v("XiaomiSDKHandler: register | called with appid = " + str + ", appkey=" + str2);
        try {
            String accountRegion = this.manifestInfo.getAccountRegion();
            if (accountRegion == null || accountRegion.isEmpty()) {
                accountRegion = "eu1";
            }
            Logger.v("XiaomiSDKHandler: register | final region from manifest = " + accountRegion);
            Region region = accountRegion.equalsIgnoreCase("in1") ? Region.India : Region.Global;
            Logger.v("XiaomiSDKHandler: register | final xiaomi region as per manifest = " + region.name());
            Logger.v("XiaomiSDKHandler: register | final xiaomi setting xiaomi region via  MiPushClient.setRegion(xiaomiRegion) and calling MiPushClient.registerPush(context, appId, appKey);");
            MiPushClient.setRegion(region);
            MiPushClient.registerPush(this.context, str, str2);
            this.isRegistered = true;
            CleverTapInstanceConfig cleverTapInstanceConfig = this.mConfig;
            cleverTapInstanceConfig.logger.verbose(cleverTapInstanceConfig.getDefaultSuffix("PushProvider"), XpsConstants.XIAOMI_LOG_TAG + "Xiaomi Registeration success for appId-" + str + " and appKey-" + str2);
        } catch (Throwable unused) {
            this.isRegistered = false;
            CleverTapInstanceConfig cleverTapInstanceConfig2 = this.mConfig;
            StringBuilder sb = new StringBuilder();
            GeneratedOutlineSupport.outline103(sb, XpsConstants.XIAOMI_LOG_TAG, "Xiaomi Registration failed for appId-", str, " appKey-");
            sb.append(str2);
            cleverTapInstanceConfig2.logger.verbose(cleverTapInstanceConfig2.getDefaultSuffix("PushProvider"), sb.toString());
            throw new RegistrationException(GeneratedOutlineSupport.outline53("Registration failed for appId ", str, " and appKey ", str2));
        }
    }
}
