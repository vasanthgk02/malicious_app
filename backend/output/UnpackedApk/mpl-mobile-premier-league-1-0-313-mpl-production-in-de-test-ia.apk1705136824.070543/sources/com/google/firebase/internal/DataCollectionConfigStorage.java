package com.google.firebase.internal;

import android.content.Context;
import android.content.SharedPreferences;

public class DataCollectionConfigStorage {
    public boolean dataCollectionDefaultEnabled;
    public final Context deviceProtectedContext;
    public final SharedPreferences sharedPreferences;

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005a, code lost:
        r5 = r3.metaData.getBoolean("firebase_data_collection_default_enabled");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DataCollectionConfigStorage(android.content.Context r3, java.lang.String r4, com.google.firebase.events.Publisher r5) {
        /*
            r2 = this;
            r2.<init>()
            int r5 = android.os.Build.VERSION.SDK_INT
            r0 = 24
            if (r5 >= r0) goto L_0x000a
            goto L_0x000e
        L_0x000a:
            android.content.Context r3 = androidx.core.content.ContextCompat.createDeviceProtectedStorageContext(r3)
        L_0x000e:
            r2.deviceProtectedContext = r3
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r0 = "com.google.firebase.common.prefs:"
            r5.append(r0)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r5 = 0
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r5)
            r2.sharedPreferences = r3
            java.lang.String r4 = "firebase_data_collection_default_enabled"
            boolean r3 = r3.contains(r4)
            r5 = 1
            if (r3 == 0) goto L_0x0038
            android.content.SharedPreferences r3 = r2.sharedPreferences
            boolean r3 = r3.getBoolean(r4, r5)
            goto L_0x0061
        L_0x0038:
            android.content.Context r3 = r2.deviceProtectedContext     // Catch:{ NameNotFoundException -> 0x0060 }
            android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0060 }
            if (r3 == 0) goto L_0x0060
            android.content.Context r0 = r2.deviceProtectedContext     // Catch:{ NameNotFoundException -> 0x0060 }
            java.lang.String r0 = r0.getPackageName()     // Catch:{ NameNotFoundException -> 0x0060 }
            r1 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r3 = r3.getApplicationInfo(r0, r1)     // Catch:{ NameNotFoundException -> 0x0060 }
            if (r3 == 0) goto L_0x0060
            android.os.Bundle r0 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0060 }
            if (r0 == 0) goto L_0x0060
            android.os.Bundle r0 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0060 }
            boolean r0 = r0.containsKey(r4)     // Catch:{ NameNotFoundException -> 0x0060 }
            if (r0 == 0) goto L_0x0060
            android.os.Bundle r3 = r3.metaData     // Catch:{ NameNotFoundException -> 0x0060 }
            boolean r5 = r3.getBoolean(r4)     // Catch:{ NameNotFoundException -> 0x0060 }
        L_0x0060:
            r3 = r5
        L_0x0061:
            r2.dataCollectionDefaultEnabled = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.internal.DataCollectionConfigStorage.<init>(android.content.Context, java.lang.String, com.google.firebase.events.Publisher):void");
    }
}
