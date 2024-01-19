package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ReflectJavaClassifierType.kt */
public final class ReflectJavaClassifierType extends ReflectJavaType implements JavaClassifierType {
    public final JavaClassifier classifier;
    public final Type reflectType;

    public ReflectJavaClassifierType(Type type) {
        JavaClassifier javaClassifier;
        Intrinsics.checkNotNullParameter(type, "reflectType");
        this.reflectType = type;
        if (type instanceof Class) {
            javaClassifier = new ReflectJavaClass((Class) type);
        } else if (type instanceof TypeVariable) {
            javaClassifier = new ReflectJavaTypeParameter((TypeVariable) type);
        } else if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType != null) {
                new ReflectJavaClass((Class) rawType);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
            }
        } else {
            StringBuilder outline73 = GeneratedOutlineSupport.outline73("Not a classifier type (");
            outline73.append(type.getClass());
            outline73.append("): ");
            outline73.append(type);
            throw new IllegalStateException(outline73.toString());
        }
        this.classifier = javaClassifier;
    }

    public JavaAnnotation findAnnotation(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return null;
    }

    public Collection<JavaAnnotation> getAnnotations() {
        return EmptyList.INSTANCE;
    }

    public JavaClassifier getClassifier() {
        return this.classifier;
    }

    public String getClassifierQualifiedName() {
        throw new UnsupportedOperationException(Intrinsics.stringPlus("Type not found: ", this.reflectType));
    }

    public String getPresentableText() {
        return this.reflectType.toString();
    }

    public Type getReflectType() {
        return this.reflectType;
    }

    public List<JavaType> getTypeArguments() {
        Object obj;
        Object obj2;
        List<Type> parameterizedTypeArguments = ReflectClassUtilKt.getParameterizedTypeArguments(this.reflectType);
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(parameterizedTypeArguments, 10));
        for (Type type : parameterizedTypeArguments) {
            Intrinsics.checkNotNullParameter(type, "type");
            boolean z = type instanceof Class;
            if (z) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    obj = new ReflectJavaPrimitiveType(cls);
                    arrayList.add(obj);
                }
            }
            if ((type instanceof GenericArrayType) || (z && ((Class) type).isArray())) {
                obj2 = new ReflectJavaArrayType(type);
            } else if (type instanceof WildcardType) {
                obj2 = new ReflectJavaWildcardType((WildcardType) type);
            } else {
                obj2 = new ReflectJavaClassifierType(type);
            }
            obj = obj2;
            arrayList.add(obj);
        }
        return arrayList;
    }

    public boolean isDeprecatedInJavaDoc() {
        return false;
    }

    public boolean isRaw() {
        Type type = this.reflectType;
        if (!(type instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) type).getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters()");
        return (typeParameters.length == 0) ^ true;
    }
}
