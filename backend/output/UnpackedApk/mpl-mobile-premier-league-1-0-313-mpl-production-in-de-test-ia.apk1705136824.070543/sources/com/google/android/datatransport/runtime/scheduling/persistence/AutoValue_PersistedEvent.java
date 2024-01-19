package com.google.android.datatransport.runtime.scheduling.persistence;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;

public final class AutoValue_PersistedEvent extends PersistedEvent {
    public final EventInternal event;
    public final long id;
    public final TransportContext transportContext;

    public AutoValue_PersistedEvent(long j, TransportContext transportContext2, EventInternal eventInternal) {
        this.id = j;
        if (transportContext2 != null) {
            this.transportContext = transportContext2;
            if (eventInternal != null) {
                this.event = eventInternal;
                return;
            }
            throw new NullPointerException("Null event");
        }
        throw new NullPointerException("Null transportContext");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PersistedEvent)) {
            return false;
        }
        AutoValue_PersistedEvent autoValue_PersistedEvent = (AutoValue_PersistedEvent) ((PersistedEvent) obj);
        if (this.id != autoValue_PersistedEvent.id || !this.transportContext.equals(autoValue_PersistedEvent.transportContext) || !this.event.equals(autoValue_PersistedEvent.event)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        long j = this.id;
        return this.event.hashCode() ^ ((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.transportContext.hashCode()) * 1000003);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("PersistedEvent{id=");
        outline73.append(this.id);
        outline73.append(", transportContext=");
        outline73.append(this.transportContext);
        outline73.append(", event=");
        outline73.append(this.event);
        outline73.append("}");
        return outline73.toString();
    }
}
