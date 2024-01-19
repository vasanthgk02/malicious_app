package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.ReceiverValue;

/* compiled from: DescriptorVisibility.kt */
public abstract class DescriptorVisibility {
    public abstract boolean isVisible(ReceiverValue receiverValue, DeclarationDescriptorWithVisibility declarationDescriptorWithVisibility, DeclarationDescriptor declarationDescriptor);

    public abstract DescriptorVisibility normalize();

    public final String toString() {
        return ((DelegatedDescriptorVisibility) this).delegate.getInternalDisplayName();
    }
}
