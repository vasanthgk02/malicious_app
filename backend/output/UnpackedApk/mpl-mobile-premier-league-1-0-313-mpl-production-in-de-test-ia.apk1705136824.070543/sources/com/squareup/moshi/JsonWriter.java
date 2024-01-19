package com.squareup.moshi;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import okio.BufferedSink;
import okio.BufferedSource;

public abstract class JsonWriter implements Closeable, Flushable {
    public int flattenStackSize = -1;
    public String indent;
    public boolean lenient;
    public int[] pathIndices = new int[32];
    public String[] pathNames = new String[32];
    public boolean promoteValueToName;
    public int[] scopes = new int[32];
    public boolean serializeNulls;
    public int stackSize = 0;
    public Map<Class<?>, Object> tags;

    public static JsonWriter of(BufferedSink bufferedSink) {
        return new JsonUtf8Writer(bufferedSink);
    }

    public abstract JsonWriter beginArray() throws IOException;

    public final int beginFlatten() {
        int peekScope = peekScope();
        if (peekScope == 5 || peekScope == 3 || peekScope == 2 || peekScope == 1) {
            int i = this.flattenStackSize;
            this.flattenStackSize = this.stackSize;
            return i;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    public abstract JsonWriter beginObject() throws IOException;

    public final boolean checkStack() {
        int i = this.stackSize;
        int[] iArr = this.scopes;
        if (i != iArr.length) {
            return false;
        }
        if (i != 256) {
            this.scopes = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.pathNames;
            this.pathNames = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.pathIndices;
            this.pathIndices = Arrays.copyOf(iArr2, iArr2.length * 2);
            if (this instanceof JsonValueWriter) {
                JsonValueWriter jsonValueWriter = (JsonValueWriter) this;
                Object[] objArr = jsonValueWriter.stack;
                jsonValueWriter.stack = Arrays.copyOf(objArr, objArr.length * 2);
            }
            return true;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Nesting too deep at ");
        outline73.append(getPath());
        outline73.append(": circular reference?");
        throw new JsonDataException(outline73.toString());
    }

    public abstract JsonWriter endArray() throws IOException;

    public final void endFlatten(int i) {
        this.flattenStackSize = i;
    }

    public abstract JsonWriter endObject() throws IOException;

    public final String getIndent() {
        String str = this.indent;
        return str != null ? str : "";
    }

    public final String getPath() {
        return JsonScope.getPath(this.stackSize, this.scopes, this.pathNames, this.pathIndices);
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public final JsonWriter jsonValue(Object obj) throws IOException {
        String str;
        if (obj instanceof Map) {
            beginObject();
            for (Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                if (!(key instanceof String)) {
                    if (key == null) {
                        str = "Map keys must be non-null";
                    } else {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Map keys must be of type String: ");
                        outline73.append(key.getClass().getName());
                        str = outline73.toString();
                    }
                    throw new IllegalArgumentException(str);
                }
                name((String) key);
                jsonValue(entry.getValue());
            }
            endObject();
        } else if (obj instanceof List) {
            beginArray();
            for (Object jsonValue : (List) obj) {
                jsonValue(jsonValue);
            }
            endArray();
        } else if (obj instanceof String) {
            value((String) obj);
        } else if (obj instanceof Boolean) {
            value(((Boolean) obj).booleanValue());
        } else if (obj instanceof Double) {
            value(((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            value(((Long) obj).longValue());
        } else if (obj instanceof Number) {
            value((Number) obj);
        } else if (obj == null) {
            nullValue();
        } else {
            StringBuilder outline732 = GeneratedOutlineSupport.outline73("Unsupported type: ");
            outline732.append(obj.getClass().getName());
            throw new IllegalArgumentException(outline732.toString());
        }
        return this;
    }

    public abstract JsonWriter name(String str) throws IOException;

    public abstract JsonWriter nullValue() throws IOException;

    public final int peekScope() {
        int i = this.stackSize;
        if (i != 0) {
            return this.scopes[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void promoteValueToName() throws IOException {
        int peekScope = peekScope();
        if (peekScope == 5 || peekScope == 3) {
            this.promoteValueToName = true;
            return;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    public final void pushScope(int i) {
        int[] iArr = this.scopes;
        int i2 = this.stackSize;
        this.stackSize = i2 + 1;
        iArr[i2] = i;
    }

    public final void replaceTop(int i) {
        this.scopes[this.stackSize - 1] = i;
    }

    public void setIndent(String str) {
        if (str.isEmpty()) {
            str = null;
        }
        this.indent = str;
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public final void setSerializeNulls(boolean z) {
        this.serializeNulls = z;
    }

    public final <T> void setTag(Class<T> cls, T t) {
        if (cls.isAssignableFrom(t.getClass())) {
            if (this.tags == null) {
                this.tags = new LinkedHashMap();
            }
            this.tags.put(cls, t);
            return;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Tag value must be of type ")));
    }

    public final <T> T tag(Class<T> cls) {
        Map<Class<?>, Object> map = this.tags;
        if (map == null) {
            return null;
        }
        return map.get(cls);
    }

    public abstract JsonWriter value(double d2) throws IOException;

    public abstract JsonWriter value(long j) throws IOException;

    public abstract JsonWriter value(Boolean bool) throws IOException;

    public abstract JsonWriter value(Number number) throws IOException;

    public abstract JsonWriter value(String str) throws IOException;

    public final JsonWriter value(BufferedSource bufferedSource) throws IOException {
        if (!this.promoteValueToName) {
            BufferedSink valueSink = valueSink();
            try {
                bufferedSource.readAll(valueSink);
                if (valueSink != null) {
                    valueSink.close();
                }
                return this;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("BufferedSource cannot be used as a map key in JSON at path ");
            outline73.append(getPath());
            throw new IllegalStateException(outline73.toString());
        }
        throw th;
    }

    public abstract JsonWriter value(boolean z) throws IOException;

    public abstract BufferedSink valueSink() throws IOException;
}
