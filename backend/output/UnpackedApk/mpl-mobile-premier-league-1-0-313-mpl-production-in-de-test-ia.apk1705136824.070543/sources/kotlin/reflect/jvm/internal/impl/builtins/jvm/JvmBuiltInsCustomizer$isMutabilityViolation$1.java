package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS$Neighbors;

/* compiled from: JvmBuiltInsCustomizer.kt */
public final class JvmBuiltInsCustomizer$isMutabilityViolation$1 implements DFS$Neighbors<CallableMemberDescriptor> {
    public static final JvmBuiltInsCustomizer$isMutabilityViolation$1 INSTANCE = new JvmBuiltInsCustomizer$isMutabilityViolation$1();

    public Iterable getNeighbors(Object obj) {
        return ((CallableMemberDescriptor) obj).getOriginal().getOverriddenDescriptors();
    }
}
