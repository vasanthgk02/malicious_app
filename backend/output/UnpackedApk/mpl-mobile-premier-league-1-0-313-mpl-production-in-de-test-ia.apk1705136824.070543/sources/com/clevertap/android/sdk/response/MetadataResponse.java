package com.clevertap.android.sdk.response;

import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.DeviceInfo;
import com.clevertap.android.sdk.Logger;
import com.clevertap.android.sdk.network.NetworkManager;

public class MetadataResponse extends CleverTapResponseDecorator {
    public final CleverTapResponse cleverTapResponse;
    public final CleverTapInstanceConfig config;
    public final DeviceInfo deviceInfo;
    public final Logger logger;
    public final NetworkManager networkManager;

    public MetadataResponse(CleverTapResponse cleverTapResponse2, CleverTapInstanceConfig cleverTapInstanceConfig, DeviceInfo deviceInfo2, NetworkManager networkManager2) {
        this.cleverTapResponse = cleverTapResponse2;
        this.config = cleverTapInstanceConfig;
        this.logger = cleverTapInstanceConfig.getLogger();
        this.deviceInfo = deviceInfo2;
        this.networkManager = networkManager2;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0065 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b A[Catch:{ all -> 0x008b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processResponse(org.json.JSONObject r9, java.lang.String r10, android.content.Context r11) {
        /*
            r8 = this;
            java.lang.String r0 = "IJ"
            java.lang.String r1 = "_j"
            java.lang.String r2 = "_i"
            java.lang.String r3 = "g"
            boolean r4 = r9.has(r3)     // Catch:{ all -> 0x0032 }
            if (r4 == 0) goto L_0x003e
            java.lang.String r3 = r9.getString(r3)     // Catch:{ all -> 0x0032 }
            com.clevertap.android.sdk.DeviceInfo r4 = r8.deviceInfo     // Catch:{ all -> 0x0032 }
            r4.forceUpdateDeviceId(r3)     // Catch:{ all -> 0x0032 }
            com.clevertap.android.sdk.Logger r4 = r8.logger     // Catch:{ all -> 0x0032 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r8.config     // Catch:{ all -> 0x0032 }
            java.lang.String r5 = r5.accountId     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r6.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r7 = "Got a new device ID: "
            r6.append(r7)     // Catch:{ all -> 0x0032 }
            r6.append(r3)     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = r6.toString()     // Catch:{ all -> 0x0032 }
            r4.verbose(r5, r3)     // Catch:{ all -> 0x0032 }
            goto L_0x003e
        L_0x0032:
            r3 = move-exception
            com.clevertap.android.sdk.Logger r4 = r8.logger
            com.clevertap.android.sdk.CleverTapInstanceConfig r5 = r8.config
            java.lang.String r5 = r5.accountId
            java.lang.String r6 = "Failed to update device ID!"
            r4.verbose(r5, r6, r3)
        L_0x003e:
            r3 = 0
            boolean r4 = r9.has(r2)     // Catch:{ all -> 0x0065 }
            if (r4 == 0) goto L_0x0065
            long r4 = r9.getLong(r2)     // Catch:{ all -> 0x0065 }
            com.clevertap.android.sdk.network.NetworkManager r2 = r8.networkManager     // Catch:{ all -> 0x0065 }
            if (r2 == 0) goto L_0x0064
            android.content.SharedPreferences r6 = co.hyperverge.hypersnapsdk.c.k.getPreferences(r11, r0)     // Catch:{ all -> 0x0065 }
            android.content.SharedPreferences$Editor r6 = r6.edit()     // Catch:{ all -> 0x0065 }
            com.clevertap.android.sdk.CleverTapInstanceConfig r2 = r2.config     // Catch:{ all -> 0x0065 }
            java.lang.String r7 = "comms_i"
            java.lang.String r2 = co.hyperverge.hypersnapsdk.c.k.storageKeyWithSuffix(r2, r7)     // Catch:{ all -> 0x0065 }
            r6.putLong(r2, r4)     // Catch:{ all -> 0x0065 }
            co.hyperverge.hypersnapsdk.c.k.persist(r6)     // Catch:{ all -> 0x0065 }
            goto L_0x0065
        L_0x0064:
            throw r3     // Catch:{ all -> 0x0065 }
        L_0x0065:
            boolean r2 = r9.has(r1)     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x008b
            long r1 = r9.getLong(r1)     // Catch:{ all -> 0x008b }
            com.clevertap.android.sdk.network.NetworkManager r4 = r8.networkManager     // Catch:{ all -> 0x008b }
            if (r4 == 0) goto L_0x008a
            android.content.SharedPreferences r0 = co.hyperverge.hypersnapsdk.c.k.getPreferences(r11, r0)     // Catch:{ all -> 0x008b }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x008b }
            com.clevertap.android.sdk.CleverTapInstanceConfig r3 = r4.config     // Catch:{ all -> 0x008b }
            java.lang.String r4 = "comms_j"
            java.lang.String r3 = co.hyperverge.hypersnapsdk.c.k.storageKeyWithSuffix(r3, r4)     // Catch:{ all -> 0x008b }
            r0.putLong(r3, r1)     // Catch:{ all -> 0x008b }
            co.hyperverge.hypersnapsdk.c.k.persist(r0)     // Catch:{ all -> 0x008b }
            goto L_0x008b
        L_0x008a:
            throw r3     // Catch:{ all -> 0x008b }
        L_0x008b:
            com.clevertap.android.sdk.response.CleverTapResponse r0 = r8.cleverTapResponse
            r0.processResponse(r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.response.MetadataResponse.processResponse(org.json.JSONObject, java.lang.String, android.content.Context):void");
    }
}
