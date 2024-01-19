package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;

/* compiled from: KotlinTypeRefiner.kt */
public abstract class KotlinTypeRefiner {

    /* compiled from: KotlinTypeRefiner.kt */
    public static final class Default extends KotlinTypeRefiner {
        public static final Default INSTANCE = new Default();

        public ClassifierDescriptor refineDescriptor(DeclarationDescriptor declarationDescriptor) {
            Intrinsics.checkNotNullParameter(declarationDescriptor, "descriptor");
            return null;
        }
    }

    public abstract ClassifierDescriptor refineDescriptor(DeclarationDescriptor declarationDescriptor);
}
