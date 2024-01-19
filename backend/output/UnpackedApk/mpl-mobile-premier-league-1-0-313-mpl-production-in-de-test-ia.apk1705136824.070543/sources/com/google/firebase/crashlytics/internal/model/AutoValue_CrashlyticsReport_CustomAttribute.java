package com.google.firebase.crashlytics.internal.model;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute;

public final class AutoValue_CrashlyticsReport_CustomAttribute extends CustomAttribute {
    public final String key;
    public final String value;

    public static final class Builder extends com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder {
        public String key;
        public String value;

        public CustomAttribute build() {
            String str = this.key == null ? " key" : "";
            if (this.value == null) {
                str = GeneratedOutlineSupport.outline50(str, " value");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_CustomAttribute(this.key, this.value);
            }
            throw new IllegalStateException(GeneratedOutlineSupport.outline50("Missing required properties:", str));
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder setKey(String str) {
            if (str != null) {
                this.key = str;
                return this;
            }
            throw new NullPointerException("Null key");
        }

        public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.CustomAttribute.Builder setValue(String str) {
            if (str != null) {
                this.value = str;
                return this;
            }
            throw new NullPointerException("Null value");
        }
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CustomAttribute)) {
            return false;
        }
        CustomAttribute customAttribute = (CustomAttribute) obj;
        if (!this.key.equals(customAttribute.getKey()) || !this.value.equals(customAttribute.getValue())) {
            z = false;
        }
        return z;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        return ((this.key.hashCode() ^ 1000003) * 1000003) ^ this.value.hashCode();
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("CustomAttribute{key=");
        outline73.append(this.key);
        outline73.append(", value=");
        return GeneratedOutlineSupport.outline62(outline73, this.value, "}");
    }

    public AutoValue_CrashlyticsReport_CustomAttribute(String str, String str2) {
        this.key = str;
        this.value = str2;
    }
}
