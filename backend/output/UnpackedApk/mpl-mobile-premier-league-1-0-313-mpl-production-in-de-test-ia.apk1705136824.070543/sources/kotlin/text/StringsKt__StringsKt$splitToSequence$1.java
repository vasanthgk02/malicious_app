package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/ranges/IntRange;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Strings.kt */
public final class StringsKt__StringsKt$splitToSequence$1 extends Lambda implements Function1<IntRange, String> {
    public final /* synthetic */ CharSequence $this_splitToSequence;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public StringsKt__StringsKt$splitToSequence$1(CharSequence charSequence) {
        // this.$this_splitToSequence = charSequence;
        super(1);
    }

    public Object invoke(Object obj) {
        IntRange intRange = (IntRange) obj;
        Intrinsics.checkNotNullParameter(intRange, "it");
        return CharsKt__CharKt.substring(this.$this_splitToSequence, intRange);
    }
}
