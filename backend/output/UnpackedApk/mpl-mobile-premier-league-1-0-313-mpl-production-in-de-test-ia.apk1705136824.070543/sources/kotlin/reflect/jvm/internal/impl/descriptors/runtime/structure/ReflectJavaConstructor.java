package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaConstructor;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaValueParameter;

/* compiled from: ReflectJavaConstructor.kt */
public final class ReflectJavaConstructor extends ReflectJavaMember implements JavaConstructor {
    public final Constructor<?> member;

    public ReflectJavaConstructor(Constructor<?> constructor) {
        Intrinsics.checkNotNullParameter(constructor, "member");
        this.member = constructor;
    }

    public Member getMember() {
        return this.member;
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
        Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "types");
        if (genericParameterTypes.length == 0) {
            return EmptyList.INSTANCE;
        }
        Class<?> declaringClass = this.member.getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            genericParameterTypes = (Type[]) ArraysKt___ArraysJvmKt.copyOfRange((T[]) genericParameterTypes, 1, genericParameterTypes.length);
        }
        Annotation[][] parameterAnnotations = this.member.getParameterAnnotations();
        if (parameterAnnotations.length >= genericParameterTypes.length) {
            if (parameterAnnotations.length > genericParameterTypes.length) {
                Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "annotations");
                parameterAnnotations = (Annotation[][]) ArraysKt___ArraysJvmKt.copyOfRange((T[]) parameterAnnotations, parameterAnnotations.length - genericParameterTypes.length, parameterAnnotations.length);
            }
            Intrinsics.checkNotNullExpressionValue(genericParameterTypes, "realTypes");
            Intrinsics.checkNotNullExpressionValue(parameterAnnotations, "realAnnotations");
            return getValueParameters(genericParameterTypes, parameterAnnotations, this.member.isVarArgs());
        }
        throw new IllegalStateException(Intrinsics.stringPlus("Illegal generic signature: ", this.member));
    }
}
