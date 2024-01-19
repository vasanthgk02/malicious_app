package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner.Default;

/* compiled from: SpecialTypes.kt */
public final class LazyWrappedType$refine$1 extends Lambda implements Function0<KotlinType> {
    public final /* synthetic */ KotlinTypeRefiner $kotlinTypeRefiner;
    public final /* synthetic */ LazyWrappedType this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public LazyWrappedType$refine$1(KotlinTypeRefiner kotlinTypeRefiner, LazyWrappedType lazyWrappedType) {
        // this.$kotlinTypeRefiner = kotlinTypeRefiner;
        // this.this$0 = lazyWrappedType;
        super(0);
    }

    public Object invoke() {
        KotlinTypeRefiner kotlinTypeRefiner = this.$kotlinTypeRefiner;
        KotlinType kotlinType = (KotlinType) this.this$0.computation.invoke();
        if (((Default) kotlinTypeRefiner) != null) {
            Intrinsics.checkNotNullParameter(kotlinType, "type");
            return kotlinType;
        }
        throw null;
    }
}
