package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AbstractTypeConstructor.kt */
public final class AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1 extends Lambda implements Function1<TypeConstructor, Iterable<? extends KotlinType>> {
    public final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AbstractTypeConstructor$supertypes$3$resultWithoutCycles$1(AbstractTypeConstructor abstractTypeConstructor) {
        // this.this$0 = abstractTypeConstructor;
        super(1);
    }

    public Object invoke(Object obj) {
        TypeConstructor typeConstructor = (TypeConstructor) obj;
        Intrinsics.checkNotNullParameter(typeConstructor, "it");
        return AbstractTypeConstructor.access$computeNeighbours(this.this$0, typeConstructor, false);
    }
}
