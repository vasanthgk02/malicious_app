package com.google.android.datatransport.runtime;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.android.datatransport.Priority;
import java.util.Arrays;

public final class AutoValue_TransportContext extends TransportContext {
    public final String backendName;
    public final byte[] extras;
    public final Priority priority;

    public static final class Builder extends com.google.android.datatransport.runtime.TransportContext.Builder {
        public String backendName;
        public byte[] extras;
        public Priority priority;

        public TransportContext build() {
            String str = this.backendName == null ? " backendName" : "";
            if (this.priority == null) {
                str = GeneratedOutlineSupport.outline50(str, " priority");
            }
            if (str.isEmpty()) {
                return new AutoValue_TransportContext(this.backendName, this.extras, this.priority, null);
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.android.datatransport.runtime.TransportContext.Builder setBackendName(String str) {
            if (str != null) {
                this.backendName = str;
                return this;
            }
            throw new NullPointerException("Null backendName");
        }

        public com.google.android.datatransport.runtime.TransportContext.Builder setPriority(Priority priority2) {
            if (priority2 != null) {
                this.priority = priority2;
                return this;
            }
            throw new NullPointerException("Null priority");
        }
    }

    public AutoValue_TransportContext(String str, byte[] bArr, Priority priority2, AnonymousClass1 r4) {
        this.backendName = str;
        this.extras = bArr;
        this.priority = priority2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0039, code lost:
        if (r4.priority.equals(((com.google.android.datatransport.runtime.AutoValue_TransportContext) r5).priority) != false) goto L_0x003d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 1
            if (r5 != r4) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r5 instanceof com.google.android.datatransport.runtime.TransportContext
            r2 = 0
            if (r1 == 0) goto L_0x003e
            com.google.android.datatransport.runtime.TransportContext r5 = (com.google.android.datatransport.runtime.TransportContext) r5
            java.lang.String r1 = r4.backendName
            r3 = r5
            com.google.android.datatransport.runtime.AutoValue_TransportContext r3 = (com.google.android.datatransport.runtime.AutoValue_TransportContext) r3
            java.lang.String r3 = r3.backendName
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x003c
            byte[] r1 = r4.extras
            boolean r3 = r5 instanceof com.google.android.datatransport.runtime.AutoValue_TransportContext
            if (r3 == 0) goto L_0x0024
            r3 = r5
            com.google.android.datatransport.runtime.AutoValue_TransportContext r3 = (com.google.android.datatransport.runtime.AutoValue_TransportContext) r3
            byte[] r3 = r3.extras
            goto L_0x0029
        L_0x0024:
            r3 = r5
            com.google.android.datatransport.runtime.AutoValue_TransportContext r3 = (com.google.android.datatransport.runtime.AutoValue_TransportContext) r3
            byte[] r3 = r3.extras
        L_0x0029:
            boolean r1 = java.util.Arrays.equals(r1, r3)
            if (r1 == 0) goto L_0x003c
            com.google.android.datatransport.Priority r1 = r4.priority
            com.google.android.datatransport.runtime.AutoValue_TransportContext r5 = (com.google.android.datatransport.runtime.AutoValue_TransportContext) r5
            com.google.android.datatransport.Priority r5 = r5.priority
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            return r0
        L_0x003e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.AutoValue_TransportContext.equals(java.lang.Object):boolean");
    }

    public String getBackendName() {
        return this.backendName;
    }

    public int hashCode() {
        return ((((this.backendName.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.extras)) * 1000003) ^ this.priority.hashCode();
    }
}
