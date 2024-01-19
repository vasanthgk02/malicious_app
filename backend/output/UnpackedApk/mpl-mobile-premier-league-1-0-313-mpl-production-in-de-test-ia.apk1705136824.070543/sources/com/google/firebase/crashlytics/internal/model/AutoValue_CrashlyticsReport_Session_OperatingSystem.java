package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem;

public final class AutoValue_CrashlyticsReport_Session_OperatingSystem extends OperatingSystem {
    public final String buildVersion;
    public final boolean jailbroken;
    public final int platform;
    public final String version;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder {
        public String buildVersion;
        public Boolean jailbroken;
        public Integer platform;
        public String version;

        public OperatingSystem build() {
            String str = this.platform == null ? " platform" : "";
            if (this.version == null) {
                str = GeneratedOutlineSupport.outline50(str, " version");
            }
            if (this.buildVersion == null) {
                str = GeneratedOutlineSupport.outline50(str, " buildVersion");
            }
            if (this.jailbroken == null) {
                str = GeneratedOutlineSupport.outline50(str, " jailbroken");
            }
            if (str.isEmpty()) {
                AutoValue_CrashlyticsReport_Session_OperatingSystem autoValue_CrashlyticsReport_Session_OperatingSystem = new AutoValue_CrashlyticsReport_Session_OperatingSystem(this.platform.intValue(), this.version, this.buildVersion, this.jailbroken.booleanValue());
                return autoValue_CrashlyticsReport_Session_OperatingSystem;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder setBuildVersion(String str) {
            if (str != null) {
                this.buildVersion = str;
                return this;
            }
            throw new NullPointerException("Null buildVersion");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder setJailbroken(boolean z) {
            this.jailbroken = Boolean.valueOf(z);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder setPlatform(int i) {
            this.platform = Integer.valueOf(i);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.OperatingSystem.Builder setVersion(String str) {
            if (str != null) {
                this.version = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OperatingSystem)) {
            return false;
        }
        OperatingSystem operatingSystem = (OperatingSystem) obj;
        if (this.platform != operatingSystem.getPlatform() || !this.version.equals(operatingSystem.getVersion()) || !this.buildVersion.equals(operatingSystem.getBuildVersion()) || this.jailbroken != operatingSystem.isJailbroken()) {
            z = false;
        }
        return z;
    }

    public String getBuildVersion() {
        return this.buildVersion;
    }

    public int getPlatform() {
        return this.platform;
    }

    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return ((((((this.platform ^ 1000003) * 1000003) ^ this.version.hashCode()) * 1000003) ^ this.buildVersion.hashCode()) * 1000003) ^ (this.jailbroken ? 1231 : 1237);
    }

    public boolean isJailbroken() {
        return this.jailbroken;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("OperatingSystem{platform=");
        outline73.append(this.platform);
        outline73.append(", version=");
        outline73.append(this.version);
        outline73.append(", buildVersion=");
        outline73.append(this.buildVersion);
        outline73.append(", jailbroken=");
        return GeneratedOutlineSupport.outline66(outline73, this.jailbroken, "}");
    }

    public AutoValue_CrashlyticsReport_Session_OperatingSystem(int i, String str, String str2, boolean z) {
        this.platform = i;
        this.version = str;
        this.buildVersion = str2;
        this.jailbroken = z;
    }
}
