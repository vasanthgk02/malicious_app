package com.google.firebase.perf.metrics.validator;

import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.v1.ApplicationInfo;

public class FirebasePerfApplicationInfoValidator extends PerfMetricValidator {
    public static final AndroidLogger logger = AndroidLogger.getInstance();
    public final ApplicationInfo applicationInfo;

    public FirebasePerfApplicationInfoValidator(ApplicationInfo applicationInfo2) {
        this.applicationInfo = applicationInfo2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0094 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isValidPerfMetric() {
        /*
            r4 = this;
            com.google.firebase.perf.v1.ApplicationInfo r0 = r4.applicationInfo
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0010
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r3 = "ApplicationInfo is null"
            r0.warn(r3)
        L_0x000d:
            r0 = 0
            goto L_0x008a
        L_0x0010:
            int r0 = r0.bitField0_
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 != 0) goto L_0x0022
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r3 = "GoogleAppId is null"
            r0.warn(r3)
            goto L_0x000d
        L_0x0022:
            com.google.firebase.perf.v1.ApplicationInfo r0 = r4.applicationInfo
            boolean r0 = r0.hasAppInstanceId()
            if (r0 != 0) goto L_0x0032
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r3 = "AppInstanceId is null"
            r0.warn(r3)
            goto L_0x000d
        L_0x0032:
            com.google.firebase.perf.v1.ApplicationInfo r0 = r4.applicationInfo
            int r0 = r0.bitField0_
            r0 = r0 & 8
            if (r0 == 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            if (r0 != 0) goto L_0x0047
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r3 = "ApplicationProcessState is null"
            r0.warn(r3)
            goto L_0x000d
        L_0x0047:
            com.google.firebase.perf.v1.ApplicationInfo r0 = r4.applicationInfo
            int r0 = r0.bitField0_
            r0 = r0 & 4
            if (r0 == 0) goto L_0x0051
            r0 = 1
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            if (r0 == 0) goto L_0x0089
            com.google.firebase.perf.v1.ApplicationInfo r0 = r4.applicationInfo
            com.google.firebase.perf.v1.AndroidApplicationInfo r0 = r0.androidAppInfo_
            if (r0 != 0) goto L_0x005c
            com.google.firebase.perf.v1.AndroidApplicationInfo r0 = com.google.firebase.perf.v1.AndroidApplicationInfo.DEFAULT_INSTANCE
        L_0x005c:
            int r0 = r0.bitField0_
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0063
            r0 = 1
            goto L_0x0064
        L_0x0063:
            r0 = 0
        L_0x0064:
            if (r0 != 0) goto L_0x006e
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r3 = "AndroidAppInfo.packageName is null"
            r0.warn(r3)
            goto L_0x000d
        L_0x006e:
            com.google.firebase.perf.v1.ApplicationInfo r0 = r4.applicationInfo
            com.google.firebase.perf.v1.AndroidApplicationInfo r0 = r0.androidAppInfo_
            if (r0 != 0) goto L_0x0076
            com.google.firebase.perf.v1.AndroidApplicationInfo r0 = com.google.firebase.perf.v1.AndroidApplicationInfo.DEFAULT_INSTANCE
        L_0x0076:
            int r0 = r0.bitField0_
            r0 = r0 & 2
            if (r0 == 0) goto L_0x007e
            r0 = 1
            goto L_0x007f
        L_0x007e:
            r0 = 0
        L_0x007f:
            if (r0 != 0) goto L_0x0089
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r3 = "AndroidAppInfo.sdkVersion is null"
            r0.warn(r3)
            goto L_0x000d
        L_0x0089:
            r0 = 1
        L_0x008a:
            if (r0 != 0) goto L_0x0094
            com.google.firebase.perf.logging.AndroidLogger r0 = logger
            java.lang.String r1 = "ApplicationInfo is invalid"
            r0.warn(r1)
            return r2
        L_0x0094:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.validator.FirebasePerfApplicationInfoValidator.isValidPerfMetric():boolean");
    }
}
