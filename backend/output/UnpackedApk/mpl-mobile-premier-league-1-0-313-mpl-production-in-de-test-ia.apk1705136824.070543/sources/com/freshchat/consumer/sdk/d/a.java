package com.freshchat.consumer.sdk.d;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.freshchat.consumer.sdk.j.as;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class a<T> implements TypeAdapterFactory {
    public final Class<?> es;
    public final String et;
    public final Map<String, Class<?>> eu = new LinkedHashMap();
    public final Map<Class<?>, String> ev = new LinkedHashMap();

    public a(Class<?> cls, String str) {
        if (str == null || cls == null) {
            throw null;
        }
        this.es = cls;
        this.et = str;
    }

    public <R> JsonObject a(String str, TypeAdapter<R> typeAdapter, R r) {
        return typeAdapter.toJsonTree(r).getAsJsonObject();
    }

    public TypeAdapter<?> a(Class<?> cls, Map<Class<?>, TypeAdapter<?>> map) {
        return map.get(cls);
    }

    public TypeAdapter<?> a(String str, Map<String, TypeAdapter<?>> map, JsonElement jsonElement, Class<?> cls) {
        return map.get(str);
    }

    public String a(JsonElement jsonElement, Class<?> cls, String str) {
        JsonElement jsonElement2 = jsonElement.getAsJsonObject().get(str);
        if (jsonElement2 != null) {
            try {
                String valueOf = String.valueOf(jsonElement2.getAsInt());
                if (!as.isEmpty(valueOf)) {
                    return valueOf;
                }
            } catch (Exception unused) {
                if (!as.isEmpty(null)) {
                    return null;
                }
            } catch (Throwable th) {
                if (as.isEmpty(null)) {
                    jsonElement2.getAsString();
                }
                throw th;
            }
            return jsonElement2.getAsString();
        }
        throw new JsonParseException("cannot deserialize " + cls + " because it does not define a field named " + str);
    }

    public a<T> b(Class<? extends T> cls, String str) {
        if (cls == null || str == null) {
            throw null;
        } else if (this.ev.containsKey(cls) || this.eu.containsKey(str)) {
            throw new IllegalArgumentException("types and labels must be unique");
        } else {
            this.eu.put(str, cls);
            this.ev.put(cls, str);
            return this;
        }
    }

    public String c(Class<?> cls) {
        return this.ev.get(cls);
    }

    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> typeToken) {
        if (typeToken.getRawType() != this.es) {
            return null;
        }
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Entry next : this.eu.entrySet()) {
            TypeAdapter delegateAdapter = gson.getDelegateAdapter(this, TypeToken.get((Class) next.getValue()));
            linkedHashMap.put(next.getKey(), delegateAdapter);
            linkedHashMap2.put(next.getValue(), delegateAdapter);
        }
        return new TypeAdapter<R>() {
            public R read(JsonReader jsonReader) throws IOException {
                JsonElement parse = Streams.parse(jsonReader);
                a aVar = a.this;
                String a2 = aVar.a(parse, aVar.es, a.this.et);
                a aVar2 = a.this;
                TypeAdapter<?> a3 = aVar2.a(a2, linkedHashMap, parse, aVar2.es);
                if (a3 != null) {
                    return a3.fromJsonTree(parse);
                }
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("cannot deserialize ");
                outline73.append(a.this.es);
                outline73.append(" subtype named ");
                outline73.append(a2);
                outline73.append("; did you forget to register a subtype?");
                throw new JsonParseException(outline73.toString());
            }

            public void write(JsonWriter jsonWriter, R r) throws IOException {
                Class<?> cls = r.getClass();
                String c2 = a.this.c(cls);
                TypeAdapter<?> a2 = a.this.a(cls, linkedHashMap2);
                if (a2 != null) {
                    JsonObject a3 = a.this.a(c2, a2, r);
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.add(a.this.et, new JsonPrimitive(c2));
                    for (Entry next : a3.entrySet()) {
                        jsonObject.add((String) next.getKey(), (JsonElement) next.getValue());
                    }
                    Streams.write(jsonObject, jsonWriter);
                    return;
                }
                throw new JsonParseException(GeneratedOutlineSupport.outline36(cls, GeneratedOutlineSupport.outline73("cannot serialize "), "; did you forget to register a subtype?"));
            }
        }.nullSafe();
    }
}
