package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: DescriptorVisibility.kt */
public abstract class DelegatedDescriptorVisibility extends DescriptorVisibility {
    public final Visibility delegate;

    public DelegatedDescriptorVisibility(Visibility visibility) {
        Intrinsics.checkNotNullParameter(visibility, "delegate");
        this.delegate = visibility;
    }

    public DescriptorVisibility normalize() {
        DescriptorVisibility descriptorVisibility = DescriptorVisibilities.toDescriptorVisibility(this.delegate.normalize());
        Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "toDescriptorVisibility(delegate.normalize())");
        return descriptorVisibility;
    }
}
