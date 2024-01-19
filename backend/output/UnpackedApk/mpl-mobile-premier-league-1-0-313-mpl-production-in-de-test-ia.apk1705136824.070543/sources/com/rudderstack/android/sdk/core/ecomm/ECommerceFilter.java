package com.rudderstack.android.sdk.core.ecomm;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;

public class ECommerceFilter {
    @SerializedName("type")
    public String type;
    @SerializedName("value")
    public String value;

    public static class Builder {
        public String type;
        public String value;

        public ECommerceFilter build() throws Exception {
            if (TextUtils.isEmpty(this.type)) {
                throw new Exception("Type can not be empty or null");
            } else if (!TextUtils.isEmpty(this.value)) {
                return new ECommerceFilter(this.type, this.value);
            } else {
                throw new Exception("Value can not be empty or null");
            }
        }

        public Builder withType(String str) {
            this.type = str;
            return this;
        }

        public Builder withValue(String str) {
            this.value = str;
            return this;
        }
    }

    public ECommerceFilter(String str, String str2) {
        this.type = str;
        this.value = str2;
    }

    public String getType() {
        return this.type;
    }

    public String getValue() {
        return this.value;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
