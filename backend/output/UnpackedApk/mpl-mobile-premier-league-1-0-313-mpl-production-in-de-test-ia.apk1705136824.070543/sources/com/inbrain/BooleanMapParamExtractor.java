package com.inbrain;

import com.facebook.react.bridge.ReadableMap;

/* compiled from: MapParameterExtractor */
public abstract class BooleanMapParamExtractor extends MapParameterExtractor<Boolean> {
    public BooleanMapParamExtractor(ReadableMap readableMap, String str) {
        super(readableMap, str);
    }

    public Object extractMapValue(ReadableMap readableMap, String str) {
        return Boolean.valueOf(readableMap.getBoolean(str));
    }
}
