package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Collection;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* compiled from: ReflectJavaArrayType.kt */
public final class ReflectJavaArrayType extends ReflectJavaType implements JavaArrayType {
    public final Collection<JavaAnnotation> annotations;
    public final ReflectJavaType componentType;
    public final Type reflectType;

    public ReflectJavaArrayType(Type type) {
        ReflectJavaType reflectJavaType;
        Intrinsics.checkNotNullParameter(type, "reflectType");
        this.reflectType = type;
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            Intrinsics.checkNotNullExpressionValue(genericComponentType, "genericComponentType");
            reflectJavaType = ReflectJavaType.create(genericComponentType);
        } else {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (cls.isArray()) {
                    Class<?> componentType2 = cls.getComponentType();
                    Intrinsics.checkNotNullExpressionValue(componentType2, "getComponentType()");
                    reflectJavaType = ReflectJavaType.create(componentType2);
                }
            }
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Not an array type (");
            outline73.append(this.reflectType.getClass());
            outline73.append("): ");
            outline73.append(this.reflectType);
            throw new IllegalArgumentException(outline73.toString());
        }
        this.componentType = reflectJavaType;
        this.annotations = EmptyList.INSTANCE;
    }

    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    public JavaType getComponentType() {
        return this.componentType;
    }

    public Type getReflectType() {
        return this.reflectType;
    }

    public boolean isDeprecatedInJavaDoc() {
        return false;
    }
}
