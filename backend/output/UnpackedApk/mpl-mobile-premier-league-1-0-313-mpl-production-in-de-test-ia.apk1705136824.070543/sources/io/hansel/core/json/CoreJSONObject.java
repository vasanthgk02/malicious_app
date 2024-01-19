package io.hansel.core.json;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant.HanselEventConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CoreJSONObject implements Serializable {
    public static final Double NEGATIVE_ZERO = Double.valueOf(-0.0d);
    public static final Object NULL = new a();
    public final LinkedHashMap<String, Object> nameValuePairs;

    public class a {
        public boolean equals(Object obj) {
            return obj == this || obj == null;
        }

        public String toString() {
            return "null";
        }
    }

    public CoreJSONObject() {
        this.nameValuePairs = new LinkedHashMap<>();
    }

    public CoreJSONObject(CoreJSONObject coreJSONObject, String[] strArr) {
        this();
        for (String str : strArr) {
            Object opt = coreJSONObject.opt(str);
            if (opt != null) {
                this.nameValuePairs.put(str, opt);
            }
        }
    }

    public CoreJSONObject(CoreJSONTokener coreJSONTokener) {
        Object nextValue = coreJSONTokener.nextValue();
        if (nextValue instanceof CoreJSONObject) {
            this.nameValuePairs = ((CoreJSONObject) nextValue).nameValuePairs;
        } else {
            a.a(nextValue, "CoreJSONObject");
            throw null;
        }
    }

    public CoreJSONObject(String str) {
        this(new CoreJSONTokener(str));
    }

    public CoreJSONObject(Map map) {
        this();
        for (Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                this.nameValuePairs.put(str, wrap(entry.getValue()));
            } else {
                throw new NullPointerException("key == null");
            }
        }
    }

    public static String numberToString(Number number) {
        if (number != null) {
            double doubleValue = number.doubleValue();
            a.a(doubleValue);
            if (number.equals(NEGATIVE_ZERO)) {
                return "-0";
            }
            long longValue = number.longValue();
            return doubleValue == ((double) longValue) ? Long.toString(longValue) : number.toString();
        }
        throw new CoreJSONException("Number must be non-null");
    }

    public static String quote(String str) {
        if (str == null) {
            return "\"\"";
        }
        try {
            CoreJSONStringer coreJSONStringer = new CoreJSONStringer();
            io.hansel.core.json.CoreJSONStringer.a aVar = io.hansel.core.json.CoreJSONStringer.a.NULL;
            coreJSONStringer.open(aVar, "");
            coreJSONStringer.value((Object) str);
            coreJSONStringer.close(aVar, aVar, "");
            return coreJSONStringer.toString();
        } catch (CoreJSONException unused) {
            throw new AssertionError();
        }
    }

    public static Object wrap(Object obj) {
        if (obj == null) {
            return NULL;
        }
        if (!(obj instanceof CoreJSONArray) && !(obj instanceof CoreJSONObject)) {
            if (obj.equals(NULL)) {
                return obj;
            }
            try {
                if (obj instanceof Collection) {
                    return new CoreJSONArray((Collection) obj);
                }
                if (obj.getClass().isArray()) {
                    return new CoreJSONArray(obj);
                }
                if (obj instanceof Map) {
                    return new CoreJSONObject((Map) obj);
                }
                if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short)) {
                    if (!(obj instanceof String)) {
                        Package packageR = obj.getClass().getPackage();
                        if (packageR != null && packageR.getName().startsWith("java.")) {
                            obj = obj.toString();
                        }
                        obj = null;
                    }
                }
                return obj;
            } catch (Exception unused) {
            }
        }
        return obj;
    }

    public CoreJSONObject accumulate(String str, Object obj) {
        Object obj2 = this.nameValuePairs.get(checkName(str));
        if (obj2 == null) {
            return put(str, obj);
        }
        if (obj2 instanceof CoreJSONArray) {
            ((CoreJSONArray) obj2).checkedPut(obj);
        } else {
            CoreJSONArray coreJSONArray = new CoreJSONArray();
            coreJSONArray.checkedPut(obj2);
            coreJSONArray.checkedPut(obj);
            this.nameValuePairs.put(str, coreJSONArray);
        }
        return this;
    }

    public CoreJSONObject append(String str, Object obj) {
        CoreJSONArray coreJSONArray;
        Object obj2 = this.nameValuePairs.get(checkName(str));
        if (obj2 instanceof CoreJSONArray) {
            coreJSONArray = (CoreJSONArray) obj2;
        } else if (obj2 == null) {
            coreJSONArray = new CoreJSONArray();
            this.nameValuePairs.put(str, coreJSONArray);
        } else {
            throw new CoreJSONException(GeneratedOutlineSupport.outline52("Key ", str, " is not a CoreJSONArray"));
        }
        coreJSONArray.checkedPut(obj);
        return this;
    }

    public String checkName(String str) {
        if (str != null) {
            return str;
        }
        throw new CoreJSONException("Names must be non-null");
    }

    public Object get(String str) {
        Object obj = this.nameValuePairs.get(str);
        if (obj != null) {
            return obj;
        }
        throw new CoreJSONException(GeneratedOutlineSupport.outline50("No value for ", str));
    }

    public boolean getBoolean(String str) {
        Object obj = get(str);
        Boolean a2 = a.a(obj);
        if (a2 != null) {
            return a2.booleanValue();
        }
        a.a(str, obj, "boolean");
        throw null;
    }

    public double getDouble(String str) {
        Object obj = get(str);
        Double b2 = a.b(obj);
        if (b2 != null) {
            return b2.doubleValue();
        }
        a.a(str, obj, "double");
        throw null;
    }

    public int getInt(String str) {
        Object obj = get(str);
        Integer c2 = a.c(obj);
        if (c2 != null) {
            return c2.intValue();
        }
        a.a(str, obj, "int");
        throw null;
    }

    public CoreJSONArray getJSONArray(String str) {
        Object obj = get(str);
        if (obj instanceof CoreJSONArray) {
            return (CoreJSONArray) obj;
        }
        a.a(str, obj, "CoreJSONArray");
        throw null;
    }

    public CoreJSONObject getJSONObject(String str) {
        Object obj = get(str);
        if (obj instanceof CoreJSONObject) {
            return (CoreJSONObject) obj;
        }
        a.a(str, obj, "CoreJSONObject");
        throw null;
    }

    public long getLong(String str) {
        Object obj = get(str);
        Long d2 = a.d(obj);
        if (d2 != null) {
            return d2.longValue();
        }
        a.a(str, obj, "long");
        throw null;
    }

    public String getString(String str) {
        Object obj = get(str);
        String e2 = a.e(obj);
        if (e2 != null) {
            return e2;
        }
        a.a(str, obj, HanselEventConstant.DATA_TYPE_STRING);
        throw null;
    }

    public boolean has(String str) {
        return this.nameValuePairs.containsKey(str);
    }

    public boolean isNull(String str) {
        Object obj = this.nameValuePairs.get(str);
        return obj == null || obj == NULL;
    }

    public Set<String> keySet() {
        return this.nameValuePairs.keySet();
    }

    public Iterator<String> keys() {
        return this.nameValuePairs.keySet().iterator();
    }

    public int length() {
        return this.nameValuePairs.size();
    }

    public CoreJSONArray names() {
        if (this.nameValuePairs.isEmpty()) {
            return null;
        }
        return new CoreJSONArray((Collection) new ArrayList(this.nameValuePairs.keySet()));
    }

    public Object opt(String str) {
        return this.nameValuePairs.get(str);
    }

    public boolean optBoolean(String str) {
        return optBoolean(str, false);
    }

    public boolean optBoolean(String str, boolean z) {
        Boolean a2 = a.a(opt(str));
        return a2 != null ? a2.booleanValue() : z;
    }

    public double optDouble(String str) {
        return optDouble(str, Double.NaN);
    }

    public double optDouble(String str, double d2) {
        Double b2 = a.b(opt(str));
        return b2 != null ? b2.doubleValue() : d2;
    }

    public int optInt(String str) {
        return optInt(str, 0);
    }

    public int optInt(String str, int i) {
        Integer c2 = a.c(opt(str));
        return c2 != null ? c2.intValue() : i;
    }

    public CoreJSONArray optJSONArray(String str) {
        Object opt = opt(str);
        if (opt instanceof CoreJSONArray) {
            return (CoreJSONArray) opt;
        }
        return null;
    }

    public CoreJSONObject optJSONObject(String str) {
        Object opt = opt(str);
        if (opt instanceof CoreJSONObject) {
            return (CoreJSONObject) opt;
        }
        return null;
    }

    public long optLong(String str) {
        return optLong(str, 0);
    }

    public long optLong(String str, long j) {
        Long d2 = a.d(opt(str));
        return d2 != null ? d2.longValue() : j;
    }

    public String optString(String str) {
        return optString(str, "");
    }

    public String optString(String str, String str2) {
        String e2 = a.e(opt(str));
        return e2 != null ? e2 : str2;
    }

    public CoreJSONObject put(String str, double d2) {
        this.nameValuePairs.put(checkName(str), Double.valueOf(a.a(d2)));
        return this;
    }

    public CoreJSONObject put(String str, int i) {
        this.nameValuePairs.put(checkName(str), Integer.valueOf(i));
        return this;
    }

    public CoreJSONObject put(String str, long j) {
        this.nameValuePairs.put(checkName(str), Long.valueOf(j));
        return this;
    }

    public CoreJSONObject put(String str, Object obj) {
        if (obj == null) {
            this.nameValuePairs.remove(str);
            return this;
        }
        if (obj instanceof Number) {
            a.a(((Number) obj).doubleValue());
        }
        this.nameValuePairs.put(checkName(str), obj);
        return this;
    }

    public CoreJSONObject put(String str, boolean z) {
        this.nameValuePairs.put(checkName(str), Boolean.valueOf(z));
        return this;
    }

    public CoreJSONObject putOpt(String str, Object obj) {
        return (str == null || obj == null) ? this : put(str, obj);
    }

    public Object remove(String str) {
        return this.nameValuePairs.remove(str);
    }

    public CoreJSONArray toJSONArray(CoreJSONArray coreJSONArray) {
        CoreJSONArray coreJSONArray2 = new CoreJSONArray();
        if (coreJSONArray == null) {
            return null;
        }
        int length = coreJSONArray.length();
        if (length == 0) {
            return null;
        }
        for (int i = 0; i < length; i++) {
            coreJSONArray2.put(opt(a.e(coreJSONArray.opt(i))));
        }
        return coreJSONArray2;
    }

    public String toString() {
        try {
            CoreJSONStringer coreJSONStringer = new CoreJSONStringer();
            writeTo(coreJSONStringer);
            return coreJSONStringer.toString();
        } catch (CoreJSONException unused) {
            return null;
        }
    }

    public String toString(int i) {
        CoreJSONStringer coreJSONStringer = new CoreJSONStringer(i);
        writeTo(coreJSONStringer);
        return coreJSONStringer.toString();
    }

    public void writeTo(CoreJSONStringer coreJSONStringer) {
        coreJSONStringer.object();
        ArrayList arrayList = new ArrayList(this.nameValuePairs.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            coreJSONStringer.key(str).value(this.nameValuePairs.get(str));
        }
        coreJSONStringer.endObject();
    }
}
