package com.google.android.datatransport.runtime.backends;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Arrays;

public final class AutoValue_BackendRequest extends BackendRequest {
    public final Iterable<EventInternal> events;
    public final byte[] extras;

    public AutoValue_BackendRequest(Iterable iterable, byte[] bArr, AnonymousClass1 r3) {
        this.events = iterable;
        this.extras = bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        if (java.util.Arrays.equals(r1, r6) != false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r6 instanceof com.google.android.datatransport.runtime.backends.BackendRequest
            r2 = 0
            if (r1 == 0) goto L_0x002c
            com.google.android.datatransport.runtime.backends.BackendRequest r6 = (com.google.android.datatransport.runtime.backends.BackendRequest) r6
            java.lang.Iterable<com.google.android.datatransport.runtime.EventInternal> r1 = r5.events
            r3 = r6
            com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest r3 = (com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest) r3
            java.lang.Iterable<com.google.android.datatransport.runtime.EventInternal> r4 = r3.events
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x002a
            byte[] r1 = r5.extras
            boolean r6 = r6 instanceof com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest
            if (r6 == 0) goto L_0x0021
            byte[] r6 = r3.extras
            goto L_0x0023
        L_0x0021:
            byte[] r6 = r3.extras
        L_0x0023:
            boolean r6 = java.util.Arrays.equals(r1, r6)
            if (r6 == 0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r0 = 0
        L_0x002b:
            return r0
        L_0x002c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.backends.AutoValue_BackendRequest.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        return ((this.events.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.extras);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("BackendRequest{events=");
        outline73.append(this.events);
        outline73.append(", extras=");
        outline73.append(Arrays.toString(this.extras));
        outline73.append("}");
        return outline73.toString();
    }
}
