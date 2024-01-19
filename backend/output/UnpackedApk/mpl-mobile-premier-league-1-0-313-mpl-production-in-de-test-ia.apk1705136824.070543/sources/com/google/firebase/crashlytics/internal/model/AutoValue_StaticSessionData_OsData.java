package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData;

public final class AutoValue_StaticSessionData_OsData extends OsData {
    public final boolean isRooted;
    public final String osCodeName;
    public final String osRelease;

    public AutoValue_StaticSessionData_OsData(String str, String str2, boolean z) {
        if (str != null) {
            this.osRelease = str;
            if (str2 != null) {
                this.osCodeName = str2;
                this.isRooted = z;
                return;
            }
            throw new NullPointerException("Null osCodeName");
        }
        throw new NullPointerException("Null osRelease");
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OsData)) {
            return false;
        }
        OsData osData = (OsData) obj;
        if (!this.osRelease.equals(osData.osRelease()) || !this.osCodeName.equals(osData.osCodeName()) || this.isRooted != osData.isRooted()) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((((this.osRelease.hashCode() ^ 1000003) * 1000003) ^ this.osCodeName.hashCode()) * 1000003) ^ (this.isRooted ? 1231 : 1237);
    }

    public boolean isRooted() {
        return this.isRooted;
    }

    public String osCodeName() {
        return this.osCodeName;
    }

    public String osRelease() {
        return this.osRelease;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("OsData{osRelease=");
        outline73.append(this.osRelease);
        outline73.append(", osCodeName=");
        outline73.append(this.osCodeName);
        outline73.append(", isRooted=");
        return GeneratedOutlineSupport.outline66(outline73, this.isRooted, "}");
    }
}
