package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AbstractTypeConstructor.kt */
public final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2 extends Lambda implements Function1<KotlinType, Unit> {
    public final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AbstractTypeConstructor$supertypes$3$resultWithoutCycles$2(AbstractTypeConstructor abstractTypeConstructor) {
        // this.this$0 = abstractTypeConstructor;
        super(1);
    }

    public Object invoke(Object obj) {
        KotlinType kotlinType = (KotlinType) obj;
        Intrinsics.checkNotNullParameter(kotlinType, "it");
        this.this$0.reportSupertypeLoopError(kotlinType);
        return Unit.INSTANCE;
    }
}
