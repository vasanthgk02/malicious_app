package io.hansel.ujmtracker;

import java.util.HashMap;

public final class HanselTracker {
    public static void deRegisterListener(HanselInternalEventsListener hanselInternalEventsListener) {
        h.a(hanselInternalEventsListener);
    }

    @Deprecated
    public static HashMap<String, Object> getHanselData(String str, String str2, HashMap<String, Object> hashMap) {
        return h.a().b(str, str2, hashMap, null, false);
    }

    @Deprecated
    public static boolean isAttachedToInteractionMap(String str, String str2, HashMap<String, Object> hashMap) {
        return true;
    }

    public static HashMap<String, Object> logEvent(String str, String str2, HashMap<String, Object> hashMap) {
        return h.a().b(str, str2, hashMap, null, false);
    }

    @Deprecated
    public static void logEventInBackground(String str, String str2, HashMap<String, Object> hashMap, HanselEventDataListener hanselEventDataListener) {
        h.a().b(str, str2, hashMap, hanselEventDataListener, true);
    }

    public static void registerListener(HanselInternalEventsListener hanselInternalEventsListener) {
        h.b(hanselInternalEventsListener);
    }

    public static void setEventHandler(d dVar) {
        h.a().a(dVar);
    }
}
