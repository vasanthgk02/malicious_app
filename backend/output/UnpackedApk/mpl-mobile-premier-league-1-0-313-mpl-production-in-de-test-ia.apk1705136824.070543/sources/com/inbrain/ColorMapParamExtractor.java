package com.inbrain;

import android.graphics.Color;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: MapParameterExtractor */
public abstract class ColorMapParamExtractor extends MapParameterExtractor<Integer> {
    public ColorMapParamExtractor(ReadableMap readableMap, String str) {
        super(readableMap, str);
    }

    public Object extractMapValue(ReadableMap readableMap, String str) {
        return Integer.valueOf(Color.parseColor(readableMap.getString(str)));
    }
}
