package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaMethod;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* compiled from: ReflectJavaMethod.kt */
public final class ReflectJavaMethod extends ReflectJavaMember implements JavaMethod {
    public final Method member;

    public ReflectJavaMethod(Method method) {
        Intrinsics.checkNotNullParameter(method, "member");
        this.member = method;
    }

    public JavaAnnotationArgument getAnnotationParameterDefaultValue() {
        JavaAnnotationArgument reflectJavaLiteralAnnotationArgument;
        Object defaultValue = this.member.getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(defaultValue, HSLCriteriaBuilder.VALUE);
        if (ReflectClassUtilKt.isEnumClassOrSpecializedEnumEntryClass(defaultValue.getClass())) {
            reflectJavaLiteralAnnotationArgument = new ReflectJavaEnumValueAnnotationArgument(null, (Enum) defaultValue);
        } else if (defaultValue instanceof Annotation) {
            reflectJavaLiteralAnnotationArgument = new ReflectJavaAnnotationAsAnnotationArgument(null, (Annotation) defaultValue);
        } else if (defaultValue instanceof Object[]) {
            reflectJavaLiteralAnnotationArgument = new ReflectJavaArrayAnnotationArgument(null, (Object[]) defaultValue);
        } else if (defaultValue instanceof Class) {
            reflectJavaLiteralAnnotationArgument = new ReflectJavaClassObjectAnnotationArgument(null, (Class) defaultValue);
        } else {
            reflectJavaLiteralAnnotationArgument = new ReflectJavaLiteralAnnotationArgument(null, defaultValue);
        }
        return reflectJavaLiteralAnnotationArgument;
    }

    public boolean getHasAnnotationParameterDefaultValue() {
        Intrinsics.checkNotNullParameter(this, "this");
        return getAnnotationParameterDefaultValue() != null;
    }

    public Member getMember() {
        return this.member;
    }

    public JavaType getReturnType() {
        JavaType javaType;
        Type genericReturnType = this.member.getGenericReturnType();
        Intrinsics.checkNotNullExpressionValue(genericReturnType, "member.genericReturnType");
        Intrinsics.checkNotNullParameter(genericReturnType, "type");
        boolean z = genericReturnType instanceof Class;
        if (z) {
            Class cls = (Class) genericReturnType;
            if (cls.isPrimitive()) {
                return new ReflectJavaPrimitiveType(cls);
            }
        }
        if ((genericReturnType instanceof GenericArrayType) || (z && ((Class) genericReturnType).isArray())) {
            javaType = new ReflectJavaArrayType(genericReturnType);
        } else if (genericReturnType instanceof WildcardType) {
            javaType = new ReflectJavaWildcardType((WildcardType) genericReturnType);
        } else {
            javaType = new ReflectJavaClassifierType(genericReturnType);
        }
        return javaType;
    }

    public List<ReflectJavaTypeParameter> getTypeParameters() {
        TypeVariable[] typeParameters = this.member.getTypeParameters();
        Intrinsics.checkNotNullExpressionValue(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        for (TypeVariable reflectJavaTypeParameter : typeParameters) {
            arrayList.add(new ReflectJavaTypeParameter(reflectJavaTypeParameter));
        }
        return arrayList;
    }

    public List<JavaValueParameter> getValueParameters() {
        Type[] genericParameterTypes = this.member.getGenericParameterTypes();
        Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = this.member.getParameterAnnotations();
        Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "member.parameterAnnotations");
        return getValueParameters(genericParameterTypes, parameterAnnotations, this.member.isVarArgs());
    }
}
