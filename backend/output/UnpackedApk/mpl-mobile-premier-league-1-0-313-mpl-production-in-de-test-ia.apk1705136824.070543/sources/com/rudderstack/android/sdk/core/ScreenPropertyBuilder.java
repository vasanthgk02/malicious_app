package com.rudderstack.android.sdk.core;

import android.text.TextUtils;

public class ScreenPropertyBuilder extends RudderPropertyBuilder {
    public boolean isAutomatic = false;
    public String name;

    public RudderProperty build() {
        RudderProperty rudderProperty = new RudderProperty();
        if (TextUtils.isEmpty(this.name)) {
            RudderLogger.logError((String) "name can not be empty");
        } else {
            rudderProperty.put("name", this.name);
        }
        rudderProperty.put("automatic", Boolean.valueOf(this.isAutomatic));
        return rudderProperty;
    }

    public ScreenPropertyBuilder isAtomatic(boolean z) {
        this.isAutomatic = z;
        return this;
    }

    public ScreenPropertyBuilder setScreenName(String str) {
        this.name = str;
        return this;
    }
}
