package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.StaticSessionData.AppData;
import com.google.firebase.crashlytics.internal.model.StaticSessionData.DeviceData;
import com.google.firebase.crashlytics.internal.model.StaticSessionData.OsData;

public final class AutoValue_StaticSessionData extends StaticSessionData {
    public final AppData appData;
    public final DeviceData deviceData;
    public final OsData osData;

    public AutoValue_StaticSessionData(AppData appData2, OsData osData2, DeviceData deviceData2) {
        if (appData2 != null) {
            this.appData = appData2;
            if (osData2 != null) {
                this.osData = osData2;
                if (deviceData2 != null) {
                    this.deviceData = deviceData2;
                    return;
                }
                throw new NullPointerException("Null deviceData");
            }
            throw new NullPointerException("Null osData");
        }
        throw new NullPointerException("Null appData");
    }

    public AppData appData() {
        return this.appData;
    }

    public DeviceData deviceData() {
        return this.deviceData;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StaticSessionData)) {
            return false;
        }
        StaticSessionData staticSessionData = (StaticSessionData) obj;
        if (!this.appData.equals(staticSessionData.appData()) || !this.osData.equals(staticSessionData.osData()) || !this.deviceData.equals(staticSessionData.deviceData())) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return ((((this.appData.hashCode() ^ 1000003) * 1000003) ^ this.osData.hashCode()) * 1000003) ^ this.deviceData.hashCode();
    }

    public OsData osData() {
        return this.osData;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("StaticSessionData{appData=");
        outline73.append(this.appData);
        outline73.append(", osData=");
        outline73.append(this.osData);
        outline73.append(", deviceData=");
        outline73.append(this.deviceData);
        outline73.append("}");
        return outline73.toString();
    }
}
