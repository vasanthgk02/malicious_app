package com.google.android.datatransport.cct.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.util.List;

public final class AutoValue_LogRequest extends LogRequest {
    public final ClientInfo clientInfo;
    public final List<LogEvent> logEvents;
    public final Integer logSource;
    public final String logSourceName;
    public final QosTier qosTier;
    public final long requestTimeMs;
    public final long requestUptimeMs;

    public AutoValue_LogRequest(long j, long j2, ClientInfo clientInfo2, Integer num, String str, List list, QosTier qosTier2, AnonymousClass1 r10) {
        this.requestTimeMs = j;
        this.requestUptimeMs = j2;
        this.clientInfo = clientInfo2;
        this.logSource = num;
        this.logSourceName = str;
        this.logEvents = list;
        this.qosTier = qosTier2;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        AutoValue_LogRequest autoValue_LogRequest = (AutoValue_LogRequest) ((LogRequest) obj);
        if (this.requestTimeMs == autoValue_LogRequest.requestTimeMs && this.requestUptimeMs == autoValue_LogRequest.requestUptimeMs) {
            ClientInfo clientInfo2 = this.clientInfo;
            if (clientInfo2 != null ? clientInfo2.equals(autoValue_LogRequest.clientInfo) : autoValue_LogRequest.clientInfo == null) {
                Integer num = this.logSource;
                if (num != null ? num.equals(autoValue_LogRequest.logSource) : autoValue_LogRequest.logSource == null) {
                    String str = this.logSourceName;
                    if (str != null ? str.equals(autoValue_LogRequest.logSourceName) : autoValue_LogRequest.logSourceName == null) {
                        List<LogEvent> list = this.logEvents;
                        if (list != null ? list.equals(autoValue_LogRequest.logEvents) : autoValue_LogRequest.logEvents == null) {
                            QosTier qosTier2 = this.qosTier;
                            if (qosTier2 != null) {
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
        long j = this.requestTimeMs;
        long j2 = this.requestUptimeMs;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        ClientInfo clientInfo2 = this.clientInfo;
        int i2 = 0;
        int hashCode = (i ^ (clientInfo2 == null ? 0 : clientInfo2.hashCode())) * 1000003;
        Integer num = this.logSource;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.logSourceName;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<LogEvent> list = this.logEvents;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        QosTier qosTier2 = this.qosTier;
        if (qosTier2 != null) {
            i2 = qosTier2.hashCode();
        }
        return hashCode4 ^ i2;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("LogRequest{requestTimeMs=");
        outline73.append(this.requestTimeMs);
        outline73.append(", requestUptimeMs=");
        outline73.append(this.requestUptimeMs);
        outline73.append(", clientInfo=");
        outline73.append(this.clientInfo);
        outline73.append(", logSource=");
        outline73.append(this.logSource);
        outline73.append(", logSourceName=");
        outline73.append(this.logSourceName);
        outline73.append(", logEvents=");
        outline73.append(this.logEvents);
        outline73.append(", qosTier=");
        outline73.append(this.qosTier);
        outline73.append("}");
        return outline73.toString();
    }
}
