package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import com.twitter.sdk.android.tweetui.TweetUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNameUnsafe;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.SimpleClassicTypeSystemContext;

/* compiled from: typeEnhancement.kt */
public final class TypeEnhancementKt {
    public static final EnhancedTypeAnnotations ENHANCED_MUTABILITY_ANNOTATIONS;
    public static final EnhancedTypeAnnotations ENHANCED_NULLABILITY_ANNOTATIONS;

    /* compiled from: typeEnhancement.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MutabilityQualifier.values().length];
            MutabilityQualifier mutabilityQualifier = MutabilityQualifier.READ_ONLY;
            iArr[0] = 1;
            MutabilityQualifier mutabilityQualifier2 = MutabilityQualifier.MUTABLE;
            iArr[1] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[NullabilityQualifier.values().length];
            NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NULLABLE;
            iArr2[0] = 1;
            NullabilityQualifier nullabilityQualifier2 = NullabilityQualifier.NOT_NULL;
            iArr2[1] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    static {
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        ENHANCED_NULLABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(fqName);
        FqName fqName2 = JvmAnnotationNames.ENHANCED_MUTABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName2, "ENHANCED_MUTABILITY_ANNOTATION");
        ENHANCED_MUTABILITY_ANNOTATIONS = new EnhancedTypeAnnotations(fqName2);
    }

    public static final EnhancementResult access$enhanceMutability(ClassifierDescriptor classifierDescriptor, JavaTypeQualifiers javaTypeQualifiers, TypeComponentPosition typeComponentPosition) {
        int i;
        EnhancementResult enhancementResult;
        if (!TweetUtils.shouldEnhance(typeComponentPosition)) {
            return noChange(classifierDescriptor);
        }
        if (!(classifierDescriptor instanceof ClassDescriptor)) {
            return noChange(classifierDescriptor);
        }
        JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.INSTANCE;
        MutabilityQualifier mutabilityQualifier = javaTypeQualifiers.mutability;
        if (mutabilityQualifier == null) {
            i = -1;
        } else {
            i = WhenMappings.$EnumSwitchMapping$0[mutabilityQualifier.ordinal()];
        }
        if (i != 1) {
            if (i == 2 && typeComponentPosition == TypeComponentPosition.FLEXIBLE_UPPER) {
                ClassDescriptor classDescriptor = (ClassDescriptor) classifierDescriptor;
                if (javaToKotlinClassMapper.isReadOnly(classDescriptor)) {
                    enhancementResult = new EnhancementResult(javaToKotlinClassMapper.convertReadOnlyToMutable(classDescriptor), ENHANCED_MUTABILITY_ANNOTATIONS);
                }
            }
            return noChange(classifierDescriptor);
        }
        if (typeComponentPosition == TypeComponentPosition.FLEXIBLE_LOWER) {
            ClassDescriptor classDescriptor2 = (ClassDescriptor) classifierDescriptor;
            if (javaToKotlinClassMapper.isMutable(classDescriptor2)) {
                Intrinsics.checkNotNullParameter(classDescriptor2, "mutable");
                FqNameUnsafe fqName = DescriptorUtils.getFqName(classDescriptor2);
                JavaToKotlinClassMap javaToKotlinClassMap = JavaToKotlinClassMap.INSTANCE;
                FqName fqName2 = JavaToKotlinClassMap.mutableToReadOnly.get(fqName);
                if (fqName2 != null) {
                    ClassDescriptor builtInClassByFqName = DescriptorUtilsKt.getBuiltIns(classDescriptor2).getBuiltInClassByFqName(fqName2);
                    Intrinsics.checkNotNullExpressionValue(builtInClassByFqName, "descriptor.builtIns.getBuiltInClassByFqName(oppositeClassFqName)");
                    enhancementResult = new EnhancementResult(builtInClassByFqName, ENHANCED_MUTABILITY_ANNOTATIONS);
                } else {
                    throw new IllegalArgumentException("Given class " + classDescriptor2 + " is not a " + "mutable" + " collection");
                }
            }
        }
        return noChange(classifierDescriptor);
        return enhancementResult;
    }

    public static final boolean hasEnhancedNullability(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        SimpleClassicTypeSystemContext simpleClassicTypeSystemContext = SimpleClassicTypeSystemContext.INSTANCE;
        Intrinsics.checkNotNullParameter(simpleClassicTypeSystemContext, "<this>");
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        FqName fqName = JvmAnnotationNames.ENHANCED_NULLABILITY_ANNOTATION;
        Intrinsics.checkNotNullExpressionValue(fqName, "ENHANCED_NULLABILITY_ANNOTATION");
        return TweetUtils.hasAnnotation(simpleClassicTypeSystemContext, kotlinType, fqName);
    }

    public static final <T> EnhancementResult<T> noChange(T t) {
        return new EnhancementResult<>(t, null);
    }
}
