package com.rudderstack.android.sdk.core;

import android.text.TextUtils;
import androidx.core.app.NotificationCompatJellybean;
import io.hansel.core.criteria.HSLCriteriaBuilder;

public class TrackPropertyBuilder extends RudderPropertyBuilder {
    public String category = null;
    public String label = "";
    public String value = "";

    public RudderProperty build() {
        RudderProperty rudderProperty = new RudderProperty();
        if (TextUtils.isEmpty(this.category)) {
            RudderLogger.logError((String) "category can not be null or empty");
        } else {
            rudderProperty.putValue("category", this.category);
            rudderProperty.putValue(NotificationCompatJellybean.KEY_LABEL, this.label);
            rudderProperty.putValue(HSLCriteriaBuilder.VALUE, this.value);
        }
        return rudderProperty;
    }

    public TrackPropertyBuilder setCategory(String str) {
        this.category = str;
        return this;
    }

    public TrackPropertyBuilder setLabel(String str) {
        this.label = str;
        return this;
    }

    public TrackPropertyBuilder setValue(String str) {
        this.value = str;
        return this;
    }
}
