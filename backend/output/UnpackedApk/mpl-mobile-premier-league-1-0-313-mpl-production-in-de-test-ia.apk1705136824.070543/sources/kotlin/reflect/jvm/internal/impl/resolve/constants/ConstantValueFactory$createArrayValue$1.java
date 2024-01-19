package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ConstantValueFactory.kt */
public final class ConstantValueFactory$createArrayValue$1 extends Lambda implements Function1<ModuleDescriptor, KotlinType> {
    public final /* synthetic */ KotlinType $type;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public ConstantValueFactory$createArrayValue$1(KotlinType kotlinType) {
        // this.$type = kotlinType;
        super(1);
    }

    public Object invoke(Object obj) {
        Intrinsics.checkNotNullParameter((ModuleDescriptor) obj, "it");
        return this.$type;
    }
}
