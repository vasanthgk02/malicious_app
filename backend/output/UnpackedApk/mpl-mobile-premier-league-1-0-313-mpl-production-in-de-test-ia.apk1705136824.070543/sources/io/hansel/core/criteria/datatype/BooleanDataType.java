package io.hansel.core.criteria.datatype;

import io.hansel.core.criteria.b;
import io.hansel.core.logger.HSLLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class BooleanDataType extends b implements Serializable {
    private Boolean getValue(Object obj, String str) {
        if (str != null) {
            Boolean valueOf = Boolean.valueOf(str);
            if ((obj instanceof ArrayList) && !((ArrayList) obj).isEmpty()) {
                return valueOf;
            }
        }
        return null;
    }

    public Object count(HashMap<Object, Integer> hashMap) {
        ArrayList arrayList = new ArrayList(hashMap.keySet());
        int size = arrayList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = arrayList.get(i2);
            Integer num = hashMap.get(obj);
            try {
                Boolean.valueOf(String.valueOf(obj));
                i += num == null ? 0 : num.intValue();
            } catch (Throwable th) {
                HSLLogger.printStackTrace(th);
            }
        }
        return Integer.valueOf(i);
    }

    public boolean equal(Object obj, String str) {
        try {
            Boolean value = getValue(obj, str);
            if (value != null) {
                return value.equals(((ArrayList) obj).get(0));
            }
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
        return false;
    }

    public boolean in(Object obj, String str) {
        try {
            Boolean value = getValue(obj, str);
            if (value != null) {
                return ((ArrayList) obj).contains(value);
            }
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
        return false;
    }

    public boolean notEqual(Object obj, String str) {
        try {
            Boolean value = getValue(obj, str);
            if (value != null) {
                return !value.equals(((ArrayList) obj).get(0));
            }
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
        return false;
    }

    public boolean notIn(Object obj, String str) {
        try {
            Boolean value = getValue(obj, str);
            if (value != null) {
                return !((ArrayList) obj).contains(value);
            }
        } catch (Exception e2) {
            HSLLogger.printStackTrace(e2);
        }
        return false;
    }
}
