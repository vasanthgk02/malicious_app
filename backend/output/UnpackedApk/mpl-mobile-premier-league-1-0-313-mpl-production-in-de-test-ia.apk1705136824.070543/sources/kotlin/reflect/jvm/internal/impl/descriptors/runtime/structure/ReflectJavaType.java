package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectJavaType.kt */
public abstract class ReflectJavaType implements JavaType {
    public static final ReflectJavaType create(Type type) {
        ReflectJavaType reflectJavaType;
        Intrinsics.checkNotNullParameter(type, "type");
        boolean z = type instanceof Class;
        if (z) {
            Class cls = (Class) type;
            if (cls.isPrimitive()) {
                return new ReflectJavaPrimitiveType(cls);
            }
        }
        if ((type instanceof GenericArrayType) || (z && ((Class) type).isArray())) {
            reflectJavaType = new ReflectJavaArrayType(type);
        } else if (type instanceof WildcardType) {
            reflectJavaType = new ReflectJavaWildcardType((WildcardType) type);
        } else {
            reflectJavaType = new ReflectJavaClassifierType(type);
        }
        return reflectJavaType;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ReflectJavaType) && Intrinsics.areEqual(getReflectType(), ((ReflectJavaType) obj).getReflectType());
    }

    public JavaAnnotation findAnnotation(FqName fqName) {
        T t;
        Intrinsics.checkNotNullParameter(this, "this");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Iterator<T> it = getAnnotations().iterator();
        while (true) {
            t = null;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            ClassId classId = ((JavaAnnotation) next).getClassId();
            if (classId != null) {
                t = classId.asSingleFqName();
            }
            if (Intrinsics.areEqual(t, fqName)) {
                t = next;
                break;
            }
        }
        return (JavaAnnotation) t;
    }

    public abstract Type getReflectType();

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }
}
