package com.google.android.datatransport.runtime;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Map;

public final class AutoValue_EventInternal extends EventInternal {
    public final Map<String, String> autoMetadata;
    public final Integer code;
    public final EncodedPayload encodedPayload;
    public final long eventMillis;
    public final String transportName;
    public final long uptimeMillis;

    public static final class Builder extends com.google.android.datatransport.runtime.EventInternal.Builder {
        public Map<String, String> autoMetadata;
        public Integer code;
        public EncodedPayload encodedPayload;
        public Long eventMillis;
        public String transportName;
        public Long uptimeMillis;

        public EventInternal build() {
            String str = this.transportName == null ? " transportName" : "";
            if (this.encodedPayload == null) {
                str = GeneratedOutlineSupport.outline50(str, " encodedPayload");
            }
            if (this.eventMillis == null) {
                str = GeneratedOutlineSupport.outline50(str, " eventMillis");
            }
            if (this.uptimeMillis == null) {
                str = GeneratedOutlineSupport.outline50(str, " uptimeMillis");
            }
            if (this.autoMetadata == null) {
                str = GeneratedOutlineSupport.outline50(str, " autoMetadata");
            }
            if (str.isEmpty()) {
                AutoValue_EventInternal autoValue_EventInternal = new AutoValue_EventInternal(this.transportName, this.code, this.encodedPayload, this.eventMillis.longValue(), this.uptimeMillis.longValue(), this.autoMetadata, null);
                return autoValue_EventInternal;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public Map<String, String> getAutoMetadata() {
            Map<String, String> map = this.autoMetadata;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        public com.google.android.datatransport.runtime.EventInternal.Builder setEncodedPayload(EncodedPayload encodedPayload2) {
            if (encodedPayload2 != null) {
                this.encodedPayload = encodedPayload2;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        public com.google.android.datatransport.runtime.EventInternal.Builder setEventMillis(long j) {
            this.eventMillis = Long.valueOf(j);
            return this;
        }

        public com.google.android.datatransport.runtime.EventInternal.Builder setTransportName(String str) {
            if (str != null) {
                this.transportName = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        public com.google.android.datatransport.runtime.EventInternal.Builder setUptimeMillis(long j) {
            this.uptimeMillis = Long.valueOf(j);
            return this;
        }
    }

    public AutoValue_EventInternal(String str, Integer num, EncodedPayload encodedPayload2, long j, long j2, Map map, AnonymousClass1 r9) {
        this.transportName = str;
        this.code = num;
        this.encodedPayload = encodedPayload2;
        this.eventMillis = j;
        this.uptimeMillis = j2;
        this.autoMetadata = map;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0053, code lost:
        if (r7.autoMetadata.equals(r8.autoMetadata) != false) goto L_0x0057;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.android.datatransport.runtime.EventInternal
            r2 = 0
            if (r1 == 0) goto L_0x0058
            com.google.android.datatransport.runtime.EventInternal r8 = (com.google.android.datatransport.runtime.EventInternal) r8
            java.lang.String r1 = r7.transportName
            r3 = r8
            com.google.android.datatransport.runtime.AutoValue_EventInternal r3 = (com.google.android.datatransport.runtime.AutoValue_EventInternal) r3
            java.lang.String r3 = r3.transportName
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
            java.lang.Integer r1 = r7.code
            if (r1 != 0) goto L_0x0024
            r1 = r8
            com.google.android.datatransport.runtime.AutoValue_EventInternal r1 = (com.google.android.datatransport.runtime.AutoValue_EventInternal) r1
            java.lang.Integer r1 = r1.code
            if (r1 != 0) goto L_0x0056
            goto L_0x002f
        L_0x0024:
            r3 = r8
            com.google.android.datatransport.runtime.AutoValue_EventInternal r3 = (com.google.android.datatransport.runtime.AutoValue_EventInternal) r3
            java.lang.Integer r3 = r3.code
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
        L_0x002f:
            com.google.android.datatransport.runtime.EncodedPayload r1 = r7.encodedPayload
            com.google.android.datatransport.runtime.AutoValue_EventInternal r8 = (com.google.android.datatransport.runtime.AutoValue_EventInternal) r8
            com.google.android.datatransport.runtime.EncodedPayload r3 = r8.encodedPayload
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0056
            long r3 = r7.eventMillis
            long r5 = r8.eventMillis
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0056
            long r3 = r7.uptimeMillis
            long r5 = r8.uptimeMillis
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0056
            java.util.Map<java.lang.String, java.lang.String> r1 = r7.autoMetadata
            java.util.Map<java.lang.String, java.lang.String> r8 = r8.autoMetadata
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r0 = 0
        L_0x0057:
            return r0
        L_0x0058:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.AutoValue_EventInternal.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int hashCode = (this.transportName.hashCode() ^ 1000003) * 1000003;
        Integer num = this.code;
        int hashCode2 = num == null ? 0 : num.hashCode();
        long j = this.eventMillis;
        long j2 = this.uptimeMillis;
        return ((((((((hashCode ^ hashCode2) * 1000003) ^ this.encodedPayload.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.autoMetadata.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("EventInternal{transportName=");
        outline73.append(this.transportName);
        outline73.append(", code=");
        outline73.append(this.code);
        outline73.append(", encodedPayload=");
        outline73.append(this.encodedPayload);
        outline73.append(", eventMillis=");
        outline73.append(this.eventMillis);
        outline73.append(", uptimeMillis=");
        outline73.append(this.uptimeMillis);
        outline73.append(", autoMetadata=");
        outline73.append(this.autoMetadata);
        outline73.append("}");
        return outline73.toString();
    }
}
