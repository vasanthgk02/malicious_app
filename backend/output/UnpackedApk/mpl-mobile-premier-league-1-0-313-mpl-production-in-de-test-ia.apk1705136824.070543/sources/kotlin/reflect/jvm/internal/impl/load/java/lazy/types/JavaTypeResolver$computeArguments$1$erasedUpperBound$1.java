package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeResolver$computeArguments$1$erasedUpperBound$1 extends Lambda implements Function0<KotlinType> {
    public final /* synthetic */ JavaTypeAttributes $attr;
    public final /* synthetic */ TypeConstructor $constructor;
    public final /* synthetic */ TypeParameterDescriptor $parameter;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JavaTypeResolver$computeArguments$1$erasedUpperBound$1(TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes, TypeConstructor typeConstructor) {
        // this.$parameter = typeParameterDescriptor;
        // this.$attr = javaTypeAttributes;
        // this.$constructor = typeConstructor;
        super(0);
    }

    public Object invoke() {
        TypeParameterDescriptor typeParameterDescriptor = this.$parameter;
        Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "parameter");
        TypeParameterDescriptor typeParameterDescriptor2 = this.$attr.upperBoundOfTypeParameter;
        final TypeConstructor typeConstructor = this.$constructor;
        return JavaTypeResolverKt.getErasedUpperBound(typeParameterDescriptor, typeParameterDescriptor2, new Function0<KotlinType>() {
            public Object invoke() {
                ClassifierDescriptor declarationDescriptor = TypeConstructor.this.getDeclarationDescriptor();
                Intrinsics.checkNotNull(declarationDescriptor);
                SimpleType defaultType = declarationDescriptor.getDefaultType();
                Intrinsics.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
                return TypeUtilsKt.replaceArgumentsWithStarProjections(defaultType);
            }
        });
    }
}
