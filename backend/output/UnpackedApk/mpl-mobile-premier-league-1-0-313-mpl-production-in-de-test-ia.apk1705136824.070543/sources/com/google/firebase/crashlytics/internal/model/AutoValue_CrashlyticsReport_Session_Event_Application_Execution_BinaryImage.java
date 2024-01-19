package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage extends BinaryImage {
    public final long baseAddress;
    public final String name;
    public final long size;
    public final String uuid;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder {
        public Long baseAddress;
        public String name;
        public Long size;
        public String uuid;

        public BinaryImage build() {
            String str = this.baseAddress == null ? " baseAddress" : "";
            if (this.size == null) {
                str = GeneratedOutlineSupport.outline50(str, " size");
            }
            if (this.name == null) {
                str = GeneratedOutlineSupport.outline50(str, " name");
            }
            if (str.isEmpty()) {
                AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage autoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage = new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(this.baseAddress.longValue(), this.size.longValue(), this.name, this.uuid);
                return autoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setBaseAddress(long j) {
            this.baseAddress = Long.valueOf(j);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setName(String str) {
            if (str != null) {
                this.name = str;
                return this;
            }
            throw new NullPointerException("Null name");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setSize(long j) {
            this.size = Long.valueOf(j);
            return this;
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder setUuid(String str) {
            this.uuid = str;
            return this;
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BinaryImage)) {
            return false;
        }
        BinaryImage binaryImage = (BinaryImage) obj;
        if (this.baseAddress == binaryImage.getBaseAddress() && this.size == binaryImage.getSize() && this.name.equals(binaryImage.getName())) {
            String str = this.uuid;
            if (str != null) {
            }
        }
        z = false;
        return z;
    }

    public long getBaseAddress() {
        return this.baseAddress;
    }

    public String getName() {
        return this.name;
    }

    public long getSize() {
        return this.size;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        long j = this.baseAddress;
        long j2 = this.size;
        int hashCode = (((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.name.hashCode()) * 1000003;
        String str = this.uuid;
        return (str == null ? 0 : str.hashCode()) ^ hashCode;
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("BinaryImage{baseAddress=");
        outline73.append(this.baseAddress);
        outline73.append(", size=");
        outline73.append(this.size);
        outline73.append(", name=");
        outline73.append(this.name);
        outline73.append(", uuid=");
        return GeneratedOutlineSupport.outline62(outline73, this.uuid, "}");
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage(long j, long j2, String str, String str2) {
        this.baseAddress = j;
        this.size = j2;
        this.name = str;
        this.uuid = str2;
    }
}
