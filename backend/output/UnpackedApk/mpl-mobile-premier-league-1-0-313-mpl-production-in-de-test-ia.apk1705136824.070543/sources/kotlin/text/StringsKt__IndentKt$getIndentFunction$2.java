package kotlin.text;

import com.android.tools.r8.GeneratedOutlineSupport;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "line", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Indent.kt */
public final class StringsKt__IndentKt$getIndentFunction$2 extends Lambda implements Function1<String, String> {
    public final /* synthetic */ String $indent;

    /* JADX WARN: Illegal instructions before constructor call commented (this can break semantics) */
    public StringsKt__IndentKt$getIndentFunction$2(String str) {
        // this.$indent = str;
        super(1);
    }

    public Object invoke(Object obj) {
        String str = (String) obj;
        Intrinsics.checkNotNullParameter(str, "line");
        return GeneratedOutlineSupport.outline62(new StringBuilder(), this.$indent, str);
    }
}
