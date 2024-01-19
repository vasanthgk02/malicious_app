package com.squareup.moshi;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public final class JsonValueWriter extends JsonWriter {
    public String deferredName;
    public Object[] stack = new Object[32];

    public JsonValueWriter() {
        pushScope(6);
    }

    /* access modifiers changed from: private */
    public JsonValueWriter add(Object obj) {
        int peekScope = peekScope();
        int i = this.stackSize;
        if (i == 1) {
            if (peekScope == 6) {
                this.scopes[i - 1] = 7;
                this.stack[i - 1] = obj;
            } else {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
        } else if (peekScope == 3 && this.deferredName != null) {
            if (obj != null || this.serializeNulls) {
                Object put = ((Map) this.stack[this.stackSize - 1]).put(this.deferredName, obj);
                if (put != null) {
                    StringBuilder outline73 = GeneratedOutlineSupport.outline73("Map key '");
                    outline73.append(this.deferredName);
                    outline73.append("' has multiple values at path ");
                    outline73.append(getPath());
                    outline73.append(": ");
                    outline73.append(put);
                    outline73.append(" and ");
                    outline73.append(obj);
                    throw new IllegalArgumentException(outline73.toString());
                }
            }
            this.deferredName = null;
        } else if (peekScope == 1) {
            ((List) this.stack[this.stackSize - 1]).add(obj);
        } else if (peekScope == 9) {
            throw new IllegalStateException("Sink from valueSink() was not closed");
        } else {
            throw new IllegalStateException("Nesting problem.");
        }
        return this;
    }

    public JsonWriter beginArray() throws IOException {
        if (!this.promoteValueToName) {
            int i = this.stackSize;
            int i2 = this.flattenStackSize;
            if (i == i2 && this.scopes[i - 1] == 1) {
                this.flattenStackSize = ~i2;
                return this;
            }
            checkStack();
            ArrayList arrayList = new ArrayList();
            add(arrayList);
            Object[] objArr = this.stack;
            int i3 = this.stackSize;
            objArr[i3] = arrayList;
            this.pathIndices[i3] = 0;
            pushScope(1);
            return this;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Array cannot be used as a map key in JSON at path ");
        outline73.append(getPath());
        throw new IllegalStateException(outline73.toString());
    }

    public JsonWriter beginObject() throws IOException {
        if (!this.promoteValueToName) {
            int i = this.stackSize;
            int i2 = this.flattenStackSize;
            if (i == i2 && this.scopes[i - 1] == 3) {
                this.flattenStackSize = ~i2;
                return this;
            }
            checkStack();
            LinkedHashTreeMap linkedHashTreeMap = new LinkedHashTreeMap();
            add(linkedHashTreeMap);
            this.stack[this.stackSize] = linkedHashTreeMap;
            pushScope(3);
            return this;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Object cannot be used as a map key in JSON at path ");
        outline73.append(getPath());
        throw new IllegalStateException(outline73.toString());
    }

    public void close() throws IOException {
        int i = this.stackSize;
        if (i > 1 || (i == 1 && this.scopes[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    public JsonWriter endArray() throws IOException {
        if (peekScope() == 1) {
            int i = this.stackSize;
            int i2 = this.flattenStackSize;
            if (i == (~i2)) {
                this.flattenStackSize = ~i2;
                return this;
            }
            int i3 = i - 1;
            this.stackSize = i3;
            this.stack[i3] = null;
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            return this;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    public JsonWriter endObject() throws IOException {
        if (peekScope() != 3) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.deferredName == null) {
            int i = this.stackSize;
            int i2 = this.flattenStackSize;
            if (i == (~i2)) {
                this.flattenStackSize = ~i2;
                return this;
            }
            this.promoteValueToName = false;
            int i3 = i - 1;
            this.stackSize = i3;
            this.stack[i3] = null;
            this.pathNames[i3] = null;
            int[] iArr = this.pathIndices;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            return this;
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Dangling name: ");
            outline73.append(this.deferredName);
            throw new IllegalStateException(outline73.toString());
        }
    }

    public void flush() throws IOException {
        if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public JsonWriter name(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        } else if (this.stackSize == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else if (peekScope() == 3 && this.deferredName == null && !this.promoteValueToName) {
            this.deferredName = str;
            this.pathNames[this.stackSize - 1] = str;
            return this;
        } else {
            throw new IllegalStateException("Nesting problem.");
        }
    }

    public JsonWriter nullValue() throws IOException {
        if (!this.promoteValueToName) {
            add(null);
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
            return this;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("null cannot be used as a map key in JSON at path ");
        outline73.append(getPath());
        throw new IllegalStateException(outline73.toString());
    }

    public Object root() {
        int i = this.stackSize;
        if (i <= 1 && (i != 1 || this.scopes[i - 1] == 7)) {
            return this.stack[0];
        }
        throw new IllegalStateException("Incomplete document");
    }

    public JsonWriter value(String str) throws IOException {
        if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(str);
        }
        add(str);
        int[] iArr = this.pathIndices;
        int i = this.stackSize - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    public BufferedSink valueSink() {
        if (this.promoteValueToName) {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("BufferedSink cannot be used as a map key in JSON at path ");
            outline73.append(getPath());
            throw new IllegalStateException(outline73.toString());
        } else if (peekScope() != 9) {
            pushScope(9);
            final Buffer buffer = new Buffer();
            return Okio.buffer((Sink) new ForwardingSink(buffer) {
                /* JADX INFO: finally extract failed */
                public void close() throws IOException {
                    if (JsonValueWriter.this.peekScope() == 9) {
                        JsonValueWriter jsonValueWriter = JsonValueWriter.this;
                        Object[] objArr = jsonValueWriter.stack;
                        int i = jsonValueWriter.stackSize;
                        if (objArr[i] == null) {
                            jsonValueWriter.stackSize = i - 1;
                            Object readJsonValue = JsonReader.of(buffer).readJsonValue();
                            JsonValueWriter jsonValueWriter2 = JsonValueWriter.this;
                            boolean z = jsonValueWriter2.serializeNulls;
                            jsonValueWriter2.serializeNulls = true;
                            try {
                                jsonValueWriter2.add(readJsonValue);
                                JsonValueWriter jsonValueWriter3 = JsonValueWriter.this;
                                jsonValueWriter3.serializeNulls = z;
                                int[] iArr = jsonValueWriter3.pathIndices;
                                int i2 = jsonValueWriter3.stackSize - 1;
                                iArr[i2] = iArr[i2] + 1;
                                return;
                            } catch (Throwable th) {
                                JsonValueWriter.this.serializeNulls = z;
                                throw th;
                            }
                        }
                    }
                    throw new AssertionError();
                }
            });
        } else {
            throw new IllegalStateException("Sink from valueSink() was not closed");
        }
    }

    public JsonWriter value(boolean z) throws IOException {
        if (!this.promoteValueToName) {
            add(Boolean.valueOf(z));
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
            return this;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Boolean cannot be used as a map key in JSON at path ");
        outline73.append(getPath());
        throw new IllegalStateException(outline73.toString());
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (!this.promoteValueToName) {
            add(bool);
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
            return this;
        }
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Boolean cannot be used as a map key in JSON at path ");
        outline73.append(getPath());
        throw new IllegalStateException(outline73.toString());
    }

    public JsonWriter value(double d2) throws IOException {
        if (!this.lenient && (Double.isNaN(d2) || d2 == Double.NEGATIVE_INFINITY || d2 == Double.POSITIVE_INFINITY)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        } else if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(Double.toString(d2));
        } else {
            add(Double.valueOf(d2));
            int[] iArr = this.pathIndices;
            int i = this.stackSize - 1;
            iArr[i] = iArr[i] + 1;
            return this;
        }
    }

    public JsonWriter value(long j) throws IOException {
        if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(Long.toString(j));
        }
        add(Long.valueOf(j));
        int[] iArr = this.pathIndices;
        int i = this.stackSize - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if ((number instanceof Byte) || (number instanceof Short) || (number instanceof Integer) || (number instanceof Long)) {
            return value(number.longValue());
        }
        if ((number instanceof Float) || (number instanceof Double)) {
            return value(number.doubleValue());
        }
        if (number == null) {
            return nullValue();
        }
        BigDecimal bigDecimal = number instanceof BigDecimal ? (BigDecimal) number : new BigDecimal(number.toString());
        if (this.promoteValueToName) {
            this.promoteValueToName = false;
            return name(bigDecimal.toString());
        }
        add(bigDecimal);
        int[] iArr = this.pathIndices;
        int i = this.stackSize - 1;
        iArr[i] = iArr[i] + 1;
        return this;
    }
}
