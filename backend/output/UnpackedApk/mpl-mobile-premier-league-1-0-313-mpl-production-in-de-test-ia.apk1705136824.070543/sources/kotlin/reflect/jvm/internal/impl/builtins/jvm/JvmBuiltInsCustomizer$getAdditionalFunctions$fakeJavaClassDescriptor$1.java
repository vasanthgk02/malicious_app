package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.components.JavaResolverCache;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverComponents;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassDescriptor;

/* compiled from: JvmBuiltInsCustomizer.kt */
public final class JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1 extends Lambda implements Function0<ClassDescriptor> {
    public final /* synthetic */ LazyJavaClassDescriptor $javaAnalogueDescriptor;
    public final /* synthetic */ ClassDescriptor $kotlinMutableClassIfContainer;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public JvmBuiltInsCustomizer$getAdditionalFunctions$fakeJavaClassDescriptor$1(LazyJavaClassDescriptor lazyJavaClassDescriptor, ClassDescriptor classDescriptor) {
        // this.$javaAnalogueDescriptor = lazyJavaClassDescriptor;
        // this.$kotlinMutableClassIfContainer = classDescriptor;
        super(0);
    }

    public Object invoke() {
        LazyJavaClassDescriptor lazyJavaClassDescriptor = this.$javaAnalogueDescriptor;
        JavaResolverCache javaResolverCache = JavaResolverCache.EMPTY;
        Intrinsics.checkNotNullExpressionValue(javaResolverCache, "EMPTY");
        ClassDescriptor classDescriptor = this.$kotlinMutableClassIfContainer;
        if (lazyJavaClassDescriptor != null) {
            Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
            LazyJavaResolverContext lazyJavaResolverContext = lazyJavaClassDescriptor.f5941c;
            JavaResolverComponents javaResolverComponents = lazyJavaResolverContext.components;
            if (javaResolverComponents != null) {
                Intrinsics.checkNotNullParameter(javaResolverCache, "javaResolverCache");
                LazyJavaClassDescriptor lazyJavaClassDescriptor2 = lazyJavaClassDescriptor;
                JavaResolverComponents javaResolverComponents2 = r2;
                JavaResolverComponents javaResolverComponents3 = javaResolverComponents;
                JavaResolverComponents javaResolverComponents4 = new JavaResolverComponents(javaResolverComponents.storageManager, javaResolverComponents.finder, javaResolverComponents.kotlinClassFinder, javaResolverComponents.deserializedDescriptorResolver, javaResolverComponents.signaturePropagator, javaResolverComponents.errorReporter, javaResolverCache, javaResolverComponents.javaPropertyInitializerEvaluator, javaResolverComponents.samConversionResolver, javaResolverComponents.sourceElementFactory, javaResolverComponents3.moduleClassResolver, javaResolverComponents3.packagePartProvider, javaResolverComponents3.supertypeLoopChecker, javaResolverComponents3.lookupTracker, javaResolverComponents3.module, javaResolverComponents3.reflectionTypes, javaResolverComponents3.annotationTypeQualifierResolver, javaResolverComponents3.signatureEnhancement, javaResolverComponents3.javaClassesTracker, javaResolverComponents3.settings, javaResolverComponents3.kotlinTypeChecker, javaResolverComponents3.javaTypeEnhancementState);
                LazyJavaResolverContext lazyJavaResolverContext2 = lazyJavaResolverContext;
                Intrinsics.checkNotNullParameter(lazyJavaResolverContext2, "<this>");
                JavaResolverComponents javaResolverComponents5 = javaResolverComponents2;
                Intrinsics.checkNotNullParameter(javaResolverComponents5, "components");
                LazyJavaResolverContext lazyJavaResolverContext3 = new LazyJavaResolverContext(javaResolverComponents5, lazyJavaResolverContext2.typeParameterResolver, lazyJavaResolverContext2.delegateForDefaultTypeQualifiers);
                DeclarationDescriptor containingDeclaration = lazyJavaClassDescriptor2.getContainingDeclaration();
                Intrinsics.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
                LazyJavaClassDescriptor lazyJavaClassDescriptor3 = new LazyJavaClassDescriptor(lazyJavaResolverContext3, containingDeclaration, lazyJavaClassDescriptor2.jClass, classDescriptor);
                return lazyJavaClassDescriptor3;
            }
            throw null;
        }
        throw null;
    }
}
