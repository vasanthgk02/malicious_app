package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.AttributionIdentifiers.Companion;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\tH\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\tH\u0002J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u0017R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/facebook/appevents/AppEventCollection;", "", "()V", "eventCount", "", "getEventCount", "()I", "stateMap", "Ljava/util/HashMap;", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "Lcom/facebook/appevents/SessionEventsState;", "addEvent", "", "accessTokenAppIdPair", "appEvent", "Lcom/facebook/appevents/AppEvent;", "addPersistedEvents", "persistedEvents", "Lcom/facebook/appevents/PersistedEvents;", "get", "getSessionEventsState", "accessTokenAppId", "keySet", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventCollection.kt */
public final class AppEventCollection {
    public final HashMap<AccessTokenAppIdPair, SessionEventsState> stateMap = new HashMap<>();

    public final synchronized void addPersistedEvents(PersistedEvents persistedEvents) {
        Set<Entry> set = null;
        if (!CrashShieldHandler.isObjectCrashing(persistedEvents)) {
            try {
                Set<Entry<AccessTokenAppIdPair, List<AppEvent>>> entrySet = persistedEvents.events.entrySet();
                Intrinsics.checkNotNullExpressionValue(entrySet, "events.entries");
                set = entrySet;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, persistedEvents);
            }
        }
        for (Entry entry : set) {
            SessionEventsState sessionEventsState = getSessionEventsState((AccessTokenAppIdPair) entry.getKey());
            if (sessionEventsState != null) {
                for (AppEvent addEvent : (List) entry.getValue()) {
                    sessionEventsState.addEvent(addEvent);
                }
            }
        }
    }

    public final synchronized SessionEventsState get(AccessTokenAppIdPair accessTokenAppIdPair) {
        try {
            Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
        }
        return this.stateMap.get(accessTokenAppIdPair);
    }

    public final synchronized int getEventCount() {
        int i;
        int i2;
        i = 0;
        for (SessionEventsState next : this.stateMap.values()) {
            synchronized (next) {
                if (!CrashShieldHandler.isObjectCrashing(next)) {
                    try {
                        i2 = next.accumulatedEvents.size();
                    } catch (Throwable th) {
                        CrashShieldHandler.handleThrowable(th, next);
                    }
                }
                i2 = 0;
            }
            i += i2;
        }
        return i;
    }

    public final synchronized SessionEventsState getSessionEventsState(AccessTokenAppIdPair accessTokenAppIdPair) {
        try {
            SessionEventsState sessionEventsState = this.stateMap.get(accessTokenAppIdPair);
            if (sessionEventsState == null) {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                Context applicationContext = FacebookSdk.getApplicationContext();
                AttributionIdentifiers attributionIdentifiers = Companion.getAttributionIdentifiers(applicationContext);
                if (attributionIdentifiers != null) {
                    sessionEventsState = new SessionEventsState(attributionIdentifiers, AppEventsLogger.Companion.getAnonymousAppDeviceGUID(applicationContext));
                }
            }
            if (sessionEventsState == null) {
                return null;
            }
            this.stateMap.put(accessTokenAppIdPair, sessionEventsState);
            return sessionEventsState;
        }
    }

    public final synchronized Set<AccessTokenAppIdPair> keySet() {
        Set<AccessTokenAppIdPair> keySet;
        try {
            keySet = this.stateMap.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "stateMap.keys");
        }
        return keySet;
    }
}
