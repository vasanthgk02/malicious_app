package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: ReflectJavaPrimitiveType.kt */
public final class ReflectJavaPrimitiveType extends ReflectJavaType implements JavaPrimitiveType {
    public final Collection<JavaAnnotation> annotations = EmptyList.INSTANCE;
    public final Class<?> reflectType;

    public ReflectJavaPrimitiveType(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "reflectType");
        this.reflectType = cls;
    }

    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    public Type getReflectType() {
        return this.reflectType;
    }

    public PrimitiveType getType() {
        if (Intrinsics.areEqual(this.reflectType, Void.TYPE)) {
            return null;
        }
        return JvmPrimitiveType.get(this.reflectType.getName()).getPrimitiveType();
    }

    public boolean isDeprecatedInJavaDoc() {
        return false;
    }
}
