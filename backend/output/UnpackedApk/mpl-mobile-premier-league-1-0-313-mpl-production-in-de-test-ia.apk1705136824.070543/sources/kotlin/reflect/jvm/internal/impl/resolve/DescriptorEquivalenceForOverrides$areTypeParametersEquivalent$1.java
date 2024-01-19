package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
public final class DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1 extends Lambda implements Function2<DeclarationDescriptor, DeclarationDescriptor, Boolean> {
    public static final DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1 INSTANCE = new DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1();

    public DescriptorEquivalenceForOverrides$areTypeParametersEquivalent$1() {
        super(2);
    }

    public Object invoke(Object obj, Object obj2) {
        DeclarationDescriptor declarationDescriptor = (DeclarationDescriptor) obj;
        DeclarationDescriptor declarationDescriptor2 = (DeclarationDescriptor) obj2;
        return Boolean.FALSE;
    }
}
