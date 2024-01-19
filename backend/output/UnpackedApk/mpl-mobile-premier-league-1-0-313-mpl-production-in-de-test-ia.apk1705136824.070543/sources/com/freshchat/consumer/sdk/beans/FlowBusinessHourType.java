package com.freshchat.consumer.sdk.beans;

import com.freshchat.consumer.sdk.j.as;

public enum FlowBusinessHourType {
    BUSINESS_HOUR_INSIDE("BUSINESS_HOUR_INSIDE"),
    BUSINESS_HOUR_OUTSIDE("BUSINESS_HOUR_OUTSIDE"),
    BUSINESS_HOUR_ALWAYS("BUSINESS_HOUR_ALWAYS");
    
    public final String key;

    /* access modifiers changed from: public */
    FlowBusinessHourType(String str) {
        this.key = str;
    }

    public static FlowBusinessHourType get(String str) {
        if (as.isEmpty(str)) {
            return null;
        }
        for (FlowBusinessHourType flowBusinessHourType : values()) {
            if (as.o(str, flowBusinessHourType.key)) {
                return flowBusinessHourType;
            }
        }
        return null;
    }
}
