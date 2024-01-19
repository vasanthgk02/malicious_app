package com.inbrain;

import com.facebook.react.bridge.ReadableMap;

public abstract class MapParameterExtractor<T> {
    public String key = null;
    public ReadableMap map = null;

    public MapParameterExtractor(ReadableMap readableMap, String str) {
        Object obj = null;
        this.map = readableMap;
        this.key = str;
        try {
            obj = readableMap.hasKey(str) ? extractMapValue(this.map, this.key) : obj;
            if (obj != null) {
                setParam(obj);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public abstract T extractMapValue(ReadableMap readableMap, String str);

    public abstract void setParam(T t);
}
