package com.rudderstack.android.sdk.core;

import android.app.Application;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;
import java.util.Map;

public class RudderElementCache {
    public static RudderContext cachedContext;

    public static RudderContext getCachedContext() {
        return cachedContext.copy();
    }

    public static void initiate(Application application, String str, String str2, String str3) {
        if (cachedContext == null) {
            RudderLogger.logDebug("RudderElementCache: initiating RudderContext");
            RudderContext rudderContext = new RudderContext(application, str, str2, str3);
            cachedContext = rudderContext;
            rudderContext.updateDeviceWithAdId();
        }
    }

    public static void persistTraits() {
        cachedContext.persistTraits();
    }

    public static void reset() {
        cachedContext.resetTraits();
        persistTraits();
        cachedContext.resetExternalIds();
    }

    public static void setAnonymousId(String str) {
        cachedContext.updateTraitsMap(GeneratedOutlineSupport.outline87(RudderTraits.ANONYMOUSID_KEY, str));
    }

    public static void updateAnonymousId(String str) {
        RudderContext.updateAnonymousId(str);
        cachedContext.updateAnonymousIdTraits();
        persistTraits();
    }

    public static void updateExternalIds(List<Map<String, Object>> list) {
        cachedContext.updateExternalIds(list);
        cachedContext.persistExternalIds();
    }

    public static void updateTraits(RudderTraits rudderTraits) {
        cachedContext.updateTraits(rudderTraits);
        persistTraits();
    }

    public static void updateTraits(Map<String, Object> map) {
        cachedContext.updateTraitsMap(map);
        persistTraits();
    }
}
