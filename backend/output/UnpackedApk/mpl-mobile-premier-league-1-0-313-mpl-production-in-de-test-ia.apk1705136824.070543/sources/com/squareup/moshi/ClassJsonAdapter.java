package com.squareup.moshi;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonAdapter.Factory;
import com.squareup.moshi.JsonReader.Options;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class ClassJsonAdapter<T> extends JsonAdapter<T> {
    public static final Factory FACTORY = new Factory() {
        private void createFieldBindings(Moshi moshi, Type type, Map<String, FieldBinding<?>> map) {
            Class<?> rawType = Types.getRawType(type);
            boolean isPlatformType = Util.isPlatformType(rawType);
            for (Field field : rawType.getDeclaredFields()) {
                if (includeField(isPlatformType, field.getModifiers())) {
                    Type resolve = Util.resolve(type, rawType, field.getGenericType());
                    Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations((AnnotatedElement) field);
                    String name = field.getName();
                    JsonAdapter<T> adapter = moshi.adapter(resolve, jsonAnnotations, name);
                    field.setAccessible(true);
                    Json json = (Json) field.getAnnotation(Json.class);
                    if (json != null) {
                        name = json.name();
                    }
                    FieldBinding fieldBinding = new FieldBinding(name, field, adapter);
                    FieldBinding put = map.put(name, fieldBinding);
                    if (put != null) {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Conflicting fields:\n    ");
                        outline73.append(put.field);
                        outline73.append("\n    ");
                        outline73.append(fieldBinding.field);
                        throw new IllegalArgumentException(outline73.toString());
                    }
                }
            }
        }

        private boolean includeField(boolean z, int i) {
            if (Modifier.isStatic(i) || Modifier.isTransient(i)) {
                return false;
            }
            if (Modifier.isPublic(i) || Modifier.isProtected(i) || !z) {
                return true;
            }
            return false;
        }

        private void throwIfIsCollectionClass(Type type, Class<?> cls) {
            Class<?> rawType = Types.getRawType(type);
            if (cls.isAssignableFrom(rawType)) {
                throw new IllegalArgumentException("No JsonAdapter for " + type + ", you should probably use " + cls.getSimpleName() + " instead of " + rawType.getSimpleName() + " (Moshi only supports the collection interfaces by default) or else register a custom JsonAdapter.");
            }
        }

        public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
            if (!(type instanceof Class) && !(type instanceof ParameterizedType)) {
                return null;
            }
            Class<?> rawType = Types.getRawType(type);
            if (rawType.isInterface() || rawType.isEnum() || !set.isEmpty()) {
                return null;
            }
            if (Util.isPlatformType(rawType)) {
                throwIfIsCollectionClass(type, List.class);
                throwIfIsCollectionClass(type, Set.class);
                throwIfIsCollectionClass(type, Map.class);
                throwIfIsCollectionClass(type, Collection.class);
                String str = "Platform " + rawType;
                if (type instanceof ParameterizedType) {
                    str = str + " in " + type;
                }
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline50(str, " requires explicit JsonAdapter to be registered"));
            } else if (rawType.isAnonymousClass()) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline35(rawType, GeneratedOutlineSupport.outline73("Cannot serialize anonymous class ")));
            } else if (rawType.isLocalClass()) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline35(rawType, GeneratedOutlineSupport.outline73("Cannot serialize local class ")));
            } else if (rawType.getEnclosingClass() != null && !Modifier.isStatic(rawType.getModifiers())) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline35(rawType, GeneratedOutlineSupport.outline73("Cannot serialize non-static nested class ")));
            } else if (Modifier.isAbstract(rawType.getModifiers())) {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline35(rawType, GeneratedOutlineSupport.outline73("Cannot serialize abstract class ")));
            } else if (!Util.isKotlin(rawType)) {
                ClassFactory<?> classFactory = ClassFactory.get(rawType);
                TreeMap treeMap = new TreeMap();
                while (type != Object.class) {
                    createFieldBindings(moshi, type, treeMap);
                    type = Types.getGenericSuperclass(type);
                }
                return new ClassJsonAdapter(classFactory, treeMap).nullSafe();
            } else {
                throw new IllegalArgumentException(GeneratedOutlineSupport.outline36(rawType, GeneratedOutlineSupport.outline73("Cannot serialize Kotlin type "), ". Reflective serialization of Kotlin classes without using kotlin-reflect has undefined and unexpected behavior. Please use KotlinJsonAdapterFactory from the moshi-kotlin artifact or use code gen from the moshi-kotlin-codegen artifact."));
            }
        }
    };
    public final ClassFactory<T> classFactory;
    public final FieldBinding<?>[] fieldsArray;
    public final Options options;

    public static class FieldBinding<T> {
        public final JsonAdapter<T> adapter;
        public final Field field;
        public final String name;

        public FieldBinding(String str, Field field2, JsonAdapter<T> jsonAdapter) {
            this.name = str;
            this.field = field2;
            this.adapter = jsonAdapter;
        }

        public void read(JsonReader jsonReader, Object obj) throws IOException, IllegalAccessException {
            this.field.set(obj, this.adapter.fromJson(jsonReader));
        }

        public void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException {
            this.adapter.toJson(jsonWriter, this.field.get(obj));
        }
    }

    public ClassJsonAdapter(ClassFactory<T> classFactory2, Map<String, FieldBinding<?>> map) {
        this.classFactory = classFactory2;
        this.fieldsArray = (FieldBinding[]) map.values().toArray(new FieldBinding[map.size()]);
        this.options = Options.of((String[]) map.keySet().toArray(new String[map.size()]));
    }

    public T fromJson(JsonReader jsonReader) throws IOException {
        try {
            T newInstance = this.classFactory.newInstance();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    int selectName = jsonReader.selectName(this.options);
                    if (selectName == -1) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                    } else {
                        this.fieldsArray[selectName].read(jsonReader, newInstance);
                    }
                }
                jsonReader.endObject();
                return newInstance;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw Util.rethrowCause(e3);
        } catch (IllegalAccessException unused2) {
            throw new AssertionError();
        }
    }

    public void toJson(JsonWriter jsonWriter, T t) throws IOException {
        try {
            jsonWriter.beginObject();
            for (FieldBinding<?> fieldBinding : this.fieldsArray) {
                jsonWriter.name(fieldBinding.name);
                fieldBinding.write(jsonWriter, t);
            }
            jsonWriter.endObject();
        } catch (IllegalAccessException unused) {
            throw new AssertionError();
        }
    }

    public String toString() {
        StringBuilder outline73 = GeneratedOutlineSupport.outline73("JsonAdapter(");
        outline73.append(this.classFactory);
        outline73.append(")");
        return outline73.toString();
    }
}
