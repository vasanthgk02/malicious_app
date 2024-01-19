package com.inbrain;

import com.facebook.react.bridge.ReadableMap;

/* compiled from: MapParameterExtractor */
public abstract class StringMapParamExtractor extends MapParameterExtractor<String> {
    public StringMapParamExtractor(ReadableMap readableMap, String str) {
        super(readableMap, str);
    }

    public Object extractMapValue(ReadableMap readableMap, String str) {
        return readableMap.getString(str);
    }
}
