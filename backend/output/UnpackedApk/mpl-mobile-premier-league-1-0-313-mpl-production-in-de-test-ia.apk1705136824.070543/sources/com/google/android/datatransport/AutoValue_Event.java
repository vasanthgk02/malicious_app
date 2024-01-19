package com.google.android.datatransport;

import com.android.tools.r8.GeneratedOutlineSupport;

public final class AutoValue_Event<T> extends Event<T> {
    public final Integer code = null;
    public final T payload;
    public final Priority priority;

    public AutoValue_Event(Integer num, T t, Priority priority2) {
        if (t != null) {
            this.payload = t;
            if (priority2 != null) {
                this.priority = priority2;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        if (r4.priority.equals(r5.priority) != false) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.datatransport.Event
            r2 = 0
            if (r1 == 0) goto L_0x003b
            com.google.android.datatransport.Event r5 = (com.google.android.datatransport.Event) r5
            java.lang.Integer r1 = r4.code
            if (r1 != 0) goto L_0x0017
            r1 = r5
            com.google.android.datatransport.AutoValue_Event r1 = (com.google.android.datatransport.AutoValue_Event) r1
            java.lang.Integer r1 = r1.code
            if (r1 != 0) goto L_0x0039
            goto L_0x0022
        L_0x0017:
            r3 = r5
            com.google.android.datatransport.AutoValue_Event r3 = (com.google.android.datatransport.AutoValue_Event) r3
            java.lang.Integer r3 = r3.code
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0039
        L_0x0022:
            T r1 = r4.payload
            com.google.android.datatransport.AutoValue_Event r5 = (com.google.android.datatransport.AutoValue_Event) r5
            T r3 = r5.payload
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0039
            com.google.android.datatransport.Priority r1 = r4.priority
            com.google.android.datatransport.Priority r5 = r5.priority
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x0039
            goto L_0x003a
        L_0x0039:
            r0 = 0
        L_0x003a:
            return r0
        L_0x003b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.AutoValue_Event.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        Integer num = this.code;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.payload.hashCode()) * 1000003) ^ this.priority.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Event{code=");
        outline73.append(this.code);
        outline73.append(", payload=");
        outline73.append(this.payload);
        outline73.append(", priority=");
        outline73.append(this.priority);
        outline73.append("}");
        return outline73.toString();
    }
}
