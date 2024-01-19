package com.badlogic.gdx.utils;

import co.hyperverge.hypersnapsdk.c.k;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.badlogic.gdx.utils.JsonWriter.JsonObject;
import com.badlogic.gdx.utils.JsonWriter.OutputType;
import com.badlogic.gdx.utils.reflect.Constructor;
import com.badlogic.gdx.utils.reflect.Field;
import com.badlogic.gdx.utils.reflect.ReflectionException;
import com.facebook.react.bridge.PromiseImpl;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Modifier;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Collections;

public class Json {
    public final ObjectMap<Class, Object[]> classToDefaultValues = new ObjectMap<>();
    public final ObjectMap<Class, Serializer> classToSerializer = new ObjectMap<>();
    public final ObjectMap<Class, String> classToTag = new ObjectMap<>();
    public boolean enumNames = true;
    public final Object[] equals1 = {null};
    public final Object[] equals2 = {null};
    public OutputType outputType = OutputType.minimal;
    public final ObjectMap<String, Class> tagToClass = new ObjectMap<>();
    public String typeName = PromiseImpl.STACK_FRAME_KEY_CLASS;
    public final ObjectMap<Class, OrderedMap<String, FieldMetadata>> typeToFields = new ObjectMap<>();
    public boolean usePrototypes = true;
    public JsonWriter writer;

    public static class FieldMetadata {
        public boolean deprecated;
        public Class elementType;
        public final Field field;

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
            r0 = java.lang.reflect.Array.newInstance((java.lang.Class) r0, 0).getClass();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public FieldMetadata(com.badlogic.gdx.utils.reflect.Field r5) {
            /*
                r4 = this;
                r4.<init>()
                r4.field = r5
                java.lang.Class<com.badlogic.gdx.utils.ObjectMap> r0 = com.badlogic.gdx.utils.ObjectMap.class
                java.lang.Class r1 = r5.getType()
                boolean r0 = r0.isAssignableFrom(r1)
                r1 = 0
                if (r0 != 0) goto L_0x0021
                java.lang.Class<java.util.Map> r0 = java.util.Map.class
                java.lang.Class r2 = r5.getType()
                boolean r0 = r0.isAssignableFrom(r2)
                if (r0 == 0) goto L_0x001f
                goto L_0x0021
            L_0x001f:
                r0 = 0
                goto L_0x0022
            L_0x0021:
                r0 = 1
            L_0x0022:
                java.lang.reflect.Field r2 = r5.field
                java.lang.reflect.Type r2 = r2.getGenericType()
                boolean r3 = r2 instanceof java.lang.reflect.ParameterizedType
                if (r3 == 0) goto L_0x0066
                java.lang.reflect.ParameterizedType r2 = (java.lang.reflect.ParameterizedType) r2
                java.lang.reflect.Type[] r2 = r2.getActualTypeArguments()
                int r3 = r2.length
                int r3 = r3 + -1
                if (r3 < r0) goto L_0x0066
                r0 = r2[r0]
                boolean r2 = r0 instanceof java.lang.Class
                if (r2 == 0) goto L_0x0040
                java.lang.Class r0 = (java.lang.Class) r0
                goto L_0x0067
            L_0x0040:
                boolean r2 = r0 instanceof java.lang.reflect.ParameterizedType
                if (r2 == 0) goto L_0x004d
                java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
                java.lang.reflect.Type r0 = r0.getRawType()
                java.lang.Class r0 = (java.lang.Class) r0
                goto L_0x0067
            L_0x004d:
                boolean r2 = r0 instanceof java.lang.reflect.GenericArrayType
                if (r2 == 0) goto L_0x0066
                java.lang.reflect.GenericArrayType r0 = (java.lang.reflect.GenericArrayType) r0
                java.lang.reflect.Type r0 = r0.getGenericComponentType()
                boolean r2 = r0 instanceof java.lang.Class
                if (r2 == 0) goto L_0x0066
                java.lang.Class r0 = (java.lang.Class) r0
                java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r1)
                java.lang.Class r0 = r0.getClass()
                goto L_0x0067
            L_0x0066:
                r0 = 0
            L_0x0067:
                r4.elementType = r0
                java.lang.Class<java.lang.Deprecated> r0 = java.lang.Deprecated.class
                java.lang.reflect.Field r5 = r5.field
                boolean r5 = r5.isAnnotationPresent(r0)
                r4.deprecated = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.Json.FieldMetadata.<init>(com.badlogic.gdx.utils.reflect.Field):void");
        }
    }

    public interface Serializable {
        void read(Json json, JsonValue jsonValue);

        void write(Json json);
    }

    public interface Serializer<T> {
        T read(Json json, JsonValue jsonValue, Class cls);

        void write(Json json, T t, Class cls);
    }

    public final String convertToString(Enum enumR) {
        return this.enumNames ? enumR.name() : enumR.toString();
    }

    public final OrderedMap<String, FieldMetadata> getFields(Class cls) {
        int i;
        OrderedMap<String, FieldMetadata> orderedMap = (OrderedMap) this.typeToFields.get(cls);
        if (orderedMap != null) {
            return orderedMap;
        }
        Array array = new Array();
        for (Class cls2 = cls; cls2 != Object.class; cls2 = cls2.getSuperclass()) {
            array.add(cls2);
        }
        ArrayList arrayList = new ArrayList();
        int i2 = array.size - 1;
        while (true) {
            i = 0;
            if (i2 < 0) {
                break;
            }
            java.lang.reflect.Field[] declaredFields = ((Class) array.get(i2)).getDeclaredFields();
            Field[] fieldArr = new Field[declaredFields.length];
            int length = declaredFields.length;
            while (i < length) {
                fieldArr[i] = new Field(declaredFields[i]);
                i++;
            }
            Collections.addAll(arrayList, fieldArr);
            i2--;
        }
        OrderedMap<String, FieldMetadata> orderedMap2 = new OrderedMap<>(arrayList.size());
        int size = arrayList.size();
        while (i < size) {
            Field field = (Field) arrayList.get(i);
            if (!Modifier.isTransient(field.field.getModifiers()) && !Modifier.isStatic(field.field.getModifiers()) && !field.field.isSynthetic()) {
                if (!field.field.isAccessible()) {
                    try {
                        field.field.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                }
                orderedMap2.put(field.getName(), new FieldMetadata(field));
            }
            i++;
        }
        this.typeToFields.put(cls, orderedMap2);
        return orderedMap2;
    }

    public Object newInstance(Class<? super T> cls) {
        try {
            return k.newInstance(cls);
        } catch (Exception e2) {
            e = e2;
            try {
                Constructor declaredConstructor = k.getDeclaredConstructor(cls, new Class[0]);
                declaredConstructor.constructor.setAccessible(true);
                return declaredConstructor.newInstance(new Object[0]);
            } catch (SecurityException unused) {
                throw new SerializationException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Error constructing instance of class: ")), e);
            } catch (ReflectionException unused2) {
                if (Enum.class.isAssignableFrom(cls)) {
                    if (cls.getEnumConstants() == null) {
                        cls = cls.getSuperclass();
                    }
                    return cls.getEnumConstants()[0];
                } else if (cls.isArray()) {
                    throw new SerializationException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Encountered JSON object when expected array of type: ")), e);
                } else if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
                    throw new SerializationException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Class cannot be created (missing no-arg constructor): ")), e);
                } else {
                    throw new SerializationException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Class cannot be created (non-static member class): ")), e);
                }
            } catch (Exception e3) {
                e = e3;
                throw new SerializationException(GeneratedOutlineSupport.outline35(cls, GeneratedOutlineSupport.outline73("Error constructing instance of class: ")), e);
            }
        }
    }

    public <T> T readValue(String str, Class<T> cls, JsonValue jsonValue) {
        return readValue(cls, (Class) null, jsonValue.get(str));
    }

    public void toJson(Object obj, Class cls, Class cls2, Writer writer2) {
        if (!(writer2 instanceof JsonWriter)) {
            writer2 = new JsonWriter(writer2);
        }
        JsonWriter jsonWriter = (JsonWriter) writer2;
        this.writer = jsonWriter;
        jsonWriter.outputType = this.outputType;
        jsonWriter.quoteLongValues = false;
        try {
            writeValue(obj, cls, cls2);
            JsonWriter jsonWriter2 = this.writer;
            if (jsonWriter2 != null) {
                try {
                    jsonWriter2.close();
                } catch (Throwable unused) {
                }
            }
            this.writer = null;
            return;
        } catch (Throwable unused2) {
        }
        this.writer = null;
        throw th;
    }

    public void writeArrayEnd() {
        try {
            this.writer.pop();
        } catch (IOException e2) {
            throw new SerializationException((Throwable) e2);
        }
    }

    public void writeArrayStart() {
        try {
            JsonWriter jsonWriter = this.writer;
            jsonWriter.requireCommaOrName();
            Array<JsonObject> array = jsonWriter.stack;
            JsonObject jsonObject = new JsonObject(true);
            jsonWriter.current = jsonObject;
            array.add(jsonObject);
        } catch (IOException e2) {
            throw new SerializationException((Throwable) e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0124, code lost:
        if (java.util.Arrays.deepEquals(r1.equals1, r1.equals2) != false) goto L_0x0126;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeFields(java.lang.Object r19) {
        /*
            r18 = this;
            r1 = r18
            java.lang.Class r2 = r19.getClass()
            boolean r0 = r1.usePrototypes
            r3 = 0
            r4 = 0
            java.lang.String r5 = "Error accessing field: "
            java.lang.String r6 = " ("
            java.lang.String r7 = ")"
            if (r0 != 0) goto L_0x0014
            goto L_0x00c8
        L_0x0014:
            com.badlogic.gdx.utils.ObjectMap<java.lang.Class, java.lang.Object[]> r0 = r1.classToDefaultValues
            int r0 = r0.locateKey(r2)
            if (r0 < 0) goto L_0x001e
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            if (r0 == 0) goto L_0x002c
            com.badlogic.gdx.utils.ObjectMap<java.lang.Class, java.lang.Object[]> r0 = r1.classToDefaultValues
            java.lang.Object r0 = r0.get(r2)
            r4 = r0
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            goto L_0x00c8
        L_0x002c:
            java.lang.Object r0 = r1.newInstance(r2)     // Catch:{ Exception -> 0x00c3 }
            com.badlogic.gdx.utils.OrderedMap r4 = r1.getFields(r2)
            int r8 = r4.size
            java.lang.Object[] r8 = new java.lang.Object[r8]
            com.badlogic.gdx.utils.ObjectMap<java.lang.Class, java.lang.Object[]> r9 = r1.classToDefaultValues
            r9.put(r2, r8)
            com.badlogic.gdx.utils.Array<K> r9 = r4.keys
            int r10 = r9.size
            r11 = 0
            r12 = 0
        L_0x0043:
            if (r11 >= r10) goto L_0x00c1
            java.lang.Object r13 = r9.get(r11)
            java.lang.Object r13 = r4.get(r13)
            com.badlogic.gdx.utils.Json$FieldMetadata r13 = (com.badlogic.gdx.utils.Json.FieldMetadata) r13
            com.badlogic.gdx.utils.reflect.Field r13 = r13.field
            int r14 = r12 + 1
            java.lang.Object r15 = r13.get(r0)     // Catch:{ ReflectionException -> 0x009e, SerializationException -> 0x0080, RuntimeException -> 0x005d }
            r8[r12] = r15     // Catch:{ ReflectionException -> 0x009e, SerializationException -> 0x0080, RuntimeException -> 0x005d }
            int r11 = r11 + 1
            r12 = r14
            goto L_0x0043
        L_0x005d:
            r0 = move-exception
            com.badlogic.gdx.utils.SerializationException r3 = new com.badlogic.gdx.utils.SerializationException
            r3.<init>(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r13)
            r0.append(r6)
            java.lang.String r2 = r2.getName()
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r3.addTrace(r0)
            throw r3
        L_0x0080:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r13)
            r3.append(r6)
            java.lang.String r2 = r2.getName()
            r3.append(r2)
            r3.append(r7)
            java.lang.String r2 = r3.toString()
            r0.addTrace(r2)
            throw r0
        L_0x009e:
            r0 = move-exception
            com.badlogic.gdx.utils.SerializationException r3 = new com.badlogic.gdx.utils.SerializationException
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r5)
            java.lang.String r5 = r13.getName()
            r4.append(r5)
            r4.append(r6)
            java.lang.String r2 = r2.getName()
            r4.append(r2)
            r4.append(r7)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2, r0)
            throw r3
        L_0x00c1:
            r4 = r8
            goto L_0x00c8
        L_0x00c3:
            com.badlogic.gdx.utils.ObjectMap<java.lang.Class, java.lang.Object[]> r0 = r1.classToDefaultValues
            r0.put(r2, r4)
        L_0x00c8:
            com.badlogic.gdx.utils.OrderedMap r0 = r1.getFields(r2)
            com.badlogic.gdx.utils.Array<K> r8 = r0.keys
            int r9 = r8.size
            r10 = 0
            r11 = 0
        L_0x00d2:
            if (r10 >= r9) goto L_0x01ac
            java.lang.Object r12 = r8.get(r10)
            java.lang.Object r12 = r0.get(r12)
            com.badlogic.gdx.utils.Json$FieldMetadata r12 = (com.badlogic.gdx.utils.Json.FieldMetadata) r12
            com.badlogic.gdx.utils.reflect.Field r13 = r12.field
            r14 = r19
            java.lang.Object r15 = r13.get(r14)     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            if (r4 == 0) goto L_0x012e
            int r16 = r11 + 1
            r11 = r4[r11]     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            if (r15 != 0) goto L_0x00f1
            if (r11 != 0) goto L_0x00f1
            goto L_0x00fb
        L_0x00f1:
            if (r15 == 0) goto L_0x0129
            if (r11 == 0) goto L_0x0129
            boolean r17 = r15.equals(r11)     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            if (r17 == 0) goto L_0x00fe
        L_0x00fb:
            r17 = r0
            goto L_0x0126
        L_0x00fe:
            java.lang.Class r17 = r15.getClass()     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            boolean r17 = r17.isArray()     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            if (r17 == 0) goto L_0x0129
            java.lang.Class r17 = r11.getClass()     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            boolean r17 = r17.isArray()     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            if (r17 == 0) goto L_0x0129
            r17 = r0
            java.lang.Object[] r0 = r1.equals1     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            r0[r3] = r15     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            java.lang.Object[] r0 = r1.equals2     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            r0[r3] = r11     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            java.lang.Object[] r0 = r1.equals1     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            java.lang.Object[] r3 = r1.equals2     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            boolean r0 = java.util.Arrays.deepEquals(r0, r3)     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            if (r0 == 0) goto L_0x012b
        L_0x0126:
            r11 = r16
            goto L_0x0142
        L_0x0129:
            r17 = r0
        L_0x012b:
            r11 = r16
            goto L_0x0130
        L_0x012e:
            r17 = r0
        L_0x0130:
            com.badlogic.gdx.utils.JsonWriter r0 = r1.writer     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            java.lang.String r3 = r13.getName()     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            r0.name(r3)     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            java.lang.Class r0 = r13.getType()     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            java.lang.Class r3 = r12.elementType     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
            r1.writeValue(r15, r0, r3)     // Catch:{ ReflectionException -> 0x0189, SerializationException -> 0x016b, Exception -> 0x0148 }
        L_0x0142:
            int r10 = r10 + 1
            r3 = 0
            r0 = r17
            goto L_0x00d2
        L_0x0148:
            r0 = move-exception
            com.badlogic.gdx.utils.SerializationException r3 = new com.badlogic.gdx.utils.SerializationException
            r3.<init>(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r13)
            r0.append(r6)
            java.lang.String r2 = r2.getName()
            r0.append(r2)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            r3.addTrace(r0)
            throw r3
        L_0x016b:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r13)
            r3.append(r6)
            java.lang.String r2 = r2.getName()
            r3.append(r2)
            r3.append(r7)
            java.lang.String r2 = r3.toString()
            r0.addTrace(r2)
            throw r0
        L_0x0189:
            r0 = move-exception
            com.badlogic.gdx.utils.SerializationException r3 = new com.badlogic.gdx.utils.SerializationException
            java.lang.StringBuilder r4 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r5)
            java.lang.String r5 = r13.getName()
            r4.append(r5)
            r4.append(r6)
            java.lang.String r2 = r2.getName()
            r4.append(r2)
            r4.append(r7)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2, r0)
            throw r3
        L_0x01ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.Json.writeFields(java.lang.Object):void");
    }

    public void writeObjectEnd() {
        try {
            this.writer.pop();
        } catch (IOException e2) {
            throw new SerializationException((Throwable) e2);
        }
    }

    public void writeObjectStart(Class cls, Class cls2) {
        try {
            JsonWriter jsonWriter = this.writer;
            jsonWriter.requireCommaOrName();
            Array<JsonObject> array = jsonWriter.stack;
            JsonObject jsonObject = new JsonObject(false);
            jsonWriter.current = jsonObject;
            array.add(jsonObject);
            if ((cls2 == null || cls2 != cls) && this.typeName != null) {
                String str = (String) this.classToTag.get(cls);
                if (str == null) {
                    str = cls.getName();
                }
                try {
                    JsonWriter jsonWriter2 = this.writer;
                    jsonWriter2.name(this.typeName);
                    jsonWriter2.value(str);
                } catch (IOException e2) {
                    throw new SerializationException((Throwable) e2);
                }
            }
        } catch (IOException e3) {
            throw new SerializationException((Throwable) e3);
        }
    }

    public void writeValue(String str, Object obj) {
        try {
            this.writer.name(str);
            if (obj == null) {
                writeValue(obj, (Class) null, (Class) null);
            } else {
                writeValue(obj, (Class) obj.getClass(), (Class) null);
            }
        } catch (IOException e2) {
            throw new SerializationException((Throwable) e2);
        }
    }

    public final String convertToString(Object obj) {
        if (obj instanceof Enum) {
            return convertToString((Enum) obj);
        }
        if (obj instanceof Class) {
            return ((Class) obj).getName();
        }
        return String.valueOf(obj);
    }

    public <T> T readValue(String str, Class<T> cls, Class cls2, JsonValue jsonValue) {
        return readValue(cls, cls2, jsonValue.get(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:279:0x04d6, code lost:
        if (r12 != r8) goto L_0x04e1;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<T>, code=java.lang.Class, for r20v0, types: [java.lang.Class, java.lang.Class<T>] */
    /* JADX WARNING: Removed duplicated region for block: B:286:0x04f1  */
    /* JADX WARNING: Removed duplicated region for block: B:287:0x04f3  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x04f6  */
    /* JADX WARNING: Removed duplicated region for block: B:353:0x05a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T readValue(java.lang.Class r20, java.lang.Class r21, com.badlogic.gdx.utils.JsonValue r22) {
        /*
            r19 = this;
            r1 = r19
            r0 = r21
            r2 = r22
            java.lang.Class<java.lang.Character> r3 = java.lang.Character.class
            java.lang.Class<java.lang.Byte> r4 = java.lang.Byte.class
            java.lang.Class<java.lang.Short> r5 = java.lang.Short.class
            java.lang.Class<java.lang.Double> r6 = java.lang.Double.class
            java.lang.Class<java.lang.Long> r7 = java.lang.Long.class
            java.lang.Class<java.lang.Boolean> r8 = java.lang.Boolean.class
            java.lang.Class<java.lang.String> r9 = java.lang.String.class
            java.lang.Class<java.lang.Integer> r10 = java.lang.Integer.class
            java.lang.Class<java.lang.Float> r11 = java.lang.Float.class
            r12 = 0
            if (r2 != 0) goto L_0x001c
            return r12
        L_0x001c:
            boolean r12 = r22.isObject()
            java.lang.String r13 = ")"
            java.lang.String r14 = " ("
            if (r12 == 0) goto L_0x0307
            java.lang.String r12 = r1.typeName
            if (r12 != 0) goto L_0x002c
            r12 = 0
            goto L_0x0031
        L_0x002c:
            r15 = 0
            java.lang.String r12 = r2.getString(r12, r15)
        L_0x0031:
            if (r12 == 0) goto L_0x004c
            com.badlogic.gdx.utils.ObjectMap<java.lang.String, java.lang.Class> r15 = r1.tagToClass
            java.lang.Object r15 = r15.get(r12)
            java.lang.Class r15 = (java.lang.Class) r15
            if (r15 != 0) goto L_0x004a
            java.lang.Class r12 = co.hyperverge.hypersnapsdk.c.k.forName(r12)     // Catch:{ ReflectionException -> 0x0042 }
            goto L_0x004e
        L_0x0042:
            r0 = move-exception
            r2 = r0
            com.badlogic.gdx.utils.SerializationException r0 = new com.badlogic.gdx.utils.SerializationException
            r0.<init>(r2)
            throw r0
        L_0x004a:
            r12 = r15
            goto L_0x004e
        L_0x004c:
            r12 = r20
        L_0x004e:
            if (r12 != 0) goto L_0x0051
            return r2
        L_0x0051:
            java.lang.String r15 = r1.typeName
            if (r15 == 0) goto L_0x0081
            java.lang.Class<java.util.Collection> r15 = java.util.Collection.class
            boolean r15 = r15.isAssignableFrom(r12)
            if (r15 == 0) goto L_0x0081
            java.lang.String r15 = "items"
            com.badlogic.gdx.utils.JsonValue r2 = r2.get(r15)
            if (r2 == 0) goto L_0x0067
            goto L_0x0309
        L_0x0067:
            com.badlogic.gdx.utils.SerializationException r0 = new com.badlogic.gdx.utils.SerializationException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Unable to convert object to collection: "
            r3.append(r4)
            r3.append(r2)
            r3.append(r14)
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline36(r12, r3, r13)
            r0.<init>(r2)
            throw r0
        L_0x0081:
            com.badlogic.gdx.utils.ObjectMap<java.lang.Class, com.badlogic.gdx.utils.Json$Serializer> r15 = r1.classToSerializer
            java.lang.Object r15 = r15.get(r12)
            com.badlogic.gdx.utils.Json$Serializer r15 = (com.badlogic.gdx.utils.Json.Serializer) r15
            if (r15 == 0) goto L_0x0090
            java.lang.Object r0 = r15.read(r1, r2, r12)
            return r0
        L_0x0090:
            if (r12 == r9) goto L_0x0300
            if (r12 == r10) goto L_0x0300
            if (r12 == r8) goto L_0x0300
            if (r12 == r11) goto L_0x0300
            if (r12 == r7) goto L_0x0300
            if (r12 == r6) goto L_0x0300
            if (r12 == r5) goto L_0x0300
            if (r12 == r4) goto L_0x0300
            if (r12 == r3) goto L_0x0300
            java.lang.Class<java.lang.Enum> r3 = java.lang.Enum.class
            boolean r3 = r3.isAssignableFrom(r12)
            if (r3 == 0) goto L_0x00ac
            goto L_0x0300
        L_0x00ac:
            java.lang.Object r3 = r1.newInstance(r12)
            boolean r4 = r3 instanceof com.badlogic.gdx.utils.Json.Serializable
            if (r4 == 0) goto L_0x00bb
            r0 = r3
            com.badlogic.gdx.utils.Json$Serializable r0 = (com.badlogic.gdx.utils.Json.Serializable) r0
            r0.read(r1, r2)
            return r3
        L_0x00bb:
            boolean r4 = r3 instanceof com.badlogic.gdx.utils.ObjectMap
            if (r4 == 0) goto L_0x00d3
            com.badlogic.gdx.utils.ObjectMap r3 = (com.badlogic.gdx.utils.ObjectMap) r3
            com.badlogic.gdx.utils.JsonValue r2 = r2.child
        L_0x00c3:
            if (r2 == 0) goto L_0x00d2
            java.lang.String r4 = r2.name
            r5 = 0
            java.lang.Object r5 = r1.readValue(r0, r5, r2)
            r3.put(r4, r5)
            com.badlogic.gdx.utils.JsonValue r2 = r2.next
            goto L_0x00c3
        L_0x00d2:
            return r3
        L_0x00d3:
            boolean r4 = r3 instanceof com.badlogic.gdx.utils.ObjectIntMap
            if (r4 == 0) goto L_0x00f1
            com.badlogic.gdx.utils.ObjectIntMap r3 = (com.badlogic.gdx.utils.ObjectIntMap) r3
            com.badlogic.gdx.utils.JsonValue r0 = r2.child
        L_0x00db:
            if (r0 == 0) goto L_0x00f0
            java.lang.String r2 = r0.name
            r4 = 0
            java.lang.Object r4 = r1.readValue(r10, r4, r0)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            r3.put(r2, r4)
            com.badlogic.gdx.utils.JsonValue r0 = r0.next
            goto L_0x00db
        L_0x00f0:
            return r3
        L_0x00f1:
            boolean r4 = r3 instanceof com.badlogic.gdx.utils.ObjectFloatMap
            if (r4 == 0) goto L_0x0176
            com.badlogic.gdx.utils.ObjectFloatMap r3 = (com.badlogic.gdx.utils.ObjectFloatMap) r3
            com.badlogic.gdx.utils.JsonValue r0 = r2.child
        L_0x00f9:
            if (r0 == 0) goto L_0x0175
            java.lang.String r2 = r0.name
            r4 = 0
            java.lang.Object r4 = r1.readValue(r11, r4, r0)
            java.lang.Float r4 = (java.lang.Float) r4
            float r4 = r4.floatValue()
            int r5 = r3.locateKey(r2)
            if (r5 < 0) goto L_0x0113
            float[] r2 = r3.valueTable
            r2[r5] = r4
            goto L_0x0172
        L_0x0113:
            int r5 = r5 + 1
            int r5 = -r5
            K[] r6 = r3.keyTable
            r6[r5] = r2
            float[] r2 = r3.valueTable
            r2[r5] = r4
            int r2 = r3.size
            int r2 = r2 + 1
            r3.size = r2
            int r4 = r3.threshold
            if (r2 < r4) goto L_0x0172
            int r2 = r6.length
            int r2 = r2 << 1
            int r4 = r6.length
            float r5 = (float) r2
            float r6 = r3.loadFactor
            float r5 = r5 * r6
            int r5 = (int) r5
            r3.threshold = r5
            int r5 = r2 + -1
            r3.mask = r5
            long r5 = (long) r5
            int r5 = java.lang.Long.numberOfLeadingZeros(r5)
            r3.shift = r5
            K[] r5 = r3.keyTable
            float[] r6 = r3.valueTable
            java.lang.Object[] r7 = new java.lang.Object[r2]
            r3.keyTable = r7
            float[] r2 = new float[r2]
            r3.valueTable = r2
            int r2 = r3.size
            if (r2 <= 0) goto L_0x0172
            r2 = 0
        L_0x0150:
            if (r2 >= r4) goto L_0x0172
            r7 = r5[r2]
            if (r7 == 0) goto L_0x016f
            r8 = r6[r2]
            K[] r9 = r3.keyTable
            int r10 = r3.place(r7)
        L_0x015e:
            r12 = r9[r10]
            if (r12 != 0) goto L_0x0169
            r9[r10] = r7
            float[] r7 = r3.valueTable
            r7[r10] = r8
            goto L_0x016f
        L_0x0169:
            int r10 = r10 + 1
            int r12 = r3.mask
            r10 = r10 & r12
            goto L_0x015e
        L_0x016f:
            int r2 = r2 + 1
            goto L_0x0150
        L_0x0172:
            com.badlogic.gdx.utils.JsonValue r0 = r0.next
            goto L_0x00f9
        L_0x0175:
            return r3
        L_0x0176:
            boolean r4 = r3 instanceof com.badlogic.gdx.utils.ObjectSet
            java.lang.String r5 = "values"
            if (r4 == 0) goto L_0x0196
            com.badlogic.gdx.utils.ObjectSet r3 = (com.badlogic.gdx.utils.ObjectSet) r3
            com.badlogic.gdx.utils.JsonValue r2 = r2.get(r5)
            if (r2 != 0) goto L_0x0186
            r2 = 0
            goto L_0x0188
        L_0x0186:
            com.badlogic.gdx.utils.JsonValue r2 = r2.child
        L_0x0188:
            if (r2 == 0) goto L_0x0195
            r4 = 0
            java.lang.Object r4 = r1.readValue(r0, r4, r2)
            r3.add(r4)
            com.badlogic.gdx.utils.JsonValue r2 = r2.next
            goto L_0x0188
        L_0x0195:
            return r3
        L_0x0196:
            boolean r4 = r3 instanceof com.badlogic.gdx.utils.IntMap
            if (r4 == 0) goto L_0x01b2
            com.badlogic.gdx.utils.IntMap r3 = (com.badlogic.gdx.utils.IntMap) r3
            com.badlogic.gdx.utils.JsonValue r2 = r2.child
        L_0x019e:
            if (r2 == 0) goto L_0x01b1
            java.lang.String r4 = r2.name
            int r4 = java.lang.Integer.parseInt(r4)
            r5 = 0
            java.lang.Object r5 = r1.readValue(r0, r5, r2)
            r3.put(r4, r5)
            com.badlogic.gdx.utils.JsonValue r2 = r2.next
            goto L_0x019e
        L_0x01b1:
            return r3
        L_0x01b2:
            boolean r4 = r3 instanceof com.badlogic.gdx.utils.LongMap
            if (r4 == 0) goto L_0x01ce
            com.badlogic.gdx.utils.LongMap r3 = (com.badlogic.gdx.utils.LongMap) r3
            com.badlogic.gdx.utils.JsonValue r2 = r2.child
        L_0x01ba:
            if (r2 == 0) goto L_0x01cd
            java.lang.String r4 = r2.name
            long r4 = java.lang.Long.parseLong(r4)
            r6 = 0
            java.lang.Object r6 = r1.readValue(r0, r6, r2)
            r3.put(r4, r6)
            com.badlogic.gdx.utils.JsonValue r2 = r2.next
            goto L_0x01ba
        L_0x01cd:
            return r3
        L_0x01ce:
            boolean r4 = r3 instanceof com.badlogic.gdx.utils.IntSet
            if (r4 == 0) goto L_0x01eb
            com.badlogic.gdx.utils.IntSet r3 = (com.badlogic.gdx.utils.IntSet) r3
            com.badlogic.gdx.utils.JsonValue r0 = r2.get(r5)
            if (r0 != 0) goto L_0x01dc
            r0 = 0
            goto L_0x01de
        L_0x01dc:
            com.badlogic.gdx.utils.JsonValue r0 = r0.child
        L_0x01de:
            if (r0 == 0) goto L_0x01ea
            int r2 = r0.asInt()
            r3.add(r2)
            com.badlogic.gdx.utils.JsonValue r0 = r0.next
            goto L_0x01de
        L_0x01ea:
            return r3
        L_0x01eb:
            boolean r4 = r3 instanceof com.badlogic.gdx.utils.ArrayMap
            if (r4 == 0) goto L_0x0203
            com.badlogic.gdx.utils.ArrayMap r3 = (com.badlogic.gdx.utils.ArrayMap) r3
            com.badlogic.gdx.utils.JsonValue r2 = r2.child
        L_0x01f3:
            if (r2 == 0) goto L_0x0202
            java.lang.String r4 = r2.name
            r5 = 0
            java.lang.Object r5 = r1.readValue(r0, r5, r2)
            r3.put(r4, r5)
            com.badlogic.gdx.utils.JsonValue r2 = r2.next
            goto L_0x01f3
        L_0x0202:
            return r3
        L_0x0203:
            boolean r4 = r3 instanceof java.util.Map
            if (r4 == 0) goto L_0x0226
            java.util.Map r3 = (java.util.Map) r3
            com.badlogic.gdx.utils.JsonValue r2 = r2.child
        L_0x020b:
            if (r2 == 0) goto L_0x0225
            java.lang.String r4 = r2.name
            java.lang.String r5 = r1.typeName
            boolean r4 = r4.equals(r5)
            if (r4 == 0) goto L_0x0218
            goto L_0x0222
        L_0x0218:
            java.lang.String r4 = r2.name
            r5 = 0
            java.lang.Object r5 = r1.readValue(r0, r5, r2)
            r3.put(r4, r5)
        L_0x0222:
            com.badlogic.gdx.utils.JsonValue r2 = r2.next
            goto L_0x020b
        L_0x0225:
            return r3
        L_0x0226:
            java.lang.Class r4 = r3.getClass()
            com.badlogic.gdx.utils.OrderedMap r0 = r1.getFields(r4)
            com.badlogic.gdx.utils.JsonValue r2 = r2.child
        L_0x0230:
            if (r2 == 0) goto L_0x02ff
            java.lang.String r5 = r2.name
            java.lang.String r6 = " "
            java.lang.String r7 = "_"
            java.lang.String r5 = r5.replace(r6, r7)
            java.lang.Object r5 = r0.get(r5)
            com.badlogic.gdx.utils.Json$FieldMetadata r5 = (com.badlogic.gdx.utils.Json.FieldMetadata) r5
            if (r5 != 0) goto L_0x0278
            java.lang.String r5 = r2.name
            java.lang.String r6 = r1.typeName
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x024f
            goto L_0x0287
        L_0x024f:
            com.badlogic.gdx.utils.SerializationException r0 = new com.badlogic.gdx.utils.SerializationException
            java.lang.String r3 = "Field not found: "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r5 = r2.name
            r3.append(r5)
            r3.append(r14)
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            r3.append(r13)
            java.lang.String r3 = r3.toString()
            r0.<init>(r3)
            java.lang.String r2 = r2.trace()
            r0.addTrace(r2)
            throw r0
        L_0x0278:
            com.badlogic.gdx.utils.reflect.Field r6 = r5.field
            java.lang.Class r7 = r6.getType()     // Catch:{ ReflectionException -> 0x02da, SerializationException -> 0x02b8, RuntimeException -> 0x028a }
            java.lang.Class r5 = r5.elementType     // Catch:{ ReflectionException -> 0x02da, SerializationException -> 0x02b8, RuntimeException -> 0x028a }
            java.lang.Object r5 = r1.readValue(r7, r5, r2)     // Catch:{ ReflectionException -> 0x02da, SerializationException -> 0x02b8, RuntimeException -> 0x028a }
            r6.set(r3, r5)     // Catch:{ ReflectionException -> 0x02da, SerializationException -> 0x02b8, RuntimeException -> 0x028a }
        L_0x0287:
            com.badlogic.gdx.utils.JsonValue r2 = r2.next
            goto L_0x0230
        L_0x028a:
            r0 = move-exception
            com.badlogic.gdx.utils.SerializationException r3 = new com.badlogic.gdx.utils.SerializationException
            r3.<init>(r0)
            java.lang.String r0 = r2.trace()
            r3.addTrace(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r6.getName()
            r0.append(r2)
            r0.append(r14)
            java.lang.String r2 = r4.getName()
            r0.append(r2)
            r0.append(r13)
            java.lang.String r0 = r0.toString()
            r3.addTrace(r0)
            throw r3
        L_0x02b8:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r6.getName()
            r2.append(r3)
            r2.append(r14)
            java.lang.String r3 = r4.getName()
            r2.append(r3)
            r2.append(r13)
            java.lang.String r2 = r2.toString()
            r0.addTrace(r2)
            throw r0
        L_0x02da:
            r0 = move-exception
            com.badlogic.gdx.utils.SerializationException r2 = new com.badlogic.gdx.utils.SerializationException
            java.lang.String r3 = "Error accessing field: "
            java.lang.StringBuilder r3 = com.android.tools.r8.GeneratedOutlineSupport.outline73(r3)
            java.lang.String r5 = r6.getName()
            r3.append(r5)
            r3.append(r14)
            java.lang.String r4 = r4.getName()
            r3.append(r4)
            r3.append(r13)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3, r0)
            throw r2
        L_0x02ff:
            return r3
        L_0x0300:
            java.lang.String r0 = "value"
            java.lang.Object r0 = r1.readValue(r0, r12, r2)
            return r0
        L_0x0307:
            r12 = r20
        L_0x0309:
            if (r12 == 0) goto L_0x032d
            com.badlogic.gdx.utils.ObjectMap<java.lang.Class, com.badlogic.gdx.utils.Json$Serializer> r15 = r1.classToSerializer
            java.lang.Object r15 = r15.get(r12)
            com.badlogic.gdx.utils.Json$Serializer r15 = (com.badlogic.gdx.utils.Json.Serializer) r15
            if (r15 == 0) goto L_0x031a
            java.lang.Object r0 = r15.read(r1, r2, r12)
            return r0
        L_0x031a:
            java.lang.Class<com.badlogic.gdx.utils.Json$Serializable> r15 = com.badlogic.gdx.utils.Json.Serializable.class
            boolean r15 = r15.isAssignableFrom(r12)
            if (r15 == 0) goto L_0x032d
            java.lang.Object r0 = r1.newInstance(r12)
            r3 = r0
            com.badlogic.gdx.utils.Json$Serializable r3 = (com.badlogic.gdx.utils.Json.Serializable) r3
            r3.read(r1, r2)
            return r0
        L_0x032d:
            boolean r15 = r2.isArray()
            r16 = r3
            java.lang.String r3 = "Unable to convert value to required type: "
            if (r15 == 0) goto L_0x0443
            if (r12 == 0) goto L_0x033d
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            if (r12 != r4) goto L_0x033f
        L_0x033d:
            java.lang.Class<com.badlogic.gdx.utils.Array> r12 = com.badlogic.gdx.utils.Array.class
        L_0x033f:
            java.lang.Class<com.badlogic.gdx.utils.Array> r4 = com.badlogic.gdx.utils.Array.class
            boolean r4 = r4.isAssignableFrom(r12)
            if (r4 == 0) goto L_0x0367
            java.lang.Class<com.badlogic.gdx.utils.Array> r3 = com.badlogic.gdx.utils.Array.class
            if (r12 != r3) goto L_0x0351
            com.badlogic.gdx.utils.Array r3 = new com.badlogic.gdx.utils.Array
            r3.<init>()
            goto L_0x0357
        L_0x0351:
            java.lang.Object r3 = r1.newInstance(r12)
            com.badlogic.gdx.utils.Array r3 = (com.badlogic.gdx.utils.Array) r3
        L_0x0357:
            com.badlogic.gdx.utils.JsonValue r2 = r2.child
        L_0x0359:
            if (r2 == 0) goto L_0x0366
            r4 = 0
            java.lang.Object r4 = r1.readValue(r0, r4, r2)
            r3.add(r4)
            com.badlogic.gdx.utils.JsonValue r2 = r2.next
            goto L_0x0359
        L_0x0366:
            return r3
        L_0x0367:
            java.lang.Class<com.badlogic.gdx.utils.Queue> r4 = com.badlogic.gdx.utils.Queue.class
            boolean r4 = r4.isAssignableFrom(r12)
            if (r4 == 0) goto L_0x03da
            java.lang.Class<com.badlogic.gdx.utils.Queue> r3 = com.badlogic.gdx.utils.Queue.class
            if (r12 != r3) goto L_0x0379
            com.badlogic.gdx.utils.Queue r3 = new com.badlogic.gdx.utils.Queue
            r3.<init>()
            goto L_0x037f
        L_0x0379:
            java.lang.Object r3 = r1.newInstance(r12)
            com.badlogic.gdx.utils.Queue r3 = (com.badlogic.gdx.utils.Queue) r3
        L_0x037f:
            com.badlogic.gdx.utils.JsonValue r2 = r2.child
        L_0x0381:
            if (r2 == 0) goto L_0x03d9
            r4 = 0
            java.lang.Object r4 = r1.readValue(r0, r4, r2)
            T[] r5 = r3.values
            int r6 = r3.size
            int r7 = r5.length
            if (r6 != r7) goto L_0x03c2
            int r6 = r5.length
            int r6 = r6 << 1
            int r7 = r3.head
            int r8 = r3.tail
            java.lang.Class r9 = r5.getClass()
            java.lang.Class r9 = r9.getComponentType()
            java.lang.Object r6 = java.lang.reflect.Array.newInstance(r9, r6)
            java.lang.Object[] r6 = (java.lang.Object[]) r6
            if (r7 >= r8) goto L_0x03ac
            int r8 = r8 - r7
            r9 = 0
            java.lang.System.arraycopy(r5, r7, r6, r9, r8)
            goto L_0x03b9
        L_0x03ac:
            r9 = 0
            int r10 = r3.size
            if (r10 <= 0) goto L_0x03b9
            int r10 = r5.length
            int r10 = r10 - r7
            java.lang.System.arraycopy(r5, r7, r6, r9, r10)
            java.lang.System.arraycopy(r5, r9, r6, r10, r8)
        L_0x03b9:
            r3.values = r6
            r3.head = r9
            int r5 = r3.size
            r3.tail = r5
            r5 = r6
        L_0x03c2:
            int r6 = r3.tail
            int r7 = r6 + 1
            r3.tail = r7
            r5[r6] = r4
            int r4 = r5.length
            if (r7 != r4) goto L_0x03d0
            r4 = 0
            r3.tail = r4
        L_0x03d0:
            int r4 = r3.size
            int r4 = r4 + 1
            r3.size = r4
            com.badlogic.gdx.utils.JsonValue r2 = r2.next
            goto L_0x0381
        L_0x03d9:
            return r3
        L_0x03da:
            java.lang.Class<java.util.Collection> r4 = java.util.Collection.class
            boolean r4 = r4.isAssignableFrom(r12)
            if (r4 == 0) goto L_0x0404
            boolean r3 = r12.isInterface()
            if (r3 == 0) goto L_0x03ee
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            goto L_0x03f4
        L_0x03ee:
            java.lang.Object r3 = r1.newInstance(r12)
            java.util.Collection r3 = (java.util.Collection) r3
        L_0x03f4:
            com.badlogic.gdx.utils.JsonValue r2 = r2.child
        L_0x03f6:
            if (r2 == 0) goto L_0x0403
            r4 = 0
            java.lang.Object r4 = r1.readValue(r0, r4, r2)
            r3.add(r4)
            com.badlogic.gdx.utils.JsonValue r2 = r2.next
            goto L_0x03f6
        L_0x0403:
            return r3
        L_0x0404:
            boolean r4 = r12.isArray()
            if (r4 == 0) goto L_0x042b
            java.lang.Class r3 = r12.getComponentType()
            if (r0 != 0) goto L_0x0411
            r0 = r3
        L_0x0411:
            int r4 = r2.size
            java.lang.Object r3 = java.lang.reflect.Array.newInstance(r3, r4)
            com.badlogic.gdx.utils.JsonValue r2 = r2.child
            r4 = 0
        L_0x041a:
            if (r2 == 0) goto L_0x042a
            int r5 = r4 + 1
            r6 = 0
            java.lang.Object r6 = r1.readValue(r0, r6, r2)
            java.lang.reflect.Array.set(r3, r4, r6)
            com.badlogic.gdx.utils.JsonValue r2 = r2.next
            r4 = r5
            goto L_0x041a
        L_0x042a:
            return r3
        L_0x042b:
            com.badlogic.gdx.utils.SerializationException r0 = new com.badlogic.gdx.utils.SerializationException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r2)
            r4.append(r14)
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline36(r12, r4, r13)
            r0.<init>(r2)
            throw r0
        L_0x0443:
            com.badlogic.gdx.utils.JsonValue$ValueType r0 = r2.type
            com.badlogic.gdx.utils.JsonValue$ValueType r15 = com.badlogic.gdx.utils.JsonValue.ValueType.doubleValue
            if (r0 == r15) goto L_0x0450
            com.badlogic.gdx.utils.JsonValue$ValueType r15 = com.badlogic.gdx.utils.JsonValue.ValueType.longValue
            if (r0 != r15) goto L_0x044e
            goto L_0x0450
        L_0x044e:
            r0 = 0
            goto L_0x0451
        L_0x0450:
            r0 = 1
        L_0x0451:
            if (r0 == 0) goto L_0x04c5
            if (r12 == 0) goto L_0x04b2
            java.lang.Class r0 = java.lang.Float.TYPE     // Catch:{ NumberFormatException -> 0x04bb }
            if (r12 == r0) goto L_0x04b2
            if (r12 != r11) goto L_0x045c
            goto L_0x04b2
        L_0x045c:
            java.lang.Class r0 = java.lang.Integer.TYPE     // Catch:{ NumberFormatException -> 0x04bb }
            if (r12 == r0) goto L_0x04a9
            if (r12 != r10) goto L_0x0463
            goto L_0x04a9
        L_0x0463:
            java.lang.Class r0 = java.lang.Long.TYPE     // Catch:{ NumberFormatException -> 0x04bb }
            if (r12 == r0) goto L_0x04a0
            if (r12 != r7) goto L_0x046a
            goto L_0x04a0
        L_0x046a:
            java.lang.Class r0 = java.lang.Double.TYPE     // Catch:{ NumberFormatException -> 0x04bb }
            if (r12 == r0) goto L_0x0497
            if (r12 != r6) goto L_0x0471
            goto L_0x0497
        L_0x0471:
            if (r12 != r9) goto L_0x0478
            java.lang.String r0 = r2.asString()     // Catch:{ NumberFormatException -> 0x04bb }
            return r0
        L_0x0478:
            java.lang.Class r0 = java.lang.Short.TYPE     // Catch:{ NumberFormatException -> 0x04bb }
            if (r12 == r0) goto L_0x048e
            if (r12 != r5) goto L_0x047f
            goto L_0x048e
        L_0x047f:
            java.lang.Class r0 = java.lang.Byte.TYPE     // Catch:{ NumberFormatException -> 0x04bb }
            if (r12 == r0) goto L_0x0485
            if (r12 != r4) goto L_0x04bb
        L_0x0485:
            byte r0 = r2.asByte()     // Catch:{ NumberFormatException -> 0x04bb }
            java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ NumberFormatException -> 0x04bb }
            return r0
        L_0x048e:
            short r0 = r2.asShort()     // Catch:{ NumberFormatException -> 0x04bb }
            java.lang.Short r0 = java.lang.Short.valueOf(r0)     // Catch:{ NumberFormatException -> 0x04bb }
            return r0
        L_0x0497:
            double r17 = r2.asDouble()     // Catch:{ NumberFormatException -> 0x04bb }
            java.lang.Double r0 = java.lang.Double.valueOf(r17)     // Catch:{ NumberFormatException -> 0x04bb }
            return r0
        L_0x04a0:
            long r17 = r2.asLong()     // Catch:{ NumberFormatException -> 0x04bb }
            java.lang.Long r0 = java.lang.Long.valueOf(r17)     // Catch:{ NumberFormatException -> 0x04bb }
            return r0
        L_0x04a9:
            int r0 = r2.asInt()     // Catch:{ NumberFormatException -> 0x04bb }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x04bb }
            return r0
        L_0x04b2:
            float r0 = r2.asFloat()     // Catch:{ NumberFormatException -> 0x04bb }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ NumberFormatException -> 0x04bb }
            return r0
        L_0x04bb:
            com.badlogic.gdx.utils.JsonValue r0 = new com.badlogic.gdx.utils.JsonValue
            java.lang.String r2 = r2.asString()
            r0.<init>(r2)
            r2 = r0
        L_0x04c5:
            com.badlogic.gdx.utils.JsonValue$ValueType r0 = r2.type
            com.badlogic.gdx.utils.JsonValue$ValueType r15 = com.badlogic.gdx.utils.JsonValue.ValueType.booleanValue
            if (r0 != r15) goto L_0x04cd
            r0 = 1
            goto L_0x04ce
        L_0x04cd:
            r0 = 0
        L_0x04ce:
            if (r0 == 0) goto L_0x04eb
            if (r12 == 0) goto L_0x04d8
            java.lang.Class r0 = java.lang.Boolean.TYPE     // Catch:{ NumberFormatException -> 0x04e1 }
            if (r12 == r0) goto L_0x04d8
            if (r12 != r8) goto L_0x04e1
        L_0x04d8:
            boolean r0 = r2.asBoolean()     // Catch:{ NumberFormatException -> 0x04e1 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ NumberFormatException -> 0x04e1 }
            return r0
        L_0x04e1:
            com.badlogic.gdx.utils.JsonValue r0 = new com.badlogic.gdx.utils.JsonValue
            java.lang.String r2 = r2.asString()
            r0.<init>(r2)
            r2 = r0
        L_0x04eb:
            com.badlogic.gdx.utils.JsonValue$ValueType r0 = r2.type
            com.badlogic.gdx.utils.JsonValue$ValueType r15 = com.badlogic.gdx.utils.JsonValue.ValueType.stringValue
            if (r0 != r15) goto L_0x04f3
            r15 = 1
            goto L_0x04f4
        L_0x04f3:
            r15 = 0
        L_0x04f4:
            if (r15 == 0) goto L_0x05a6
            java.lang.String r0 = r2.asString()
            if (r12 == 0) goto L_0x05a5
            if (r12 != r9) goto L_0x0500
            goto L_0x05a5
        L_0x0500:
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ NumberFormatException -> 0x0547 }
            if (r12 == r9) goto L_0x0542
            if (r12 != r10) goto L_0x0507
            goto L_0x0542
        L_0x0507:
            java.lang.Class r9 = java.lang.Float.TYPE     // Catch:{ NumberFormatException -> 0x0547 }
            if (r12 == r9) goto L_0x053d
            if (r12 != r11) goto L_0x050e
            goto L_0x053d
        L_0x050e:
            java.lang.Class r9 = java.lang.Long.TYPE     // Catch:{ NumberFormatException -> 0x0547 }
            if (r12 == r9) goto L_0x0538
            if (r12 != r7) goto L_0x0515
            goto L_0x0538
        L_0x0515:
            java.lang.Class r7 = java.lang.Double.TYPE     // Catch:{ NumberFormatException -> 0x0547 }
            if (r12 == r7) goto L_0x0533
            if (r12 != r6) goto L_0x051c
            goto L_0x0533
        L_0x051c:
            java.lang.Class r6 = java.lang.Short.TYPE     // Catch:{ NumberFormatException -> 0x0547 }
            if (r12 == r6) goto L_0x052e
            if (r12 != r5) goto L_0x0523
            goto L_0x052e
        L_0x0523:
            java.lang.Class r5 = java.lang.Byte.TYPE     // Catch:{ NumberFormatException -> 0x0547 }
            if (r12 == r5) goto L_0x0529
            if (r12 != r4) goto L_0x0548
        L_0x0529:
            java.lang.Byte r0 = java.lang.Byte.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0547 }
            return r0
        L_0x052e:
            java.lang.Short r0 = java.lang.Short.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0547 }
            return r0
        L_0x0533:
            java.lang.Double r0 = java.lang.Double.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0547 }
            return r0
        L_0x0538:
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0547 }
            return r0
        L_0x053d:
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0547 }
            return r0
        L_0x0542:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0547 }
            return r0
        L_0x0547:
        L_0x0548:
            java.lang.Class r4 = java.lang.Boolean.TYPE
            if (r12 == r4) goto L_0x05a1
            if (r12 != r8) goto L_0x054f
            goto L_0x05a1
        L_0x054f:
            java.lang.Class r4 = java.lang.Character.TYPE
            if (r12 == r4) goto L_0x0597
            r4 = r16
            if (r12 != r4) goto L_0x0558
            goto L_0x0597
        L_0x0558:
            java.lang.Class<java.lang.Enum> r4 = java.lang.Enum.class
            boolean r4 = r4.isAssignableFrom(r12)
            if (r4 == 0) goto L_0x057a
            java.lang.Object[] r4 = r12.getEnumConstants()
            java.lang.Enum[] r4 = (java.lang.Enum[]) r4
            int r5 = r4.length
            r6 = 0
        L_0x0568:
            if (r6 >= r5) goto L_0x057a
            r7 = r4[r6]
            java.lang.String r8 = r1.convertToString(r7)
            boolean r8 = r0.equals(r8)
            if (r8 == 0) goto L_0x0577
            return r7
        L_0x0577:
            int r6 = r6 + 1
            goto L_0x0568
        L_0x057a:
            java.lang.Class<java.lang.CharSequence> r4 = java.lang.CharSequence.class
            if (r12 != r4) goto L_0x057f
            return r0
        L_0x057f:
            com.badlogic.gdx.utils.SerializationException r0 = new com.badlogic.gdx.utils.SerializationException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r2)
            r4.append(r14)
            java.lang.String r2 = com.android.tools.r8.GeneratedOutlineSupport.outline36(r12, r4, r13)
            r0.<init>(r2)
            throw r0
        L_0x0597:
            r2 = 0
            char r0 = r0.charAt(r2)
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            return r0
        L_0x05a1:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
        L_0x05a5:
            return r0
        L_0x05a6:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.Json.readValue(java.lang.Class, java.lang.Class, com.badlogic.gdx.utils.JsonValue):java.lang.Object");
    }

    public void writeValue(String str, Object obj, Class cls) {
        try {
            this.writer.name(str);
            writeValue(obj, cls, (Class) null);
        } catch (IOException e2) {
            throw new SerializationException((Throwable) e2);
        }
    }

    public void writeValue(String str, Object obj, Class cls, Class cls2) {
        try {
            this.writer.name(str);
            writeValue(obj, cls, cls2);
        } catch (IOException e2) {
            throw new SerializationException((Throwable) e2);
        }
    }

    /* JADX INFO: used method not loaded: com.badlogic.gdx.utils.SerializationException.<init>(java.lang.Throwable):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x03fd, code lost:
        throw new com.badlogic.gdx.utils.SerializationException((java.lang.Throwable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0023, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x014f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0155, code lost:
        throw new com.badlogic.gdx.utils.SerializationException((java.lang.Throwable) r0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:2:0x001d, B:79:0x011c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeValue(java.lang.Object r17, java.lang.Class r18, java.lang.Class r19) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            r3 = r19
            java.lang.Class<java.lang.Character> r4 = java.lang.Character.class
            java.lang.Class<java.lang.Byte> r5 = java.lang.Byte.class
            java.lang.Class<java.lang.Short> r6 = java.lang.Short.class
            java.lang.Class<java.lang.Double> r7 = java.lang.Double.class
            java.lang.Class<java.lang.Long> r8 = java.lang.Long.class
            java.lang.Class<java.lang.Boolean> r9 = java.lang.Boolean.class
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            java.lang.Class<java.lang.Float> r11 = java.lang.Float.class
            java.lang.Class<java.lang.Integer> r12 = java.lang.Integer.class
            r13 = 0
            if (r0 != 0) goto L_0x0026
            com.badlogic.gdx.utils.JsonWriter r0 = r1.writer     // Catch:{ IOException -> 0x0023 }
            r0.value(r13)     // Catch:{ IOException -> 0x0023 }
            return
        L_0x0023:
            r0 = move-exception
            goto L_0x03f8
        L_0x0026:
            if (r2 == 0) goto L_0x002e
            boolean r14 = r18.isPrimitive()     // Catch:{ IOException -> 0x0023 }
            if (r14 != 0) goto L_0x03f2
        L_0x002e:
            if (r2 == r10) goto L_0x03f2
            if (r2 == r12) goto L_0x03f2
            if (r2 == r9) goto L_0x03f2
            if (r2 == r11) goto L_0x03f2
            if (r2 == r8) goto L_0x03f2
            if (r2 == r7) goto L_0x03f2
            if (r2 == r6) goto L_0x03f2
            if (r2 == r5) goto L_0x03f2
            if (r2 != r4) goto L_0x0042
            goto L_0x03f2
        L_0x0042:
            java.lang.Class r14 = r17.getClass()     // Catch:{ IOException -> 0x0023 }
            boolean r15 = r14.isPrimitive()     // Catch:{ IOException -> 0x0023 }
            java.lang.String r13 = "value"
            if (r15 != 0) goto L_0x03e7
            if (r14 == r10) goto L_0x03e7
            if (r14 == r12) goto L_0x03e7
            if (r14 == r9) goto L_0x03e7
            if (r14 == r11) goto L_0x03e7
            if (r14 == r8) goto L_0x03e7
            if (r14 == r7) goto L_0x03e7
            if (r14 == r6) goto L_0x03e7
            if (r14 == r5) goto L_0x03e7
            if (r14 != r4) goto L_0x0062
            goto L_0x03e7
        L_0x0062:
            boolean r4 = r0 instanceof com.badlogic.gdx.utils.Json.Serializable     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x0072
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.Json$Serializable r0 = (com.badlogic.gdx.utils.Json.Serializable) r0     // Catch:{ IOException -> 0x0023 }
            r0.write(r1)     // Catch:{ IOException -> 0x0023 }
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x0072:
            com.badlogic.gdx.utils.ObjectMap<java.lang.Class, com.badlogic.gdx.utils.Json$Serializer> r4 = r1.classToSerializer     // Catch:{ IOException -> 0x0023 }
            java.lang.Object r4 = r4.get(r14)     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.Json$Serializer r4 = (com.badlogic.gdx.utils.Json.Serializer) r4     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x0080
            r4.write(r1, r0, r2)     // Catch:{ IOException -> 0x0023 }
            return
        L_0x0080:
            boolean r4 = r0 instanceof com.badlogic.gdx.utils.Array     // Catch:{ IOException -> 0x0023 }
            java.lang.String r5 = "\nActual type: "
            r6 = 0
            if (r4 == 0) goto L_0x00c5
            if (r2 == 0) goto L_0x00ad
            if (r14 == r2) goto L_0x00ad
            java.lang.Class<com.badlogic.gdx.utils.Array> r4 = com.badlogic.gdx.utils.Array.class
            if (r14 != r4) goto L_0x0090
            goto L_0x00ad
        L_0x0090:
            com.badlogic.gdx.utils.SerializationException r0 = new com.badlogic.gdx.utils.SerializationException     // Catch:{ IOException -> 0x0023 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0023 }
            r3.<init>()     // Catch:{ IOException -> 0x0023 }
            java.lang.String r4 = "Serialization of an Array other than the known type is not supported.\nKnown type: "
            r3.append(r4)     // Catch:{ IOException -> 0x0023 }
            r3.append(r2)     // Catch:{ IOException -> 0x0023 }
            r3.append(r5)     // Catch:{ IOException -> 0x0023 }
            r3.append(r14)     // Catch:{ IOException -> 0x0023 }
            java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x0023 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0023 }
            throw r0     // Catch:{ IOException -> 0x0023 }
        L_0x00ad:
            r16.writeArrayStart()     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.Array r0 = (com.badlogic.gdx.utils.Array) r0     // Catch:{ IOException -> 0x0023 }
            int r2 = r0.size     // Catch:{ IOException -> 0x0023 }
        L_0x00b4:
            if (r6 >= r2) goto L_0x00c1
            java.lang.Object r4 = r0.get(r6)     // Catch:{ IOException -> 0x0023 }
            r5 = 0
            r1.writeValue(r4, r3, r5)     // Catch:{ IOException -> 0x0023 }
            int r6 = r6 + 1
            goto L_0x00b4
        L_0x00c1:
            r16.writeArrayEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x00c5:
            boolean r4 = r0 instanceof com.badlogic.gdx.utils.Queue     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x0107
            if (r2 == 0) goto L_0x00ef
            if (r14 == r2) goto L_0x00ef
            java.lang.Class<com.badlogic.gdx.utils.Queue> r4 = com.badlogic.gdx.utils.Queue.class
            if (r14 != r4) goto L_0x00d2
            goto L_0x00ef
        L_0x00d2:
            com.badlogic.gdx.utils.SerializationException r0 = new com.badlogic.gdx.utils.SerializationException     // Catch:{ IOException -> 0x0023 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0023 }
            r3.<init>()     // Catch:{ IOException -> 0x0023 }
            java.lang.String r4 = "Serialization of a Queue other than the known type is not supported.\nKnown type: "
            r3.append(r4)     // Catch:{ IOException -> 0x0023 }
            r3.append(r2)     // Catch:{ IOException -> 0x0023 }
            r3.append(r5)     // Catch:{ IOException -> 0x0023 }
            r3.append(r14)     // Catch:{ IOException -> 0x0023 }
            java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x0023 }
            r0.<init>(r2)     // Catch:{ IOException -> 0x0023 }
            throw r0     // Catch:{ IOException -> 0x0023 }
        L_0x00ef:
            r16.writeArrayStart()     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.Queue r0 = (com.badlogic.gdx.utils.Queue) r0     // Catch:{ IOException -> 0x0023 }
            int r2 = r0.size     // Catch:{ IOException -> 0x0023 }
        L_0x00f6:
            if (r6 >= r2) goto L_0x0103
            java.lang.Object r4 = r0.get(r6)     // Catch:{ IOException -> 0x0023 }
            r5 = 0
            r1.writeValue(r4, r3, r5)     // Catch:{ IOException -> 0x0023 }
            int r6 = r6 + 1
            goto L_0x00f6
        L_0x0103:
            r16.writeArrayEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x0107:
            boolean r4 = r0 instanceof java.util.Collection     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x0172
            java.lang.String r4 = r1.typeName     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x0156
            java.lang.Class<java.util.ArrayList> r4 = java.util.ArrayList.class
            if (r14 == r4) goto L_0x0156
            if (r2 == 0) goto L_0x0117
            if (r2 == r14) goto L_0x0156
        L_0x0117:
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            java.lang.String r2 = "items"
            com.badlogic.gdx.utils.JsonWriter r4 = r1.writer     // Catch:{ IOException -> 0x014f }
            r4.name(r2)     // Catch:{ IOException -> 0x014f }
            com.badlogic.gdx.utils.JsonWriter r2 = r1.writer     // Catch:{ IOException -> 0x014f }
            r2.requireCommaOrName()     // Catch:{ IOException -> 0x014f }
            com.badlogic.gdx.utils.Array<com.badlogic.gdx.utils.JsonWriter$JsonObject> r4 = r2.stack     // Catch:{ IOException -> 0x014f }
            com.badlogic.gdx.utils.JsonWriter$JsonObject r5 = new com.badlogic.gdx.utils.JsonWriter$JsonObject     // Catch:{ IOException -> 0x014f }
            r6 = 1
            r5.<init>(r6)     // Catch:{ IOException -> 0x014f }
            r2.current = r5     // Catch:{ IOException -> 0x014f }
            r4.add(r5)     // Catch:{ IOException -> 0x014f }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ IOException -> 0x0023 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x0023 }
        L_0x0139:
            boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x0023 }
            if (r2 == 0) goto L_0x0148
            java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x0023 }
            r4 = 0
            r1.writeValue(r2, r3, r4)     // Catch:{ IOException -> 0x0023 }
            goto L_0x0139
        L_0x0148:
            r16.writeArrayEnd()     // Catch:{ IOException -> 0x0023 }
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0171
        L_0x014f:
            r0 = move-exception
            com.badlogic.gdx.utils.SerializationException r2 = new com.badlogic.gdx.utils.SerializationException     // Catch:{ IOException -> 0x0023 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0023 }
            throw r2     // Catch:{ IOException -> 0x0023 }
        L_0x0156:
            r16.writeArrayStart()     // Catch:{ IOException -> 0x0023 }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ IOException -> 0x0023 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x0023 }
        L_0x015f:
            boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x0023 }
            if (r2 == 0) goto L_0x016e
            java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x0023 }
            r4 = 0
            r1.writeValue(r2, r3, r4)     // Catch:{ IOException -> 0x0023 }
            goto L_0x015f
        L_0x016e:
            r16.writeArrayEnd()     // Catch:{ IOException -> 0x0023 }
        L_0x0171:
            return
        L_0x0172:
            boolean r4 = r14.isArray()     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x0198
            if (r3 != 0) goto L_0x017f
            java.lang.Class r2 = r14.getComponentType()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0180
        L_0x017f:
            r2 = r3
        L_0x0180:
            int r3 = java.lang.reflect.Array.getLength(r17)     // Catch:{ IOException -> 0x0023 }
            r16.writeArrayStart()     // Catch:{ IOException -> 0x0023 }
        L_0x0187:
            if (r6 >= r3) goto L_0x0194
            java.lang.Object r4 = java.lang.reflect.Array.get(r0, r6)     // Catch:{ IOException -> 0x0023 }
            r5 = 0
            r1.writeValue(r4, r2, r5)     // Catch:{ IOException -> 0x0023 }
            int r6 = r6 + 1
            goto L_0x0187
        L_0x0194:
            r16.writeArrayEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x0198:
            boolean r4 = r0 instanceof com.badlogic.gdx.utils.ObjectMap     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x01cf
            if (r2 != 0) goto L_0x01a0
            java.lang.Class<com.badlogic.gdx.utils.ObjectMap> r2 = com.badlogic.gdx.utils.ObjectMap.class
        L_0x01a0:
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.ObjectMap r0 = (com.badlogic.gdx.utils.ObjectMap) r0     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.ObjectMap$Entries r0 = r0.entries()     // Catch:{ IOException -> 0x0023 }
            if (r0 == 0) goto L_0x01cd
        L_0x01ab:
            boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x0023 }
            if (r2 == 0) goto L_0x01c9
            java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.ObjectMap$Entry r2 = (com.badlogic.gdx.utils.ObjectMap.Entry) r2     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.JsonWriter r4 = r1.writer     // Catch:{ IOException -> 0x0023 }
            K r5 = r2.key     // Catch:{ IOException -> 0x0023 }
            java.lang.String r5 = r1.convertToString(r5)     // Catch:{ IOException -> 0x0023 }
            r4.name(r5)     // Catch:{ IOException -> 0x0023 }
            V r2 = r2.value     // Catch:{ IOException -> 0x0023 }
            r4 = 0
            r1.writeValue(r2, r3, r4)     // Catch:{ IOException -> 0x0023 }
            goto L_0x01ab
        L_0x01c9:
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x01cd:
            r0 = 0
            throw r0     // Catch:{ IOException -> 0x0023 }
        L_0x01cf:
            boolean r4 = r0 instanceof com.badlogic.gdx.utils.ObjectIntMap     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x020a
            if (r2 != 0) goto L_0x01d7
            java.lang.Class<com.badlogic.gdx.utils.ObjectIntMap> r2 = com.badlogic.gdx.utils.ObjectIntMap.class
        L_0x01d7:
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.ObjectIntMap r0 = (com.badlogic.gdx.utils.ObjectIntMap) r0     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.ObjectIntMap$Entries r0 = r0.entries()     // Catch:{ IOException -> 0x0023 }
            if (r0 == 0) goto L_0x0208
        L_0x01e2:
            boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x0023 }
            if (r2 == 0) goto L_0x0204
            java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.ObjectIntMap$Entry r2 = (com.badlogic.gdx.utils.ObjectIntMap.Entry) r2     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.JsonWriter r3 = r1.writer     // Catch:{ IOException -> 0x0023 }
            K r4 = r2.key     // Catch:{ IOException -> 0x0023 }
            java.lang.String r4 = r1.convertToString(r4)     // Catch:{ IOException -> 0x0023 }
            r3.name(r4)     // Catch:{ IOException -> 0x0023 }
            int r2 = r2.value     // Catch:{ IOException -> 0x0023 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x0023 }
            r3 = 0
            r1.writeValue(r2, r12, r3)     // Catch:{ IOException -> 0x0023 }
            goto L_0x01e2
        L_0x0204:
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x0208:
            r0 = 0
            throw r0     // Catch:{ IOException -> 0x0023 }
        L_0x020a:
            boolean r4 = r0 instanceof com.badlogic.gdx.utils.ObjectFloatMap     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x0245
            if (r2 != 0) goto L_0x0212
            java.lang.Class<com.badlogic.gdx.utils.ObjectFloatMap> r2 = com.badlogic.gdx.utils.ObjectFloatMap.class
        L_0x0212:
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.ObjectFloatMap r0 = (com.badlogic.gdx.utils.ObjectFloatMap) r0     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.ObjectFloatMap$Entries r0 = r0.entries()     // Catch:{ IOException -> 0x0023 }
            if (r0 == 0) goto L_0x0243
        L_0x021d:
            boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x0023 }
            if (r2 == 0) goto L_0x023f
            java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.ObjectFloatMap$Entry r2 = (com.badlogic.gdx.utils.ObjectFloatMap.Entry) r2     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.JsonWriter r3 = r1.writer     // Catch:{ IOException -> 0x0023 }
            K r4 = r2.key     // Catch:{ IOException -> 0x0023 }
            java.lang.String r4 = r1.convertToString(r4)     // Catch:{ IOException -> 0x0023 }
            r3.name(r4)     // Catch:{ IOException -> 0x0023 }
            float r2 = r2.value     // Catch:{ IOException -> 0x0023 }
            java.lang.Float r2 = java.lang.Float.valueOf(r2)     // Catch:{ IOException -> 0x0023 }
            r3 = 0
            r1.writeValue(r2, r11, r3)     // Catch:{ IOException -> 0x0023 }
            goto L_0x021d
        L_0x023f:
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x0243:
            r0 = 0
            throw r0     // Catch:{ IOException -> 0x0023 }
        L_0x0245:
            boolean r4 = r0 instanceof com.badlogic.gdx.utils.ObjectSet     // Catch:{ IOException -> 0x0023 }
            java.lang.String r5 = "values"
            if (r4 == 0) goto L_0x0276
            if (r2 != 0) goto L_0x024f
            java.lang.Class<com.badlogic.gdx.utils.ObjectSet> r2 = com.badlogic.gdx.utils.ObjectSet.class
        L_0x024f:
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.JsonWriter r2 = r1.writer     // Catch:{ IOException -> 0x0023 }
            r2.name(r5)     // Catch:{ IOException -> 0x0023 }
            r16.writeArrayStart()     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.ObjectSet r0 = (com.badlogic.gdx.utils.ObjectSet) r0     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.ObjectSet$ObjectSetIterator r0 = r0.iterator()     // Catch:{ IOException -> 0x0023 }
        L_0x0260:
            boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x0023 }
            if (r2 == 0) goto L_0x026f
            java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x0023 }
            r4 = 0
            r1.writeValue(r2, r3, r4)     // Catch:{ IOException -> 0x0023 }
            goto L_0x0260
        L_0x026f:
            r16.writeArrayEnd()     // Catch:{ IOException -> 0x0023 }
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x0276:
            boolean r4 = r0 instanceof com.badlogic.gdx.utils.IntMap     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x02ad
            if (r2 != 0) goto L_0x027e
            java.lang.Class<com.badlogic.gdx.utils.IntMap> r2 = com.badlogic.gdx.utils.IntMap.class
        L_0x027e:
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.IntMap r0 = (com.badlogic.gdx.utils.IntMap) r0     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.IntMap$Entries r0 = r0.entries()     // Catch:{ IOException -> 0x0023 }
            if (r0 == 0) goto L_0x02ab
        L_0x0289:
            boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x0023 }
            if (r2 == 0) goto L_0x02a7
            java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.IntMap$Entry r2 = (com.badlogic.gdx.utils.IntMap.Entry) r2     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.JsonWriter r4 = r1.writer     // Catch:{ IOException -> 0x0023 }
            int r5 = r2.key     // Catch:{ IOException -> 0x0023 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ IOException -> 0x0023 }
            r4.name(r5)     // Catch:{ IOException -> 0x0023 }
            V r2 = r2.value     // Catch:{ IOException -> 0x0023 }
            r4 = 0
            r1.writeValue(r2, r3, r4)     // Catch:{ IOException -> 0x0023 }
            goto L_0x0289
        L_0x02a7:
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x02ab:
            r0 = 0
            throw r0     // Catch:{ IOException -> 0x0023 }
        L_0x02ad:
            boolean r4 = r0 instanceof com.badlogic.gdx.utils.LongMap     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x02e4
            if (r2 != 0) goto L_0x02b5
            java.lang.Class<com.badlogic.gdx.utils.LongMap> r2 = com.badlogic.gdx.utils.LongMap.class
        L_0x02b5:
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.LongMap r0 = (com.badlogic.gdx.utils.LongMap) r0     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.LongMap$Entries r0 = r0.entries()     // Catch:{ IOException -> 0x0023 }
            if (r0 == 0) goto L_0x02e2
        L_0x02c0:
            boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x0023 }
            if (r2 == 0) goto L_0x02de
            java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.LongMap$Entry r2 = (com.badlogic.gdx.utils.LongMap.Entry) r2     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.JsonWriter r4 = r1.writer     // Catch:{ IOException -> 0x0023 }
            long r5 = r2.key     // Catch:{ IOException -> 0x0023 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ IOException -> 0x0023 }
            r4.name(r5)     // Catch:{ IOException -> 0x0023 }
            V r2 = r2.value     // Catch:{ IOException -> 0x0023 }
            r4 = 0
            r1.writeValue(r2, r3, r4)     // Catch:{ IOException -> 0x0023 }
            goto L_0x02c0
        L_0x02de:
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x02e2:
            r0 = 0
            throw r0     // Catch:{ IOException -> 0x0023 }
        L_0x02e4:
            boolean r4 = r0 instanceof com.badlogic.gdx.utils.IntSet     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x0337
            if (r2 != 0) goto L_0x02ec
            java.lang.Class<com.badlogic.gdx.utils.IntSet> r2 = com.badlogic.gdx.utils.IntSet.class
        L_0x02ec:
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.JsonWriter r2 = r1.writer     // Catch:{ IOException -> 0x0023 }
            r2.name(r5)     // Catch:{ IOException -> 0x0023 }
            r16.writeArrayStart()     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.IntSet r0 = (com.badlogic.gdx.utils.IntSet) r0     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.IntSet$IntSetIterator r0 = r0.iterator()     // Catch:{ IOException -> 0x0023 }
        L_0x02fd:
            boolean r2 = r0.hasNext     // Catch:{ IOException -> 0x0023 }
            if (r2 == 0) goto L_0x0330
            boolean r2 = r0.hasNext     // Catch:{ IOException -> 0x0023 }
            if (r2 == 0) goto L_0x032a
            boolean r2 = r0.valid     // Catch:{ IOException -> 0x0023 }
            if (r2 == 0) goto L_0x0322
            int r2 = r0.nextIndex     // Catch:{ IOException -> 0x0023 }
            r3 = -1
            if (r2 != r3) goto L_0x0310
            r2 = 0
            goto L_0x0316
        L_0x0310:
            com.badlogic.gdx.utils.IntSet r3 = r0.set     // Catch:{ IOException -> 0x0023 }
            int[] r3 = r3.keyTable     // Catch:{ IOException -> 0x0023 }
            r2 = r3[r2]     // Catch:{ IOException -> 0x0023 }
        L_0x0316:
            r0.findNextIndex()     // Catch:{ IOException -> 0x0023 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x0023 }
            r3 = 0
            r1.writeValue(r2, r12, r3)     // Catch:{ IOException -> 0x0023 }
            goto L_0x02fd
        L_0x0322:
            com.badlogic.gdx.utils.GdxRuntimeException r0 = new com.badlogic.gdx.utils.GdxRuntimeException     // Catch:{ IOException -> 0x0023 }
            java.lang.String r2 = "#iterator() cannot be used nested."
            r0.<init>(r2)     // Catch:{ IOException -> 0x0023 }
            throw r0     // Catch:{ IOException -> 0x0023 }
        L_0x032a:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException     // Catch:{ IOException -> 0x0023 }
            r0.<init>()     // Catch:{ IOException -> 0x0023 }
            throw r0     // Catch:{ IOException -> 0x0023 }
        L_0x0330:
            r16.writeArrayEnd()     // Catch:{ IOException -> 0x0023 }
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x0337:
            boolean r4 = r0 instanceof com.badlogic.gdx.utils.ArrayMap     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x0364
            if (r2 != 0) goto L_0x033f
            java.lang.Class<com.badlogic.gdx.utils.ArrayMap> r2 = com.badlogic.gdx.utils.ArrayMap.class
        L_0x033f:
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.ArrayMap r0 = (com.badlogic.gdx.utils.ArrayMap) r0     // Catch:{ IOException -> 0x0023 }
            int r2 = r0.size     // Catch:{ IOException -> 0x0023 }
        L_0x0346:
            if (r6 >= r2) goto L_0x0360
            com.badlogic.gdx.utils.JsonWriter r4 = r1.writer     // Catch:{ IOException -> 0x0023 }
            K[] r5 = r0.keys     // Catch:{ IOException -> 0x0023 }
            r5 = r5[r6]     // Catch:{ IOException -> 0x0023 }
            java.lang.String r5 = r1.convertToString(r5)     // Catch:{ IOException -> 0x0023 }
            r4.name(r5)     // Catch:{ IOException -> 0x0023 }
            V[] r4 = r0.values     // Catch:{ IOException -> 0x0023 }
            r4 = r4[r6]     // Catch:{ IOException -> 0x0023 }
            r5 = 0
            r1.writeValue(r4, r3, r5)     // Catch:{ IOException -> 0x0023 }
            int r6 = r6 + 1
            goto L_0x0346
        L_0x0360:
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x0364:
            boolean r4 = r0 instanceof java.util.Map     // Catch:{ IOException -> 0x0023 }
            if (r4 == 0) goto L_0x039f
            if (r2 != 0) goto L_0x036c
            java.lang.Class<java.util.HashMap> r2 = java.util.HashMap.class
        L_0x036c:
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ IOException -> 0x0023 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ IOException -> 0x0023 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x0023 }
        L_0x0379:
            boolean r2 = r0.hasNext()     // Catch:{ IOException -> 0x0023 }
            if (r2 == 0) goto L_0x039b
            java.lang.Object r2 = r0.next()     // Catch:{ IOException -> 0x0023 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.JsonWriter r4 = r1.writer     // Catch:{ IOException -> 0x0023 }
            java.lang.Object r5 = r2.getKey()     // Catch:{ IOException -> 0x0023 }
            java.lang.String r5 = r1.convertToString(r5)     // Catch:{ IOException -> 0x0023 }
            r4.name(r5)     // Catch:{ IOException -> 0x0023 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ IOException -> 0x0023 }
            r4 = 0
            r1.writeValue(r2, r3, r4)     // Catch:{ IOException -> 0x0023 }
            goto L_0x0379
        L_0x039b:
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x039f:
            java.lang.Class<java.lang.Enum> r3 = java.lang.Enum.class
            boolean r3 = r3.isAssignableFrom(r14)     // Catch:{ IOException -> 0x0023 }
            if (r3 == 0) goto L_0x03dd
            java.lang.String r3 = r1.typeName     // Catch:{ IOException -> 0x0023 }
            if (r3 == 0) goto L_0x03d1
            if (r2 == 0) goto L_0x03af
            if (r2 == r14) goto L_0x03d1
        L_0x03af:
            java.lang.Object[] r2 = r14.getEnumConstants()     // Catch:{ IOException -> 0x0023 }
            if (r2 != 0) goto L_0x03b9
            java.lang.Class r14 = r14.getSuperclass()     // Catch:{ IOException -> 0x0023 }
        L_0x03b9:
            r2 = 0
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.JsonWriter r2 = r1.writer     // Catch:{ IOException -> 0x0023 }
            r2.name(r13)     // Catch:{ IOException -> 0x0023 }
            com.badlogic.gdx.utils.JsonWriter r2 = r1.writer     // Catch:{ IOException -> 0x0023 }
            java.lang.Enum r0 = (java.lang.Enum) r0     // Catch:{ IOException -> 0x0023 }
            java.lang.String r0 = r1.convertToString(r0)     // Catch:{ IOException -> 0x0023 }
            r2.value(r0)     // Catch:{ IOException -> 0x0023 }
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            goto L_0x03dc
        L_0x03d1:
            com.badlogic.gdx.utils.JsonWriter r2 = r1.writer     // Catch:{ IOException -> 0x0023 }
            java.lang.Enum r0 = (java.lang.Enum) r0     // Catch:{ IOException -> 0x0023 }
            java.lang.String r0 = r1.convertToString(r0)     // Catch:{ IOException -> 0x0023 }
            r2.value(r0)     // Catch:{ IOException -> 0x0023 }
        L_0x03dc:
            return
        L_0x03dd:
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            r16.writeFields(r17)     // Catch:{ IOException -> 0x0023 }
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x03e7:
            r2 = 0
            r1.writeObjectStart(r14, r2)     // Catch:{ IOException -> 0x0023 }
            r1.writeValue(r13, r0)     // Catch:{ IOException -> 0x0023 }
            r16.writeObjectEnd()     // Catch:{ IOException -> 0x0023 }
            return
        L_0x03f2:
            com.badlogic.gdx.utils.JsonWriter r2 = r1.writer     // Catch:{ IOException -> 0x0023 }
            r2.value(r0)     // Catch:{ IOException -> 0x0023 }
            return
        L_0x03f8:
            com.badlogic.gdx.utils.SerializationException r2 = new com.badlogic.gdx.utils.SerializationException
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.utils.Json.writeValue(java.lang.Object, java.lang.Class, java.lang.Class):void");
    }
}
