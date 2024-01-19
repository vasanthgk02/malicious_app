package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
public final class DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1 implements TypeConstructorEquality {
    public final /* synthetic */ CallableDescriptor $a;
    public final /* synthetic */ boolean $allowCopiesFromTheSameDeclaration;
    public final /* synthetic */ CallableDescriptor $b;
    public final /* synthetic */ DescriptorEquivalenceForOverrides this$0;

    public DescriptorEquivalenceForOverrides$areCallableDescriptorsEquivalent$overridingUtil$1(DescriptorEquivalenceForOverrides descriptorEquivalenceForOverrides, boolean z, CallableDescriptor callableDescriptor, CallableDescriptor callableDescriptor2) {
        this.this$0 = descriptorEquivalenceForOverrides;
        this.$allowCopiesFromTheSameDeclaration = z;
        this.$a = callableDescriptor;
        this.$b = callableDescriptor2;
    }

    public final boolean equals(TypeConstructor typeConstructor, TypeConstructor typeConstructor2) {
        Intrinsics.checkNotNullParameter(typeConstructor, "c1");
        Intrinsics.checkNotNullParameter(typeConstructor2, "c2");
        if (Intrinsics.areEqual(typeConstructor, typeConstructor2)) {
            return true;
        }
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        ClassifierDescriptor declarationDescriptor2 = typeConstructor2.getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof TypeParameterDescriptor) || !(declarationDescriptor2 instanceof TypeParameterDescriptor)) {
            return false;
        }
        boolean z = this.$allowCopiesFromTheSameDeclaration;
        final CallableDescriptor callableDescriptor = this.$a;
        final CallableDescriptor callableDescriptor2 = this.$b;
        return this.this$0.areTypeParametersEquivalent((TypeParameterDescriptor) declarationDescriptor, (TypeParameterDescriptor) declarationDescriptor2, z, new Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean>() {
            public Object invoke(Object obj, Object obj2) {
                return Boolean.valueOf(Intrinsics.areEqual((DeclarationDescriptor) obj, callableDescriptor) && Intrinsics.areEqual((DeclarationDescriptor) obj2, callableDescriptor2));
            }
        });
    }
}
