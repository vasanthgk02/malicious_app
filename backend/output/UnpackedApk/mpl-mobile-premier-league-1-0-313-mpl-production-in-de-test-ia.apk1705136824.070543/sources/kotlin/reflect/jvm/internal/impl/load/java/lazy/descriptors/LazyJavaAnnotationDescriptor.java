package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import io.hansel.core.criteria.HSLCriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.StandardNames.FqNames;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.JvmAnnotationNames;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.PossiblyExternalAnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.sources.JavaSourceElement;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotationAsAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassObjectAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaEnumValueAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaLiteralAnnotationArgument;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.AnnotationValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValueFactory$createArrayValue$1;
import kotlin.reflect.jvm.internal.impl.resolve.constants.EnumValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value;
import kotlin.reflect.jvm.internal.impl.resolve.constants.KClassValue.Value.LocalClass;
import kotlin.reflect.jvm.internal.impl.resolve.constants.NullValue;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* compiled from: LazyJavaAnnotationDescriptor.kt */
public final class LazyJavaAnnotationDescriptor implements AnnotationDescriptor, PossiblyExternalAnnotationDescriptor {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    public final NotNullLazyValue allValueArguments$delegate = this.f5940c.components.storageManager.createLazyValue(new LazyJavaAnnotationDescriptor$allValueArguments$2(this));

    /* renamed from: c  reason: collision with root package name */
    public final LazyJavaResolverContext f5940c;
    public final NullableLazyValue fqName$delegate;
    public final boolean isFreshlySupportedTypeUseAnnotation;
    public final boolean isIdeExternalAnnotation = this.javaAnnotation.isIdeExternalAnnotation();
    public final JavaAnnotation javaAnnotation;
    public final JavaSourceElement source = this.f5940c.components.sourceElementFactory.source(this.javaAnnotation);
    public final NotNullLazyValue type$delegate = this.f5940c.components.storageManager.createLazyValue(new LazyJavaAnnotationDescriptor$type$2(this));

    static {
        Class<LazyJavaAnnotationDescriptor> cls = LazyJavaAnnotationDescriptor.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "fqName", "getFqName()Lorg/jetbrains/kotlin/name/FqName;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "type", "getType()Lorg/jetbrains/kotlin/types/SimpleType;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};
    }

    public LazyJavaAnnotationDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaAnnotation javaAnnotation2, boolean z) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(javaAnnotation2, "javaAnnotation");
        this.f5940c = lazyJavaResolverContext;
        this.javaAnnotation = javaAnnotation2;
        this.fqName$delegate = lazyJavaResolverContext.components.storageManager.createNullableLazyValue(new LazyJavaAnnotationDescriptor$fqName$2(this));
        this.isFreshlySupportedTypeUseAnnotation = this.javaAnnotation.isFreshlySupportedTypeUseAnnotation() || z;
    }

    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return (Map) TweetUtils.getValue(this.allValueArguments$delegate, $$delegatedProperties[2]);
    }

    public FqName getFqName() {
        NullableLazyValue nullableLazyValue = this.fqName$delegate;
        KProperty<Object> kProperty = $$delegatedProperties[0];
        Intrinsics.checkNotNullParameter(nullableLazyValue, "<this>");
        Intrinsics.checkNotNullParameter(kProperty, "p");
        return (FqName) nullableLazyValue.invoke();
    }

    public SourceElement getSource() {
        return this.source;
    }

    public KotlinType getType() {
        return (SimpleType) TweetUtils.getValue(this.type$delegate, $$delegatedProperties[1]);
    }

    public boolean isIdeExternalAnnotation() {
        return this.isIdeExternalAnnotation;
    }

    public final ConstantValue<?> resolveAnnotationArgument(JavaAnnotationArgument javaAnnotationArgument) {
        ConstantValue<?> constantValue;
        KotlinType kotlinType = null;
        if (javaAnnotationArgument instanceof JavaLiteralAnnotationArgument) {
            return ConstantValueFactory.createConstantValue(((JavaLiteralAnnotationArgument) javaAnnotationArgument).getValue());
        }
        if (javaAnnotationArgument instanceof JavaEnumValueAnnotationArgument) {
            JavaEnumValueAnnotationArgument javaEnumValueAnnotationArgument = (JavaEnumValueAnnotationArgument) javaAnnotationArgument;
            ClassId enumClassId = javaEnumValueAnnotationArgument.getEnumClassId();
            Name entryName = javaEnumValueAnnotationArgument.getEntryName();
            if (enumClassId == null || entryName == null) {
                return null;
            }
            return new EnumValue(enumClassId, entryName);
        }
        if (javaAnnotationArgument instanceof JavaArrayAnnotationArgument) {
            Name name = javaAnnotationArgument.getName();
            if (name == null) {
                name = JvmAnnotationNames.DEFAULT_ANNOTATION_MEMBER_NAME;
            }
            Intrinsics.checkNotNullExpressionValue(name, "argument.name ?: DEFAULT_ANNOTATION_MEMBER_NAME");
            List<JavaAnnotationArgument> elements = ((JavaArrayAnnotationArgument) javaAnnotationArgument).getElements();
            SimpleType simpleType = (SimpleType) TweetUtils.getValue(this.type$delegate, $$delegatedProperties[1]);
            Intrinsics.checkNotNullExpressionValue(simpleType, "type");
            if (TweetUtils.isError(simpleType)) {
                return null;
            }
            ClassDescriptor annotationClass = DescriptorUtilsKt.getAnnotationClass(this);
            Intrinsics.checkNotNull(annotationClass);
            ValueParameterDescriptor annotationParameterByName = TweetUtils.getAnnotationParameterByName(name, annotationClass);
            if (annotationParameterByName != null) {
                kotlinType = annotationParameterByName.getType();
            }
            if (kotlinType == null) {
                kotlinType = this.f5940c.components.module.getBuiltIns().getArrayType(Variance.INVARIANT, ErrorUtils.createErrorType("Unknown array element type"));
            }
            Intrinsics.checkNotNullExpressionValue(kotlinType, "DescriptorResolverUtils.getAnnotationParameterByName(argumentName, annotationClass!!)?.type\n            // Try to load annotation arguments even if the annotation class is not found\n                ?: c.components.module.builtIns.getArrayType(\n                    Variance.INVARIANT,\n                    ErrorUtils.createErrorType(\"Unknown array element type\")\n                )");
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(elements, 10));
            for (JavaAnnotationArgument resolveAnnotationArgument : elements) {
                Object resolveAnnotationArgument2 = resolveAnnotationArgument(resolveAnnotationArgument);
                if (resolveAnnotationArgument2 == null) {
                    resolveAnnotationArgument2 = new NullValue();
                }
                arrayList.add(resolveAnnotationArgument2);
            }
            Intrinsics.checkNotNullParameter(arrayList, HSLCriteriaBuilder.VALUE);
            Intrinsics.checkNotNullParameter(kotlinType, "type");
            constantValue = new ArrayValue<>(arrayList, new ConstantValueFactory$createArrayValue$1(kotlinType));
        } else if (javaAnnotationArgument instanceof JavaAnnotationAsAnnotationArgument) {
            return new AnnotationValue(new LazyJavaAnnotationDescriptor(this.f5940c, ((JavaAnnotationAsAnnotationArgument) javaAnnotationArgument).getAnnotation(), false));
        } else if (!(javaAnnotationArgument instanceof JavaClassObjectAnnotationArgument)) {
            return null;
        } else {
            KotlinType transformJavaType = this.f5940c.typeResolver.transformJavaType(((JavaClassObjectAnnotationArgument) javaAnnotationArgument).getReferencedType(), JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, null, 3));
            Intrinsics.checkNotNullParameter(transformJavaType, "argumentType");
            if (TweetUtils.isError(transformJavaType)) {
                return null;
            }
            int i = 0;
            KotlinType kotlinType2 = transformJavaType;
            while (KotlinBuiltIns.isArray(kotlinType2)) {
                kotlinType2 = ((TypeProjection) ArraysKt___ArraysJvmKt.single(kotlinType2.getArguments())).getType();
                Intrinsics.checkNotNullExpressionValue(kotlinType2, "type.arguments.single().type");
                i++;
            }
            ClassifierDescriptor declarationDescriptor = kotlinType2.getConstructor().getDeclarationDescriptor();
            if (declarationDescriptor instanceof ClassDescriptor) {
                ClassId classId = DescriptorUtilsKt.getClassId(declarationDescriptor);
                if (classId == null) {
                    return new KClassValue((Value) new LocalClass(transformJavaType));
                }
                constantValue = new KClassValue<>(classId, i);
            } else if (!(declarationDescriptor instanceof TypeParameterDescriptor)) {
                return null;
            } else {
                ClassId classId2 = ClassId.topLevel(FqNames.any.toSafe());
                Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(StandardNames.FqNames.any.toSafe())");
                constantValue = new KClassValue<>(classId2, 0);
            }
        }
        return constantValue;
    }

    public String toString() {
        return DescriptorRenderer.renderAnnotation$default(DescriptorRenderer.FQ_NAMES_IN_TYPES, this, null, 2, null);
    }
}
