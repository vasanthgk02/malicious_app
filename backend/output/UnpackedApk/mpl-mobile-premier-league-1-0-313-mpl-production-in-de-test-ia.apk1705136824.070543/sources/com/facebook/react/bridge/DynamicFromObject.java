package com.facebook.react.bridge;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.logging.FLog;

public class DynamicFromObject implements Dynamic {
    public Object mObject;

    public DynamicFromObject(Object obj) {
        this.mObject = obj;
    }

    public ReadableArray asArray() {
        return (ReadableArray) this.mObject;
    }

    public boolean asBoolean() {
        return ((Boolean) this.mObject).booleanValue();
    }

    public double asDouble() {
        return ((Double) this.mObject).doubleValue();
    }

    public int asInt() {
        return ((Double) this.mObject).intValue();
    }

    public ReadableMap asMap() {
        return (ReadableMap) this.mObject;
    }

    public String asString() {
        return (String) this.mObject;
    }

    public ReadableType getType() {
        if (isNull()) {
            return ReadableType.Null;
        }
        Object obj = this.mObject;
        if (obj instanceof Boolean) {
            return ReadableType.Boolean;
        }
        if (obj instanceof Number) {
            return ReadableType.Number;
        }
        if (obj instanceof String) {
            return ReadableType.String;
        }
        if (obj instanceof ReadableMap) {
            return ReadableType.Map;
        }
        if (obj instanceof ReadableArray) {
            return ReadableType.Array;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Unmapped object type ");
        outline73.append(this.mObject.getClass().getName());
        FLog.e((String) "ReactNative", outline73.toString());
        return ReadableType.Null;
    }

    public boolean isNull() {
        return this.mObject == null;
    }

    public void recycle() {
    }
}
