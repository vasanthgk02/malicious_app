package com.google.android.datatransport.cct.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.Arrays;

public final class AutoValue_LogEvent extends LogEvent {
    public final Integer eventCode;
    public final long eventTimeMs;
    public final long eventUptimeMs;
    public final NetworkConnectionInfo networkConnectionInfo;
    public final byte[] sourceExtension;
    public final String sourceExtensionJsonProto3;
    public final long timezoneOffsetSeconds;

    public static final class Builder extends com.google.android.datatransport.cct.internal.LogEvent.Builder {
        public Integer eventCode;
        public Long eventTimeMs;
        public Long eventUptimeMs;
        public NetworkConnectionInfo networkConnectionInfo;
        public byte[] sourceExtension;
        public String sourceExtensionJsonProto3;
        public Long timezoneOffsetSeconds;
    }

    public AutoValue_LogEvent(long j, Integer num, long j2, byte[] bArr, String str, long j3, NetworkConnectionInfo networkConnectionInfo2, AnonymousClass1 r11) {
        this.eventTimeMs = j;
        this.eventCode = num;
        this.eventUptimeMs = j2;
        this.sourceExtension = bArr;
        this.sourceExtensionJsonProto3 = str;
        this.timezoneOffsetSeconds = j3;
        this.networkConnectionInfo = networkConnectionInfo2;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        AutoValue_LogEvent autoValue_LogEvent = (AutoValue_LogEvent) logEvent;
        if (this.eventTimeMs == autoValue_LogEvent.eventTimeMs) {
            Integer num = this.eventCode;
            if (num != null ? num.equals(autoValue_LogEvent.eventCode) : autoValue_LogEvent.eventCode == null) {
                if (this.eventUptimeMs == autoValue_LogEvent.eventUptimeMs) {
                    byte[] bArr2 = this.sourceExtension;
                    if (logEvent instanceof AutoValue_LogEvent) {
                        bArr = autoValue_LogEvent.sourceExtension;
                    } else {
                        bArr = autoValue_LogEvent.sourceExtension;
                    }
                    if (Arrays.equals(bArr2, bArr)) {
                        String str = this.sourceExtensionJsonProto3;
                        if (str != null ? str.equals(autoValue_LogEvent.sourceExtensionJsonProto3) : autoValue_LogEvent.sourceExtensionJsonProto3 == null) {
                            if (this.timezoneOffsetSeconds == autoValue_LogEvent.timezoneOffsetSeconds) {
                                NetworkConnectionInfo networkConnectionInfo2 = this.networkConnectionInfo;
                                if (networkConnectionInfo2 != null) {
                                }
                            }
                        }
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public int hashCode() {
        long j = this.eventTimeMs;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.eventCode;
        int i2 = 0;
        int hashCode = num == null ? 0 : num.hashCode();
        long j2 = this.eventUptimeMs;
        int hashCode2 = (((((i ^ hashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.sourceExtension)) * 1000003;
        String str = this.sourceExtensionJsonProto3;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.timezoneOffsetSeconds;
        int i3 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo2 = this.networkConnectionInfo;
        if (networkConnectionInfo2 != null) {
            i2 = networkConnectionInfo2.hashCode();
        }
        return i3 ^ i2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("LogEvent{eventTimeMs=");
        outline73.append(this.eventTimeMs);
        outline73.append(", eventCode=");
        outline73.append(this.eventCode);
        outline73.append(", eventUptimeMs=");
        outline73.append(this.eventUptimeMs);
        outline73.append(", sourceExtension=");
        outline73.append(Arrays.toString(this.sourceExtension));
        outline73.append(", sourceExtensionJsonProto3=");
        outline73.append(this.sourceExtensionJsonProto3);
        outline73.append(", timezoneOffsetSeconds=");
        outline73.append(this.timezoneOffsetSeconds);
        outline73.append(", networkConnectionInfo=");
        outline73.append(this.networkConnectionInfo);
        outline73.append("}");
        return outline73.toString();
    }
}
