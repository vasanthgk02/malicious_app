package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal extends Signal {
    public final long address;
    public final String code;
    public final String name;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder {
        public Long address;
        public String code;
        public String name;

        public Signal build() {
            String str = this.name == null ? " name" : "";
            if (this.code == null) {
                str = GeneratedOutlineSupport.outline50(str, " code");
            }
            if (this.address == null) {
                str = GeneratedOutlineSupport.outline50(str, " address");
            }
            if (str.isEmpty()) {
                AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(this.name, this.code, this.address.longValue());
                return autoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setAddress(long j) {
            this.address = Long.valueOf(j);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setCode(String str) {
            if (str != null) {
                this.code = str;
                return this;
            }
            throw new NullPointerException("Null code");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder setName(String str) {
            if (str != null) {
                this.name = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Signal)) {
            return false;
        }
        Signal signal = (Signal) obj;
        if (!this.name.equals(signal.getName()) || !this.code.equals(signal.getCode()) || this.address != signal.getAddress()) {
            z = false;
        }
        return z;
    }

    public long getAddress() {
        return this.address;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        long j = this.address;
        return ((((this.name.hashCode() ^ 1000003) * 1000003) ^ this.code.hashCode()) * 1000003) ^ ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Signal{name=");
        outline73.append(this.name);
        outline73.append(", code=");
        outline73.append(this.code);
        outline73.append(", address=");
        return GeneratedOutlineSupport.outline58(outline73, this.address, "}");
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal(String str, String str2, long j) {
        this.name = str;
        this.code = str2;
        this.address = j;
    }
}
