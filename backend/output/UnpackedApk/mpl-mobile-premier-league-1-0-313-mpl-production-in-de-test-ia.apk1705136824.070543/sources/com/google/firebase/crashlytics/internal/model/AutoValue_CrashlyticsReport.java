package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.FilesPayload;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session;

public final class AutoValue_CrashlyticsReport extends CrashlyticsReport {
    public final String buildVersion;
    public final String displayVersion;
    public final String gmpAppId;
    public final String installationUuid;
    public final FilesPayload ndkPayload;
    public final int platform;
    public final String sdkVersion;
    public final Session session;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder {
        public String buildVersion;
        public String displayVersion;
        public String gmpAppId;
        public String installationUuid;
        public FilesPayload ndkPayload;
        public Integer platform;
        public String sdkVersion;
        public Session session;

        public CrashlyticsReport build() {
            String str = this.sdkVersion == null ? " sdkVersion" : "";
            if (this.gmpAppId == null) {
                str = GeneratedOutlineSupport.outline50(str, " gmpAppId");
            }
            if (this.platform == null) {
                str = GeneratedOutlineSupport.outline50(str, " platform");
            }
            if (this.installationUuid == null) {
                str = GeneratedOutlineSupport.outline50(str, " installationUuid");
            }
            if (this.buildVersion == null) {
                str = GeneratedOutlineSupport.outline50(str, " buildVersion");
            }
            if (this.displayVersion == null) {
                str = GeneratedOutlineSupport.outline50(str, " displayVersion");
            }
            if (str.isEmpty()) {
                AutoValue_CrashlyticsReport autoValue_CrashlyticsReport = new AutoValue_CrashlyticsReport(this.sdkVersion, this.gmpAppId, this.platform.intValue(), this.installationUuid, this.buildVersion, this.displayVersion, this.session, this.ndkPayload);
                return autoValue_CrashlyticsReport;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setBuildVersion(String str) {
            if (str != null) {
                this.buildVersion = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setDisplayVersion(String str) {
            if (str != null) {
                this.displayVersion = str;
                return this;
            }
            throw new NullPointerException("Null displayVersion");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setGmpAppId(String str) {
            if (str != null) {
                this.gmpAppId = str;
                return this;
            }
            throw new NullPointerException("Null gmpAppId");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setInstallationUuid(String str) {
            if (str != null) {
                this.installationUuid = str;
                return this;
            }
            throw new NullPointerException("Null installationUuid");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setNdkPayload(FilesPayload filesPayload) {
            this.ndkPayload = filesPayload;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setPlatform(int i) {
            this.platform = Integer.valueOf(i);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setSdkVersion(String str) {
            if (str != null) {
                this.sdkVersion = str;
                return this;
            }
            throw new NullPointerException("Null sdkVersion");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder setSession(Session session2) {
            this.session = session2;
            return this;
        }

        public Builder() {
        }

        public Builder(CrashlyticsReport crashlyticsReport) {
            this.sdkVersion = crashlyticsReport.getSdkVersion();
            this.gmpAppId = crashlyticsReport.getGmpAppId();
            this.platform = Integer.valueOf(crashlyticsReport.getPlatform());
            this.installationUuid = crashlyticsReport.getInstallationUuid();
            this.buildVersion = crashlyticsReport.getBuildVersion();
            this.displayVersion = crashlyticsReport.getDisplayVersion();
            this.session = crashlyticsReport.getSession();
            this.ndkPayload = crashlyticsReport.getNdkPayload();
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport)) {
            return false;
        }
        CrashlyticsReport crashlyticsReport = (CrashlyticsReport) obj;
        if (this.sdkVersion.equals(crashlyticsReport.getSdkVersion()) && this.gmpAppId.equals(crashlyticsReport.getGmpAppId()) && this.platform == crashlyticsReport.getPlatform() && this.installationUuid.equals(crashlyticsReport.getInstallationUuid()) && this.buildVersion.equals(crashlyticsReport.getBuildVersion()) && this.displayVersion.equals(crashlyticsReport.getDisplayVersion())) {
            Session session2 = this.session;
            if (session2 != null ? session2.equals(crashlyticsReport.getSession()) : crashlyticsReport.getSession() == null) {
                FilesPayload filesPayload = this.ndkPayload;
                if (filesPayload != null) {
                }
            }
        }
        z = false;
        return z;
    }

    public String getBuildVersion() {
        return this.buildVersion;
    }

    public String getDisplayVersion() {
        return this.displayVersion;
    }

    public String getGmpAppId() {
        return this.gmpAppId;
    }

    public String getInstallationUuid() {
        return this.installationUuid;
    }

    public FilesPayload getNdkPayload() {
        return this.ndkPayload;
    }

    public int getPlatform() {
        return this.platform;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public Session getSession() {
        return this.session;
    }

    public int hashCode() {
        int hashCode = (((((((((((this.sdkVersion.hashCode() ^ 1000003) * 1000003) ^ this.gmpAppId.hashCode()) * 1000003) ^ this.platform) * 1000003) ^ this.installationUuid.hashCode()) * 1000003) ^ this.buildVersion.hashCode()) * 1000003) ^ this.displayVersion.hashCode()) * 1000003;
        Session session2 = this.session;
        int i = 0;
        int hashCode2 = (hashCode ^ (session2 == null ? 0 : session2.hashCode())) * 1000003;
        FilesPayload filesPayload = this.ndkPayload;
        if (filesPayload != null) {
            i = filesPayload.hashCode();
        }
        return hashCode2 ^ i;
    }

    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CrashlyticsReport{sdkVersion=");
        outline73.append(this.sdkVersion);
        outline73.append(", gmpAppId=");
        outline73.append(this.gmpAppId);
        outline73.append(", platform=");
        outline73.append(this.platform);
        outline73.append(", installationUuid=");
        outline73.append(this.installationUuid);
        outline73.append(", buildVersion=");
        outline73.append(this.buildVersion);
        outline73.append(", displayVersion=");
        outline73.append(this.displayVersion);
        outline73.append(", session=");
        outline73.append(this.session);
        outline73.append(", ndkPayload=");
        outline73.append(this.ndkPayload);
        outline73.append("}");
        return outline73.toString();
    }

    public AutoValue_CrashlyticsReport(String str, String str2, int i, String str3, String str4, String str5, Session session2, FilesPayload filesPayload) {
        this.sdkVersion = str;
        this.gmpAppId = str2;
        this.platform = i;
        this.installationUuid = str3;
        this.buildVersion = str4;
        this.displayVersion = str5;
        this.session = session2;
        this.ndkPayload = filesPayload;
    }
}
