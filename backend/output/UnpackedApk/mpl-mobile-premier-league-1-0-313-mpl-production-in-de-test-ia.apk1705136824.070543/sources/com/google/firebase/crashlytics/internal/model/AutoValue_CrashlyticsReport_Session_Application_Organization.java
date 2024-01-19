package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization;

public final class AutoValue_CrashlyticsReport_Session_Application_Organization extends Organization {
    public final String clsId;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization.Builder {
        public String clsId;

        public Organization build() {
            String str = this.clsId == null ? " clsId" : "";
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Application_Organization(this.clsId);
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization.Builder setClsId(String str) {
            if (str != null) {
                this.clsId = str;
                return this;
            }
            throw new NullPointerException("Null clsId");
        }

        public Builder() {
        }

        public Builder(Organization organization) {
            this.clsId = organization.getClsId();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Organization) {
            return this.clsId.equals(((Organization) obj).getClsId());
        }
        return false;
    }

    public String getClsId() {
        return this.clsId;
    }

    public int hashCode() {
        return this.clsId.hashCode() ^ 1000003;
    }

    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Application.Organization.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("Organization{clsId="), this.clsId, "}");
    }

    public AutoValue_CrashlyticsReport_Session_Application_Organization(String str) {
        this.clsId = str;
    }
}
