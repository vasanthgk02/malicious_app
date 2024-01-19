package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: ReflectJavaAnnotationArguments.kt */
public final class ReflectJavaClassObjectAnnotationArgument extends ReflectJavaAnnotationArgument implements JavaClassObjectAnnotationArgument {
    public final Class<?> klass;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ReflectJavaClassObjectAnnotationArgument(Name name, Class<?> cls) {
        // Intrinsics.checkNotNullParameter(cls, "klass");
        super(name);
        this.klass = cls;
    }

    public JavaType getReferencedType() {
        Class<?> cls = this.klass;
        Intrinsics.checkNotNullParameter(cls, "type");
        boolean z = cls instanceof Class;
        if (z && cls.isPrimitive()) {
            return new ReflectJavaPrimitiveType(cls);
        }
        if ((cls instanceof GenericArrayType) || (z && cls.isArray())) {
            return new ReflectJavaArrayType(cls);
        }
        if (cls instanceof WildcardType) {
            return new ReflectJavaWildcardType((WildcardType) cls);
        }
        return new ReflectJavaClassifierType(cls);
    }
}
