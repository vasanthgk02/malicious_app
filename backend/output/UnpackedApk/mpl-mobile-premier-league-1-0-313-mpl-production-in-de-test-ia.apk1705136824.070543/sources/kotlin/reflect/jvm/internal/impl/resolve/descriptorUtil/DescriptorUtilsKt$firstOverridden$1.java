package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.Collection;
import kotlin.collections.EmptyList;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors;

/* compiled from: DescriptorUtils.kt */
public final class DescriptorUtilsKt$firstOverridden$1 implements DFS$Neighbors<CallableMemberDescriptor> {
    public final /* synthetic */ boolean $useOriginal;

    public DescriptorUtilsKt$firstOverridden$1(boolean z) {
        this.$useOriginal = z;
    }

    public Iterable getNeighbors(Object obj) {
        CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) obj;
        Collection<? extends CallableMemberDescriptor> collection = null;
        if (this.$useOriginal) {
            callableMemberDescriptor = callableMemberDescriptor == null ? null : callableMemberDescriptor.getOriginal();
        }
        if (callableMemberDescriptor != null) {
            collection = callableMemberDescriptor.getOverriddenDescriptors();
        }
        return collection == null ? EmptyList.INSTANCE : collection;
    }
}
