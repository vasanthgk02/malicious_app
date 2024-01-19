package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Field;", "T", "V", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KProperty1Impl.kt */
public final class KProperty1Impl$delegateField$1 extends Lambda implements Function0<Field> {
    public final /* synthetic */ KProperty1Impl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KProperty1Impl$delegateField$1(KProperty1Impl kProperty1Impl) {
        // this.this$0 = kProperty1Impl;
        super(0);
    }

    public Object invoke() {
        return this.this$0.computeDelegateField();
    }
}
