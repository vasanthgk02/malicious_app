package com.clevertap.android.sdk.pushnotification;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.clevertap.android.sdk.Logger;

public interface PushConstants {
    public static final String FCM_LOG_TAG = PushType.FCM.toString();

    public enum PushType {
        FCM("fcm", "fcm_token", "com.clevertap.android.sdk.pushnotification.fcm.FcmPushProvider", "com.google.firebase.messaging.FirebaseMessagingService", 1, ""),
        XPS("xps", "xps_token", "com.clevertap.android.xps.XiaomiPushProvider", "com.xiaomi.mipush.sdk.MiPushClient", 1, ""),
        HPS("hps", "hps_token", "com.clevertap.android.hms.HmsPushProvider", "com.huawei.hms.push.HmsMessageService", 1, ""),
        BPS("bps", "bps_token", "com.clevertap.android.bps.BaiduPushProvider", "com.baidu.android.pushservice.PushMessageReceiver", 1, ""),
        ADM("adm", "adm_token", "com.clevertap.android.adm.AmazonPushProvider", "com.amazon.device.messaging.ADM", 1, "");
        
        public final String ctProviderClassName;
        public final String messagingSDKClassName;
        public int runningDevices;
        public String serverRegion;
        public final String tokenPrefKey;
        public final String type;

        /* access modifiers changed from: public */
        PushType(String str, String str2, String str3, String str4, int i, String str5) {
            this.type = str;
            this.tokenPrefKey = str2;
            this.ctProviderClassName = str3;
            this.messagingSDKClassName = str4;
            this.runningDevices = i;
            this.serverRegion = str5;
        }

        public String getCtProviderClassName() {
            return this.ctProviderClassName;
        }

        public String getMessagingSDKClassName() {
            return this.messagingSDKClassName;
        }

        public int getRunningDevices() {
            return this.runningDevices;
        }

        public String getServerRegion() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("PushConstants: getServerRegion called, returning region:");
            outline73.append(this.serverRegion);
            Logger.v(outline73.toString());
            return this.serverRegion;
        }

        public String getTokenPrefKey() {
            return this.tokenPrefKey;
        }

        public String getType() {
            return this.type;
        }

        public void setRunningDevices(int i) {
            this.runningDevices = i;
        }

        public void setServerRegion(String str) {
            Logger.v("PushConstants: setServerRegion called with region:" + str);
            this.serverRegion = str;
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73(" [PushType:");
            outline73.append(name());
            outline73.append("] ");
            return outline73.toString();
        }
    }
}
