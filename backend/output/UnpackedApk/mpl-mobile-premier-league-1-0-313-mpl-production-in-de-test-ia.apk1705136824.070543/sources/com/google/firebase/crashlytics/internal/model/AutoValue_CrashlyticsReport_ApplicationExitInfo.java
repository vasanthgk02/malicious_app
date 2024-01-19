package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo;

public final class AutoValue_CrashlyticsReport_ApplicationExitInfo extends ApplicationExitInfo {
    public final int importance;
    public final int pid;
    public final String processName;
    public final long pss;
    public final int reasonCode;
    public final long rss;
    public final long timestamp;
    public final String traceFile;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder {
        public Integer importance;
        public Integer pid;
        public String processName;
        public Long pss;
        public Integer reasonCode;
        public Long rss;
        public Long timestamp;
        public String traceFile;

        public ApplicationExitInfo build() {
            String str = this.pid == null ? " pid" : "";
            if (this.processName == null) {
                str = GeneratedOutlineSupport.outline50(str, " processName");
            }
            if (this.reasonCode == null) {
                str = GeneratedOutlineSupport.outline50(str, " reasonCode");
            }
            if (this.importance == null) {
                str = GeneratedOutlineSupport.outline50(str, " importance");
            }
            if (this.pss == null) {
                str = GeneratedOutlineSupport.outline50(str, " pss");
            }
            if (this.rss == null) {
                str = GeneratedOutlineSupport.outline50(str, " rss");
            }
            if (this.timestamp == null) {
                str = GeneratedOutlineSupport.outline50(str, " timestamp");
            }
            if (str.isEmpty()) {
                AutoValue_CrashlyticsReport_ApplicationExitInfo autoValue_CrashlyticsReport_ApplicationExitInfo = new AutoValue_CrashlyticsReport_ApplicationExitInfo(this.pid.intValue(), this.processName, this.reasonCode.intValue(), this.importance.intValue(), this.pss.longValue(), this.rss.longValue(), this.timestamp.longValue(), this.traceFile);
                return autoValue_CrashlyticsReport_ApplicationExitInfo;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setImportance(int i) {
            this.importance = Integer.valueOf(i);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setPid(int i) {
            this.pid = Integer.valueOf(i);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setProcessName(String str) {
            if (str != null) {
                this.processName = str;
                return this;
            }
            throw new NullPointerException("Null processName");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setPss(long j) {
            this.pss = Long.valueOf(j);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setReasonCode(int i) {
            this.reasonCode = Integer.valueOf(i);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setRss(long j) {
            this.rss = Long.valueOf(j);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setTimestamp(long j) {
            this.timestamp = Long.valueOf(j);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.ApplicationExitInfo.Builder setTraceFile(String str) {
            this.traceFile = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ApplicationExitInfo)) {
            return false;
        }
        ApplicationExitInfo applicationExitInfo = (ApplicationExitInfo) obj;
        if (this.pid == applicationExitInfo.getPid() && this.processName.equals(applicationExitInfo.getProcessName()) && this.reasonCode == applicationExitInfo.getReasonCode() && this.importance == applicationExitInfo.getImportance() && this.pss == applicationExitInfo.getPss() && this.rss == applicationExitInfo.getRss() && this.timestamp == applicationExitInfo.getTimestamp()) {
            String str = this.traceFile;
            if (str != null) {
            }
        }
        z = false;
        return z;
    }

    public int getImportance() {
        return this.importance;
    }

    public int getPid() {
        return this.pid;
    }

    public String getProcessName() {
        return this.processName;
    }

    public long getPss() {
        return this.pss;
    }

    public int getReasonCode() {
        return this.reasonCode;
    }

    public long getRss() {
        return this.rss;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getTraceFile() {
        return this.traceFile;
    }

    public int hashCode() {
        long j = this.pss;
        long j2 = this.rss;
        long j3 = this.timestamp;
        int hashCode = (((((((((((((this.pid ^ 1000003) * 1000003) ^ this.processName.hashCode()) * 1000003) ^ this.reasonCode) * 1000003) ^ this.importance) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        String str = this.traceFile;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("ApplicationExitInfo{pid=");
        outline73.append(this.pid);
        outline73.append(", processName=");
        outline73.append(this.processName);
        outline73.append(", reasonCode=");
        outline73.append(this.reasonCode);
        outline73.append(", importance=");
        outline73.append(this.importance);
        outline73.append(", pss=");
        outline73.append(this.pss);
        outline73.append(", rss=");
        outline73.append(this.rss);
        outline73.append(", timestamp=");
        outline73.append(this.timestamp);
        outline73.append(", traceFile=");
        return GeneratedOutlineSupport.outline62(outline73, this.traceFile, "}");
    }

    public AutoValue_CrashlyticsReport_ApplicationExitInfo(int i, String str, int i2, int i3, long j, long j2, long j3, String str2) {
        this.pid = i;
        this.processName = str;
        this.reasonCode = i2;
        this.importance = i3;
        this.pss = j;
        this.rss = j2;
        this.timestamp = j3;
        this.traceFile = str2;
    }
}
