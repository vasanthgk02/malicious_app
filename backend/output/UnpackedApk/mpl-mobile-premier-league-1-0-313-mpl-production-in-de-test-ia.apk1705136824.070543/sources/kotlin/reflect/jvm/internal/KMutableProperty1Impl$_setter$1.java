package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl.Setter;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\"\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003 \u0004*\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "T", "V", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 1})
/* compiled from: KProperty1Impl.kt */
public final class KMutableProperty1Impl$_setter$1 extends Lambda implements Function0<Setter<T, V>> {
    public final /* synthetic */ KMutableProperty1Impl this$0;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public KMutableProperty1Impl$_setter$1(KMutableProperty1Impl kMutableProperty1Impl) {
        // this.this$0 = kMutableProperty1Impl;
        super(0);
    }

    public Object invoke() {
        return new Setter(this.this$0);
    }
}
