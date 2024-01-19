package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: NewCapturedType.kt */
public final class NewCapturedTypeConstructor$initializeSupertypes$2 extends Lambda implements Function0<List<? extends UnwrappedType>> {
    public final /* synthetic */ List<UnwrappedType> $supertypes;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public NewCapturedTypeConstructor$initializeSupertypes$2(List<? extends UnwrappedType> list) {
        // this.$supertypes = list;
        super(0);
    }

    public Object invoke() {
        return this.$supertypes;
    }
}
