package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData;

public final class AutoValue_StaticSessionData_AppData extends AppData {
    public final String appIdentifier;
    public final int deliveryMechanism;
    public final DevelopmentPlatformProvider developmentPlatformProvider;
    public final String installUuid;
    public final String versionCode;
    public final String versionName;

    public AutoValue_StaticSessionData_AppData(String str, String str2, String str3, String str4, int i, DevelopmentPlatformProvider developmentPlatformProvider2) {
        if (str != null) {
            this.appIdentifier = str;
            if (str2 != null) {
                this.versionCode = str2;
                if (str3 != null) {
                    this.versionName = str3;
                    if (str4 != null) {
                        this.installUuid = str4;
                        this.deliveryMechanism = i;
                        if (developmentPlatformProvider2 != null) {
                            this.developmentPlatformProvider = developmentPlatformProvider2;
                            return;
                        }
                        throw new NullPointerException("Null developmentPlatformProvider");
                    }
                    throw new NullPointerException("Null installUuid");
                }
                throw new NullPointerException("Null versionName");
            }
            throw new NullPointerException("Null versionCode");
        }
        throw new NullPointerException("Null appIdentifier");
    }

    public String appIdentifier() {
        return this.appIdentifier;
    }

    public int deliveryMechanism() {
        return this.deliveryMechanism;
    }

    public DevelopmentPlatformProvider developmentPlatformProvider() {
        return this.developmentPlatformProvider;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppData)) {
            return false;
        }
        AppData appData = (AppData) obj;
        if (!this.appIdentifier.equals(appData.appIdentifier()) || !this.versionCode.equals(appData.versionCode()) || !this.versionName.equals(appData.versionName()) || !this.installUuid.equals(appData.installUuid()) || this.deliveryMechanism != appData.deliveryMechanism() || !this.developmentPlatformProvider.equals(appData.developmentPlatformProvider())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((((((((((this.appIdentifier.hashCode() ^ 1000003) * 1000003) ^ this.versionCode.hashCode()) * 1000003) ^ this.versionName.hashCode()) * 1000003) ^ this.installUuid.hashCode()) * 1000003) ^ this.deliveryMechanism) * 1000003) ^ this.developmentPlatformProvider.hashCode();
    }

    public String installUuid() {
        return this.installUuid;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("AppData{appIdentifier=");
        outline73.append(this.appIdentifier);
        outline73.append(", versionCode=");
        outline73.append(this.versionCode);
        outline73.append(", versionName=");
        outline73.append(this.versionName);
        outline73.append(", installUuid=");
        outline73.append(this.installUuid);
        outline73.append(", deliveryMechanism=");
        outline73.append(this.deliveryMechanism);
        outline73.append(", developmentPlatformProvider=");
        outline73.append(this.developmentPlatformProvider);
        outline73.append("}");
        return outline73.toString();
    }

    public String versionCode() {
        return this.versionCode;
    }

    public String versionName() {
        return this.versionName;
    }
}
