package io.hansel.core.json;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.mpl.androidapp.utils.Constant.HanselEventConstant;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CoreJSONArray {
    public final List<Object> values;

    public class a implements Comparator<Object> {
        public a(CoreJSONArray coreJSONArray) {
        }

        public int compare(Object obj, Object obj2) {
            return obj.toString().compareTo(obj2.toString());
        }
    }

    public CoreJSONArray() {
        this.values = new ArrayList();
    }

    public CoreJSONArray(CoreJSONTokener coreJSONTokener) {
        Object nextValue = coreJSONTokener.nextValue();
        if (nextValue instanceof CoreJSONArray) {
            this.values = ((CoreJSONArray) nextValue).values;
        } else {
            a.a(nextValue, "CoreJSONArray");
            throw null;
        }
    }

    public CoreJSONArray(Object obj) {
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            this.values = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                put(CoreJSONObject.wrap(Array.get(obj, i)));
            }
            return;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Not a primitive array: ");
        outline73.append(obj.getClass());
        throw new CoreJSONException(outline73.toString());
    }

    public CoreJSONArray(String str) {
        this(new CoreJSONTokener(str));
    }

    public CoreJSONArray(Collection<Object> collection) {
        this();
        if (collection != null) {
            for (Object wrap : collection) {
                put(CoreJSONObject.wrap(wrap));
            }
        }
    }

    public int binarySearch(Object obj) {
        return Collections.binarySearch(this.values, obj, new a(this));
    }

    public void checkedPut(Object obj) {
        if (obj instanceof Number) {
            a.a(((Number) obj).doubleValue());
        }
        put(obj);
    }

    public boolean equals(Object obj) {
        return (obj instanceof CoreJSONArray) && ((CoreJSONArray) obj).values.equals(this.values);
    }

    public Object get(int i) {
        try {
            Object obj = this.values.get(i);
            if (obj != null) {
                return obj;
            }
            throw new CoreJSONException("Value at " + i + " is null.");
        } catch (IndexOutOfBoundsException unused) {
            StringBuilder outline74 = GeneratedOutlineSupport.outline74("Index ", i, " out of range [0..");
            outline74.append(this.values.size());
            outline74.append(")");
            throw new CoreJSONException(outline74.toString());
        }
    }

    public boolean getBoolean(int i) {
        Object obj = get(i);
        Boolean a2 = a.a(obj);
        if (a2 != null) {
            return a2.booleanValue();
        }
        a.a(Integer.valueOf(i), obj, "boolean");
        throw null;
    }

    public double getDouble(int i) {
        Object obj = get(i);
        Double b2 = a.b(obj);
        if (b2 != null) {
            return b2.doubleValue();
        }
        a.a(Integer.valueOf(i), obj, "double");
        throw null;
    }

    public int getInt(int i) {
        Object obj = get(i);
        Integer c2 = a.c(obj);
        if (c2 != null) {
            return c2.intValue();
        }
        a.a(Integer.valueOf(i), obj, "int");
        throw null;
    }

    public CoreJSONArray getJSONArray(int i) {
        Object obj = get(i);
        if (obj instanceof CoreJSONArray) {
            return (CoreJSONArray) obj;
        }
        a.a(Integer.valueOf(i), obj, "CoreJSONArray");
        throw null;
    }

    public CoreJSONObject getJSONObject(int i) {
        Object obj = get(i);
        if (obj instanceof CoreJSONObject) {
            return (CoreJSONObject) obj;
        }
        a.a(Integer.valueOf(i), obj, "CoreJSONObject");
        throw null;
    }

    public long getLong(int i) {
        Object obj = get(i);
        Long d2 = a.d(obj);
        if (d2 != null) {
            return d2.longValue();
        }
        a.a(Integer.valueOf(i), obj, "long");
        throw null;
    }

    public String getString(int i) {
        Object obj = get(i);
        String e2 = a.e(obj);
        if (e2 != null) {
            return e2;
        }
        a.a(Integer.valueOf(i), obj, HanselEventConstant.DATA_TYPE_STRING);
        throw null;
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public boolean isNull(int i) {
        Object opt = opt(i);
        return opt == null || opt == CoreJSONObject.NULL;
    }

    public String join(String str) {
        CoreJSONStringer coreJSONStringer = new CoreJSONStringer();
        coreJSONStringer.open(io.hansel.core.json.CoreJSONStringer.a.NULL, "");
        int size = this.values.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                coreJSONStringer.out.append(str);
            }
            coreJSONStringer.value(this.values.get(i));
        }
        io.hansel.core.json.CoreJSONStringer.a aVar = io.hansel.core.json.CoreJSONStringer.a.NULL;
        coreJSONStringer.close(aVar, aVar, "");
        return coreJSONStringer.out.toString();
    }

    public int length() {
        return this.values.size();
    }

    public Object opt(int i) {
        if (i < 0 || i >= this.values.size()) {
            return null;
        }
        return this.values.get(i);
    }

    public boolean optBoolean(int i) {
        return optBoolean(i, false);
    }

    public boolean optBoolean(int i, boolean z) {
        Boolean a2 = a.a(opt(i));
        return a2 != null ? a2.booleanValue() : z;
    }

    public double optDouble(int i) {
        return optDouble(i, Double.NaN);
    }

    public double optDouble(int i, double d2) {
        Double b2 = a.b(opt(i));
        return b2 != null ? b2.doubleValue() : d2;
    }

    public int optInt(int i) {
        return optInt(i, 0);
    }

    public int optInt(int i, int i2) {
        Integer c2 = a.c(opt(i));
        return c2 != null ? c2.intValue() : i2;
    }

    public CoreJSONArray optJSONArray(int i) {
        Object opt = opt(i);
        if (opt instanceof CoreJSONArray) {
            return (CoreJSONArray) opt;
        }
        return null;
    }

    public CoreJSONObject optJSONObject(int i) {
        Object opt = opt(i);
        if (opt instanceof CoreJSONObject) {
            return (CoreJSONObject) opt;
        }
        return null;
    }

    public long optLong(int i) {
        return optLong(i, 0);
    }

    public long optLong(int i, long j) {
        Long d2 = a.d(opt(i));
        return d2 != null ? d2.longValue() : j;
    }

    public String optString(int i) {
        return optString(i, "");
    }

    public String optString(int i, String str) {
        String e2 = a.e(opt(i));
        return e2 != null ? e2 : str;
    }

    public CoreJSONArray put(double d2) {
        this.values.add(Double.valueOf(a.a(d2)));
        return this;
    }

    public CoreJSONArray put(int i) {
        this.values.add(Integer.valueOf(i));
        return this;
    }

    public CoreJSONArray put(int i, double d2) {
        return put(i, (Object) Double.valueOf(d2));
    }

    public CoreJSONArray put(int i, int i2) {
        return put(i, (Object) Integer.valueOf(i2));
    }

    public CoreJSONArray put(int i, long j) {
        return put(i, (Object) Long.valueOf(j));
    }

    public CoreJSONArray put(int i, Object obj) {
        if (obj instanceof Number) {
            a.a(((Number) obj).doubleValue());
        }
        while (this.values.size() <= i) {
            this.values.add(null);
        }
        this.values.set(i, obj);
        return this;
    }

    public CoreJSONArray put(int i, boolean z) {
        return put(i, (Object) Boolean.valueOf(z));
    }

    public CoreJSONArray put(long j) {
        this.values.add(Long.valueOf(j));
        return this;
    }

    public CoreJSONArray put(Object obj) {
        this.values.add(obj);
        return this;
    }

    public CoreJSONArray put(boolean z) {
        this.values.add(Boolean.valueOf(z));
        return this;
    }

    public Object remove(int i) {
        if (i < 0 || i >= this.values.size()) {
            return null;
        }
        return this.values.remove(i);
    }

    public CoreJSONObject toJSONObject(CoreJSONArray coreJSONArray) {
        CoreJSONObject coreJSONObject = new CoreJSONObject();
        int min = Math.min(coreJSONArray.length(), this.values.size());
        if (min == 0) {
            return null;
        }
        for (int i = 0; i < min; i++) {
            coreJSONObject.put(a.e(coreJSONArray.opt(i)), opt(i));
        }
        return coreJSONObject;
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
        coreJSONStringer.array();
        int size = this.values.size();
        for (int i = 0; i < size; i++) {
            coreJSONStringer.value(this.values.get(i));
        }
        coreJSONStringer.endArray();
    }
}
