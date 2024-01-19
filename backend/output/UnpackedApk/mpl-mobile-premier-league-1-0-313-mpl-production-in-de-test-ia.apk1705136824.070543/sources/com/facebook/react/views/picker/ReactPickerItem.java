package com.facebook.react.views.picker;

import androidx.core.app.NotificationCompatJellybean;
import com.facebook.react.bridge.ReadableMap;

public class ReactPickerItem {
    public final Integer color;
    public final String label;

    public ReactPickerItem(ReadableMap readableMap) {
        this.label = readableMap.getString(NotificationCompatJellybean.KEY_LABEL);
        if (!readableMap.hasKey("color") || readableMap.isNull("color")) {
            this.color = null;
        } else {
            this.color = Integer.valueOf(readableMap.getInt("color"));
        }
    }
}
