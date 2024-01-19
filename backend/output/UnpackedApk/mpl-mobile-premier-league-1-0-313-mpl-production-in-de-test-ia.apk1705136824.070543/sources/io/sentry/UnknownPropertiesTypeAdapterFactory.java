package io.sentry;

import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Excluder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;

public final class UnknownPropertiesTypeAdapterFactory implements TypeAdapterFactory {
    public static final TypeAdapterFactory instance = new UnknownPropertiesTypeAdapterFactory();

    public static final class UnknownPropertiesTypeAdapter<T extends IUnknownPropertiesConsumer> extends TypeAdapter<T> {
        public final Collection<String> propertyNames;
        public final TypeAdapter<T> typeAdapter;

        public UnknownPropertiesTypeAdapter(TypeAdapter<T> typeAdapter2, Collection<String> collection) {
            this.typeAdapter = typeAdapter2;
            this.propertyNames = collection;
        }

        public static <T extends IUnknownPropertiesConsumer> TypeAdapter<T> create(Class<? super T> cls, TypeAdapter<T> typeAdapter2, Excluder excluder, FieldNamingStrategy fieldNamingStrategy) {
            return new UnknownPropertiesTypeAdapter(typeAdapter2, getPropertyNames(cls, excluder, fieldNamingStrategy));
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r7v0, types: [java.lang.Class<?>, java.lang.Class] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.util.Collection<java.lang.String> getPropertyNames(java.lang.Class r7, com.google.gson.internal.Excluder r8, com.google.gson.FieldNamingStrategy r9) {
            /*
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
            L_0x0005:
                java.lang.Class r1 = r7.getSuperclass()
                if (r1 == 0) goto L_0x002f
                java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
                if (r7 == r1) goto L_0x002f
                java.lang.reflect.Field[] r1 = r7.getDeclaredFields()
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L_0x0016:
                if (r4 >= r2) goto L_0x002a
                r5 = r1[r4]
                boolean r6 = r8.excludeField(r5, r3)
                if (r6 != 0) goto L_0x0027
                java.lang.String r5 = r9.translateName(r5)
                r0.add(r5)
            L_0x0027:
                int r4 = r4 + 1
                goto L_0x0016
            L_0x002a:
                java.lang.Class r7 = r7.getSuperclass()
                goto L_0x0005
            L_0x002f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.UnknownPropertiesTypeAdapterFactory.UnknownPropertiesTypeAdapter.getPropertyNames(java.lang.Class, com.google.gson.internal.Excluder, com.google.gson.FieldNamingStrategy):java.util.Collection");
        }

        public T read(JsonReader jsonReader) {
            JsonElement parse = new JsonParser().parse(jsonReader);
            if (parse == null || parse.isJsonNull()) {
                return null;
            }
            JsonObject asJsonObject = parse.getAsJsonObject();
            HashMap hashMap = new HashMap();
            for (Entry next : asJsonObject.entrySet()) {
                String str = (String) next.getKey();
                if (!this.propertyNames.contains(str)) {
                    hashMap.put(str, next.getValue());
                }
            }
            T t = (IUnknownPropertiesConsumer) this.typeAdapter.fromJsonTree(asJsonObject);
            if (!hashMap.isEmpty()) {
                t.acceptUnknownProperties(hashMap);
            }
            return t;
        }

        public void write(JsonWriter jsonWriter, T t) throws IOException {
            this.typeAdapter.write(jsonWriter, t);
        }
    }

    public static TypeAdapterFactory get() {
        return instance;
    }

    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (!IUnknownPropertiesConsumer.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        return UnknownPropertiesTypeAdapter.create(typeToken.getRawType(), gson.getDelegateAdapter(this, typeToken), gson.excluder(), gson.fieldNamingStrategy());
    }
}
