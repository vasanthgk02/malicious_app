package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public enum FieldType {
    DOUBLE(0, Collection.SCALAR, JavaType.DOUBLE),
    FLOAT(1, Collection.SCALAR, JavaType.FLOAT),
    INT64(2, Collection.SCALAR, JavaType.LONG),
    UINT64(3, Collection.SCALAR, JavaType.LONG),
    INT32(4, Collection.SCALAR, JavaType.INT),
    FIXED64(5, Collection.SCALAR, JavaType.LONG),
    FIXED32(6, Collection.SCALAR, JavaType.INT),
    BOOL(7, Collection.SCALAR, JavaType.BOOLEAN),
    STRING(8, Collection.SCALAR, JavaType.STRING),
    MESSAGE(9, Collection.SCALAR, JavaType.MESSAGE),
    BYTES(10, Collection.SCALAR, JavaType.BYTE_STRING),
    UINT32(11, Collection.SCALAR, JavaType.INT),
    ENUM(12, Collection.SCALAR, JavaType.ENUM),
    SFIXED32(13, Collection.SCALAR, JavaType.INT),
    SFIXED64(14, Collection.SCALAR, JavaType.LONG),
    SINT32(15, Collection.SCALAR, JavaType.INT),
    SINT64(16, Collection.SCALAR, JavaType.LONG),
    GROUP(17, Collection.SCALAR, JavaType.MESSAGE),
    DOUBLE_LIST(18, Collection.VECTOR, JavaType.DOUBLE),
    FLOAT_LIST(19, Collection.VECTOR, JavaType.FLOAT),
    INT64_LIST(20, Collection.VECTOR, JavaType.LONG),
    UINT64_LIST(21, Collection.VECTOR, JavaType.LONG),
    INT32_LIST(22, Collection.VECTOR, JavaType.INT),
    FIXED64_LIST(23, Collection.VECTOR, JavaType.LONG),
    FIXED32_LIST(24, Collection.VECTOR, JavaType.INT),
    BOOL_LIST(25, Collection.VECTOR, JavaType.BOOLEAN),
    STRING_LIST(26, Collection.VECTOR, JavaType.STRING),
    MESSAGE_LIST(27, Collection.VECTOR, JavaType.MESSAGE),
    BYTES_LIST(28, Collection.VECTOR, JavaType.BYTE_STRING),
    UINT32_LIST(29, Collection.VECTOR, JavaType.INT),
    ENUM_LIST(30, Collection.VECTOR, JavaType.ENUM),
    SFIXED32_LIST(31, Collection.VECTOR, JavaType.INT),
    SFIXED64_LIST(32, Collection.VECTOR, JavaType.LONG),
    SINT32_LIST(33, Collection.VECTOR, JavaType.INT),
    SINT64_LIST(34, Collection.VECTOR, JavaType.LONG),
    DOUBLE_LIST_PACKED(35, Collection.PACKED_VECTOR, JavaType.DOUBLE),
    FLOAT_LIST_PACKED(36, Collection.PACKED_VECTOR, JavaType.FLOAT),
    INT64_LIST_PACKED(37, Collection.PACKED_VECTOR, JavaType.LONG),
    UINT64_LIST_PACKED(38, Collection.PACKED_VECTOR, JavaType.LONG),
    INT32_LIST_PACKED(39, Collection.PACKED_VECTOR, JavaType.INT),
    FIXED64_LIST_PACKED(40, Collection.PACKED_VECTOR, JavaType.LONG),
    FIXED32_LIST_PACKED(41, Collection.PACKED_VECTOR, JavaType.INT),
    BOOL_LIST_PACKED(42, Collection.PACKED_VECTOR, JavaType.BOOLEAN),
    UINT32_LIST_PACKED(43, Collection.PACKED_VECTOR, JavaType.INT),
    ENUM_LIST_PACKED(44, Collection.PACKED_VECTOR, JavaType.ENUM),
    SFIXED32_LIST_PACKED(45, Collection.PACKED_VECTOR, JavaType.INT),
    SFIXED64_LIST_PACKED(46, Collection.PACKED_VECTOR, JavaType.LONG),
    SINT32_LIST_PACKED(47, Collection.PACKED_VECTOR, JavaType.INT),
    SINT64_LIST_PACKED(48, Collection.PACKED_VECTOR, JavaType.LONG),
    GROUP_LIST(49, Collection.VECTOR, JavaType.MESSAGE),
    MAP(50, Collection.MAP, JavaType.VOID);
    
    public static final Type[] EMPTY_TYPES = null;
    public static final FieldType[] VALUES = null;
    public final Collection collection;
    public final Class<?> elementType;
    public final int id;
    public final JavaType javaType;
    public final boolean primitiveScalar;

    public enum Collection {
        public static final /* synthetic */ Collection[] $VALUES = null;
        public static final Collection MAP = null;
        public static final Collection PACKED_VECTOR = null;
        public static final Collection SCALAR = null;
        public static final Collection VECTOR = null;
        public final boolean isList;

        /* access modifiers changed from: public */
        static {
            SCALAR = new Collection("SCALAR", 0, false);
            VECTOR = new Collection("VECTOR", 1, true);
            PACKED_VECTOR = new Collection("PACKED_VECTOR", 2, true);
            Collection collection = new Collection("MAP", 3, false);
            MAP = collection;
            $VALUES = new Collection[]{SCALAR, VECTOR, PACKED_VECTOR, collection};
        }

        /* access modifiers changed from: public */
        Collection(String str, int i, boolean z) {
            this.isList = z;
        }

        public static Collection valueOf(String str) {
            return (Collection) Enum.valueOf(Collection.class, str);
        }

        public static Collection[] values() {
            return (Collection[]) $VALUES.clone();
        }

        public boolean isList() {
            return this.isList;
        }
    }

    /* access modifiers changed from: public */
    static {
        int i;
        EMPTY_TYPES = new Type[0];
        FieldType[] values = values();
        VALUES = new FieldType[values.length];
        for (FieldType fieldType : values) {
            VALUES[fieldType.id] = fieldType;
        }
    }

    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
        if (r3 != 9) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    FieldType(int r3, com.google.crypto.tink.shaded.protobuf.FieldType.Collection r4, com.google.crypto.tink.shaded.protobuf.JavaType r5) {
        /*
            r0 = this;
            r0.<init>(r1, r2)
            r0.id = r3
            r0.collection = r4
            r0.javaType = r5
            int r1 = r4.ordinal()
            r2 = 1
            if (r1 == r2) goto L_0x001e
            r3 = 3
            if (r1 == r3) goto L_0x0017
            r1 = 0
            r0.elementType = r1
            goto L_0x0024
        L_0x0017:
            java.lang.Class r1 = r5.getBoxedType()
            r0.elementType = r1
            goto L_0x0024
        L_0x001e:
            java.lang.Class r1 = r5.getBoxedType()
            r0.elementType = r1
        L_0x0024:
            r1 = 0
            com.google.crypto.tink.shaded.protobuf.FieldType$Collection r3 = com.google.crypto.tink.shaded.protobuf.FieldType.Collection.SCALAR
            if (r4 != r3) goto L_0x0038
            int r3 = r5.ordinal()
            r4 = 6
            if (r3 == r4) goto L_0x0038
            r4 = 7
            if (r3 == r4) goto L_0x0038
            r4 = 9
            if (r3 == r4) goto L_0x0038
            goto L_0x0039
        L_0x0038:
            r2 = 0
        L_0x0039:
            r0.primitiveScalar = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.FieldType.<init>(java.lang.String, int, int, com.google.crypto.tink.shaded.protobuf.FieldType$Collection, com.google.crypto.tink.shaded.protobuf.JavaType):void");
    }

    public static FieldType forId(int i) {
        if (i >= 0) {
            FieldType[] fieldTypeArr = VALUES;
            if (i < fieldTypeArr.length) {
                return fieldTypeArr[i];
            }
        }
        return null;
    }

    public static Type getGenericSuperList(Class<?> cls) {
        for (Type type : cls.getGenericInterfaces()) {
            if (type instanceof ParameterizedType) {
                if (List.class.isAssignableFrom((Class) ((ParameterizedType) type).getRawType())) {
                    return type;
                }
            }
        }
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            if (List.class.isAssignableFrom((Class) ((ParameterizedType) genericSuperclass).getRawType())) {
                return genericSuperclass;
            }
        }
        return null;
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r7v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type getListParameter(java.lang.Class r7, java.lang.reflect.Type[] r8) {
        /*
        L_0x0000:
            java.lang.Class<java.util.List> r0 = java.util.List.class
            r1 = 0
            r2 = 1
            if (r7 == r0) goto L_0x0077
            java.lang.reflect.Type r0 = getGenericSuperList(r7)
            boolean r2 = r0 instanceof java.lang.reflect.ParameterizedType
            if (r2 == 0) goto L_0x005a
            java.lang.reflect.ParameterizedType r0 = (java.lang.reflect.ParameterizedType) r0
            java.lang.reflect.Type[] r1 = r0.getActualTypeArguments()
            r2 = 0
        L_0x0015:
            int r3 = r1.length
            if (r2 >= r3) goto L_0x0052
            r3 = r1[r2]
            boolean r4 = r3 instanceof java.lang.reflect.TypeVariable
            if (r4 == 0) goto L_0x004f
            java.lang.reflect.TypeVariable[] r4 = r7.getTypeParameters()
            int r5 = r8.length
            int r6 = r4.length
            if (r5 != r6) goto L_0x0047
            r5 = 0
        L_0x0027:
            int r6 = r4.length
            if (r5 >= r6) goto L_0x0037
            r6 = r4[r5]
            if (r3 != r6) goto L_0x0034
            r4 = r8[r5]
            r1[r2] = r4
            r4 = 1
            goto L_0x0038
        L_0x0034:
            int r5 = r5 + 1
            goto L_0x0027
        L_0x0037:
            r4 = 0
        L_0x0038:
            if (r4 == 0) goto L_0x003b
            goto L_0x004f
        L_0x003b:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r8 = "Unable to find replacement for "
            java.lang.String r8 = com.android.tools.r8.GeneratedOutlineSupport.outline55(r8, r3)
            r7.<init>(r8)
            throw r7
        L_0x0047:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r8 = "Type array mismatch"
            r7.<init>(r8)
            throw r7
        L_0x004f:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0052:
            java.lang.reflect.Type r7 = r0.getRawType()
            java.lang.Class r7 = (java.lang.Class) r7
            r8 = r1
            goto L_0x0000
        L_0x005a:
            java.lang.reflect.Type[] r8 = EMPTY_TYPES
            java.lang.Class[] r0 = r7.getInterfaces()
            int r2 = r0.length
        L_0x0061:
            if (r1 >= r2) goto L_0x0072
            r3 = r0[r1]
            java.lang.Class<java.util.List> r4 = java.util.List.class
            boolean r4 = r4.isAssignableFrom(r3)
            if (r4 == 0) goto L_0x006f
            r7 = r3
            goto L_0x0000
        L_0x006f:
            int r1 = r1 + 1
            goto L_0x0061
        L_0x0072:
            java.lang.Class r7 = r7.getSuperclass()
            goto L_0x0000
        L_0x0077:
            int r7 = r8.length
            if (r7 != r2) goto L_0x007d
            r7 = r8[r1]
            return r7
        L_0x007d:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException
            java.lang.String r8 = "Unable to identify parameter type for List<T>"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.shaded.protobuf.FieldType.getListParameter(java.lang.Class, java.lang.reflect.Type[]):java.lang.reflect.Type");
    }

    private boolean isValidForList(Field field) {
        Class<?> type = field.getType();
        if (!this.javaType.getType().isAssignableFrom(type)) {
            return false;
        }
        Type[] typeArr = EMPTY_TYPES;
        if (field.getGenericType() instanceof ParameterizedType) {
            typeArr = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
        }
        Type listParameter = getListParameter(type, typeArr);
        if (!(listParameter instanceof Class)) {
            return true;
        }
        return this.elementType.isAssignableFrom((Class) listParameter);
    }

    public JavaType getJavaType() {
        return this.javaType;
    }

    public int id() {
        return this.id;
    }

    public boolean isList() {
        return this.collection.isList();
    }

    public boolean isMap() {
        return this.collection == Collection.MAP;
    }

    public boolean isPacked() {
        return Collection.PACKED_VECTOR.equals(this.collection);
    }

    public boolean isPrimitiveScalar() {
        return this.primitiveScalar;
    }

    public boolean isScalar() {
        return this.collection == Collection.SCALAR;
    }

    public boolean isValidForField(Field field) {
        if (Collection.VECTOR.equals(this.collection)) {
            return isValidForList(field);
        }
        return this.javaType.getType().isAssignableFrom(field.getType());
    }
}
