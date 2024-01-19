package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinTypeFactory.kt */
public final class NullableSimpleType extends DelegatingSimpleTypeImpl {
    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NullableSimpleType(SimpleType simpleType) {
        // Intrinsics.checkNotNullParameter(simpleType, "delegate");
        super(simpleType);
    }

    public boolean isMarkedNullable() {
        return true;
    }

    public DelegatingSimpleType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new NullableSimpleType(simpleType);
    }
}
