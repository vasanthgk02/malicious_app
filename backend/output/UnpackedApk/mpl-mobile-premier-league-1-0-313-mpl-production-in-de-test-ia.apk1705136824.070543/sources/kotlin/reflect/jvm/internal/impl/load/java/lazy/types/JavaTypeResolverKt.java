package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import com.facebook.react.bridge.ColorPropConverter;
import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeResolverKt {
    public static final FqName JAVA_LANG_CLASS_FQ_NAME = new FqName((String) "java.lang.Class");

    public static final KotlinType getErasedUpperBound(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, Function0<? extends KotlinType> function0) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        if (typeParameterDescriptor == typeParameterDescriptor2) {
            return (KotlinType) function0.invoke();
        }
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "upperBounds");
        KotlinType kotlinType = (KotlinType) ArraysKt___ArraysJvmKt.first(upperBounds);
        if (kotlinType.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
            Intrinsics.checkNotNullExpressionValue(kotlinType, "firstUpperBound");
            return TypeUtilsKt.replaceArgumentsWithStarProjections(kotlinType);
        }
        if (typeParameterDescriptor2 != null) {
            typeParameterDescriptor = typeParameterDescriptor2;
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor != null) {
            while (true) {
                TypeParameterDescriptor typeParameterDescriptor3 = (TypeParameterDescriptor) declarationDescriptor;
                if (Intrinsics.areEqual(typeParameterDescriptor3, typeParameterDescriptor)) {
                    return (KotlinType) function0.invoke();
                }
                List<KotlinType> upperBounds2 = typeParameterDescriptor3.getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds2, "current.upperBounds");
                KotlinType kotlinType2 = (KotlinType) ArraysKt___ArraysJvmKt.first(upperBounds2);
                if (kotlinType2.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
                    Intrinsics.checkNotNullExpressionValue(kotlinType2, "nextUpperBound");
                    return TypeUtilsKt.replaceArgumentsWithStarProjections(kotlinType2);
                }
                declarationDescriptor = kotlinType2.getConstructor().getDeclarationDescriptor();
                if (declarationDescriptor == null) {
                    throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                }
            }
        } else {
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
    }

    public static /* synthetic */ KotlinType getErasedUpperBound$default(TypeParameterDescriptor typeParameterDescriptor, TypeParameterDescriptor typeParameterDescriptor2, Function0 function0, int i) {
        int i2 = i & 1;
        return getErasedUpperBound(typeParameterDescriptor, null, (i & 2) != 0 ? new JavaTypeResolverKt$getErasedUpperBound$1(typeParameterDescriptor) : null);
    }

    public static final TypeProjection makeStarProjection(TypeParameterDescriptor typeParameterDescriptor, JavaTypeAttributes javaTypeAttributes) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkNotNullParameter(javaTypeAttributes, ColorPropConverter.ATTR);
        if (javaTypeAttributes.howThisTypeIsUsed == TypeUsage.SUPERTYPE) {
            return new TypeProjectionImpl(TweetUtils.starProjectionType(typeParameterDescriptor));
        }
        return new StarProjectionImpl(typeParameterDescriptor);
    }

    public static JavaTypeAttributes toAttributes$default(TypeUsage typeUsage, boolean z, TypeParameterDescriptor typeParameterDescriptor, int i) {
        boolean z2 = (i & 1) != 0 ? false : z;
        if ((i & 2) != 0) {
            typeParameterDescriptor = null;
        }
        Intrinsics.checkNotNullParameter(typeUsage, "<this>");
        JavaTypeAttributes javaTypeAttributes = new JavaTypeAttributes(typeUsage, null, z2, typeParameterDescriptor, 2);
        return javaTypeAttributes;
    }
}
