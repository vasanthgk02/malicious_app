package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: NewCapturedType.kt */
public final class NewCapturedTypeConstructor$_supertypes$2 extends Lambda implements Function0<List<? extends UnwrappedType>> {
    public final /* synthetic */ NewCapturedTypeConstructor this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NewCapturedTypeConstructor$_supertypes$2(NewCapturedTypeConstructor newCapturedTypeConstructor) {
        // this.this$0 = newCapturedTypeConstructor;
        super(0);
    }

    public Object invoke() {
        Function0<? extends List<? extends UnwrappedType>> function0 = this.this$0.supertypesComputation;
        if (function0 == null) {
            return null;
        }
        return (List) function0.invoke();
    }
}
