package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import com.twitter.sdk.android.tweetui.TweetUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractLazyTypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement$enhanceTypeParameterBounds$1$1;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.SignatureEnhancement.SignatureParts;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: LazyJavaTypeParameterDescriptor.kt */
public final class LazyJavaTypeParameterDescriptor extends AbstractLazyTypeParameterDescriptor {
    public final LazyJavaAnnotations annotations = new LazyJavaAnnotations(this.f5944c, this.javaTypeParameter, false, 4);

    /* renamed from: c  reason: collision with root package name */
    public final LazyJavaResolverContext f5944c;
    public final JavaTypeParameter javaTypeParameter;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyJavaTypeParameterDescriptor(LazyJavaResolverContext lazyJavaResolverContext, JavaTypeParameter javaTypeParameter2, int i, DeclarationDescriptor declarationDescriptor) {
        // Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        // Intrinsics.checkNotNullParameter(javaTypeParameter2, "javaTypeParameter");
        // Intrinsics.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        super(lazyJavaResolverContext.components.storageManager, declarationDescriptor, javaTypeParameter2.getName(), Variance.INVARIANT, false, i, SourceElement.NO_SOURCE, lazyJavaResolverContext.components.supertypeLoopChecker);
        this.f5944c = lazyJavaResolverContext;
        this.javaTypeParameter = javaTypeParameter2;
    }

    public Annotations getAnnotations() {
        return this.annotations;
    }

    public List<KotlinType> processBoundsWithoutCycles(List<? extends KotlinType> list) {
        Intrinsics.checkNotNullParameter(list, "bounds");
        LazyJavaResolverContext lazyJavaResolverContext = this.f5944c;
        SignatureEnhancement signatureEnhancement = lazyJavaResolverContext.components.signatureEnhancement;
        if (signatureEnhancement != null) {
            Intrinsics.checkNotNullParameter(this, "typeParameter");
            Intrinsics.checkNotNullParameter(list, "bounds");
            Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "context");
            ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(list, 10));
            for (KotlinType kotlinType : list) {
                if (!TypeUtilsKt.contains(kotlinType, SignatureEnhancement$enhanceTypeParameterBounds$1$1.INSTANCE)) {
                    SignatureParts signatureParts = new SignatureParts(signatureEnhancement, this, kotlinType, EmptyList.INSTANCE, false, lazyJavaResolverContext, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, true);
                    kotlinType = signatureParts.enhance(null).type;
                }
                arrayList.add(kotlinType);
            }
            return arrayList;
        }
        throw null;
    }

    public void reportSupertypeLoopError(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
    }

    public List<KotlinType> resolveUpperBounds() {
        Collection<JavaClassifierType> upperBounds = this.javaTypeParameter.getUpperBounds();
        if (upperBounds.isEmpty()) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.INSTANCE;
            SimpleType anyType = this.f5944c.components.module.getBuiltIns().getAnyType();
            Intrinsics.checkNotNullExpressionValue(anyType, "c.module.builtIns.anyType");
            SimpleType nullableAnyType = this.f5944c.components.module.getBuiltIns().getNullableAnyType();
            Intrinsics.checkNotNullExpressionValue(nullableAnyType, "c.module.builtIns.nullableAnyType");
            return TweetUtils.listOf(KotlinTypeFactory.flexibleType(anyType, nullableAnyType));
        }
        ArrayList arrayList = new ArrayList(TweetUtils.collectionSizeOrDefault(upperBounds, 10));
        for (JavaClassifierType transformJavaType : upperBounds) {
            arrayList.add(this.f5944c.typeResolver.transformJavaType(transformJavaType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, this, 1)));
        }
        return arrayList;
    }
}
