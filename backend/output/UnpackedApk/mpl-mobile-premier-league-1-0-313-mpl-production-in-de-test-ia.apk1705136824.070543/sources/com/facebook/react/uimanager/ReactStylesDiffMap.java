package com.facebook.react.uimanager;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ReadableMap;

public class ReactStylesDiffMap {
    public final ReadableMap mBackingMap;

    public ReactStylesDiffMap(ReadableMap readableMap) {
        this.mBackingMap = readableMap;
    }

    public int getInt(String str, int i) {
        return this.mBackingMap.isNull(str) ? i : this.mBackingMap.getInt(str);
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("{ ");
        outline73.append(ReactStylesDiffMap.class.getSimpleName());
        outline73.append(": ");
        outline73.append(this.mBackingMap.toString());
        outline73.append(" }");
        return outline73.toString();
    }
}
