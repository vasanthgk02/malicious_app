package com.squareup.moshi;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.squareup.moshi.JsonAdapter.Factory;
import com.squareup.moshi.JsonReader.Token;
import com.squareup.moshi.internal.Util;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class AdapterMethodsFactory implements Factory {
    public final List<AdapterMethod> fromAdapters;
    public final List<AdapterMethod> toAdapters;

    public static abstract class AdapterMethod {
        public final Object adapter;
        public final int adaptersOffset;
        public final Set<? extends Annotation> annotations;
        public final JsonAdapter<?>[] jsonAdapters;
        public final Method method;
        public final boolean nullable;
        public final Type type;

        public AdapterMethod(Type type2, Set<? extends Annotation> set, Object obj, Method method2, int i, int i2, boolean z) {
            this.type = Util.canonicalize(type2);
            this.annotations = set;
            this.adapter = obj;
            this.method = method2;
            this.adaptersOffset = i2;
            this.jsonAdapters = new JsonAdapter[(i - i2)];
            this.nullable = z;
        }

        public void bind(Moshi moshi, Factory factory) {
            JsonAdapter<?> jsonAdapter;
            if (this.jsonAdapters.length > 0) {
                Type[] genericParameterTypes = this.method.getGenericParameterTypes();
                Annotation[][] parameterAnnotations = this.method.getParameterAnnotations();
                int length = genericParameterTypes.length;
                for (int i = this.adaptersOffset; i < length; i++) {
                    Type type2 = ((ParameterizedType) genericParameterTypes[i]).getActualTypeArguments()[0];
                    Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations(parameterAnnotations[i]);
                    JsonAdapter<?>[] jsonAdapterArr = this.jsonAdapters;
                    int i2 = i - this.adaptersOffset;
                    if (!Types.equals(this.type, type2) || !this.annotations.equals(jsonAnnotations)) {
                        jsonAdapter = moshi.adapter(type2, jsonAnnotations);
                    } else {
                        jsonAdapter = moshi.nextAdapter(factory, type2, jsonAnnotations);
                    }
                    jsonAdapterArr[i2] = jsonAdapter;
                }
            }
        }

        public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, InvocationTargetException {
            throw new AssertionError();
        }

        public Object invoke(Object obj) throws InvocationTargetException {
            JsonAdapter<?>[] jsonAdapterArr = this.jsonAdapters;
            Object[] objArr = new Object[(jsonAdapterArr.length + 1)];
            objArr[0] = obj;
            System.arraycopy(jsonAdapterArr, 0, objArr, 1, jsonAdapterArr.length);
            try {
                return this.method.invoke(this.adapter, objArr);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }

        public void toJson(Moshi moshi, JsonWriter jsonWriter, Object obj) throws IOException, InvocationTargetException {
            throw new AssertionError();
        }

        public Object invoke(Object obj, Object obj2) throws InvocationTargetException {
            JsonAdapter<?>[] jsonAdapterArr = this.jsonAdapters;
            Object[] objArr = new Object[(jsonAdapterArr.length + 2)];
            objArr[0] = obj;
            objArr[1] = obj2;
            System.arraycopy(jsonAdapterArr, 0, objArr, 2, jsonAdapterArr.length);
            try {
                return this.method.invoke(this.adapter, objArr);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }
    }

    public AdapterMethodsFactory(List<AdapterMethod> list, List<AdapterMethod> list2) {
        this.toAdapters = list;
        this.fromAdapters = list2;
    }

    public static AdapterMethod fromAdapter(Object obj, Method method) {
        method.setAccessible(true);
        final Type genericReturnType = method.getGenericReturnType();
        final Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations((AnnotatedElement) method);
        final Type[] genericParameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (genericParameterTypes.length >= 1 && genericParameterTypes[0] == JsonReader.class && genericReturnType != Void.TYPE && parametersAreJsonAdapters(1, genericParameterTypes)) {
            AnonymousClass4 r1 = new AdapterMethod(genericReturnType, jsonAnnotations, obj, method, genericParameterTypes.length, 1, true) {
                public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, InvocationTargetException {
                    return invoke(jsonReader);
                }
            };
            return r1;
        } else if (genericParameterTypes.length != 1 || genericReturnType == Void.TYPE) {
            throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@FromJson method signatures may have one of the following structures:\n    <any access modifier> R fromJson(JsonReader jsonReader) throws <any>;\n    <any access modifier> R fromJson(JsonReader jsonReader, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R fromJson(T value) throws <any>;\n");
        } else {
            final Set<? extends Annotation> jsonAnnotations2 = Util.jsonAnnotations(parameterAnnotations[0]);
            Type type = genericReturnType;
            Set<? extends Annotation> set = jsonAnnotations;
            Object obj2 = obj;
            Method method2 = method;
            AnonymousClass5 r12 = new AdapterMethod(type, set, obj2, method2, genericParameterTypes.length, 1, Util.hasNullable(parameterAnnotations[0])) {
                public JsonAdapter<Object> delegate;

                public void bind(Moshi moshi, Factory factory) {
                    JsonAdapter<Object> jsonAdapter;
                    super.bind(moshi, factory);
                    if (!Types.equals(genericParameterTypes[0], genericReturnType) || !jsonAnnotations2.equals(jsonAnnotations)) {
                        jsonAdapter = moshi.adapter(genericParameterTypes[0], jsonAnnotations2);
                    } else {
                        jsonAdapter = moshi.nextAdapter(factory, genericParameterTypes[0], jsonAnnotations2);
                    }
                    this.delegate = jsonAdapter;
                }

                public Object fromJson(Moshi moshi, JsonReader jsonReader) throws IOException, InvocationTargetException {
                    return invoke(this.delegate.fromJson(jsonReader));
                }
            };
            return r12;
        }
    }

    public static AdapterMethodsFactory get(Object obj) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Class cls = obj.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ToJson.class)) {
                    AdapterMethod adapter = toAdapter(obj, method);
                    AdapterMethod adapterMethod = get(arrayList, adapter.type, adapter.annotations);
                    if (adapterMethod == null) {
                        arrayList.add(adapter);
                    } else {
                        StringBuilder outline73 = GeneratedOutlineSupport.outline73("Conflicting @ToJson methods:\n    ");
                        outline73.append(adapterMethod.method);
                        outline73.append("\n    ");
                        outline73.append(adapter.method);
                        throw new IllegalArgumentException(outline73.toString());
                    }
                }
                if (method.isAnnotationPresent(FromJson.class)) {
                    AdapterMethod fromAdapter = fromAdapter(obj, method);
                    AdapterMethod adapterMethod2 = get(arrayList2, fromAdapter.type, fromAdapter.annotations);
                    if (adapterMethod2 == null) {
                        arrayList2.add(fromAdapter);
                    } else {
                        StringBuilder outline732 = GeneratedOutlineSupport.outline73("Conflicting @FromJson methods:\n    ");
                        outline732.append(adapterMethod2.method);
                        outline732.append("\n    ");
                        outline732.append(fromAdapter.method);
                        throw new IllegalArgumentException(outline732.toString());
                    }
                }
            }
        }
        if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
            return new AdapterMethodsFactory(arrayList, arrayList2);
        }
        StringBuilder outline733 = GeneratedOutlineSupport.outline73("Expected at least one @ToJson or @FromJson method on ");
        outline733.append(obj.getClass().getName());
        throw new IllegalArgumentException(outline733.toString());
    }

    public static boolean parametersAreJsonAdapters(int i, Type[] typeArr) {
        int length = typeArr.length;
        while (i < length) {
            if (!(typeArr[i] instanceof ParameterizedType) || typeArr[i].getRawType() != JsonAdapter.class) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static AdapterMethod toAdapter(Object obj, Method method) {
        method.setAccessible(true);
        final Type genericReturnType = method.getGenericReturnType();
        final Type[] genericParameterTypes = method.getGenericParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        if (genericParameterTypes.length >= 2 && genericParameterTypes[0] == JsonWriter.class && genericReturnType == Void.TYPE && parametersAreJsonAdapters(2, genericParameterTypes)) {
            AnonymousClass2 r0 = new AdapterMethod(genericParameterTypes[1], Util.jsonAnnotations(parameterAnnotations[1]), obj, method, genericParameterTypes.length, 2, true) {
                public void toJson(Moshi moshi, JsonWriter jsonWriter, Object obj) throws IOException, InvocationTargetException {
                    invoke(jsonWriter, obj);
                }
            };
            return r0;
        } else if (genericParameterTypes.length != 1 || genericReturnType == Void.TYPE) {
            throw new IllegalArgumentException("Unexpected signature for " + method + ".\n@ToJson method signatures may have one of the following structures:\n    <any access modifier> void toJson(JsonWriter writer, T value) throws <any>;\n    <any access modifier> void toJson(JsonWriter writer, T value, JsonAdapter<any> delegate, <any more delegates>) throws <any>;\n    <any access modifier> R toJson(T value) throws <any>;\n");
        } else {
            final Set<? extends Annotation> jsonAnnotations = Util.jsonAnnotations((AnnotatedElement) method);
            final Set<? extends Annotation> jsonAnnotations2 = Util.jsonAnnotations(parameterAnnotations[0]);
            Set<? extends Annotation> set = jsonAnnotations2;
            Object obj2 = obj;
            Method method2 = method;
            AnonymousClass3 r02 = new AdapterMethod(genericParameterTypes[0], set, obj2, method2, genericParameterTypes.length, 1, Util.hasNullable(parameterAnnotations[0])) {
                public JsonAdapter<Object> delegate;

                public void bind(Moshi moshi, Factory factory) {
                    JsonAdapter<Object> jsonAdapter;
                    super.bind(moshi, factory);
                    if (!Types.equals(genericParameterTypes[0], genericReturnType) || !jsonAnnotations2.equals(jsonAnnotations)) {
                        jsonAdapter = moshi.adapter(genericReturnType, jsonAnnotations);
                    } else {
                        jsonAdapter = moshi.nextAdapter(factory, genericReturnType, jsonAnnotations);
                    }
                    this.delegate = jsonAdapter;
                }

                public void toJson(Moshi moshi, JsonWriter jsonWriter, Object obj) throws IOException, InvocationTargetException {
                    this.delegate.toJson(jsonWriter, invoke(obj));
                }
            };
            return r02;
        }
    }

    public JsonAdapter<?> create(Type type, Set<? extends Annotation> set, Moshi moshi) {
        final AdapterMethod adapterMethod = get(this.toAdapters, type, set);
        final AdapterMethod adapterMethod2 = get(this.fromAdapters, type, set);
        JsonAdapter<T> jsonAdapter = null;
        if (adapterMethod == null && adapterMethod2 == null) {
            return null;
        }
        if (adapterMethod == null || adapterMethod2 == null) {
            try {
                jsonAdapter = moshi.nextAdapter(this, type, set);
            } catch (IllegalArgumentException e2) {
                StringBuilder outline80 = GeneratedOutlineSupport.outline80("No ", adapterMethod == null ? "@ToJson" : "@FromJson", " adapter for ");
                outline80.append(Util.typeAnnotatedWithAnnotations(type, set));
                throw new IllegalArgumentException(outline80.toString(), e2);
            }
        }
        final JsonAdapter<T> jsonAdapter2 = jsonAdapter;
        if (adapterMethod != null) {
            adapterMethod.bind(moshi, this);
        }
        if (adapterMethod2 != null) {
            adapterMethod2.bind(moshi, this);
        }
        final Moshi moshi2 = moshi;
        final Set<? extends Annotation> set2 = set;
        final Type type2 = type;
        AnonymousClass1 r1 = new JsonAdapter<Object>() {
            public Object fromJson(JsonReader jsonReader) throws IOException {
                AdapterMethod adapterMethod = adapterMethod2;
                if (adapterMethod == null) {
                    return jsonAdapter2.fromJson(jsonReader);
                }
                if (adapterMethod.nullable || jsonReader.peek() != Token.NULL) {
                    try {
                        return adapterMethod2.fromJson(moshi2, jsonReader);
                    } catch (InvocationTargetException e2) {
                        Throwable cause = e2.getCause();
                        if (cause instanceof IOException) {
                            throw ((IOException) cause);
                        }
                        throw new JsonDataException(cause + " at " + jsonReader.getPath(), cause);
                    }
                } else {
                    jsonReader.nextNull();
                    return null;
                }
            }

            public void toJson(JsonWriter jsonWriter, Object obj) throws IOException {
                AdapterMethod adapterMethod = adapterMethod;
                if (adapterMethod == null) {
                    jsonAdapter2.toJson(jsonWriter, obj);
                } else if (adapterMethod.nullable || obj != null) {
                    try {
                        adapterMethod.toJson(moshi2, jsonWriter, obj);
                    } catch (InvocationTargetException e2) {
                        Throwable cause = e2.getCause();
                        if (cause instanceof IOException) {
                            throw ((IOException) cause);
                        }
                        throw new JsonDataException(cause + " at " + jsonWriter.getPath(), cause);
                    }
                } else {
                    jsonWriter.nullValue();
                }
            }

            public String toString() {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("JsonAdapter");
                outline73.append(set2);
                outline73.append("(");
                outline73.append(type2);
                outline73.append(")");
                return outline73.toString();
            }
        };
        return r1;
    }

    public static AdapterMethod get(List<AdapterMethod> list, Type type, Set<? extends Annotation> set) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AdapterMethod adapterMethod = list.get(i);
            if (Types.equals(adapterMethod.type, type) && adapterMethod.annotations.equals(set)) {
                return adapterMethod;
            }
        }
        return null;
    }
}
