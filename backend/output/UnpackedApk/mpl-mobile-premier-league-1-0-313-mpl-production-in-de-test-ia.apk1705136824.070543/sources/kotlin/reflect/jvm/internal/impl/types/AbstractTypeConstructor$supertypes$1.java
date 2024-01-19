package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor.Supertypes;

/* compiled from: AbstractTypeConstructor.kt */
public final class AbstractTypeConstructor$supertypes$1 extends Lambda implements Function0<Supertypes> {
    public final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public AbstractTypeConstructor$supertypes$1(AbstractTypeConstructor abstractTypeConstructor) {
        // this.this$0 = abstractTypeConstructor;
        super(0);
    }

    public Object invoke() {
        return new Supertypes(this.this$0.computeSupertypes());
    }
}
