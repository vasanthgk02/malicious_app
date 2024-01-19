package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Device;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Log;

public final class AutoValue_CrashlyticsReport_Session_Event extends Event {
    public final Application app;
    public final Device device;
    public final Log log;
    public final long timestamp;
    public final String type;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder {
        public Application app;
        public Device device;
        public Log log;
        public Long timestamp;
        public String type;

        public Event build() {
            String str = this.timestamp == null ? " timestamp" : "";
            if (this.type == null) {
                str = GeneratedOutlineSupport.outline50(str, " type");
            }
            if (this.app == null) {
                str = GeneratedOutlineSupport.outline50(str, " app");
            }
            if (this.device == null) {
                str = GeneratedOutlineSupport.outline50(str, " device");
            }
            if (str.isEmpty()) {
                AutoValue_CrashlyticsReport_Session_Event autoValue_CrashlyticsReport_Session_Event = new AutoValue_CrashlyticsReport_Session_Event(this.timestamp.longValue(), this.type, this.app, this.device, this.log);
                return autoValue_CrashlyticsReport_Session_Event;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder setApp(Application application) {
            if (application != null) {
                this.app = application;
                return this;
            }
            throw new NullPointerException("Null app");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder setDevice(Device device2) {
            if (device2 != null) {
                this.device = device2;
                return this;
            }
            throw new NullPointerException("Null device");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder setLog(Log log2) {
            this.log = log2;
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder setTimestamp(long j) {
            this.timestamp = Long.valueOf(j);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder setType(String str) {
            if (str != null) {
                this.type = str;
                return this;
            }
            throw new NullPointerException("Null type");
        }

        public Builder() {
        }

        public Builder(Event event) {
            this.timestamp = Long.valueOf(event.getTimestamp());
            this.type = event.getType();
            this.app = event.getApp();
            this.device = event.getDevice();
            this.log = event.getLog();
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        if (this.timestamp == event.getTimestamp() && this.type.equals(event.getType()) && this.app.equals(event.getApp()) && this.device.equals(event.getDevice())) {
            Log log2 = this.log;
            if (log2 != null) {
            }
        }
        z = false;
        return z;
    }

    public Application getApp() {
        return this.app;
    }

    public Device getDevice() {
        return this.device;
    }

    public Log getLog() {
        return this.log;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        long j = this.timestamp;
        int hashCode = (((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.type.hashCode()) * 1000003) ^ this.app.hashCode()) * 1000003) ^ this.device.hashCode()) * 1000003;
        Log log2 = this.log;
        return (log2 == null ? 0 : log2.hashCode()) ^ hashCode;
    }

    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Builder toBuilder() {
        return new Builder(this);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Event{timestamp=");
        outline73.append(this.timestamp);
        outline73.append(", type=");
        outline73.append(this.type);
        outline73.append(", app=");
        outline73.append(this.app);
        outline73.append(", device=");
        outline73.append(this.device);
        outline73.append(", log=");
        outline73.append(this.log);
        outline73.append("}");
        return outline73.toString();
    }

    public AutoValue_CrashlyticsReport_Session_Event(long j, String str, Application application, Device device2, Log log2) {
        this.timestamp = j;
        this.type = str;
        this.app = application;
        this.device = device2;
        this.log = log2;
    }
}
