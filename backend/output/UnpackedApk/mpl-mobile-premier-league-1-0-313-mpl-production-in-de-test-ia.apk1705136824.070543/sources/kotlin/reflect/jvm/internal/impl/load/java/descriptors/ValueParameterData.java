package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: util.kt */
public final class ValueParameterData {
    public final boolean hasDefaultValue;
    public final KotlinType type;

    public ValueParameterData(KotlinType kotlinType, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.type = kotlinType;
        this.hasDefaultValue = z;
    }
}
