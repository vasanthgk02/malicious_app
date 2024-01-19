package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaField;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;

/* compiled from: ReflectJavaField.kt */
public final class ReflectJavaField extends ReflectJavaMember implements JavaField {
    public final Field member;

    public ReflectJavaField(Field field) {
        Intrinsics.checkNotNullParameter(field, "member");
        this.member = field;
    }

    public boolean getHasConstantNotNullInitializer() {
        return false;
    }

    public Member getMember() {
        return this.member;
    }

    public JavaType getType() {
        JavaType javaType;
        Type genericType = this.member.getGenericType();
        Intrinsics.checkNotNullExpressionValue(genericType, "member.genericType");
        Intrinsics.checkNotNullParameter(genericType, "type");
        boolean z = genericType instanceof Class;
        if (z) {
            Class cls = (Class) genericType;
            if (cls.isPrimitive()) {
                return new ReflectJavaPrimitiveType(cls);
            }
        }
        if ((genericType instanceof GenericArrayType) || (z && ((Class) genericType).isArray())) {
            javaType = new ReflectJavaArrayType(genericType);
        } else if (genericType instanceof WildcardType) {
            javaType = new ReflectJavaWildcardType((WildcardType) genericType);
        } else {
            javaType = new ReflectJavaClassifierType(genericType);
        }
        return javaType;
    }

    public boolean isEnumEntry() {
        return this.member.isEnumConstant();
    }
}
