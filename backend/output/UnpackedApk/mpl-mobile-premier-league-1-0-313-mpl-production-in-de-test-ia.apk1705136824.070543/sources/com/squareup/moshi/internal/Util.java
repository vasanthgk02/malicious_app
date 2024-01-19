package com.squareup.moshi.internal;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonQualifier;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.Types;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import okhttp3.HttpUrl;

public final class Util {
    public static final Class<?> DEFAULT_CONSTRUCTOR_MARKER;
    public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];
    public static final Class<? extends Annotation> METADATA;
    public static final Set<Annotation> NO_ANNOTATIONS = Collections.emptySet();
    public static final Map<Class<?>, Class<?>> PRIMITIVE_TO_WRAPPER_TYPE;

    public static final class GenericArrayTypeImpl implements GenericArrayType {
        public final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = Util.canonicalize(type);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && Types.equals(this, (GenericArrayType) obj);
        }

        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Util.typeToString(this.componentType) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    public static final class ParameterizedTypeImpl implements ParameterizedType {
        public final Type ownerType;
        public final Type rawType;
        public final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            Type type3;
            if (type2 instanceof Class) {
                Class<?> enclosingClass = ((Class) type2).getEnclosingClass();
                if (type != null) {
                    if (enclosingClass == null || Types.getRawType(type) != enclosingClass) {
                        throw new IllegalArgumentException("unexpected owner type for " + type2 + ": " + type);
                    }
                } else if (enclosingClass != null) {
                    throw new IllegalArgumentException("unexpected owner type for " + type2 + ": null");
                }
            }
            if (type == null) {
                type3 = null;
            } else {
                type3 = Util.canonicalize(type);
            }
            this.ownerType = type3;
            this.rawType = Util.canonicalize(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            int i = 0;
            while (true) {
                Type[] typeArr2 = this.typeArguments;
                if (i >= typeArr2.length) {
                    return;
                }
                if (typeArr2[i] != null) {
                    Util.checkNotPrimitive(typeArr2[i]);
                    Type[] typeArr3 = this.typeArguments;
                    typeArr3[i] = Util.canonicalize(typeArr3[i]);
                    i++;
                } else {
                    throw null;
                }
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && Types.equals(this, (ParameterizedType) obj);
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        public Type getOwnerType() {
            return this.ownerType;
        }

        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            return (Arrays.hashCode(this.typeArguments) ^ this.rawType.hashCode()) ^ Util.hashCodeOrZero(this.ownerType);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((this.typeArguments.length + 1) * 30);
            sb.append(Util.typeToString(this.rawType));
            if (this.typeArguments.length == 0) {
                return sb.toString();
            }
            sb.append("<");
            sb.append(Util.typeToString(this.typeArguments[0]));
            for (int i = 1; i < this.typeArguments.length; i++) {
                sb.append(", ");
                sb.append(Util.typeToString(this.typeArguments[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    public static final class WildcardTypeImpl implements WildcardType {
        public final Type lowerBound;
        public final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Class<Object> cls = Object.class;
            if (typeArr2.length > 1) {
                throw new IllegalArgumentException();
            } else if (typeArr.length != 1) {
                throw new IllegalArgumentException();
            } else if (typeArr2.length == 1) {
                if (typeArr2[0] != null) {
                    Util.checkNotPrimitive(typeArr2[0]);
                    if (typeArr[0] == cls) {
                        this.lowerBound = Util.canonicalize(typeArr2[0]);
                        this.upperBound = cls;
                        return;
                    }
                    throw new IllegalArgumentException();
                }
                throw null;
            } else if (typeArr[0] != null) {
                Util.checkNotPrimitive(typeArr[0]);
                this.lowerBound = null;
                this.upperBound = Util.canonicalize(typeArr[0]);
            } else {
                throw null;
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && Types.equals(this, (WildcardType) obj);
        }

        public Type[] getLowerBounds() {
            Type type = this.lowerBound;
            if (type == null) {
                return Util.EMPTY_TYPE_ARRAY;
            }
            return new Type[]{type};
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public int hashCode() {
            Type type = this.lowerBound;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.upperBound.hashCode() + 31);
        }

        public String toString() {
            if (this.lowerBound != null) {
                StringBuilder outline73 = GeneratedOutlineSupport.outline73("? super ");
                outline73.append(Util.typeToString(this.lowerBound));
                return outline73.toString();
            } else if (this.upperBound == Object.class) {
                return ColorPropConverter.PREFIX_ATTR;
            } else {
                StringBuilder outline732 = GeneratedOutlineSupport.outline73("? extends ");
                outline732.append(Util.typeToString(this.upperBound));
                return outline732.toString();
            }
        }
    }

    static {
        Class<?> cls;
        Class<?> cls2 = null;
        try {
            cls = Class.forName(getKotlinMetadataClassName());
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        METADATA = cls;
        try {
            cls2 = Class.forName("kotlin.jvm.internal.DefaultConstructorMarker");
        } catch (ClassNotFoundException unused2) {
        }
        DEFAULT_CONSTRUCTOR_MARKER = cls2;
        LinkedHashMap linkedHashMap = new LinkedHashMap(16);
        linkedHashMap.put(Boolean.TYPE, Boolean.class);
        linkedHashMap.put(Byte.TYPE, Byte.class);
        linkedHashMap.put(Character.TYPE, Character.class);
        linkedHashMap.put(Double.TYPE, Double.class);
        linkedHashMap.put(Float.TYPE, Float.class);
        linkedHashMap.put(Integer.TYPE, Integer.class);
        linkedHashMap.put(Long.TYPE, Long.class);
        linkedHashMap.put(Short.TYPE, Short.class);
        linkedHashMap.put(Void.TYPE, Void.class);
        PRIMITIVE_TO_WRAPPER_TYPE = Collections.unmodifiableMap(linkedHashMap);
    }

    public static <T> Class<T> boxIfPrimitive(Class<T> cls) {
        Class cls2 = PRIMITIVE_TO_WRAPPER_TYPE.get(cls);
        return cls2 == null ? cls : cls2;
    }

    /* JADX WARNING: type inference failed for: r0v11, types: [com.squareup.moshi.internal.Util$GenericArrayTypeImpl] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type canonicalize(java.lang.reflect.Type r3) {
        /*
            boolean r0 = r3 instanceof java.lang.Class
            if (r0 == 0) goto L_0x001b
            java.lang.Class r3 = (java.lang.Class) r3
            boolean r0 = r3.isArray()
            if (r0 == 0) goto L_0x001a
            com.squareup.moshi.internal.Util$GenericArrayTypeImpl r0 = new com.squareup.moshi.internal.Util$GenericArrayTypeImpl
            java.lang.Class r3 = r3.getComponentType()
            java.lang.reflect.Type r3 = canonicalize(r3)
            r0.<init>(r3)
            r3 = r0
        L_0x001a:
            return r3
        L_0x001b:
            boolean r0 = r3 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L_0x0038
            boolean r0 = r3 instanceof com.squareup.moshi.internal.Util.ParameterizedTypeImpl
            if (r0 == 0) goto L_0x0024
            return r3
        L_0x0024:
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
            com.squareup.moshi.internal.Util$ParameterizedTypeImpl r0 = new com.squareup.moshi.internal.Util$ParameterizedTypeImpl
            java.lang.reflect.Type r1 = r3.getOwnerType()
            java.lang.reflect.Type r2 = r3.getRawType()
            java.lang.reflect.Type[] r3 = r3.getActualTypeArguments()
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0038:
            boolean r0 = r3 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x004d
            boolean r0 = r3 instanceof com.squareup.moshi.internal.Util.GenericArrayTypeImpl
            if (r0 == 0) goto L_0x0041
            return r3
        L_0x0041:
            java.lang.reflect.GenericArrayType r3 = (java.lang.reflect.GenericArrayType) r3
            com.squareup.moshi.internal.Util$GenericArrayTypeImpl r0 = new com.squareup.moshi.internal.Util$GenericArrayTypeImpl
            java.lang.reflect.Type r3 = r3.getGenericComponentType()
            r0.<init>(r3)
            return r0
        L_0x004d:
            boolean r0 = r3 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x0066
            boolean r0 = r3 instanceof com.squareup.moshi.internal.Util.WildcardTypeImpl
            if (r0 == 0) goto L_0x0056
            return r3
        L_0x0056:
            java.lang.reflect.WildcardType r3 = (java.lang.reflect.WildcardType) r3
            com.squareup.moshi.internal.Util$WildcardTypeImpl r0 = new com.squareup.moshi.internal.Util$WildcardTypeImpl
            java.lang.reflect.Type[] r1 = r3.getUpperBounds()
            java.lang.reflect.Type[] r3 = r3.getLowerBounds()
            r0.<init>(r1, r3)
            return r0
        L_0x0066:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.internal.Util.canonicalize(java.lang.reflect.Type):java.lang.reflect.Type");
    }

    public static void checkNotPrimitive(Type type) {
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            throw new IllegalArgumentException("Unexpected primitive " + type + ". Use the boxed type.");
        }
    }

    public static Class<?> declaringClassOf(TypeVariable<?> typeVariable) {
        Object genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static <T> Constructor<T> findConstructor(Class<T> cls) {
        for (Constructor<T> constructor : cls.getDeclaredConstructors()) {
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length != 0 && parameterTypes[parameterTypes.length - 1].equals(DEFAULT_CONSTRUCTOR_MARKER)) {
                return constructor;
            }
        }
        throw new IllegalStateException("No defaults constructor found for " + cls);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0078, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        throw rethrowCause(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007e, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        throw new java.lang.RuntimeException(com.android.tools.r8.GeneratedOutlineSupport.outline55("Failed to instantiate the generated JsonAdapter for ", r7), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008b, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0097, code lost:
        throw new java.lang.RuntimeException(com.android.tools.r8.GeneratedOutlineSupport.outline55("Failed to access the generated JsonAdapter for ", r7), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0098, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009b, code lost:
        if ((r7 instanceof java.lang.reflect.ParameterizedType) != false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cb, code lost:
        throw new java.lang.RuntimeException("Failed to find the generated JsonAdapter constructor for '" + r7 + "'. Suspiciously, the type was not parameterized but the target class '" + r2.getCanonicalName() + "' is generic. Consider using Types#newParameterizedType() to define these missing type variables.", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00d7, code lost:
        throw new java.lang.RuntimeException(com.android.tools.r8.GeneratedOutlineSupport.outline55("Failed to find the generated JsonAdapter constructor for ", r7), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d8, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e4, code lost:
        throw new java.lang.RuntimeException(com.android.tools.r8.GeneratedOutlineSupport.outline55("Failed to find the generated JsonAdapter class for ", r7), r6);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0046 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0062 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078 A[ExcHandler: InvocationTargetException (r6v5 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007e A[ExcHandler: InstantiationException (r6v4 'e' java.lang.InstantiationException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x008b A[ExcHandler: IllegalAccessException (r6v3 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d8 A[ExcHandler: ClassNotFoundException (r6v1 'e' java.lang.ClassNotFoundException A[CUSTOM_DECLARE]), Splitter:B:5:0x001d] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0062=Splitter:B:16:0x0062, B:12:0x0046=Splitter:B:12:0x0046} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.squareup.moshi.JsonAdapter<?> generatedAdapter(com.squareup.moshi.Moshi r6, java.lang.reflect.Type r7, java.lang.Class<?> r8) {
        /*
            java.lang.Class<com.squareup.moshi.Moshi> r0 = com.squareup.moshi.Moshi.class
            java.lang.Class<com.squareup.moshi.JsonClass> r1 = com.squareup.moshi.JsonClass.class
            java.lang.annotation.Annotation r1 = r8.getAnnotation(r1)
            com.squareup.moshi.JsonClass r1 = (com.squareup.moshi.JsonClass) r1
            r2 = 0
            if (r1 == 0) goto L_0x00e5
            boolean r1 = r1.generateAdapter()
            if (r1 != 0) goto L_0x0015
            goto L_0x00e5
        L_0x0015:
            java.lang.String r1 = r8.getName()
            java.lang.String r1 = com.squareup.moshi.Types.generatedJsonAdapterName(r1)
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r3 = 1
            java.lang.Class r2 = java.lang.Class.forName(r1, r3, r8)     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            boolean r8 = r7 instanceof java.lang.reflect.ParameterizedType     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r1 = 0
            if (r8 == 0) goto L_0x0055
            r8 = r7
            java.lang.reflect.ParameterizedType r8 = (java.lang.reflect.ParameterizedType) r8     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.reflect.Type[] r8 = r8.getActualTypeArguments()     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r4 = 2
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00d8, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r5[r1] = r0     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00d8, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Class<java.lang.reflect.Type[]> r0 = java.lang.reflect.Type[].class
            r5[r3] = r0     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00d8, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.reflect.Constructor r0 = r2.getDeclaredConstructor(r5)     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00d8, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00d8, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r4[r1] = r6     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00d8, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r4[r3] = r8     // Catch:{ NoSuchMethodException -> 0x0046, ClassNotFoundException -> 0x00d8, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            goto L_0x006a
        L_0x0046:
            java.lang.Class[] r6 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Class<java.lang.reflect.Type[]> r0 = java.lang.reflect.Type[].class
            r6[r1] = r0     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.reflect.Constructor r0 = r2.getDeclaredConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r4[r1] = r8     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            goto L_0x006a
        L_0x0055:
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0062, ClassNotFoundException -> 0x00d8, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r8[r1] = r0     // Catch:{ NoSuchMethodException -> 0x0062, ClassNotFoundException -> 0x00d8, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.reflect.Constructor r0 = r2.getDeclaredConstructor(r8)     // Catch:{ NoSuchMethodException -> 0x0062, ClassNotFoundException -> 0x00d8, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ NoSuchMethodException -> 0x0062, ClassNotFoundException -> 0x00d8, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            r4[r1] = r6     // Catch:{ NoSuchMethodException -> 0x0062, ClassNotFoundException -> 0x00d8, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            goto L_0x006a
        L_0x0062:
            java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.reflect.Constructor r0 = r2.getDeclaredConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
        L_0x006a:
            r0.setAccessible(r3)     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            java.lang.Object r6 = r0.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            com.squareup.moshi.JsonAdapter r6 = (com.squareup.moshi.JsonAdapter) r6     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            com.squareup.moshi.JsonAdapter r6 = r6.nullSafe()     // Catch:{ ClassNotFoundException -> 0x00d8, NoSuchMethodException -> 0x0098, IllegalAccessException -> 0x008b, InstantiationException -> 0x007e, InvocationTargetException -> 0x0078 }
            return r6
        L_0x0078:
            r6 = move-exception
            java.lang.RuntimeException r6 = rethrowCause(r6)
            throw r6
        L_0x007e:
            r6 = move-exception
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r0 = "Failed to instantiate the generated JsonAdapter for "
            java.lang.String r7 = com.android.tools.r8.GeneratedOutlineSupport.outline55(r0, r7)
            r8.<init>(r7, r6)
            throw r8
        L_0x008b:
            r6 = move-exception
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r0 = "Failed to access the generated JsonAdapter for "
            java.lang.String r7 = com.android.tools.r8.GeneratedOutlineSupport.outline55(r0, r7)
            r8.<init>(r7, r6)
            throw r8
        L_0x0098:
            r6 = move-exception
            boolean r8 = r7 instanceof java.lang.reflect.ParameterizedType
            if (r8 != 0) goto L_0x00cc
            java.lang.reflect.TypeVariable[] r8 = r2.getTypeParameters()
            int r8 = r8.length
            if (r8 == 0) goto L_0x00cc
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to find the generated JsonAdapter constructor for '"
            r0.append(r1)
            r0.append(r7)
            java.lang.String r7 = "'. Suspiciously, the type was not parameterized but the target class '"
            r0.append(r7)
            java.lang.String r7 = r2.getCanonicalName()
            r0.append(r7)
            java.lang.String r7 = "' is generic. Consider using Types#newParameterizedType() to define these missing type variables."
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            r8.<init>(r7, r6)
            throw r8
        L_0x00cc:
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r0 = "Failed to find the generated JsonAdapter constructor for "
            java.lang.String r7 = com.android.tools.r8.GeneratedOutlineSupport.outline55(r0, r7)
            r8.<init>(r7, r6)
            throw r8
        L_0x00d8:
            r6 = move-exception
            java.lang.RuntimeException r8 = new java.lang.RuntimeException
            java.lang.String r0 = "Failed to find the generated JsonAdapter class for "
            java.lang.String r7 = com.android.tools.r8.GeneratedOutlineSupport.outline55(r0, r7)
            r8.<init>(r7, r6)
            throw r8
        L_0x00e5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.internal.Util.generatedAdapter(com.squareup.moshi.Moshi, java.lang.reflect.Type, java.lang.Class):com.squareup.moshi.JsonAdapter");
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r4v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type getGenericSupertype(java.lang.reflect.Type r3, java.lang.Class r4, java.lang.Class<?> r5) {
        /*
            if (r5 != r4) goto L_0x0003
            return r3
        L_0x0003:
            boolean r3 = r5.isInterface()
            if (r3 == 0) goto L_0x0034
            java.lang.Class[] r3 = r4.getInterfaces()
            r0 = 0
            int r1 = r3.length
        L_0x000f:
            if (r0 >= r1) goto L_0x0034
            r2 = r3[r0]
            if (r2 != r5) goto L_0x001c
            java.lang.reflect.Type[] r3 = r4.getGenericInterfaces()
            r3 = r3[r0]
            return r3
        L_0x001c:
            r2 = r3[r0]
            boolean r2 = r5.isAssignableFrom(r2)
            if (r2 == 0) goto L_0x0031
            java.lang.reflect.Type[] r4 = r4.getGenericInterfaces()
            r4 = r4[r0]
            r3 = r3[r0]
            java.lang.reflect.Type r3 = getGenericSupertype(r4, r3, r5)
            return r3
        L_0x0031:
            int r0 = r0 + 1
            goto L_0x000f
        L_0x0034:
            boolean r3 = r4.isInterface()
            if (r3 != 0) goto L_0x005a
        L_0x003a:
            java.lang.Class<java.lang.Object> r3 = java.lang.Object.class
            if (r4 == r3) goto L_0x005a
            java.lang.Class r3 = r4.getSuperclass()
            if (r3 != r5) goto L_0x0049
            java.lang.reflect.Type r3 = r4.getGenericSuperclass()
            return r3
        L_0x0049:
            boolean r0 = r5.isAssignableFrom(r3)
            if (r0 == 0) goto L_0x0058
            java.lang.reflect.Type r4 = r4.getGenericSuperclass()
            java.lang.reflect.Type r3 = getGenericSupertype(r4, r3, r5)
            return r3
        L_0x0058:
            r4 = r3
            goto L_0x003a
        L_0x005a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.internal.Util.getGenericSupertype(java.lang.reflect.Type, java.lang.Class, java.lang.Class):java.lang.reflect.Type");
    }

    public static String getKotlinMetadataClassName() {
        return "kotlin.Metadata";
    }

    public static boolean hasNullable(Annotation[] annotationArr) {
        for (Annotation annotationType : annotationArr) {
            if (annotationType.annotationType().getSimpleName().equals("Nullable")) {
                return true;
            }
        }
        return false;
    }

    public static int hashCodeOrZero(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static int indexOf(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    public static boolean isAnnotationPresent(Set<? extends Annotation> set, Class<? extends Annotation> cls) {
        if (set.isEmpty()) {
            return false;
        }
        for (Annotation annotationType : set) {
            if (annotationType.annotationType() == cls) {
                return true;
            }
        }
        return false;
    }

    public static boolean isKotlin(Class<?> cls) {
        Class<? extends Annotation> cls2 = METADATA;
        return cls2 != null && cls.isAnnotationPresent(cls2);
    }

    public static boolean isPlatformType(Class<?> cls) {
        String name = cls.getName();
        return name.startsWith("android.") || name.startsWith("androidx.") || name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    public static Set<? extends Annotation> jsonAnnotations(AnnotatedElement annotatedElement) {
        return jsonAnnotations(annotatedElement.getAnnotations());
    }

    public static <T> Constructor<T> lookupDefaultsConstructor(Class<T> cls) {
        if (DEFAULT_CONSTRUCTOR_MARKER != null) {
            Constructor<T> findConstructor = findConstructor(cls);
            findConstructor.setAccessible(true);
            return findConstructor;
        }
        throw new IllegalStateException("DefaultConstructorMarker not on classpath. Make sure the Kotlin stdlib is on the classpath.");
    }

    public static JsonDataException missingProperty(String str, String str2, JsonReader jsonReader) {
        String str3;
        String path = jsonReader.getPath();
        if (str2.equals(str)) {
            str3 = String.format("Required value '%s' missing at %s", new Object[]{str, path});
        } else {
            str3 = String.format("Required value '%s' (JSON name '%s') missing at %s", new Object[]{str, str2, path});
        }
        return new JsonDataException(str3);
    }

    public static Type removeSubtypeWildcard(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        WildcardType wildcardType = (WildcardType) type;
        if (wildcardType.getLowerBounds().length != 0) {
            return type;
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        if (upperBounds.length == 1) {
            return upperBounds[0];
        }
        throw new IllegalArgumentException();
    }

    public static Type resolve(Type type, Class<?> cls, Type type2) {
        return resolve(type, cls, type2, new LinkedHashSet());
    }

    public static Type resolveTypeVariable(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> declaringClassOf = declaringClassOf(typeVariable);
        if (declaringClassOf == null) {
            return typeVariable;
        }
        Type genericSupertype = getGenericSupertype(type, cls, declaringClassOf);
        if (!(genericSupertype instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(declaringClassOf.getTypeParameters(), typeVariable)];
    }

    public static RuntimeException rethrowCause(InvocationTargetException invocationTargetException) {
        Throwable targetException = invocationTargetException.getTargetException();
        if (targetException instanceof RuntimeException) {
            throw ((RuntimeException) targetException);
        } else if (targetException instanceof Error) {
            throw ((Error) targetException);
        } else {
            throw new RuntimeException(targetException);
        }
    }

    public static String typeAnnotatedWithAnnotations(Type type, Set<? extends Annotation> set) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(type);
        if (set.isEmpty()) {
            str = " (with no annotations)";
        } else {
            str = " annotated " + set;
        }
        sb.append(str);
        return sb.toString();
    }

    public static String typeToString(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    public static boolean typesMatch(Type type, Type type2) {
        return Types.equals(type, type2);
    }

    public static JsonDataException unexpectedNull(String str, String str2, JsonReader jsonReader) {
        String str3;
        String path = jsonReader.getPath();
        if (str2.equals(str)) {
            str3 = String.format("Non-null value '%s' was null at %s", new Object[]{str, path});
        } else {
            str3 = String.format("Non-null value '%s' (JSON name '%s') was null at %s", new Object[]{str, str2, path});
        }
        return new JsonDataException(str3);
    }

    public static Set<? extends Annotation> jsonAnnotations(Annotation[] annotationArr) {
        LinkedHashSet linkedHashSet = null;
        for (Annotation annotation : annotationArr) {
            if (annotation.annotationType().isAnnotationPresent(JsonQualifier.class)) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.add(annotation);
            }
        }
        return linkedHashSet != null ? Collections.unmodifiableSet(linkedHashSet) : NO_ANNOTATIONS;
    }

    /* JADX WARNING: type inference failed for: r10v0, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r10v1, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r10v2, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r10v3, types: [java.lang.reflect.WildcardType] */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r0v19, types: [java.lang.Class] */
    /* JADX WARNING: type inference failed for: r0v20, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r0v21, types: [java.lang.reflect.GenericArrayType] */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r10v11, types: [java.lang.reflect.Type] */
    /* JADX WARNING: type inference failed for: r10v12 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r10v11, types: [java.lang.reflect.Type]
      assigns: [java.lang.reflect.Type, java.lang.reflect.WildcardType]
      uses: [?[int, boolean, OBJECT, ARRAY, byte, short, char], java.lang.reflect.Type, ?[OBJECT, ARRAY], java.lang.reflect.WildcardType]
      mth insns count: 85
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:104)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:97)
     */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type resolve(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10, java.util.Collection<java.lang.reflect.TypeVariable<?>> r11) {
        /*
        L_0x0000:
            boolean r0 = r10 instanceof java.lang.reflect.TypeVariable
            if (r0 == 0) goto L_0x0018
            r0 = r10
            java.lang.reflect.TypeVariable r0 = (java.lang.reflect.TypeVariable) r0
            boolean r1 = r11.contains(r0)
            if (r1 == 0) goto L_0x000e
            return r10
        L_0x000e:
            r11.add(r0)
            java.lang.reflect.Type r10 = resolveTypeVariable(r8, r9, r0)
            if (r10 != r0) goto L_0x0000
            return r10
        L_0x0018:
            boolean r0 = r10 instanceof java.lang.Class
            if (r0 == 0) goto L_0x0035
            r0 = r10
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r1 = r0.isArray()
            if (r1 == 0) goto L_0x0035
            java.lang.Class r10 = r0.getComponentType()
            java.lang.reflect.Type r8 = resolve(r8, r9, r10, r11)
            if (r10 != r8) goto L_0x0030
            goto L_0x0034
        L_0x0030:
            java.lang.reflect.GenericArrayType r0 = com.squareup.moshi.Types.arrayOf(r8)
        L_0x0034:
            return r0
        L_0x0035:
            boolean r0 = r10 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x004b
            java.lang.reflect.GenericArrayType r10 = (java.lang.reflect.GenericArrayType) r10
            java.lang.reflect.Type r0 = r10.getGenericComponentType()
            java.lang.reflect.Type r8 = resolve(r8, r9, r0, r11)
            if (r0 != r8) goto L_0x0046
            goto L_0x004a
        L_0x0046:
            java.lang.reflect.GenericArrayType r10 = com.squareup.moshi.Types.arrayOf(r8)
        L_0x004a:
            return r10
        L_0x004b:
            boolean r0 = r10 instanceof java.lang.reflect.ParameterizedType
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x008d
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type r0 = r10.getOwnerType()
            java.lang.reflect.Type r3 = resolve(r8, r9, r0, r11)
            if (r3 == r0) goto L_0x005f
            r0 = 1
            goto L_0x0060
        L_0x005f:
            r0 = 0
        L_0x0060:
            java.lang.reflect.Type[] r4 = r10.getActualTypeArguments()
            int r5 = r4.length
        L_0x0065:
            if (r2 >= r5) goto L_0x0080
            r6 = r4[r2]
            java.lang.reflect.Type r6 = resolve(r8, r9, r6, r11)
            r7 = r4[r2]
            if (r6 == r7) goto L_0x007d
            if (r0 != 0) goto L_0x007b
            java.lang.Object r0 = r4.clone()
            r4 = r0
            java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
            r0 = 1
        L_0x007b:
            r4[r2] = r6
        L_0x007d:
            int r2 = r2 + 1
            goto L_0x0065
        L_0x0080:
            if (r0 == 0) goto L_0x008c
            com.squareup.moshi.internal.Util$ParameterizedTypeImpl r8 = new com.squareup.moshi.internal.Util$ParameterizedTypeImpl
            java.lang.reflect.Type r9 = r10.getRawType()
            r8.<init>(r3, r9, r4)
            r10 = r8
        L_0x008c:
            return r10
        L_0x008d:
            boolean r0 = r10 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x00bf
            java.lang.reflect.WildcardType r10 = (java.lang.reflect.WildcardType) r10
            java.lang.reflect.Type[] r0 = r10.getLowerBounds()
            java.lang.reflect.Type[] r3 = r10.getUpperBounds()
            int r4 = r0.length
            if (r4 != r1) goto L_0x00ad
            r1 = r0[r2]
            java.lang.reflect.Type r8 = resolve(r8, r9, r1, r11)
            r9 = r0[r2]
            if (r8 == r9) goto L_0x00bf
            java.lang.reflect.WildcardType r8 = com.squareup.moshi.Types.supertypeOf(r8)
            return r8
        L_0x00ad:
            int r0 = r3.length
            if (r0 != r1) goto L_0x00bf
            r0 = r3[r2]
            java.lang.reflect.Type r8 = resolve(r8, r9, r0, r11)     // Catch:{ all -> 0x00c0 }
            r9 = r3[r2]
            if (r8 == r9) goto L_0x00bf
            java.lang.reflect.WildcardType r8 = com.squareup.moshi.Types.subtypeOf(r8)
            return r8
        L_0x00bf:
            return r10
        L_0x00c0:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.moshi.internal.Util.resolve(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.Collection):java.lang.reflect.Type");
    }
}
