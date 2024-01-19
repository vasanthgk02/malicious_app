package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

public final class JsonValueObjectEncoderContext implements ObjectEncoderContext, ValueEncoderContext {
    public boolean active = true;
    public JsonValueObjectEncoderContext childContext = null;
    public final ObjectEncoder<Object> fallbackEncoder;
    public final boolean ignoreNullValues;
    public final JsonWriter jsonWriter;
    public final Map<Class<?>, ObjectEncoder<?>> objectEncoders;
    public final Map<Class<?>, ValueEncoder<?>> valueEncoders;

    public JsonValueObjectEncoderContext(Writer writer, Map<Class<?>, ObjectEncoder<?>> map, Map<Class<?>, ValueEncoder<?>> map2, ObjectEncoder<Object> objectEncoder, boolean z) {
        this.jsonWriter = new JsonWriter(writer);
        this.objectEncoders = map;
        this.valueEncoders = map2;
        this.fallbackEncoder = objectEncoder;
        this.ignoreNullValues = z;
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, int i) throws IOException {
        String str = fieldDescriptor.name;
        maybeUnNest();
        this.jsonWriter.name(str);
        maybeUnNest();
        this.jsonWriter.value((long) i);
        return this;
    }

    public final void maybeUnNest() throws IOException {
        if (this.active) {
            JsonValueObjectEncoderContext jsonValueObjectEncoderContext = this.childContext;
            if (jsonValueObjectEncoderContext != null) {
                jsonValueObjectEncoderContext.maybeUnNest();
                this.childContext.active = false;
                this.childContext = null;
                this.jsonWriter.endObject();
                return;
            }
            return;
        }
        throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, long j) throws IOException {
        String str = fieldDescriptor.name;
        maybeUnNest();
        this.jsonWriter.name(str);
        maybeUnNest();
        this.jsonWriter.value(j);
        return this;
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, Object obj) throws IOException {
        return add(fieldDescriptor.name, obj);
    }

    public ObjectEncoderContext add(FieldDescriptor fieldDescriptor, boolean z) throws IOException {
        String str = fieldDescriptor.name;
        maybeUnNest();
        this.jsonWriter.name(str);
        maybeUnNest();
        this.jsonWriter.value(z);
        return this;
    }

    public JsonValueObjectEncoderContext add(String str, Object obj) throws IOException {
        JsonValueObjectEncoderContext jsonValueObjectEncoderContext;
        JsonValueObjectEncoderContext jsonValueObjectEncoderContext2;
        if (this.ignoreNullValues) {
            if (obj == null) {
                jsonValueObjectEncoderContext2 = this;
            } else {
                maybeUnNest();
                this.jsonWriter.name(str);
                jsonValueObjectEncoderContext2 = add(obj, false);
            }
            return jsonValueObjectEncoderContext2;
        }
        maybeUnNest();
        this.jsonWriter.name(str);
        if (obj == null) {
            this.jsonWriter.nullValue();
            jsonValueObjectEncoderContext = this;
        } else {
            jsonValueObjectEncoderContext = add(obj, false);
        }
        return jsonValueObjectEncoderContext;
    }

    public ValueEncoderContext add(String str) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(str);
        return this;
    }

    public ValueEncoderContext add(boolean z) throws IOException {
        maybeUnNest();
        this.jsonWriter.value(z);
        return this;
    }

    public JsonValueObjectEncoderContext add(Object obj, boolean z) throws IOException {
        Class<?> cls;
        int i = 0;
        if (z) {
            if (obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number)) {
                Object[] objArr = new Object[1];
                if (obj == null) {
                    cls = null;
                } else {
                    cls = obj.getClass();
                }
                objArr[0] = cls;
                throw new EncodingException(String.format("%s cannot be encoded inline", objArr));
            }
        }
        if (obj == null) {
            this.jsonWriter.nullValue();
            return this;
        } else if (obj instanceof Number) {
            this.jsonWriter.value((Number) obj);
            return this;
        } else if (obj.getClass().isArray()) {
            if (obj instanceof byte[]) {
                maybeUnNest();
                this.jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
                return this;
            }
            this.jsonWriter.beginArray();
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length = iArr.length;
                while (i < length) {
                    this.jsonWriter.value((long) iArr[i]);
                    i++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length2 = jArr.length;
                while (i < length2) {
                    long j = jArr[i];
                    maybeUnNest();
                    this.jsonWriter.value(j);
                    i++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length3 = dArr.length;
                while (i < length3) {
                    this.jsonWriter.value(dArr[i]);
                    i++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length4 = zArr.length;
                while (i < length4) {
                    this.jsonWriter.value(zArr[i]);
                    i++;
                }
            } else if (obj instanceof Number[]) {
                for (Number add : (Number[]) obj) {
                    add((Object) add, false);
                }
            } else {
                for (Object add2 : (Object[]) obj) {
                    add(add2, false);
                }
            }
            this.jsonWriter.endArray();
            return this;
        } else if (obj instanceof Collection) {
            this.jsonWriter.beginArray();
            for (Object add3 : (Collection) obj) {
                add(add3, false);
            }
            this.jsonWriter.endArray();
            return this;
        } else if (obj instanceof Map) {
            this.jsonWriter.beginObject();
            for (Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                try {
                    add((String) key, entry.getValue());
                } catch (ClassCastException e2) {
                    throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", new Object[]{key, key.getClass()}), e2);
                }
            }
            this.jsonWriter.endObject();
            return this;
        } else {
            ObjectEncoder objectEncoder = this.objectEncoders.get(obj.getClass());
            if (objectEncoder != null) {
                if (!z) {
                    this.jsonWriter.beginObject();
                }
                objectEncoder.encode(obj, this);
                if (!z) {
                    this.jsonWriter.endObject();
                }
                return this;
            }
            ValueEncoder valueEncoder = this.valueEncoders.get(obj.getClass());
            if (valueEncoder != null) {
                valueEncoder.encode(obj, this);
                return this;
            } else if (obj instanceof Enum) {
                String name = ((Enum) obj).name();
                maybeUnNest();
                this.jsonWriter.value(name);
                return this;
            } else {
                ObjectEncoder<Object> objectEncoder2 = this.fallbackEncoder;
                if (!z) {
                    this.jsonWriter.beginObject();
                }
                objectEncoder2.encode(obj, this);
                if (!z) {
                    this.jsonWriter.endObject();
                }
                return this;
            }
        }
    }
}
