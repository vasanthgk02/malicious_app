package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter.Companion;

/* compiled from: MemberScope.kt */
public abstract class DescriptorKindExclude {

    /* compiled from: MemberScope.kt */
    public static final class NonExtensions extends DescriptorKindExclude {
        public static final NonExtensions INSTANCE = new NonExtensions();
        public static final int fullyExcludedDescriptorKinds;

        static {
            Companion companion = DescriptorKindFilter.Companion;
            int i = DescriptorKindFilter.ALL_KINDS_MASK;
            Companion companion2 = DescriptorKindFilter.Companion;
            int i2 = DescriptorKindFilter.FUNCTIONS_MASK;
            Companion companion3 = DescriptorKindFilter.Companion;
            fullyExcludedDescriptorKinds = i & (~(i2 | DescriptorKindFilter.VARIABLES_MASK));
        }

        public int getFullyExcludedDescriptorKinds() {
            return fullyExcludedDescriptorKinds;
        }
    }

    /* compiled from: MemberScope.kt */
    public static final class TopLevelPackages extends DescriptorKindExclude {
        public static final TopLevelPackages INSTANCE = new TopLevelPackages();

        public int getFullyExcludedDescriptorKinds() {
            return 0;
        }
    }

    public abstract int getFullyExcludedDescriptorKinds();

    public String toString() {
        return getClass().getSimpleName();
    }
}
