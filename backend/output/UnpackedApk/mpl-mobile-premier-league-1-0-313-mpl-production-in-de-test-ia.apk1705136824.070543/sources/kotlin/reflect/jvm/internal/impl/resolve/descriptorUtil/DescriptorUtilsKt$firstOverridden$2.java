package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS$AbstractNodeHandler;

/* compiled from: DescriptorUtils.kt */
public final class DescriptorUtilsKt$firstOverridden$2 extends DFS$AbstractNodeHandler<CallableMemberDescriptor, CallableMemberDescriptor> {
    public final /* synthetic */ Function1<CallableMemberDescriptor, Boolean> $predicate;
    public final /* synthetic */ Ref$ObjectRef<CallableMemberDescriptor> $result;

    public DescriptorUtilsKt$firstOverridden$2(Ref$ObjectRef<CallableMemberDescriptor> ref$ObjectRef, Function1<? super CallableMemberDescriptor, Boolean> function1) {
        this.$result = ref$ObjectRef;
        this.$predicate = function1;
    }

    public void afterChildren(Object obj) {
        T t = (CallableMemberDescriptor) obj;
        Intrinsics.checkNotNullParameter(t, "current");
        if (this.$result.element == null && ((Boolean) this.$predicate.invoke(t)).booleanValue()) {
            this.$result.element = t;
        }
    }

    public boolean beforeChildren(Object obj) {
        Intrinsics.checkNotNullParameter((CallableMemberDescriptor) obj, "current");
        return this.$result.element == null;
    }

    public Object result() {
        return (CallableMemberDescriptor) this.$result.element;
    }
}
