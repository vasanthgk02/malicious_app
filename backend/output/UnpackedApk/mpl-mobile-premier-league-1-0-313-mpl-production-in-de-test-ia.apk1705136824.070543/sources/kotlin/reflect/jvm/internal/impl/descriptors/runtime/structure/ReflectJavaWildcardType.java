package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;

/* compiled from: ReflectJavaWildcardType.kt */
public final class ReflectJavaWildcardType extends ReflectJavaType implements JavaWildcardType {
    public final Collection<JavaAnnotation> annotations = EmptyList.INSTANCE;
    public final WildcardType reflectType;

    public ReflectJavaWildcardType(WildcardType wildcardType) {
        Intrinsics.checkNotNullParameter(wildcardType, "reflectType");
        this.reflectType = wildcardType;
    }

    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    public JavaType getBound() {
        JavaType reflectJavaArrayType;
        ReflectJavaPrimitiveType reflectJavaPrimitiveType;
        Type[] upperBounds = this.reflectType.getUpperBounds();
        Type[] lowerBounds = this.reflectType.getLowerBounds();
        if (upperBounds.length > 1 || lowerBounds.length > 1) {
            throw new UnsupportedOperationException(Intrinsics.stringPlus("Wildcard types with many bounds are not yet supported: ", this.reflectType));
        }
        if (lowerBounds.length == 1) {
            Intrinsics.checkNotNullExpressionValue(lowerBounds, "lowerBounds");
            Object single = TweetUtils.single((T[]) lowerBounds);
            Intrinsics.checkNotNullExpressionValue(single, "lowerBounds.single()");
            Type type = (Type) single;
            Intrinsics.checkNotNullParameter(type, "type");
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    reflectJavaPrimitiveType = new ReflectJavaPrimitiveType(cls);
                }
            }
            if ((type instanceof GenericArrayType) || (z && ((Class) type).isArray())) {
                reflectJavaArrayType = new ReflectJavaArrayType(type);
                return reflectJavaArrayType;
            }
            if (type instanceof WildcardType) {
                reflectJavaArrayType = new ReflectJavaWildcardType((WildcardType) type);
            } else {
                reflectJavaArrayType = new ReflectJavaClassifierType(type);
            }
            return reflectJavaArrayType;
        } else if (upperBounds.length != 1) {
            return null;
        } else {
            Intrinsics.checkNotNullExpressionValue(upperBounds, "upperBounds");
            Type type2 = (Type) TweetUtils.single((T[]) upperBounds);
            if (Intrinsics.areEqual(type2, Object.class)) {
                return null;
            }
            Intrinsics.checkNotNullExpressionValue(type2, "ub");
            Intrinsics.checkNotNullParameter(type2, "type");
            boolean z2 = type2 instanceof Class;
            if (z2) {
                Class cls2 = (Class) type2;
                if (cls2.isPrimitive()) {
                    reflectJavaPrimitiveType = new ReflectJavaPrimitiveType(cls2);
                }
            }
            if ((type2 instanceof GenericArrayType) || (z2 && ((Class) type2).isArray())) {
                reflectJavaArrayType = new ReflectJavaArrayType(type2);
                return reflectJavaArrayType;
            }
            if (type2 instanceof WildcardType) {
                reflectJavaArrayType = new ReflectJavaWildcardType((WildcardType) type2);
            } else {
                reflectJavaArrayType = new ReflectJavaClassifierType(type2);
            }
            return reflectJavaArrayType;
        }
        return reflectJavaPrimitiveType;
    }

    public Type getReflectType() {
        return this.reflectType;
    }

    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public boolean isExtends() {
        Type[] upperBounds = this.reflectType.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "reflectType.upperBounds");
        return !Intrinsics.areEqual(TweetUtils.firstOrNull(upperBounds), Object.class);
    }
}
