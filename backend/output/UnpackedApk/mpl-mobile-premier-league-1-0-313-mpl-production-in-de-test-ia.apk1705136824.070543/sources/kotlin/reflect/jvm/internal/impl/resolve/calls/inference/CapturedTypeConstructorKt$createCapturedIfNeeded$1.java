package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedTypeConstructorKt$createCapturedIfNeeded$1 extends Lambda implements Function0<KotlinType> {
    public final /* synthetic */ TypeProjection $this_createCapturedIfNeeded;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CapturedTypeConstructorKt$createCapturedIfNeeded$1(TypeProjection typeProjection) {
        // this.$this_createCapturedIfNeeded = typeProjection;
        super(0);
    }

    public Object invoke() {
        KotlinType type = this.$this_createCapturedIfNeeded.getType();
        Intrinsics.checkNotNullExpressionValue(type, "this@createCapturedIfNeeded.type");
        return type;
    }
}
