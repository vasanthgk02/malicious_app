package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization;

public final class AutoValue_CrashlyticsReport_Session_Application extends Application {
    public final String developmentPlatform;
    public final String developmentPlatformVersion;
    public final String displayVersion;
    public final String identifier;
    public final String installationUuid;
    public final Organization organization;
    public final String version;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder {
        public String developmentPlatform;
        public String developmentPlatformVersion;
        public String displayVersion;
        public String identifier;
        public String installationUuid;
        public Organization organization;
        public String version;

        public Application build() {
            String str = this.identifier == null ? " identifier" : "";
            if (this.version == null) {
                str = GeneratedOutlineSupport.outline50(str, " version");
            }
            if (str.isEmpty()) {
                AutoValue_CrashlyticsReport_Session_Application autoValue_CrashlyticsReport_Session_Application = new AutoValue_CrashlyticsReport_Session_Application(this.identifier, this.version, this.displayVersion, this.organization, this.installationUuid, this.developmentPlatform, this.developmentPlatformVersion);
                return autoValue_CrashlyticsReport_Session_Application;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setDevelopmentPlatform(String str) {
            this.developmentPlatform = str;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setDevelopmentPlatformVersion(String str) {
            this.developmentPlatformVersion = str;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setDisplayVersion(String str) {
            this.displayVersion = str;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setIdentifier(String str) {
            if (str != null) {
                this.identifier = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setInstallationUuid(String str) {
            this.installationUuid = str;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setOrganization(Organization organization2) {
            this.organization = organization2;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder setVersion(String str) {
            if (str != null) {
                this.version = str;
                return this;
            }
            throw new NullPointerException("Null version");
        }

        public Builder() {
        }

        public Builder(Application application) {
            this.identifier = application.getIdentifier();
            this.version = application.getVersion();
            this.displayVersion = application.getDisplayVersion();
            this.organization = application.getOrganization();
            this.installationUuid = application.getInstallationUuid();
            this.developmentPlatform = application.getDevelopmentPlatform();
            this.developmentPlatformVersion = application.getDevelopmentPlatformVersion();
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Application)) {
            return false;
        }
        Application application = (Application) obj;
        if (this.identifier.equals(application.getIdentifier()) && this.version.equals(application.getVersion())) {
            String str = this.displayVersion;
            if (str != null ? str.equals(application.getDisplayVersion()) : application.getDisplayVersion() == null) {
                Organization organization2 = this.organization;
                if (organization2 != null ? organization2.equals(application.getOrganization()) : application.getOrganization() == null) {
                    String str2 = this.installationUuid;
                    if (str2 != null ? str2.equals(application.getInstallationUuid()) : application.getInstallationUuid() == null) {
                        String str3 = this.developmentPlatform;
                        if (str3 != null ? str3.equals(application.getDevelopmentPlatform()) : application.getDevelopmentPlatform() == null) {
                            String str4 = this.developmentPlatformVersion;
                            if (str4 != null) {
                            }
                        }
                    }
                }
            }
        }
        z = false;
        return z;
    }

    public String getDevelopmentPlatform() {
        return this.developmentPlatform;
    }

    public String getDevelopmentPlatformVersion() {
        return this.developmentPlatformVersion;
    }

    public String getDisplayVersion() {
        return this.displayVersion;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getInstallationUuid() {
        return this.installationUuid;
    }

    public Organization getOrganization() {
        return this.organization;
    }

    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = (((this.identifier.hashCode() ^ 1000003) * 1000003) ^ this.version.hashCode()) * 1000003;
        String str = this.displayVersion;
        int i = 0;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        Organization organization2 = this.organization;
        int hashCode3 = (hashCode2 ^ (organization2 == null ? 0 : organization2.hashCode())) * 1000003;
        String str2 = this.installationUuid;
        int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.developmentPlatform;
        int hashCode5 = (hashCode4 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.developmentPlatformVersion;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode5 ^ i;
    }

    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Application{identifier=");
        outline73.append(this.identifier);
        outline73.append(", version=");
        outline73.append(this.version);
        outline73.append(", displayVersion=");
        outline73.append(this.displayVersion);
        outline73.append(", organization=");
        outline73.append(this.organization);
        outline73.append(", installationUuid=");
        outline73.append(this.installationUuid);
        outline73.append(", developmentPlatform=");
        outline73.append(this.developmentPlatform);
        outline73.append(", developmentPlatformVersion=");
        return GeneratedOutlineSupport.outline62(outline73, this.developmentPlatformVersion, "}");
    }

    public AutoValue_CrashlyticsReport_Session_Application(String str, String str2, String str3, Organization organization2, String str4, String str5, String str6) {
        this.identifier = str;
        this.version = str2;
        this.displayVersion = str3;
        this.organization = organization2;
        this.installationUuid = str4;
        this.developmentPlatform = str5;
        this.developmentPlatformVersion = str6;
    }
}
