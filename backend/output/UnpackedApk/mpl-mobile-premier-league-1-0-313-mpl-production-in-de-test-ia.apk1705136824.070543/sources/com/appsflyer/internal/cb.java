package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import java.util.concurrent.TimeUnit;

public final class cb {
    public static final long AFInAppEventParameterName = TimeUnit.HOURS.toSeconds(24);
    public final aa AFInAppEventType;
    public final bx values;

    public cb(aa aaVar, bx bxVar) {
        this.AFInAppEventType = aaVar;
        this.values = bxVar;
    }

    public final boolean AFInAppEventParameterName() {
        if (this.values.values == null) {
            AFLogger.values((String) "CFG: active config is missing - fetching from CDN");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        bx bxVar = this.values;
        if (currentTimeMillis - bxVar.AFInAppEventType > TimeUnit.SECONDS.toMillis(bxVar.valueOf)) {
            return true;
        }
        return false;
    }

    public final boolean AFInAppEventType() {
        return Boolean.parseBoolean(this.AFInAppEventType.AFInAppEventParameterName("com.appsflyer.rc.sandbox"));
    }

    public final long valueOf() {
        String AFInAppEventParameterName2 = this.AFInAppEventType.AFInAppEventParameterName("com.appsflyer.rc.cache.max-age-fallback");
        if (AFInAppEventParameterName2 == null) {
            return AFInAppEventParameterName;
        }
        try {
            return Long.parseLong(AFInAppEventParameterName2);
        } catch (NumberFormatException e2) {
            StringBuilder sb = new StringBuilder("Can't read maxAgeFallback from Manifest: ");
            sb.append(e2.getMessage());
            AFLogger.valueOf(sb.toString(), e2);
            return AFInAppEventParameterName;
        }
    }
}
