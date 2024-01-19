package com.mpl.androidapp.analytics.events;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/mpl/androidapp/analytics/events/Events;", "Lcom/mpl/androidapp/analytics/events/Event;", "()V", "SessionEvents", "Lcom/mpl/androidapp/analytics/events/Events$SessionEvents;", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Events.kt */
public abstract class Events implements Event {

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J)\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J=\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR4\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/mpl/androidapp/analytics/events/Events$SessionEvents;", "Lcom/mpl/androidapp/analytics/events/Events;", "name", "", "properties", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "(Ljava/lang/String;Ljava/util/HashMap;)V", "getName", "()Ljava/lang/String;", "getProperties", "()Ljava/util/HashMap;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com.mpl.androidapp-1000313-1.0.313-20230413_15_39_production_declutter_test_iaRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Events.kt */
    public static final class SessionEvents extends Events {
        public final String name;
        public final HashMap<String, Object> properties;

        public /* synthetic */ SessionEvents(String str, HashMap hashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : hashMap);
        }

        public static /* synthetic */ SessionEvents copy$default(SessionEvents sessionEvents, String str, HashMap<String, Object> hashMap, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sessionEvents.getName();
            }
            if ((i & 2) != 0) {
                hashMap = sessionEvents.getProperties();
            }
            return sessionEvents.copy(str, hashMap);
        }

        public final String component1() {
            return getName();
        }

        public final HashMap<String, Object> component2() {
            return getProperties();
        }

        public final SessionEvents copy(String str, HashMap<String, Object> hashMap) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new SessionEvents(str, hashMap);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SessionEvents)) {
                return false;
            }
            SessionEvents sessionEvents = (SessionEvents) obj;
            return Intrinsics.areEqual(getName(), sessionEvents.getName()) && Intrinsics.areEqual(getProperties(), sessionEvents.getProperties());
        }

        public String getName() {
            return this.name;
        }

        public HashMap<String, Object> getProperties() {
            return this.properties;
        }

        public int hashCode() {
            return (getName().hashCode() * 31) + (getProperties() == null ? 0 : getProperties().hashCode());
        }

        public String toString() {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("SessionEvents(name=");
            outline73.append(getName());
            outline73.append(", properties=");
            outline73.append(getProperties());
            outline73.append(')');
            return outline73.toString();
        }

        /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
        public SessionEvents(String str, HashMap<String, Object> hashMap) {
            // Intrinsics.checkNotNullParameter(str, "name");
            super(null);
            this.name = str;
            this.properties = hashMap;
        }
    }

    public Events() {
    }

    public /* synthetic */ Events(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
