package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: _Collections.kt */
public final class CollectionsKt___CollectionsKt$withIndex$1 extends Lambda implements Function0<Iterator<? extends T>> {
    public final /* synthetic */ Iterable<T> $this_withIndex;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public CollectionsKt___CollectionsKt$withIndex$1(Iterable<? extends T> iterable) {
        // this.$this_withIndex = iterable;
        super(0);
    }

    public Object invoke() {
        return this.$this_withIndex.iterator();
    }
}