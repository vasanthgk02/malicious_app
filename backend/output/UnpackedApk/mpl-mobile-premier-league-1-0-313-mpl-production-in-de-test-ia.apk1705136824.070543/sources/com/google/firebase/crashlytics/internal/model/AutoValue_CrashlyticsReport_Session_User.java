package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User;

public final class AutoValue_CrashlyticsReport_Session_User extends User {
    public final String identifier;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder {
        public String identifier;

        public User build() {
            String str = this.identifier == null ? " identifier" : "";
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_User(this.identifier);
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.User.Builder setIdentifier(String str) {
            if (str != null) {
                this.identifier = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof User) {
            return this.identifier.equals(((User) obj).getIdentifier());
        }
        return false;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return this.identifier.hashCode() ^ 1000003;
    }

    public String toString() {
        return GeneratedOutlineSupport.outline62(GeneratedOutlineSupport.outline73("User{identifier="), this.identifier, "}");
    }

    public AutoValue_CrashlyticsReport_Session_User(String str) {
        this.identifier = str;
    }
}
